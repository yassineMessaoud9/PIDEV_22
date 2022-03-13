/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class AfficherReservationHotelController implements Initializable {

    @FXML
    private TableView<?> reservationhotel;
    @FXML
    private TableColumn<?, ?> typechambre;
    @FXML
    private TableColumn<?, ?> nbrnuit;
    @FXML
    private TableColumn<?, ?> dateReservation;
    @FXML
    private TableColumn<?, ?> nbrpersonne;
    @FXML
    private TableColumn<?, ?> datealler;
    @FXML
    private TableColumn<?, ?> dateretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
