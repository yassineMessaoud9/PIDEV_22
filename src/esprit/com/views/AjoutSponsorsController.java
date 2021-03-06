/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImSponsors;
import esprit.com.ImServices.imSuivi;
import esprit.com.entity.Sponsors;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class AjoutSponsorsController implements Initializable {

    @FXML
    private Button Logout;
    @FXML
    private TextField ns;
    @FXML
    private TextField ps;
    @FXML
    private DatePicker dd;
    @FXML
    private DatePicker df;
    @FXML
    private Button ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Logout(ActionEvent event) {
    }

    @FXML
    private void Sponsors(ActionEvent event) {
    }

    @FXML
    private void ajouter(ActionEvent event) {
        ImSponsors ims = new ImSponsors();
        ims.ajout(new Sponsors(ns.getText(),Double.parseDouble(ps.getText()),Date.valueOf(dd.getValue()),Date.valueOf(df.getValue())));
                JOptionPane.showMessageDialog(null, "Sponsors ajoutée !");
ns.clear();ps.clear();dd.getEditor().clear();df.getEditor().clear();
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
           Parent page2 = FXMLLoader.load(getClass().getResource("MenuAdmin2.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();

    }
    
}
