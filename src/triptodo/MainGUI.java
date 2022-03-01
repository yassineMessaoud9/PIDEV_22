/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triptodo;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ons
 */
public class MainGUI extends Application {

    /**
     * @param args the command line arguments
     */
   

    @Override
    public void start(Stage primaryStage) throws Exception {
   

        //FXMLLoader loader= new FXMLLoader(getClass().getResource("../esprit/com/views/ajoutagencelocation.fxml"));
                FXMLLoader loader= new FXMLLoader(getClass().getResource("../esprit/com/views/afficheAgence.fxml"));

        Parent root= loader.load();  
        Scene scene = new Scene(root);
        primaryStage.setTitle("Ajouter Agence de Location");
        primaryStage.setScene(scene);
        primaryStage.show();
    }   
 public static void main(String[] args) {
        // TODO code application logic here
    }
}
    

