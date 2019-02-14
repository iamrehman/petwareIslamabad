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
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author iamrehman
 */
public class NewGuiController implements Initializable {

      Item t= new Item("","Schema Petware",0);
   
    TreeItem<Item> root = new TreeItem<>(t);
    
    @FXML
    private TreeTableView<Item> Table;
    @FXML
    private TreeTableColumn<Item, String> colName;

    @FXML
    private JFXButton viewData;
    @FXML
    private JFXButton readonly;
    @FXML
    private JFXButton openupdate;
    @FXML
    private AnchorPane tabinfo;


   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
        Table.setRoot(root);
            colName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Item, String> param) {
               return param.getValue().getValue().getName();
            }
        });
        
    colName.setStyle("-fx-font-size: 16pt; -fx-font:Arial; -fx-background-color :  #e6f3ff;  -fx-font-weight: bold;");
       // ItemName.setStyle("-fx-font-size: 14pt; -fx-font:Arial; -fx-background-color :  #e6f3ff;-fx-font-weight: ;");        
        
    Table.setShowRoot(false);     
       
     
    }    


    private void ItemHandler(ActionEvent event) {
   
        System.out.println("UI.GUIController.ItemHandler()");
//        Item item= fxap.FXAP.getItem(itemInput.getText().trim());
//        
//        if(item!=null){
//           item.setQuantity(new SimpleIntegerProperty(Integer.parseInt(quantityInput.getText())));
//           Table.getRoot().getChildren().add(new TreeItem<>(item));
//           quantityInput.setText("");
//         
//        } 
        
                
        
        
    }
    
    @FXML
    private void veiwDataHandler(ActionEvent event) throws SQLException {
        System.out.println("UI.NewGuiController.veiwDataHandler()");
       ArrayList<TreeItem<Item>> items = fxap.FXAP.db.getMetaData();
        
        for (int i=0; i<items.size(); ++i){
            Table.getRoot().getChildren().setAll(items);
        }
            Table.setShowRoot(true);
        
    }

    @FXML
    private void readonlyHandler(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReadOnly.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ItemReadController.editable=true;
            OwnerReadController.editable=false;
            /* first close this window */
            Stage st = (Stage) viewData.getScene().getWindow();
            // do what you have to do
            st.close();
     
            Stage stage = new Stage();
            stage.hide();
            stage.setScene(new Scene(root1)); 
            stage.show();
    }

    @FXML
    private void openupdateHandler(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReadOnly.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ItemReadController.editable=false;
            OwnerReadController.editable=true;
            
            /* first close this window */
            Stage st = (Stage) viewData.getScene().getWindow();
            // do what you have to do
            st.close();
     
            Stage stage = new Stage();
            stage.hide();
            stage.setScene(new Scene(root1)); 
            stage.show();
    }
    
}
