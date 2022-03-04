/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imlocation;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ons
 */
public class AjoutlocationController implements Initializable {
   int x,y,z ,t;
    @FXML
    private DatePicker adatedebut;
    @FXML
    private DatePicker adatefin;
  
    @FXML
    private ComboBox<String> amarquevoiture;
Timestamp date;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        LoadDataVoiture();
        LoadDataUser();
        LoadDataSaison() ;
        System.out.println(x);
   
    }    


    @FXML
    private void Return(ActionEvent event) {
    }

        @FXML
    private void ajouterLocation(ActionEvent event) throws IOException {
          if(ctrl()==false ) {
               new Alert(Alert.AlertType.ERROR,"datedebut ne peut pas etre superier a datefin",ButtonType.CLOSE).show();
             }
          else{
              
         
       // System.out.println(amarquevoiture.getSelectionModel().getSelectedItem().toString());
            //System.out.println(x);
      //  idtyperestau.getSelectionModel().getSelectedItem().toString()
          Imlocation l= new Imlocation();
              LocalDateTime now = LocalDateTime.now();
          
               System.out.println("tarifffajout: "+t); 
                Float montant =calculerMontant();
         l.ajouter(new Location(Date.valueOf(adatedebut.getValue()),Date.valueOf(adatefin.getValue()),Timestamp.valueOf(now), montant,y,x,z));
       
     JOptionPane.showMessageDialog(null, "location ajouter! votre montant est: "+calculerMontant()+"dt");
     
 
      }           //System.out.println(" tarif : "+x);
    }

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
    
    
        private int LoadTarif() {
     
        Connection cnx = ConnectionBd.getInstance().getCnx();
            // List<Voiture> list = new ArrayList<>();
       try {
            String req = "SELECT * from voitureee ";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
            amarquevoiture.getItems().addAll(rs.getString("marqueVoiture"));
              
           t= rs.getInt("tarif");
             System.out.println(x);
                        }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
       return t;
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
            System.out.println("tarif"+ LoadTarif());
        return (t*calculerNobreJours());
         
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
