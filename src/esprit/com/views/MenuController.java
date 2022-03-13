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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MediaHelp
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void getview(MouseEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("afficherHotels.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    private void getviews2(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("afficherRestau.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    private void getview3(ActionEvent event) throws IOException {
          Parent page2 = FXMLLoader.load(getClass().getResource("ajouterReservationHotel.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    private void getview4(ActionEvent event) throws IOException {
         Parent page2 = FXMLLoader.load(getClass().getResource("ajouterReservationRestaurant.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    private void getviewHOTEL(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("afficherHotels.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    private void GETVIEWAFFICHAGE(ActionEvent event) throws IOException {
         Parent page2 = FXMLLoader.load(getClass().getResource("AfficherReservationRestaurant.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    private void GETVIEWAFFICHAGEHOTEL(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("showhotel.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    @FXML
    private void adresse(ActionEvent event) {
    }

    @FXML
    private void avion(ActionEvent event) {
    }

    @FXML
    private void compagnie(ActionEvent event) {
    }

    @FXML
    private void vol(ActionEvent event) {
    }

    @FXML
    private void reserver(ActionEvent event) {
    }
    }

  
    

