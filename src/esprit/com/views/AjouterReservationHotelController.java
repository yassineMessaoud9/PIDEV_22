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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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

        sR.ajouter(new ReservationHotel(typechambre.getText(),Integer.parseInt(nbrnuit.getText()),Date.valueOf(dateReservation.getValue()),Integer.parseInt(nbrpersonne.getText()),Date.valueOf(datealler.getValue()),Date.valueOf(dateretour.getValue()),Integer.parseInt(idu.getText()),comboxoHotel.getSelectionModel().getSelectedItem().intValue()));



       JOptionPane.showMessageDialog(null, "reservationRestau ajoutèe");
    }

    @FXML
    private void retourmenu(ActionEvent event) throws IOException {
           
           Parent page2 = FXMLLoader.load(getClass().getResource("menu.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }
    }
   

