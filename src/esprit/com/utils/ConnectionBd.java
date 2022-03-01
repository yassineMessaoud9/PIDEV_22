/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.utils;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author Gamer
 */


public class ConnectionBd {
    
   private static ConnectionBd instance;
   private Connection cnx ;

    private final String URL = "jdbc:mysql://127.0.0.1/db_triptodo";
    private final String USER = "root";
    private final String PASSWORD = "";

 private ConnectionBd() {
        try {
            cnx = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connecting !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static ConnectionBd getInstance() {
        if(instance == null)
            instance = new ConnectionBd();
        return instance;
    }


    public Connection getCnx() {
        return cnx;
    }

}