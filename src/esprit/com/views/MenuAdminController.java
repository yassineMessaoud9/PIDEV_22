/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImUtilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class MenuAdminController implements Initializable {

    @FXML
    private AnchorPane gstUtil;
    @FXML
    private ChoiceBox<String> GestioUti;
    @FXML
    private Text WelcomeUSer;
    @FXML
    private ChoiceBox<String> gestSpons;
    @FXML
    private ChoiceBox<String> gestComPl;
    @FXML
    private ChoiceBox<String> GestHoRes;
    @FXML
    private ChoiceBox<String> GestVol;
    @FXML
    private ChoiceBox<String> GestLocVoi;
    @FXML
    private ChoiceBox<String> GestEve;
    @FXML
    private ChoiceBox<String> GestRec;
    @FXML
    private Pane MainPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WelcomeUSer.setText(ImUtilisateur.nameUser);
    }    

    @FXML
    private void GoProfil(ActionEvent event) {
        
    }
    
}
