/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxap;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author iamrehman
 */
public class FXAP extends Application {
    public static ArrayList<Item> items=null;
    public static QueryController db=null;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/UI/FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    public static Item getItem(String id){
        Item item=null;
       
        int i=0;
        while(i<items.size()){
          
            if(items.get(i).getId().getValue().equals(id)){
                item=items.get(i);
              
            }
            i++;
        }
        return item;
    }
}
