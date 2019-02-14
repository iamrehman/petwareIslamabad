/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.jfoenix.controls.JFXButton;
import fxap.Item;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

/**
 * FXML Controller class
 *
 * @author iamrehman
 */
public class PetREadController implements Initializable {

    @FXML
    private TreeTableView<Item> Table;
    @FXML
    private TreeTableColumn<Item, ?> ItemID;
    @FXML
    private TreeTableColumn<Item, ?> ItemName;
    @FXML
    private TreeTableColumn<Item, ?> ItemPrice;
    @FXML
    private JFXButton HomeButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void homeButtonHandler(ActionEvent event) {
    }
    
}
