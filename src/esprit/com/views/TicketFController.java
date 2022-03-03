/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.ServiceTicket;
import esprit.com.entity.Ticket;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import javafx.scene.input.MouseEvent;

import javafx.util.converter.FloatStringConverter;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Utilisateur
 */
public class TicketFController implements Initializable {
    @FXML
    private Button btndel;

    @FXML
    private TextField prixTicket;
    @FXML
    private DatePicker dateT;
    @FXML
    private TableView<Ticket> tableT;
    @FXML
    private TableColumn<Ticket, Float> col_prix;
    @FXML
    private TableColumn<Ticket, String> col_date;
    @FXML
    private Button rebtn;
    @FXML
    private TextField tfSearch;
    @FXML
    private Button btnadd;
    
    ObservableList<Ticket> s=FXCollections.observableArrayList();
    @FXML
    private Button modifyt;
    @FXML
    private RadioButton RBTrixP;
    @FXML
    private RadioButton tribDate;
    
    
    @FXML
    private TextField prixField;
    

    private List<Ticket> tickets;
    
    private Ticket Tickett;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tableT.setEditable(true);
        ServiceTicket st = new ServiceTicket();
        tickets = new ArrayList<>();
        st.afficher().stream().forEach((p) -> {s.add(p); tickets.add(p);} );
        col_date.setCellValueFactory(new PropertyValueFactory<>("dateTicket"));
      // col_date.setCellFactory(TextFieldTableCell.forTableColumn());
        
        col_prix.setCellValueFactory(new PropertyValueFactory<Ticket, Float>("prixTicket"));
        col_prix.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        
            col_prix.setOnEditCommit(new EventHandler<CellEditEvent<Ticket, Float>>() {
            @Override
            public void handle(CellEditEvent<Ticket, Float> event) {
                Ticket tt = event.getRowValue();
                tt.setPrixTicket(event.getNewValue());
               ServiceTicket st = new  ServiceTicket();
               st.modifier(tt);

            }});
            
            //col_date.setOnEditCommit(event -> event.getRowValue().setDateTicket(event.getNewValue()));
            
            
        ObservableList<Ticket> data=FXCollections.observableArrayList(s);
        tableT.getItems().setAll(s);
            
                
        tfSearch.textProperty().addListener((obs, oldText, newText) -> {
            if(newText.equals("")){
                try{
                    refresh(null);
                }catch(Exception e){
                    System.out.println("hohoh");
                }
            }
                ServiceTicket fsp = new ServiceTicket();
                List<Ticket> ae = fsp.search(Float.parseFloat(newText));
                tableT.getItems().setAll(ae);
                  });
             
    }
    @FXML
    private void refresh(ActionEvent event) throws SQLException {
        
                ServiceTicket sp = new ServiceTicket();
                List<Ticket> a = sp.afficher();
                col_prix.setCellValueFactory(new PropertyValueFactory<>("prixTicket"));
                col_date.setCellValueFactory(new PropertyValueFactory<>("dateTicket"));
                ObservableList<Ticket> data=FXCollections.observableArrayList(s);
                tableT.getItems().setAll(a);
     
    
  
    
   
    }
    void update(){
        
                ServiceTicket sp = new ServiceTicket();
                List<Ticket> a = sp.afficher();
                col_prix.setCellValueFactory(new PropertyValueFactory<>("prixTicket"));
                col_date.setCellValueFactory(new PropertyValueFactory<>("dateTicket"));
                ObservableList<Ticket> data=FXCollections.observableArrayList(s);
                tableT.getItems().setAll(a);
    }
    

    @FXML
    private void ADDticket(ActionEvent event) {
         Image ig = new Image("/esprit/com/src/wrong1.png");
        if(prixTicket.getText().equals("") || dateT.getValue().equals("")){
            Notifications notifications=Notifications.create();
            notifications.graphic(new ImageView(ig));
            notifications.text("Hello please fill the required fields");
            notifications.title("Failed Message");
            notifications.show();
        }
        else{
              Image ig1 = new Image("/esprit/com/src/right1.png");

            ServiceTicket st = new ServiceTicket();
            st.ajouter(new Ticket( Float.parseFloat(prixTicket.getText()),Date.valueOf(dateT.getValue())));
            update();
            Notifications notifications=Notifications.create();
            notifications.graphic(new ImageView(ig1));
            notifications.text("Avis ajoutéé");
            notifications.title("Success Message");
            notifications.show();
        }
       
        //JOptionPane.showMessageDialog(null, "Ticket ajoutée");
        
        
    }
    @FXML
    void delete(ActionEvent event) throws IOException, SQLException{
        
      ServiceTicket st = new ServiceTicket();
       Ticket t=new Ticket();

        
            ObservableList s,tick;
            s=tableT.getItems();
            tick=tableT.getSelectionModel().getSelectedItems();
            t=tableT.getSelectionModel().getSelectedItems().get(0);

            st.supprimer(new Ticket(t.getPrixTicket()));
            update();            

                System.out.println(t);
                System.out.println(tick);

    }

    @FXML
    private void modify(ActionEvent event) throws SQLException {
        /*Ticket t=new Ticket();
        ObservableList s,tick;
        ServiceTicket sf=new ServiceTicket();
        tick=tableT.getSelectionModel().getSelectedItems();
        t=tableT.getSelectionModel().getSelectedItems().get(0);
        //Float.parseFloat(prixTicket.setText(t.getPrixTicket()));

       Ticket f = new Ticket(Float.parseFloat(prixTicket.getText()),Timestamp.valueOf(dateT.getValue().atTime(LocalTime.MIN)));
        sf.modifier(f);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Note!");
            alert.setHeaderText(null);
            alert.setContentText("Ticket modified successfully.");
            Optional<ButtonType> result = alert.showAndWait();*/
        ServiceTicket ag= new ServiceTicket();
      
       
       Tickett.setPrixTicket(Float.parseFloat(prixTicket.getText()));
   

      
       //LocalDate localDate = this.dateT.getValue();
       //Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
       // java.sql.Date date = (java.sql.Date) LocalDate.from(instant);
        
              // LocalDateTime localDate = this.dateT.getValue();
        
        int id = -1;
        for(Ticket ti : tickets){
            if(ti.getDateTicket().equals(Date.valueOf(Tickett.getDateTicket().toLocalDate()))){
                id = ti.getIdTicket();
            }
        }
        if(id == -1){
             new Alert(Alert.AlertType.INFORMATION,"error couldnt find",ButtonType.CLOSE).show();
             return;
        }
      ag.modifier(new Ticket(id,Float.parseFloat(prixTicket.getText()), Date.valueOf(dateT.getValue())));
      
     new Alert(Alert.AlertType.INFORMATION,"ticket modifier",ButtonType.CLOSE).show();
     clearFields();
     s.set(tableT.getSelectionModel().getFocusedIndex(),Tickett);
        
        
    }
    
    @FXML
    void onTableItemSelect(MouseEvent event) {
        
        
        prixTicket.opacityProperty();
        Tickett = tableT.getSelectionModel().getSelectedItem();
  
 
       prixTicket.setText(String.valueOf(Tickett.getPrixTicket()));
       this.dateT.setValue(Tickett.getDateTicket().toLocalDate());
     
    }
     public void clearFields(){
       prixTicket.clear();
       dateT.getEditor().clear();
      
    }
    
       @FXML
    void triwithprix(ActionEvent event) {
         ServiceTicket st = new ServiceTicket();
        Ticket t=new Ticket();
         List<Ticket> a = st.TRIPrix();
         col_prix.setCellValueFactory(new PropertyValueFactory<>("prixTicket"));
         col_date.setCellValueFactory(new PropertyValueFactory<>("dateTicket"));
         ObservableList<Ticket> data=FXCollections.observableArrayList(s);
         tableT.getItems().setAll(a);            
         System.out.println(t);

       
   
    }
    @FXML
    void triDate(ActionEvent event) {
          ServiceTicket st = new ServiceTicket();
         Ticket t=new Ticket();
         List<Ticket> a = st.TRIDate();
         col_prix.setCellValueFactory(new PropertyValueFactory<>("prixTicket"));
         col_date.setCellValueFactory(new PropertyValueFactory<>("dateTicket"));
         ObservableList<Ticket> data=FXCollections.observableArrayList(s);
         tableT.getItems().setAll(a);            
         System.out.println(t);
    }

  
    
    
}
