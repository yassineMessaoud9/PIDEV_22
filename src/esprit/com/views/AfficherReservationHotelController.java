/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Iservices.ServiceHotel;
import esprit.com.Iservices.ServiceReservationHotel;
import esprit.com.entity.ReservationHotel;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author MediaHelp
 */
public class AfficherReservationHotelController implements Initializable {

    @FXML
    private TableColumn<ReservationHotel, String> typechambre;
    @FXML
        private TableColumn<ReservationHotel, Integer> nbrnuit;

    @FXML
    private TableColumn<ReservationHotel, Date> dateReservation;
    @FXML
    private TableColumn<ReservationHotel, Integer> nbrpersonne;
    @FXML
    private TableColumn<ReservationHotel, Date> datealler;
    @FXML
    private TableColumn<ReservationHotel, Date> dateretour;

    @FXML
    private TableView<ReservationHotel> reservationhotel;
            ObservableList<ReservationHotel> obsrhotellist=FXCollections.observableArrayList();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadData();
        
        // TODO
        
     
       
    }    
    private void LoadData() {
        ServiceReservationHotel sRH = new ServiceReservationHotel();
        sRH.afficher().stream().forEach((p) -> {obsrhotellist.add(p);});
      typechambre.setCellValueFactory(new PropertyValueFactory<>("typeChambre"));
       nbrnuit.setCellValueFactory(new PropertyValueFactory<>("nbRnuit"));
        dateReservation.setCellValueFactory(new PropertyValueFactory<>("dateReservation"));
       nbrpersonne.setCellValueFactory(new PropertyValueFactory<>("nbrpersonne"));
        datealler.setCellValueFactory(new PropertyValueFactory<>("dateallerReser"));
                dateretour.setCellValueFactory(new PropertyValueFactory<>("dateretourReser"));

        
       reservationhotel.setItems(obsrhotellist);
    }
    
}
