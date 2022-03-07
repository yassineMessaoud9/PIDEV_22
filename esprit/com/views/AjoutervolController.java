/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imadresse;
import esprit.com.Imservices.Imcompagnieaerienne;
import esprit.com.Imservices.Imvol;
import esprit.com.entity.adresse;
import esprit.com.entity.jointure;
import esprit.com.entity.vol;
import esprit.com.utils.ConnectionBd;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Gamer
 */
public class AjoutervolController implements Initializable {

    @FXML
    private DatePicker datealler;
    @FXML
    private DatePicker dateretour;
    @FXML
    private TextField tempsaller;
    @FXML
    private TextField tempsretour;
    @FXML
    private TextField destination;
    @FXML
    private TextField prixvol;
    private ComboBox<String> compagnie;
    @FXML
    private ComboBox<Integer> numserieav;
    @FXML
    private TextField classvol;
    @FXML
    private TextField typevol;
    @FXML
    private Text Error;
    @FXML
    private ChoiceBox<jointure> choicecompagnie;
    Imcompagnieaerienne comp = new Imcompagnieaerienne();
    int idcompagnie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // pour le num serieavion affichage combobox
        getnumavion();
       // pour le nom du compagnie affichage combobox
        comp.afficher().forEach((p)->{
        choicecompagnie.getItems().add(new jointure(p.getIdcompagnie(),p.getNomcompagnie())); 
        choicecompagnie.setOnAction(event -> {
        idcompagnie=choicecompagnie.getValue().getIdcompagnie();       
     });  
        });
    }    

    
    @FXML
    private void Ajouter(ActionEvent event) {
        Notifications notifications=Notifications.create();
        // controle des saisie date et champs vide
        if(tempsaller.getText().equals("")|| Float.parseFloat(prixvol.getText())==0||destination.getText().equals("")||classvol.getText().equals("")||numserieav.equals("")||controledate()==false){
            notifications.text("champs vide ou date erroné");
            notifications.title("Message d'erreur");
            notifications.show();
           }
        // ajouter vole 
        else{
            Imvol Imvol= new Imvol();
            Imvol.ajouter(new vol(Date.valueOf(datealler.getValue()),tempsaller.getText(),Date.valueOf(dateretour.getValue()),tempsretour.getText(),destination.getText(),classvol.getText(),Float.parseFloat(prixvol.getText()),typevol.getText(),idcompagnie,numserie));      
            notifications.text("vol ajoutéé");
            notifications.title("Success Message");
            notifications.show();
            }
    } 
    public boolean controledate (){
    String datea=datealler.getValue().toString();
    String dater=dateretour.getValue().toString();
    String[] aller=datea.split("-");
    String[] retour=dater.split("-");
    if(Integer.valueOf(aller[0])<=Integer.valueOf(retour[0])&&Integer.valueOf(aller[1])<=Integer.valueOf(retour[1])&&Integer.valueOf(aller[2])<=Integer.valueOf(retour[2])) 
        return true;
    else
        return false;   
    }


    @FXML
    private void annuler(ActionEvent event) {
    }

    @FXML
    private void terminer(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("volboard.fxml"));
        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }
    
    
    
    
    
    
    
    vol vol =new vol ();
    int x ;
    int v ;
    int numserie ;
    
// fonction ne marche pas correctement
    private void LoadData(){
        Connection cnx = ConnectionBd.getInstance().getCnx();
       try {
            String req = "select idcompagnie,nomcompagnie from compagnieaerienne";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
            compagnie.getItems().addAll(rs.getString("nomcompagnie"));
            x=rs.getInt("idcompagnie");
                        }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }         
   }
// recupere les numero de serie des avion    
    private void getnumavion(){
        Connection cnx = ConnectionBd.getInstance().getCnx();
              try {
            String req1 = "select numserieavion from avion";
            PreparedStatement pst1 = cnx.prepareStatement(req1);
            ResultSet rs1 = pst1.executeQuery();
            while(rs1.next()) {
            numserieav.getItems().addAll(rs1.getInt("numserieavion"));
            }
            numserieav.setOnAction(event -> {
            numserie=numserieav.getValue();     
          });     
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
   }
}
