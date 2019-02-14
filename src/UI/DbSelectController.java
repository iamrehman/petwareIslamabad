/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import static fxap.FXAP.db;
import static fxap.FXAP.items;
import fxap.QueryController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author iamrehman
 */
public class DbSelectController implements Initializable {

    @FXML
    private AnchorPane mainAnchor;
    @FXML
    private JFXButton sqlbutton;
    @FXML
    private AnchorPane ImagePane;
    @FXML
    private JFXButton accessbutton;
    @FXML
    private JFXSpinner spinner;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        spinner.setVisible(true);
    }    

    @FXML
    private void sqlhandler(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
         spinner.setVisible(true);
      
             
        fxap.FXAP.db= new QueryController("sql");
        
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewGui.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            /* first close this window */
            Stage st = (Stage) mainAnchor.getScene().getWindow();
            // do what you have to do
            st.close();
     
            Stage stage = new Stage();
            stage.hide();
            stage.setScene(new Scene(root1)); 
            stage.show();
    
    }

    @FXML
    private void accesshandler(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        fxap.FXAP.db= new QueryController("access");
         spinner.setVisible(true);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(DbSelectController.class.getName()).log(Level.SEVERE, null, ex);
        }
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewGui.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            /* first close this window */
            Stage st = (Stage) mainAnchor.getScene().getWindow();
            // do what you have to do
            st.close();
     
            Stage stage = new Stage();
            stage.hide();
            stage.setScene(new Scene(root1)); 
            stage.show();
    }
    
}
