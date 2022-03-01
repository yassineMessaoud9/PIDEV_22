/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Iservices.ServiceHotel;
import esprit.com.entity.Hotel;
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
 * @author MediaHelp
 */
public class AjouterHotelsController implements Initializable {

    @FXML
    private TextField idnomhotel;
    @FXML
    private TextField idadresse;
    @FXML
    private TextField idetoile;
    @FXML
    private TextField idnbrchambre;
    @FXML
    private TextField idphoto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
        @FXML

    private void ajouterHotel(ActionEvent event) throws IOException { 
        ServiceHotel sH = new ServiceHotel();

        sH.ajouter(new Hotel( idnomhotel.getText(),idadresse.getText(),Integer.parseInt(idetoile.getText())
,Integer.parseInt(idnbrchambre.getText())
,idphoto.getText()));
       // JOptionPane.showMessageDialog(null, "hotel ajoutèe");
          
    Parent page2 = FXMLLoader.load(getClass().getResource("afficherHotels.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
}

    @FXML
    private void retouraffichage(ActionEvent event) throws IOException {
           Parent page2 = FXMLLoader.load(getClass().getResource("afficherHotels.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }
    }
    

