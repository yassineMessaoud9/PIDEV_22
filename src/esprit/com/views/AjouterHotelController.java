/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Iservices.ServiceHotel;
import esprit.com.entity.Hotel;
import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MediaHelp
 */
public class AjouterHotelController implements Initializable {

    /**
     * Initializes the controller class.
     */
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
        JOptionPane.showMessageDialog(null, "hotel ajoutèe");

       

    }

    
}
