/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxap;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import javafx.scene.control.TreeItem;

/**
 *
 * @author iamrehman
 */
public class QueryController {
    
    Connection conn=null;
    Statement st=null;
    
    public QueryController(String db) throws ClassNotFoundException, SQLException{
        if(db.trim().toLowerCase().equals("access")){
            conn= DBAccess.getAccessConnection();
            st=conn.createStatement();
        }
        else{
            conn = SQLDB.getSqlConnection();
            st=conn.createStatement();
        }
    }
    
    ResultSet getResultSet(String query) throws SQLException{
      st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
      ResultSet rs=st.executeQuery(query);
      return rs;
    }   
    
    public ArrayList<Owner> getOwners() throws SQLException{
        ResultSet rs= getResultSet("select * from owner;");
        ArrayList<Owner> owners = new ArrayList<>();
        while(rs.next()){
            Owner owner = new Owner(rs.getString("id"),rs.getString("name"),rs.getString("email"),rs.getString("gender"));
            owners.add(owner);
        }
        
        return owners;
    }
    public ArrayList<Item> getItems() throws SQLException{
        ResultSet rs= getResultSet("select * from Item;");
        ArrayList<Item> items= new ArrayList<>();
        
        while(rs.next()){
            items.add(new Item(""+rs.getInt("ItemId"), rs.getString("Name"), rs.getInt("Price")));
        }
        return items;
    }  
    
    public ArrayList<TreeItem<Item>>  getMetaData() throws SQLException{
        
        
         Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/petware","rehman","rehman");
          
          DatabaseMetaData dbmd =conn.getMetaData();
          
          ResultSet schemaNames = dbmd.getCatalogs();
          
     
          String[] types = { "TABLE" };
          String catalog = "petware";
          ResultSet tables = dbmd.getTables(catalog, null, "%", types);
          ArrayList<TreeItem<Item>> treeItems = new ArrayList<>();
          int i=0;
          while (tables.next()) {
              
              System.out.println(tables.getString(3));
              treeItems.add(new TreeItem<Item> (new Item ("",tables.getString(3),0)));
              
              ResultSet columns = dbmd.getColumns(catalog, null, tables.getString(3), "%");
              int j=0;             
              while (columns.next()) {
                  
                  Object[] possibleValues = Types.class.getEnumConstants();
                  
                 // String typeName = possibleValues[columns.getInt(5)].toString();
                  
                  System.out.println("Column " + columns.getString(4) + " Type: ");
                  Item item= new Item(columns.getString(5), columns.getString(4) , 0);
                  treeItems.get(i).getChildren().add(new TreeItem<Item> (item));
                  
                  
                  j++;
              }
              
              i++;
              
          }
          
          return treeItems;
    }
    
   public void insertItem(Item item) throws SQLException{
        String name=item.getName().getValue();
        String id=item.getId().getValue();
      
        Integer price= item.getPrice().getValue();
        String query="insert into item (itemId,name, price)values("+id+","+name+","+""+price+");";
      PreparedStatement st=conn.prepareStatement("INSERT INTO item(itemid, name, price) VALUES(?,?,?)");
      st.setString(1,id);
    st.setString(2,name);
    st.setString(3,price.toString());
    st.executeUpdate();
        
    }
   
   public void insertOwner(Owner owner) throws SQLException{
       String name=owner.getName().getValue();
        String id=owner.getId().getValue();
      
        String gender= owner.getGender().getValue();
        String email = owner.getEmail().getValue();
        
        
        String query="insert into owner (Id,name, email, gender)values("+id+","+name+","+email+","+gender+");";
      PreparedStatement st=conn.prepareStatement("INSERT INTO owner(id, name, email,gender) VALUES(?,?,?,?)");
    st.setString(1,id);
    st.setString(2,name);
    st.setString(3,email);
    st.setString(4,gender);
    st.executeUpdate();
   }
    

    
}
