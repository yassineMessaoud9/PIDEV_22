/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ServiceReservationRestaurant;
import esprit.com.entity.ReservationRestaurant;
import esprit.com.entity.Restaurant;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MediaHelp
 */
public class AfficherReservationRestaurantController implements Initializable {

    @FXML
    private TableView<ReservationRestaurant> tableRR;
    @FXML
    private TableColumn<ReservationRestaurant,Date> date1;
    @FXML
    private TableColumn<ReservationRestaurant, Date> date2;
    @FXML
    private TableColumn<ReservationRestaurant, Date> date3;
                  ObservableList<ReservationRestaurant> obsrrestaulist=FXCollections.observableArrayList();
  
    @FXML
    private DatePicker datee1;
    @FXML
    private DatePicker datee3;
    @FXML
    private DatePicker datee22;
ReservationRestaurant rr;
    @FXML
    private AnchorPane datee2;
    @FXML
    private Button delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceReservationRestaurant sR = new ServiceReservationRestaurant();
        sR.afficher().stream().forEach((p) -> {obsrrestaulist.add(p);});
        

      date1.setCellValueFactory(new PropertyValueFactory<>("datereservationrestau"));
       date2.setCellValueFactory(new PropertyValueFactory<>("datedebutres"));
        date3.setCellValueFactory(new PropertyValueFactory<>("datefinres"));
   
        
       tableRR.setItems(obsrrestaulist);
        // TODO
    }    

    @FXML
    private void onTableItemSelect(MouseEvent event) {
          datee1.opacityProperty();
  rr = tableRR.getSelectionModel().getSelectedItem();
     datee1.setValue(rr.getDatereservationrestau().toLocalDate());
          datee22.setValue(rr.getDatedebutres().toLocalDate());
                    datee3.setValue(rr.getDatefinres().toLocalDate());




     
    }
        public void clearFields(){
  datee1.getEditor().clear();
    datee22.getEditor().clear();
    datee3.getEditor().clear();


    }

    @FXML
    private void updateReser(ActionEvent event) {
                ServiceReservationRestaurant sH= new ServiceReservationRestaurant();

                          rr.setDatereservationrestau(Date.valueOf(datee1.getValue()));

         rr.setDatedebutres(Date.valueOf(datee22.getValue()));

         rr.setDatefinres(Date.valueOf(datee3.getValue()));


      

       

      
      sH.modifier2(new ReservationRestaurant(rr.getIdReservationRestaurant(),
              Date.valueOf(datee1.getValue())
              ,Date.valueOf(datee22.getValue()),
              Date.valueOf(datee3.getValue())));
      
     new Alert(Alert.AlertType.INFORMATION,"C BON",ButtonType.CLOSE).show();
     clearFields();
     obsrrestaulist.set(tableRR.getSelectionModel().getFocusedIndex(),rr);
    }

    @FXML
    private void delete(ActionEvent event) {
                ServiceReservationRestaurant sH= new ServiceReservationRestaurant();
                    ReservationRestaurant t=new ReservationRestaurant();

        
      ObservableList obsrrestaulist,a;
    obsrrestaulist=tableRR.getItems();
      a=tableRR.getSelectionModel().getSelectedItems();
            t=tableRR.getSelectionModel().getSelectedItems().get(0);

      sH.supprimer(new ReservationRestaurant(t.getIdReservationRestaurant()));

        System.out.println(t);
                System.out.println(a);

        
      a.forEach(obsrrestaulist::remove);
    }

    @FXML
    private void getviewreset(ActionEvent event) throws IOException {
            Parent page2 = FXMLLoader.load(getClass().getResource("menu.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

   
    }
    

