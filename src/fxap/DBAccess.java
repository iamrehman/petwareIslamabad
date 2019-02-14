/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author iamrehman
 */
public class DBAccess {
    private static Connection conn=null;
    
    private DBAccess() {     }
    
    public static  Connection getSqlConnection(){
        return null;
    }
    
    public static  Connection getAccessConnection() throws ClassNotFoundException, SQLException{
        if(conn==null){
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conn=DriverManager.getConnection("jdbc:ucanaccess://D:\\Access306.accdb");
        }        
        
        return conn;
    }
}
