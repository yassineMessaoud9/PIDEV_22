/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imadresse;
import esprit.com.Imservices.Imavion;
import esprit.com.entity.adresse;
import esprit.com.entity.avion;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Gamer
 */
public class AjouteravionController implements Initializable {

    @FXML
    private TextField numserie;
    @FXML
    private TextField marque;
    @FXML
    private TextField nbrplace;
    @FXML
    private Button ajout;
    @FXML
    private Button ann;
    @FXML
    private Button term;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        // controle de saisie
            if(numserie.getText().equals("")|| marque.getText().equals("")||nbrplace.getText().equals("")){
            Notifications notifications=Notifications.create();
            notifications.text("champs vide");
            notifications.title("Message d'erreur");
            notifications.show();
             }
        // ajoute avion    
        else{
            Imavion Imavion= new Imavion();
            Imavion.ajouter(new avion(Integer.parseInt(numserie.getText()),marque.getText(),Integer.parseInt(nbrplace.getText())));
            Notifications notifications=Notifications.create();
            notifications.text("adresse ajoutéé");
            notifications.title("Success Message");
            notifications.show();   
                   }
    }
    
    public void clearFields(){
        numserie.clear();
        marque.clear();
        nbrplace.clear();}

    @FXML
    private void annuler(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void terminer(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("Avionboard.fxml"));
        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }
}
