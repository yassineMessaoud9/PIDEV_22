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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author MediaHelp
 */
public class PdfController implements Initializable {

   
    private Button export;
   private TableView <Hotel>pdftable;
    private TableView<Hotel> tablepdf;
    @FXML
    private Button export2;
    @FXML
    private TableView<ReservationHotel> tableReser;
    @FXML
    private TableColumn<ReservationHotel,String > typech;
    @FXML
    private TableColumn<ReservationHotel, Integer> nbrnuit;
    @FXML
    private TableColumn<ReservationHotel, Date> dateres;
    @FXML
    private TableColumn<ReservationHotel, Date> nbrpersonne;
    @FXML
    private TableColumn<ReservationHotel, Date> datealler;
    @FXML
    private TableColumn<ReservationHotel, Date> dateretour;
    @FXML
    private TableColumn<?, ?> dateretour1;
    @FXML
    private TableColumn<?, ?> dateretour2;
    @FXML
    private TableColumn<?, ?> dateretour21;
                 ObservableList<ReservationHotel> obsrehotellist=FXCollections.observableArrayList();
    private AnchorPane report11;
    @FXML
    private AnchorPane report50;
    @FXML
    private AnchorPane report88;
    @FXML
    private AnchorPane report12;

  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              ServiceReservationHotel sH = new ServiceReservationHotel();
        sH.afficher().stream().forEach((p) -> {obsrehotellist.add(p);});
         typech.setCellValueFactory(new PropertyValueFactory<>("typeChambre"));
            nbrnuit.setCellValueFactory(new PropertyValueFactory<>("nbrNuit"));


      dateres.setCellValueFactory(new PropertyValueFactory<>("dateReservation"));
     nbrpersonne.setCellValueFactory(new PropertyValueFactory<>("nbrPersonne"));
     datealler.setCellValueFactory(new PropertyValueFactory<>("dateretourReser"));
        dateretour.setCellValueFactory(new PropertyValueFactory<>("dateretourReser"));
        
       tableReser.setItems(obsrehotellist);
     
          
    }    
        // TODO

    private void pdf() {
        
    }
    


    @FXML
    private void savepdf(ActionEvent event) {
         System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
             Window primaryStage = null;
             job.showPrintDialog(primaryStage); 
            
             Node root=this.report50;   
              job.printPage(root);
              job.endJob();
        
    }
    
}

    @FXML
    private void onTableItemSelect(MouseEvent event) {
    }

   
}
