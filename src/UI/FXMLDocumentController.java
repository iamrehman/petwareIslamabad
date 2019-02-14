/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author iamrehman
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane mainAnchor;
    
    @FXML
    private JFXButton login;
    @FXML
    private ImageView image;
    
    @FXML
    AnchorPane ImagePane;

    
    @FXML
    JFXPasswordField password;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image i= new Image("file:icon.jpg");
        image=new ImageView(i);
        image.setFitWidth(450);
        image.setFitHeight(400);
        image.setOpacity(.30);
        ImagePane.getChildren().add(image);
        
    }    
    @FXML
    private JFXTextField idLogin;
    @FXML
    private void loginHandler(ActionEvent event) throws IOException {
        if(password.getText().equals("rehman") && idLogin.getText().equals("rehman")){

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dbSelect.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            /* first close this window */
            Stage st = (Stage) login.getScene().getWindow();
            // do what you have to do
            st.close();
     
            Stage stage = new Stage();
            stage.hide();
            stage.setScene(new Scene(root1)); 
            stage.show();
        }
        else{
            System.out.println("UI.FXMLDocumentController.loginHandler()");
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Warning.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            /* first close this window */
  

            Stage stage = new Stage();

            stage.setScene(new Scene(root1)); 
            stage.show();
        }
    }

}
