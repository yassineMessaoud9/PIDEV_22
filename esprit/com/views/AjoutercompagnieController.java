/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imadresse;
import esprit.com.Imservices.Imcompagnieaerienne;
import esprit.com.entity.KeyValuePair;
import esprit.com.entity.adresse;
import esprit.com.entity.compagnieaerienne;
import esprit.com.utils.ConnectionBd;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Gamer
 */
public class AjoutercompagnieController implements Initializable {
int x ;
    @FXML
    private TextField nomcompagnie;
    private TableView<adresse> tableadresse;
    private compagnieaerienne compagnieaerienne;
    private ComboBox<String> combo;
    @FXML
    private ChoiceBox<KeyValuePair> select_field;
    Imadresse imadresse= new Imadresse();
    int idadresse;
    adresse adr =new adresse ();
    /**
     * Initializes the controller class.
     */
    @Override
// pour que le combox a les pays     
    public void initialize(URL url, ResourceBundle rb) {
        imadresse.afficher().forEach((p)->{
        select_field.getItems().add(new KeyValuePair(p.getIdadresse(),p.getPaysadresse()));      
        select_field.setOnAction(event -> {
        idadresse=select_field.getValue().getIdadresse();  
              });  
        });  
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        //controle de saisie 
        if(select_field.equals("")|| nomcompagnie.getText().equals("")){
            Notifications notifications=Notifications.create();
            notifications.text("champs vide");
            notifications.title("Message d'erreur");
            notifications.show();
        }
        //ajout d"une compagnie 
        else{
         Imcompagnieaerienne imcompagnieaerienne= new Imcompagnieaerienne();
         imcompagnieaerienne.ajouter(new compagnieaerienne (nomcompagnie.getText(),idadresse));
         Notifications notifications=Notifications.create();     
         notifications.text("compagnie ajoutéé");
         notifications.title("Success Message");   
         notifications.show();
          }
    }
    @FXML
    private void annuler(ActionEvent event) {
    }
        
    @FXML
    private void terminer(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("compagnieboard.fxml"));
        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }
     
// ne marche pas correctement     
    private void jonturesansjounture(){
       Connection cnx = ConnectionBd.getInstance().getCnx();
        try {
            String req1 = "select  * from adresse";
            PreparedStatement pst1 = cnx.prepareStatement(req1);
            ResultSet rs1 = pst1.executeQuery();
            while(rs1.next()) {
           combo.getItems().addAll(rs1.getString("paysadresse"));
            x=rs1.getInt("idadresse");
               // System.out.println("Pays: "+rs1.getString("paysadresse")+" Id: "+x);
                        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   }   
}
