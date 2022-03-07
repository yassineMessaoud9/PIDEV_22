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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class MenuAdmin2Controller implements Initializable {

    @FXML
    private BorderPane borderPaneid;
    @FXML
    private Text WelcomeUSer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        borderPaneid.setBottom(null);
    }    

    @FXML
    private void GoProfil(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("pdf.fxml"));
        borderPaneid.setCenter(view);
    }

    @FXML
    private void GoUtilisateur(ActionEvent event) throws IOException {
         AnchorPane view = FXMLLoader.load(getClass().getResource("show.fxml"));
        borderPaneid.setCenter(view);
    }

    @FXML
    private void GoSponsoring(ActionEvent event) {
    }

    @FXML
    private void GoCommandPlat(ActionEvent event) {
    }

    @FXML
    private void GoHotelRestau(ActionEvent event) {
    }

    @FXML
    private void GoVol(ActionEvent event) {
    }

    @FXML
    private void GoLocation(ActionEvent event) {
    }

    @FXML
    private void GoEvenement(ActionEvent event) {
    }

    @FXML
    private void GoReclamation(ActionEvent event) {
    }
    
}
