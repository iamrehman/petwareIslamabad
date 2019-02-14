/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxap;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author iamrehman
 */
public class Owner {
    
   private SimpleStringProperty id;
    private final SimpleStringProperty gender;

    public SimpleStringProperty getGender() {
        return gender;
    }



    public SimpleStringProperty getId() {
        return id;
    }

    public void setId(SimpleStringProperty id) {
        this.id = id;
    }

    public SimpleStringProperty getName() {
        return name;
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }



    public SimpleStringProperty getEmail() {
        return email;
    }

    public void setEmail(SimpleStringProperty email) {
        this.email = email;
    }
   private  SimpleStringProperty name;
   private  SimpleStringProperty email;
    
   public Owner(String id, String name, String email, String gender){
            this.id= new SimpleStringProperty(id);
            this.name= new SimpleStringProperty(name);
            this.email=new SimpleStringProperty(email);
            this.gender= new SimpleStringProperty(gender);       
            
            
    }
    
}
