/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import fxap.Item;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author iamrehman
 */
public class GUIController implements Initializable {

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
    private TreeTableColumn<Item, Number> ItemQuantity;
    @FXML
    private JFXTextField itemInput;
    
    @FXML
    private JFXButton EnterButton;
    
    @FXML
    private Label total;
    
    
    @FXML
    private Label grandTotal;
    @FXML
    private JFXTextField quantityInput;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
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
 
         ItemQuantity.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Item, Number>, ObservableValue<Number>>() {
            @Override
            public ObservableValue<Number> call(TreeTableColumn.CellDataFeatures<Item, Number> param) {
               return param.getValue().getValue().getQuantity();
            }
        });
        
        ItemID.setStyle("-fx-font-size: 14pt; -fx-font:Arial; -fx-background-color :  #e6f3ff;  -fx-font-weight: ;");
        ItemName.setStyle("-fx-font-size: 14pt; -fx-font:Arial; -fx-background-color :  #e6f3ff;-fx-font-weight: ;");
        ItemQuantity.setStyle("-fx-font-size: 14pt; -fx-font:Arial; -fx-background-color :  #e6f3ff;-fx-font-weight: ;");
        ItemPrice.setStyle("-fx-font-size: 14pt; -fx-font:Arial; -fx-background-color :  #e6f3ff ;-fx-font-weight ;");

     
       ItemQuantity.setOnEditCommit((TreeTableColumn.CellEditEvent<Item, Number> event) -> {
            System.out.println(".handle()");
        });
       

        
       Table.setShowRoot(false);
        
       
     
    }    

    @FXML
    private void InputID(ActionEvent event) {
    }

    @FXML
    private void ItemHandler(ActionEvent event) {
   
        System.out.println("UI.GUIController.ItemHandler()");
        Item item= fxap.FXAP.getItem(itemInput.getText().trim());
        
        if(item!=null){
           item.setQuantity(new SimpleIntegerProperty(Integer.parseInt(quantityInput.getText())));
           Table.getRoot().getChildren().add(new TreeItem<>(item));
           quantityInput.setText("");
           itemInput.setText("");
           setTotal();
        }           
        
        
    }
    
    void setTotal(){
        Integer sum=0;
        ObservableList<TreeItem<Item>> items = Table.getRoot().getChildren();
        for (int i=0; i<items.size(); ++i){
            TreeItem<Item> item= items.get(i);
            sum+=item.getValue().getPrice().getValue() * item.getValue().getQuantity().getValue() ;
        }
        total.setText(sum.toString());
        grandTotal.setText(String.valueOf(1.025*sum));
        
                
    }
    
    @FXML
    void EditQuantity(ActionEvent event) {

    }

}

