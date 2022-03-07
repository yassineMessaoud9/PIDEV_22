/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Utilisateur
 */
public class GestionEventsAndReclamationController implements Initializable {

    @FXML
    private Button EVe;
    @FXML
    private Button tick;
    @FXML
    private Button GeRe;
    @FXML
    private Button AvisG;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gotoEve(ActionEvent event) throws IOException {
          
        Parent root = FXMLLoader.load(getClass().getResource("show.fxml"));
        

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        
    }

    @FXML
    private void gottoTick(ActionEvent event) throws IOException {
          
        Parent root = FXMLLoader.load(getClass().getResource("ticketF.fxml"));
        

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        
    }

    @FXML
    private void goToRe(ActionEvent event) throws IOException {
          
        Parent root = FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
        

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        
    }

    @FXML
    private void gotoAvis(ActionEvent event) throws IOException {
          
        Parent root = FXMLLoader.load(getClass().getResource("Avis.fxml"));
        

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        
    }
    
}
