/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_pi;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author MediaHelp
 */
public class mainGui extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
     //  FXMLLoader loader=new FXMLLoader(getClass().getResource("../esprit/com/views/ajouterHotels.fxml"));
   //    FXMLLoader loader=new FXMLLoader(getClass().getResource("../esprit/com/views/afficherHotels.fxml"));
       
   //FXMLLoader loader=new FXMLLoader(getClass().getResource("../esprit/com/views/notification.fxml"));
                                             //       FXMLLoader loader=new FXMLLoader(getClass().getResource("../esprit/com/views/ajouterRestaurant.fxml"));
         //       FXMLLoader loader=new FXMLLoader(getClass().getResource("../esprit/com/views/afficherRestau.fxml"));
         //   FXMLLoader loader=new FXMLLoader(getClass().getResource("../esprit/com/views/ajouterReservationHotel.fxml"));
                    //  FXMLLoader loader=new FXMLLoader(getClass().getResource("../esprit/com/views/AfficherReservationRestaurant.fxml"));
               FXMLLoader loader=new FXMLLoader(getClass().getResource("../esprit/com/views/menu.fxml"));




       Parent root=loader.load();
       Scene scene=new Scene(root);
       primaryStage.setTitle("workshop");
       primaryStage.setScene(scene);
       primaryStage.show();
   
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
