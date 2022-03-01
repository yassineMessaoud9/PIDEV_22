/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imagencelocation;
import esprit.com.Imservices.Imsaison;
import esprit.com.entity.Agencelocation;
import esprit.com.entity.Saison;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ons
 */
public class AjoutsaisonController implements Initializable {

    @FXML
    private TextField idNom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterSaison(ActionEvent event) throws IOException {
         Imsaison sai= new Imsaison();
     sai.ajouter(new Saison(idNom.getText()));
     JOptionPane.showMessageDialog(null, "Saison ajouter!");
     
       Parent page2 = FXMLLoader.load(getClass().getResource("affichesaison.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    @FXML
    private void Return(ActionEvent event) throws IOException {
          Parent page2 = FXMLLoader.load(getClass().getResource("affichesaison.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }
    
}
