/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triptodo;

import com.google.maps.model.AddressComponentType;
import com.google.maps.model.PlaceDetails;
import com.teamdev.jxmaps.javafx.MapView;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader; 
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Yassine
 */
public class TripToDoGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("../esprit/com/views/ListeUtilisateur.fxml"));
     // FXMLLoader loader = new FXMLLoader(getClass().getResource("../esprit/com/views/sinscrireAdmin.fxml"));
       FXMLLoader loader = new FXMLLoader(getClass().getResource("../esprit/com/views/Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("S'inscrire");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
