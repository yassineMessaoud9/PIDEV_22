/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Iservices.ServiceRestaurant;
import esprit.com.entity.Restaurant;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MediaHelp
 */
public class AjouterRestaurantController implements Initializable {

    @FXML
    private TextField idnomrestau;
    @FXML
    private ComboBox<String> idtyperestau;
    @FXML
    private TextField idnbrtable;
    @FXML
    private TextField idlocalisation;
    @FXML
    private TextField idtelephone;
    @FXML
    private TextField idphoto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      ObservableList<String> options = 
    FXCollections.observableArrayList(
        "5FORCHETTE ",
        "4 FORCHETTE ",
        " 3 FORCHETTE"
    );
            idtyperestau.setItems(options);

    }    

    @FXML
    private void ajouterRestau(ActionEvent event) {
         ServiceRestaurant sR = new ServiceRestaurant();

        sR.ajouter(new Restaurant( idnomrestau.getText(),idtyperestau.getSelectionModel().getSelectedItem().toString(),Integer.parseInt(idnbrtable.getText()),idlocalisation.getText(),Integer.parseInt(idtelephone.getText()),idnomrestau.getText()));

       JOptionPane.showMessageDialog(null, "RESTAU ajoutèe");
    }

    @FXML
    private void resetmenu2(ActionEvent event) throws IOException {
          
           Parent page2 = FXMLLoader.load(getClass().getResource("menu.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }
    }
    
    

