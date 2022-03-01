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
 * @author Yassine
 */
public class TripToDoGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
       // FXMLLoader loader = new FXMLLoader(getClass().getResource("../esprit/com/views/ListCommandeClient.fxml"));
      // FXMLLoader loader = new FXMLLoader(getClass().getResource("../esprit/com/views/AjouterCommande.fxml"));
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
