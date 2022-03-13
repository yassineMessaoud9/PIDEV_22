/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imagencelocation;
import esprit.com.entity.Agencelocation;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ons
 */
public class AjoutagencelocationController implements Initializable {

    @FXML
    private TextField idNom;
    @FXML
    private TextField idContact;
    @FXML
    private TextField idAdresse;
    @FXML
    private TextField idLogo;
    @FXML
    private Text textError;
    @FXML
    private ImageView imgbg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Image Imaage = new Image("/images/ajouteragence.png");

        imgbg.setImage(Imaage);
    }

    //ajouter agence
    @FXML
    private void ajouterAgence(ActionEvent event) throws IOException {

        Imagencelocation ag = new Imagencelocation();
        if ((idNom.getText().length() > 20)) {
            new Alert(Alert.AlertType.ERROR, "ce champ de passe 9", ButtonType.CLOSE).show();

        } else if (Integer.parseInt(idContact.getText()) > 99999999) {
            new Alert(Alert.AlertType.ERROR, "telephone invalide veuillez saisir 8 CHIFFRES", ButtonType.CLOSE).show();

        } else if (idNom.getText().equals("") || Integer.parseInt(idContact.getText()) == 0 || idAdresse.getText().equals("") || idLogo.getText().equals("")) {
            new Alert(Alert.AlertType.ERROR, "Tous les champs sont obligatoires", ButtonType.CLOSE).show();
        } else {

            ag.ajouter(new Agencelocation(idNom.getText(), Integer.parseInt(idContact.getText()), idAdresse.getText(), idLogo.getText()));
            Notifications notifications = Notifications.create();
            notifications.text("agence ajoutée");
            notifications.title("Sucess Message");
            notifications.show();

            Parent page2 = FXMLLoader.load(getClass().getResource("afficheAgence.fxml"));

            Scene scene2 = new Scene(page2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene2);
            app_stage.show();
        }
    }

    @FXML
    private void Return(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("MenuAdmin2.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

}
