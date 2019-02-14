/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author iamrehman
 */
public class ReadOnlyController implements Initializable {

    @FXML
    private AnchorPane tabinfo;
    @FXML
    private JFXButton owner;
    @FXML
    private JFXButton pet;
    @FXML
    private JFXButton item;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ownerHandler(ActionEvent event) throws IOException {
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OwnerRead.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            /* first close this window */
            Stage st = (Stage) item.getScene().getWindow();
            // do what you have to do
            st.close();
     
            Stage stage = new Stage();
            stage.hide();
            stage.setScene(new Scene(root1)); 
            stage.show();
    }

    @FXML
    private void petHanlder(ActionEvent event) throws IOException {
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OwnerRead.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            /* first close this window */
            Stage st = (Stage) item.getScene().getWindow();
            // do what you have to do
            st.close();
     
            Stage stage = new Stage();
            stage.hide();
            stage.setScene(new Scene(root1)); 
            stage.show();
    }

    @FXML
    private void Itemhandler(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ItemRead.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            /* first close this window */
            Stage st = (Stage) item.getScene().getWindow();
            // do what you have to do
            st.close();
     
            Stage stage = new Stage();
            stage.hide();
            stage.setScene(new Scene(root1)); 
            stage.show();
    }
    
}
