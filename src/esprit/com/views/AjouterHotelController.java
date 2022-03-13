/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class AjouterHotelController implements Initializable {

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
    private void ajouterHotel(ActionEvent event) {
    }
    
}
