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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
    @FXML
    private Text textcs;

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
 if (idnomhotel.getText().equals("")|| idadresse.getText().equals("") || Integer.parseInt(idetoile.getText())==0|| Integer.parseInt(idetoile.getText())==0 ||Integer.parseInt(idnbrchambre.getText())==0 ||idphoto.getText().equals("") ){ 
                            new Alert(Alert.AlertType.ERROR,"les champs ne peut pas etre vides" ,ButtonType.CLOSE).show();
       
         }
 else if((idnomhotel.getText().length()>10 ))
 {
                                 new Alert(Alert.AlertType.ERROR,"ce champ ne peut pas depasser les 10 caratères" ,ButtonType.CLOSE).show();

 }
 else if((idadresse.getText().length()>10 ))
 {
                                 new Alert(Alert.AlertType.ERROR,"ce champ ne peut pas depasser les 10 caratères" ,ButtonType.CLOSE).show();

 }
else if(( Integer.parseInt(idetoile.getText())>5  ))
 {
                                 new Alert(Alert.AlertType.ERROR,"ce champ ne peut pas depasser   5 etoile" ,ButtonType.CLOSE).show();

 }
else if(( Integer.parseInt(idnbrchambre.getText())==0 ))
 {
                                 new Alert(Alert.AlertType.ERROR,"ce champ ne peut pas etre null" ,ButtonType.CLOSE).show();

 }
 else 
 {
        sH.ajouter(new Hotel( idnomhotel.getText(),idadresse.getText(),Integer.parseInt(idetoile.getText())
,Integer.parseInt(idnbrchambre.getText())
,idphoto.getText()));
      JOptionPane.showMessageDialog(null, "hotel ajoutèe");
          
    Parent page2 = FXMLLoader.load(getClass().getResource("afficherHotels.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
}
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
    

