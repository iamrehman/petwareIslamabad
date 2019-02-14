/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import fxap.Item;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author iamrehman
 */
public class ItemReadController implements Initializable {
public static boolean editable=false;
    
    Item t= new Item("","",0);
   
    TreeItem<Item> root = new TreeItem<>(t);
    
    @FXML
    private TreeTableView<Item> Table;
    @FXML
    private TreeTableColumn<Item, String> ItemID;
    @FXML
    private TreeTableColumn<Item, String> ItemName;
    @FXML
    private TreeTableColumn<Item, Number> ItemPrice;
    @FXML
    private JFXButton HomeButton;
    @FXML
    private JFXButton EnterItem;
    @FXML
    private JFXTextField ItemId;
    @FXML
    private JFXTextField Name;
    @FXML
    private JFXTextField Price;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Table.setRoot(root);
            ItemID.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Item, String> param) {
               return param.getValue().getValue().getId();
            }
        });
        ItemName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Item, String> param) {
               return param.getValue().getValue().getName();
            }
        });
        
        ItemPrice.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Item, Number>, ObservableValue<Number>>() {
            @Override
            public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<Item, Number> param) {
               return param.getValue().getValue().getPrice();
            }
        });
        
          
        ItemID.setStyle("-fx-font-size: 12pt; -fx-font:Arial; -fx-background-color :  #e6f3ff;  -fx-font-weight: ;");
        ItemName.setStyle("-fx-font-size: 12pt; -fx-font:Arial; -fx-background-color :  #e6f3ff;-fx-font-weight: ;");
      
        ItemPrice.setStyle("-fx-font-size: 12pt; -fx-font:Arial; -fx-background-color :  #e6f3ff ;-fx-font-weight ;");
        ArrayList<Item> items= null;
        try {
           items = fxap.FXAP.db.getItems();
        } catch (SQLException ex) {
            Logger.getLogger(ItemReadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i=0; i<items.size(); ++i){    
            TreeItem<Item> item =new TreeItem<Item>(items.get(i));
          
            Table.getRoot().getChildren().add(item);
        }
        
        
        Table.setShowRoot(false);
        if(editable){
        ItemId.setDisable(true);
         Name.setDisable(true);
         EnterItem.setDisable(true);
        Price.setDisable(true);
        } 
        
        
         
    }    

    @FXML
    private void homeButtonHandler(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewGui.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            /* first close this window */
            Stage st = (Stage) Table.getScene().getWindow();
            // do what you have to do
            st.close();
     
            Stage stage = new Stage();
            stage.hide();
            stage.setScene(new Scene(root1)); 
            stage.show();
    }

    @FXML
    private void EnterHandler(ActionEvent event) {
        if(Name.getText().equals("") || ItemId.getText().equals("") || Price.getText().equals(""))
            return ;
        Item item= new Item(ItemId.getText(), Name.getText(), Integer.parseInt(Price.getText()));
        
        TreeItem<Item> t_itme= new TreeItem<>(item);
        
        root.getChildren().add(t_itme);
        try {
            fxap.FXAP.db.insertItem(item);
        } catch (SQLException ex) {
            Logger.getLogger(ItemReadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Name.setText("");
        ItemId.setText("");
        Price.setText("");
        
        
    }
    
}
