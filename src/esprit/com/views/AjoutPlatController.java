/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImPlat;
import esprit.com.entity.Plat;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class AjoutPlatController implements Initializable {

    @FXML
    private TextField nomPlat;
    @FXML
    private TextField descP;
    @FXML
    private TextField phtoPlat;
    @FXML
    private TextField PrixPlat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  @FXML
    private void AjoutPat(ActionEvent event) {
        ImPlat imp = new ImPlat();
        imp.ajout(new Plat(nomPlat.getText(),Double.parseDouble(PrixPlat.getText()),phtoPlat.getText(),descP.getText()));
                        JOptionPane.showMessageDialog(null, "Plat ajoutée !");

    }
}
