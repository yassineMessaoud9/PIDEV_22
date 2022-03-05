/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imlocation;
import esprit.com.Imservices.Imvoiture;
import esprit.com.entity.KeyValueVoiture;
import esprit.com.entity.Location;
import esprit.com.entity.Voiture;
import esprit.com.utils.ConnectionBd;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author ons
 */
public class AjoutlocationController implements Initializable {
   int x,y,z ,t;
   float tariff;
    int matricule;
    @FXML
    private DatePicker adatedebut;
    @FXML
    private DatePicker adatefin;
  
    @FXML
    private ComboBox<String> amarquevoiture;
Timestamp date;
    @FXML
    private Text selectedtext;
    @FXML
    private ChoiceBox<KeyValueVoiture> select_field;
    private KeyValueVoiture KeyValueVoiture;
    
    
        Imvoiture servicevoiture= new Imvoiture();
        
 final String imageURI = "https://www.challenges.fr/assets/img/2019/01/10/cover-r4x3w1000-5c373e921f6c5-p90333087-highres-jpg.jpg"; 
final Image image = new Image(imageURI,00, 200, false, true);    
    @FXML
    private ImageView idimage= new ImageView(image);
        
       
        
        
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            //LoadDataVoiture();
            
             final String imageURI = "https://www.challenges.fr/assets/img/2019/01/10/cover-r4x3w1000-5c373e921f6c5-p90333087-highres-jpg.jpg"; 
final Image image = new Image(imageURI,00, 200, false, true);  

        LoadDataUser();
        LoadDataSaison() ;
      
        
         servicevoiture.afficherTest().forEach((p)->{
             select_field.getItems().add(new KeyValueVoiture(p.getMatricule(),p.getMarqueVoiture(),p.getTarif())); 
             
             
        }); select_field.setOnAction(event -> {
              matricule=select_field.getValue().getMatricule();
              System.out.println(matricule);
               tariff=select_field.getValue().getTarif();
               System.out.println(tariff);
              });
                 
        
        
   
    }   


    @FXML
    private void Return(ActionEvent event) throws IOException {
          Parent page2 = FXMLLoader.load(getClass().getResource("affichelocation.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

        @FXML
    private void ajouterLocation(ActionEvent event) throws IOException {
          if(ctrl()==false ) {
              new Alert(Alert.AlertType.ERROR,"datedebut ne peut pas etre superier a datefin",ButtonType.CLOSE).show();
             }
          else{
       
          Imlocation l= new Imlocation();
              LocalDateTime now = LocalDateTime.now();
          
               System.out.println("tarifffajout: "+tariff); 
               float montant = calculerMontant();
         l.ajouter(new Location(Date.valueOf(adatedebut.getValue()),Date.valueOf(adatefin.getValue()),Timestamp.valueOf(now),montant,1,matricule,4));
       
     JOptionPane.showMessageDialog(null, "location ajouter! votre montant est: "+calculerMontant()+"dt");
     
        Parent page2 = FXMLLoader.load(getClass().getResource("affichelocation.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
     
 
      } }          
    

    private void LoadDataVoiture() {
     
        Connection cnx = ConnectionBd.getInstance().getCnx();
            // List<Voiture> list = new ArrayList<>();
       try {
            String req = "SELECT * from voitureee ";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
            amarquevoiture.getItems().addAll(rs.getString("marqueVoiture"));
              
           x= rs.getInt("matricule");
             System.out.println(x);
                        }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
 
    
    
    
    
    
    
    
       private void LoadDataUser() {
        Connection cnx = ConnectionBd.getInstance().getCnx();
    try {
            String req = "SELECT idU,prenom from utilisateur";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
         
            y=rs.getInt("idU");
                  
                        }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }
       
       
           private void LoadDataSaison() {
        Connection cnx = ConnectionBd.getInstance().getCnx();
    try {
            String req = "SELECT idSaison,nomSaison from saison";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
         
            z=rs.getInt("idSaison");
              
                        }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }
           
           


           
           
           
         public float calculerMontant(){
      //   float f=LoadDataTarifVoiture();
            System.out.println("tarif"+ tariff);
        return (tariff*calculerNobreJours());
         
         }
     
       
  public int calculerNobreJours()  {
          String datea=adatedebut.getValue().toString();
    String dater=adatefin.getValue().toString();
    String[] aller=datea.split("-");
    String[] retour=dater.split("-");
   int nbrjrs= Integer.valueOf(retour[2])- Integer.valueOf(aller[2]);
   int nbrmoi =(Integer.valueOf(retour[1])- Integer.valueOf(aller[1]))*30;
   int nbrannee =(Integer.valueOf(retour[0])- Integer.valueOf(aller[0]))*360;
   

   return (nbrjrs+nbrmoi+nbrannee);
  } 
  
  
  
  
   public boolean ctrl()
{String d=adatedebut.getValue().toString();String f=adatefin.getValue().toString();
     String[] d1=d.split("-");
     String[] f1=f.split("-");
     if(Integer.valueOf(d1[0])<=Integer.valueOf(f1[0])  && Integer.valueOf(d1[1])<=Integer.valueOf(f1[1]) && Integer.valueOf(d1[2])<=Integer.valueOf(f1[2]) )
          return true;
     return false;
}
}
