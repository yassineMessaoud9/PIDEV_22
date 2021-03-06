/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import esprit.com.ImServices.ServiceReservationHotel;
import esprit.com.entity.Hotel;
import esprit.com.entity.ReservationHotel;
import java.io.FileOutputStream;
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
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.text.Document;
 


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
                 ObservableList<ReservationHotel> obsrehotellist=FXCollections.observableArrayList();
    private AnchorPane report11;
    @FXML
    private AnchorPane report88;

  
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
    private void savepdf(ActionEvent event)  {
     System.out.println("To Printer!");
       
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
             Window primaryStage = null;
             job.showPrintDialog(primaryStage); 
            
             Node root=this.report88
;   
              job.printPage(root);
              
              job.endJob(); 

    
        
    }
    }

    @FXML
    private void onTableItemSelect(MouseEvent event) {
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
         Parent page2 = FXMLLoader.load(getClass().getResource("MenuAdmin2.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

   
}
