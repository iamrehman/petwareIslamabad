/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import static UI.ItemReadController.editable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import fxap.Item;
import fxap.Owner;
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
public class OwnerReadController implements Initializable {
public static boolean editable=false;
    
    Owner owner = new Owner("", "root", "root@gmail.com", "male");
    TreeItem<Owner> root =new TreeItem<> (owner) ;
    @FXML
    private TreeTableView<Owner> Table;
    @FXML
    private TreeTableColumn<Owner, String> Col_ownerId;
    @FXML
    private TreeTableColumn<Owner, String> Col_OwnerName;
    @FXML
    private TreeTableColumn<Owner, String> Col_Email;
    @FXML
    private JFXButton HomeButton;
    @FXML
    private JFXButton EnterItem;
    @FXML
    private JFXTextField OwnerID;
    @FXML
    private JFXTextField Name;
    @FXML
    private JFXTextField Email;
    @FXML
    private JFXRadioButton male;
    @FXML
    private JFXRadioButton female;
    @FXML
    private TreeTableColumn<Owner, String> Col_gender;

 

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
          if(Name.getText().equals("") || Email.getText().equals("") || OwnerID.getText().equals(""))
             return ;
        String gender ="female";
        if(male.isSelected())
            gender="male";
                
        Owner owner= new Owner(OwnerID.getText(), Name.getText(), Email.getText(), gender);
        
        TreeItem<Owner> t_itme= new TreeItem<>(owner);
        
        root.getChildren().add(t_itme);
        try {
            fxap.FXAP.db.insertOwner(owner);
        } catch (SQLException ex) {
            Logger.getLogger(ItemReadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Name.setText("");
        OwnerID.setText("");
        Email.setText("");
        male.setSelected(false);
        female.setSelected(false);
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    Table.setRoot(root);
            Col_ownerId.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Owner, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Owner, String> param) {
               return param.getValue().getValue().getId();
            }
        });
        Col_OwnerName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Owner, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Owner, String> param) {
               return param.getValue().getValue().getName();
            }
        });
                  Col_Email.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Owner, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Owner, String> param) {
               return param.getValue().getValue().getEmail();
            }
        });
        Col_gender.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Owner, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Owner, String> param) {
               return param.getValue().getValue().getGender();
            }
            
        });   
        
        Col_Email. setStyle("-fx-font-size: 12pt; -fx-font:Arial; -fx-background-color :  #e6f3ff;  -fx-font-weight:bold ;");
        Col_OwnerName.setStyle("-fx-font-size: 12pt; -fx-font:Arial; -fx-background-color :  #e6f3ff;  -fx-font-weight: bold;");
        Col_gender.setStyle("-fx-font-size: 12pt; -fx-font:Arial; -fx-background-color :  #e6f3ff;  -fx-font-weight: bold;");
        Col_ownerId.setStyle("-fx-font-size: 12pt; -fx-font:Arial; -fx-background-color :  #e6f3ff;  -fx-font-weight:bold ;");
        
        ArrayList<Owner> owners=null;
        try {
           owners = fxap.FXAP.db.getOwners();
        } catch (SQLException ex) {
            Logger.getLogger(ItemReadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i=0; i<owners.size(); ++i){    
            TreeItem<Owner> owner =new TreeItem<>(owners.get(i));          
            Table.getRoot().getChildren().add(owner);
        }
        
        Table.setShowRoot(false);
        
        if(!editable){
                Email.setDisable(true);
                Name.setDisable(true);
                EnterItem.setDisable(true);
                male.setDisable(true);
                female.setDisable(true);
                OwnerID.setDisable(true);
                
                
        } 
        
    }

    @FXML
    private void maleHandler(ActionEvent event) {
        female.setSelected(false);
        male.setSelected(true);
    }

    @FXML
    private void femaleHandler(ActionEvent event) {
           female.setSelected(true);
        male.setSelected(false);
    }
    
}
