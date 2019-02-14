/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxap;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 *
 * @author iamrehman
 */
public class Item {
    private SimpleStringProperty name;

    public SimpleStringProperty getName() {
        return name;
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public SimpleStringProperty getId() {
        return id;
    }

    public void setId(SimpleStringProperty id) {
        this.id = id;
    }

    public SimpleIntegerProperty getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(SimpleIntegerProperty price) {
        this.price = price;
    }

    public SimpleIntegerProperty getQuantity() {
        return quantity;
    }

    public void setQuantity(SimpleIntegerProperty quantity) {
        this.quantity = quantity;
    }
    private SimpleStringProperty id;
    private SimpleIntegerProperty price;
    private SimpleIntegerProperty quantity;
    
   public Item(String id, String name,  Integer price){
        this.id=new SimpleStringProperty(id);
        this.name= new SimpleStringProperty(name);
        this.price=new SimpleIntegerProperty(price);
        this.quantity= new SimpleIntegerProperty(1);
        
    }
}
