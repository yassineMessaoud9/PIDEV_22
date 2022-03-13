/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImUtilisateur;
import esprit.com.ImServices.ServiceReservationRestaurant;
import esprit.com.entity.ReservationRestaurant;
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
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author MediaHelp
 */
public class AjouterReservationRestaurantController implements Initializable {

    @FXML
    private DatePicker date1;
    @FXML
    private DatePicker date2;
    @FXML
    private DatePicker date3;
    @FXML
    private ComboBox<Integer> comboxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           Connection bd1=ConnectionBd.getInstance().getCnx();

       List<ReservationRestaurant> list = new ArrayList<>();
        
        try {
            String req = "SELECT idrestau FROM restaurant";
            Statement st = bd1.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
             comboxid.getItems().addAll((rs.getInt("idrestau")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        // TODO
    }    

    @FXML
    private void ajouterReserResrau(ActionEvent event) {
         ServiceReservationRestaurant sR = new ServiceReservationRestaurant();

        sR.ajouter(new ReservationRestaurant(Date.valueOf(date1.getValue()),Date.valueOf(date2.getValue()),Date.valueOf(date3.getValue()),ImUtilisateur.idUser,comboxid.getSelectionModel().getSelectedItem().intValue()));

       JOptionPane.showMessageDialog(null, "RESTAU ajoutèe");
    }

    @FXML
    private void resetmenu1(ActionEvent event) throws IOException {
          
           Parent page2 = FXMLLoader.load(getClass().getResource("MenuClient.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
                  Notifications notifications=Notifications.create();
        notifications.text("reset menu");
        notifications.title("Success Message");
     //   notifications.hideAfter(Duration.seconds(4));
       notifications.darkStyle();
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();
    }
    }
    

