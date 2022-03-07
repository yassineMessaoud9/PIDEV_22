/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imadresse;
import esprit.com.entity.adresse;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Gamer
 */
public class AjouteradresseController implements Initializable {

    @FXML
    private TextField paysadresse;
    @FXML
    private TextField rueadresse;
    @FXML
    private TextField contactadresse;
    @FXML
    private Button annul;
    @FXML
    private Button term;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  


    @FXML
    private void ajouteradresse(ActionEvent event) {
  
           if(paysadresse.getText().equals("")|| rueadresse.getText().equals("")||contactadresse.getText().equals("")){
          
            Notifications notifications=Notifications.create();
           
            notifications.text("champs vide");
            notifications.title("Message d'erreur");
            
            notifications.show();
            
        }
        else{
             
           Imadresse Imadresse= new Imadresse();
       
            Imadresse.ajouter(new adresse(paysadresse.getText(),rueadresse.getText(),Integer.parseInt(contactadresse.getText())));
            
            Notifications notifications=Notifications.create();
              
            notifications.text("adresse ajoutéé");
            notifications.title("Success Message");
            //notifications.darkStyle();
              notifications.show();
        }
        
        
        
        
        
        //FXMLLoader loader= new FXMLLoader(getClass().getResource("../views/Ajouteradresse.fxml"));
    }
       public void clearFields(){
        paysadresse.clear();
        rueadresse.clear();
        contactadresse.clear();
       
    }

    @FXML
    private void annuler(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void terminer(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("adresseboard.fxml"));

         Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }
    
}
