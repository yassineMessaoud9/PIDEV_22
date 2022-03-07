/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ServiceReservationHotel;
import esprit.com.entity.ReservationHotel;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JFileChooser;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import java.io.BufferedReader;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import static sun.management.ConnectorAddressLink.export;


/**
 * FXML Controller class
 *
 * @author MediaHelp
 */
public class ShowhotelController implements Initializable {

    @FXML
    private TableView<ReservationHotel> tableReser;
    @FXML
    private TableColumn<ReservationHotel, String> typech;
    @FXML
    private TableColumn<ReservationHotel, Integer> nbrnuit;
    @FXML
    private TableColumn<ReservationHotel, Date> dateres;
    @FXML
    private TableColumn<ReservationHotel, Integer> nbrpersonne;
    @FXML
    private TableColumn<ReservationHotel, Date> datealler;
             ObservableList<ReservationHotel> obsrehotellist=FXCollections.observableArrayList();

    @FXML
    private TableColumn<ReservationHotel, Integer> dateretour;
 private ReservationHotel rhotel ;
    @FXML
    private TextField typeCh;
    @FXML
    private TextField nbrnuit1;
    @FXML
    private DatePicker datereserv1;
    @FXML
    private TextField nbpersonne;
    @FXML
    private DatePicker datealler1;
    @FXML
    private DatePicker dateretour11;
    @FXML
    private AnchorPane report;
    @FXML
    private TableColumn<ReservationHotel,String > dateretour1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceReservationHotel sH = new ServiceReservationHotel();
        sH.afficher().stream().forEach((p) -> {obsrehotellist.add(p);});
        
   //  dateretour21.setCellValueFactory(new PropertyValueFactory<>("idReservationHotel"));
    // dateretour1.setCellValueFactory(new PropertyValueFactory<>("idhotel"));
   ///   dateretour2.setCellValueFactory(new PropertyValueFactory<>("idU"));
         //   nbrnuit.setCellValueFactory(new PropertyValueFactory<>("nbrnuit"));
      typech.setCellValueFactory(new PropertyValueFactory<>("typeChambre"));
            nbrnuit.setCellValueFactory(new PropertyValueFactory<>("nbrNuit"));


      dateres.setCellValueFactory(new PropertyValueFactory<>("dateReservation"));
     nbrpersonne.setCellValueFactory(new PropertyValueFactory<>("nbrPersonne"));
     datealler.setCellValueFactory(new PropertyValueFactory<>("dateretourReser"));
        dateretour.setCellValueFactory(new PropertyValueFactory<>("dateretourReser"));
                dateretour1.setCellValueFactory(new PropertyValueFactory<>("nomhotel"));

       tableReser.setItems(obsrehotellist);
              //   export.setOnAction(event ->{pdf(event);});

       
    }    
     @FXML
    private void onTableItemSelect(MouseEvent event) {
         typeCh.opacityProperty();
  rhotel = tableReser.getSelectionModel().getSelectedItem();
      typeCh.setText(rhotel.getTypeChambre());
           nbrnuit1.setText(String.valueOf(rhotel.getNbrNuit()));
               datereserv1.setValue(rhotel.getDateReservation().toLocalDate());
           nbpersonne.setText(String.valueOf(rhotel.getNbrPersonne()));


                datealler1.setValue(rhotel.getDateallerReser().toLocalDate());
      dateretour11.setValue(rhotel.getDateretourReser().toLocalDate());
    }
    
     public void clearFields(){
  typeCh.clear();
nbrnuit1.clear();
datereserv1.getEditor().clear();
nbpersonne.clear();
datealler1.getEditor().clear();
dateretour11.getEditor().clear();
       // nbrtable.clear();
      //  localisation.clear();
      //  telephone.clear();
       // photo.clear();
    }
    @FXML
    private void updateReservation(ActionEvent event) {
                        ServiceReservationHotel sH= new ServiceReservationHotel();
                        rhotel.setTypeChambre(typeCh.getText());
                                   rhotel.setNbrNuit(Integer.parseInt(nbrnuit1.getText()));


             rhotel.setDateReservation(Date.valueOf(datereserv1.getValue()));
               rhotel.setNbrPersonne(Integer.parseInt(nbpersonne.getText()));


                     rhotel.setDateallerReser(Date.valueOf(datealler1.getValue()));
                        rhotel.setDateretourReser(Date.valueOf(dateretour11.getValue()));



      

       

      
      sH.modifier2(new ReservationHotel(rhotel.getIdReservationHotel(),typeCh.getText(),Integer.parseInt(nbrnuit1.getText()), Date.valueOf(datereserv1.getValue()),Integer.parseInt(nbpersonne.getText()), Date.valueOf(datealler1.getValue()), Date.valueOf(dateretour11.getValue())));

             
      
     new Alert(Alert.AlertType.INFORMATION,"modifier",ButtonType.CLOSE).show();
     clearFields();
     obsrehotellist.set(tableReser.getSelectionModel().getFocusedIndex(),rhotel);
    }

    @FXML
    private void delete(ActionEvent event) {
         ServiceReservationHotel sH= new ServiceReservationHotel();
                    ReservationHotel t=new ReservationHotel();

        
      ObservableList obsrehotellist,a;
    obsrehotellist=tableReser.getItems();
      a=tableReser.getSelectionModel().getSelectedItems();
            t=tableReser.getSelectionModel().getSelectedItems().get(0);

      sH.supprimer(new ReservationHotel(t.getIdReservationHotel()));

        System.out.println(t);
                System.out.println(a);

        
      a.forEach(obsrehotellist::remove);
    }

    @FXML
    private void getview(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("menu.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
  
   }
//         
//        
//        
//        
//        
//        

    @FXML
    private void envoyermail(ActionEvent event) throws IOException {
         Parent page2 = FXMLLoader.load(getClass().getResource("mailing.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();

    }

    private void pdf(ActionEvent event) {
          System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
             Window primaryStage = null;
             job.showPrintDialog(primaryStage); 
            
             Node root=this.tableReser;   
              job.printPage(root);
              job.endJob();
                
    }
   }

    @FXML
    private void changevalue(ActionEvent event) {
    }

    @FXML
    private void getViewPdf(ActionEvent event) throws IOException {
         Parent page2 = FXMLLoader.load(getClass().getResource("pdf.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();

    }

}
    

   

