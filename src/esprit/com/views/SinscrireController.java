/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImUtilisateur;
import esprit.com.entity.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class SinscrireController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    private TextField salaire;
    @FXML
    private TextField adresse;
    private TextField grade;
    @FXML
    private TextField motpasse;
    @FXML
    private TextField pays;
    @FXML
    private TextField email;
    @FXML
    private TextField photo;
    @FXML
    private Button submit;
    @FXML
    private TextField role;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void sisncrire(ActionEvent event) {
        ImUtilisateur uti = new ImUtilisateur();
                      // uti.registre(new Utilisateur("ayass","mess","Ariana Soghra","amaha.messaoud3@gmail.com","yassine","photo","tunis",Role.Admin,"Admin+",100.9));

        uti.registre(new Utilisateur(nom.getText(),prenom.getText(),adresse.getText(),email.getText(),motpasse.getText(),photo.getText(),pays.getText(),role.getText()));
        JOptionPane.showMessageDialog(null, "Personne ajoutée ! , Un email vous a envoyé");
        
    }
    
}
