/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Iservices.ServiceReservationHotel;
import esprit.com.entity.Hotel;
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
public class AfficherreserHotellController implements Initializable {

    @FXML
    private TableView<ReservationHotel> reservationhotel;
    @FXML
    private TableColumn<ReservationHotel, String> typechambre;
    @FXML
    private TableColumn<ReservationHotel, Integer> nbrnuit;
    @FXML
    private TableColumn<ReservationHotel, Date> dateReservation;
    @FXML
    private TableColumn<ReservationHotel, Integer> nbrpersonne;
    @FXML
    private TableColumn<ReservationHotel,Date> datealler;
      @FXML
    private TableColumn<ReservationHotel, Integer> idu;
    @FXML
    private TableColumn<ReservationHotel, Integer> idtourisme;
    @FXML
    private TableColumn<ReservationHotel, Date> dateretour;
              ObservableList<ReservationHotel> obsreshotellist=FXCollections.observableArrayList();
  


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServiceReservationHotel sRh = new ServiceReservationHotel();
        sRh.afficher().stream().forEach((p) -> {obsreshotellist.add(p);});
        
      // col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
      // idhotel.setCellValueFactory(new PropertyValueFactory<>("idhotel"));
         typechambre.setCellValueFactory(new PropertyValueFactory<>("typeChambre"));
       nbrnuit.setCellValueFactory(new PropertyValueFactory<>("nbrnuit"));
        dateReservation.setCellValueFactory(new PropertyValueFactory<>("datereservation"));
       nbrpersonne.setCellValueFactory(new PropertyValueFactory<>("nbrpersonne"));
        datealler.setCellValueFactory(new PropertyValueFactory<>("dateallerReser"));
                dateretour.setCellValueFactory(new PropertyValueFactory<>("dateretourReser"));
                        idu.setCellValueFactory(new PropertyValueFactory<>("idU"));
                    idtourisme.setCellValueFactory(new PropertyValueFactory<>("idhotel"));

                        

        // TODO
    }    
    
}
