/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Iservices.ServiceHotel;
import esprit.com.Iservices.ServiceReservationHotel;
import esprit.com.Iservices.ServiceRestaurant;
import esprit.com.entity.Hotel;
import esprit.com.entity.ReservationHotel;
import esprit.com.entity.Restaurant;
import esprit.com.utils.ConnectionBd;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author MediaHelp
 */
public class AjouterReservationHotelController implements Initializable {

    @FXML
    private ComboBox<Integer> comboxoHotel;
    @FXML
    private TextField typechambre;
    @FXML
    private TextField nbrnuit;
    @FXML
    private TextField nbrpersonne;
    @FXML
    private DatePicker dateReservation;
    @FXML
    private DatePicker datealler;
    @FXML
    private DatePicker dateretour;
    @FXML
    private TextField idu;
    @FXML
    private Text idtext;
    @FXML
    private Text idchambre;
    @FXML
    private Text Textnbrnuit;
    @FXML
    private Text textcs;

    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
             Connection bd1=ConnectionBd.getInstance().getCnx();

       List<Hotel> list = new ArrayList<>();
        
        try {
            String req = "SELECT idhotel FROM hotel";
            Statement st = bd1.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
             comboxoHotel.getItems().addAll((rs.getInt("idhotel")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      // TODO
    }    

    @FXML
    private void ajouterReservationHotel(ActionEvent event) {
        ServiceReservationHotel sR = new ServiceReservationHotel();
         if(typechambre.getText().equals("")|| Integer.parseInt(nbrnuit.getText())==0||Integer.parseInt(idu.getText())==0||(comboxoHotel.getSelectionModel().getSelectedItem().intValue()==0||dateReservation.getValue().equals(""))){ 
         textcs.setText("saisir  tous les champs!");
       
         }
        else if((typechambre.getText().length()>9) ) {
                            new Alert(Alert.AlertType.ERROR,"ce champ de passe 9",ButtonType.CLOSE).show();

         }
         else if((Integer.parseInt(nbrnuit.getText())==0) ) {
               new Alert(Alert.AlertType.ERROR,"ce champ ne peux pas etre null",ButtonType.CLOSE).show();
             }
       
           else if(ctrl()==false ) {
               new Alert(Alert.AlertType.ERROR,"datedebut ne peut pas etre superier a datefin",ButtonType.CLOSE).show();
             }
         else{
        sR.ajouter(new ReservationHotel(typechambre.getText(),
                Integer.parseInt(nbrnuit.getText()),Date.valueOf(dateReservation.getValue()),Integer.parseInt(nbrpersonne.getText()),Date.valueOf(datealler.getValue()),Date.valueOf(dateretour.getValue()),Integer.parseInt(idu.getText()),comboxoHotel.getSelectionModel().getSelectedItem().intValue()));



       JOptionPane.showMessageDialog(null, "reservationRestau ajoutèe VOUS A"+calculerNobreJours());
        }
         }
    

    @FXML
    private void retourmenu(ActionEvent event) throws IOException {
           
           Parent page2 = FXMLLoader.load(getClass().getResource("menu.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }
    public boolean ctrl()
{String d=datealler.getValue().toString();String f=dateretour.getValue().toString();
     String[] d1=d.split("-");
     String[] f1=f.split("-");
     if(Integer.valueOf(d1[0])<=Integer.valueOf(f1[0])  && Integer.valueOf(d1[1])<=Integer.valueOf(f1[1]) && Integer.valueOf(d1[2])<=Integer.valueOf(f1[2]) )
          return true;
     return false;


}
    public int calculerNobreJours()  {
          String datea=datealler.getValue().toString();
    String dater=dateretour.getValue().toString();
    String[] aller=datea.split("-");
    String[] retour=dater.split("-");
   int nbrjrs= Integer.valueOf(retour[2])- Integer.valueOf(aller[2]);
   int nbrmoi =(Integer.valueOf(retour[1])- Integer.valueOf(aller[1]))*30;
   int nbrannee =(Integer.valueOf(retour[0])- Integer.valueOf(aller[0]))*360;
   

   return (nbrjrs+nbrmoi+nbrannee);
  }  
    }
   

