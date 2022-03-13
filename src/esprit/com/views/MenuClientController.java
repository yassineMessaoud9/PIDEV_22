/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImUtilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class MenuClientController implements Initializable {

    @FXML
    private BorderPane borderPaneid;
    @FXML
    private Text WelcomeUSer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //         borderPaneid.setBottom(null);
        WelcomeUSer.setText(ImUtilisateur.nameUser);
    }    

    @FXML
    private void GoCommandPlat(ActionEvent event) throws IOException {
       
        AnchorPane view = FXMLLoader.load(getClass().getResource("messComPlat.fxml"));
        borderPaneid.setCenter(view);
    }

    @FXML
    private void GoHotelRestau(ActionEvent event) throws IOException {
            
               AnchorPane view = FXMLLoader.load(getClass().getResource("AsmaClient.fxml"));
        borderPaneid.setCenter(view);
    }

    @FXML
    private void GoVol(ActionEvent event)throws IOException {
         AnchorPane view = FXMLLoader.load(getClass().getResource("reservationvol2.fxml"));
        borderPaneid.setCenter(view);
    }

    @FXML
    private void GoLocation(ActionEvent event)throws IOException {
         AnchorPane view = FXMLLoader.load(getClass().getResource("Usermain.fxml"));
        borderPaneid.setCenter(view);
    }

    @FXML
    private void GoEvenement(ActionEvent event) throws IOException { 
        AnchorPane view = FXMLLoader.load(getClass().getResource("LEvent.fxml"));
        borderPaneid.setCenter(view);
    }

    @FXML
    private void GoReclamation(ActionEvent event) throws IOException  {
         AnchorPane view = FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
        borderPaneid.setCenter(view);
    }

    @FXML
    private void Logout(ActionEvent event) throws IOException {
       /* Parent page2 = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();*/
    }
    
}
