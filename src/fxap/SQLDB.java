/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author iamrehman
 */
public class SQLDB {
   private static Connection conn=null;
    
    private SQLDB() {     }
    
    public static  Connection getAccessConnection() throws ClassNotFoundException, SQLException, SQLException{
       Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        if(conn==null){
    
                   Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                   Connection conn=DriverManager.getConnection("jdbc:ucanaccess://D:\\Access306.accdb");           
        }       
        return conn;
    }
    
    public static  Connection getSqlConnection() throws ClassNotFoundException, SQLException{
        if(conn==null){
    
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/petware","rehman","rehman");
            Statement st= conn.createStatement();
            
        }        
        System.out.println("fxap.SQLDB.getSqlConnection()");
        return conn;
    }
    
}
