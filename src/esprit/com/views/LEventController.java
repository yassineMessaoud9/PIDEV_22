/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.ServiceEvenement;
import esprit.com.Imservices.ServiceTicket;
import esprit.com.entity.Ticket;
import esprit.com.entity.key_valueEvenement;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class LEventController implements Initializable {

    @FXML
    private TableView<Ticket> tableT;
    @FXML
    private TableColumn<Ticket, Float> col_prix;
    @FXML
    private TableColumn<Ticket, String> col_date;
    @FXML
    private TableColumn<Ticket, String> col_nom1;

    private List<Ticket> tickets;
     private Ticket Tickett;
  
    private ServiceEvenement ev = new  ServiceEvenement();
    int idE;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        tableT.setEditable(true);
        ServiceTicket st = new ServiceTicket();
        List<Ticket>lt =st.afficherjoin();
        tickets = new ArrayList<>();
        
       

           
        col_date.setCellValueFactory(new PropertyValueFactory<Ticket,String>("dateTicket"));
  
        //col_date.setCellFactory(TextFieldTableCell.forTableColumn());
        
        col_prix.setCellValueFactory(new PropertyValueFactory<Ticket, Float>("prixTicket"));
        col_prix.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        col_nom1.setCellValueFactory(new PropertyValueFactory<>("intituleEve"));
        tableT.getItems().setAll(lt);
   
         
            
  
            
       /* ObservableList<Ticket> data=FXCollections.observableArrayList(s);
        tableT.getItems().setAll(s);*/
               
    }    

    @FXML
    private void onTableItemSelect(MouseEvent event) {
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("MenuClient.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }
    
}
