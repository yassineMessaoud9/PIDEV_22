/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.ServiceEvenement;
import esprit.com.Imservices.ServiceReclamation;
import esprit.com.Imservices.ServiceTicket;
import esprit.com.entity.Reclamation;
import esprit.com.entity.Ticket;
import esprit.com.entity.TypeReclamation;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import mailertest.util.JavaMail;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Utilisateur
 */
public class ReclamationController implements Initializable {

    @FXML
    private TextField prixTicket;
    @FXML
    private DatePicker dateT;
    @FXML
    private TableView<Reclamation> tableT;
    @FXML
    private TableColumn<Reclamation, String> col_titre;
    @FXML
    private TableColumn<Reclamation, String> col_Date;
    @FXML
    private TableColumn<Reclamation, String> col_Date1;
    @FXML
    private TableColumn<Reclamation ,Date> col_Date11;
    @FXML
    private TableColumn<Reclamation, String> col_Date111;
    @FXML
    private Button rebtn;
    @FXML
    private Button btADD;
    @FXML
    private Button btndelRe;
    @FXML
    private Button modifyb;
    @FXML
    private TextField tfSearch;
    @FXML
    private Label getType;
    ObservableList<Reclamation> s=FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> TypeRe;
        @FXML
    private TextField descRe;
        private Reclamation Re;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<String> list = FXCollections.observableArrayList ("Abuse","vol", "perte","mauvais service");
            TypeRe.setItems(list);
            
        ServiceReclamation sp = new ServiceReclamation();
        List<Reclamation> a = sp.afficher();
    
        col_titre.setCellValueFactory(new PropertyValueFactory<>("intituleReclamation"));
        col_Date.setCellValueFactory(new PropertyValueFactory<>("etatReclamation"));
        col_Date1.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_Date11.setCellValueFactory(new PropertyValueFactory<>("dateReclamation"));
        col_Date111.setCellValueFactory(new PropertyValueFactory<>("typeReclamation"));
        tableT.getItems().setAll(a);
        
        tfSearch.textProperty().addListener((obs, oldText, newText) -> {
            if(newText.equals("")){
                try{
                    refreshi(null);
                }catch(Exception e){
                    System.out.println("hohoh");
                }
            }
                ServiceReclamation fsp = new ServiceReclamation();
                List<Reclamation> ae = fsp.search(newText);
                tableT.getItems().setAll(ae);
                  });
        // TODO
    }    

    @FXML
    private void refreshi(ActionEvent event) {
        ServiceReclamation sp = new ServiceReclamation();
        List<Reclamation> a = sp.afficher();
    
        col_titre.setCellValueFactory(new PropertyValueFactory<>("intituleReclamation"));
        col_Date.setCellValueFactory(new PropertyValueFactory<>("etatReclamation"));
        col_Date1.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_Date11.setCellValueFactory(new PropertyValueFactory<>("dateReclamation"));
        col_Date111.setCellValueFactory(new PropertyValueFactory<>("typeReclamation"));
        tableT.getItems().setAll(a);
        // TODO
    }

    @FXML
    private void addRec(ActionEvent event) {
        
        
        Image ig = new Image("/esprit/com/src/wrong1.png");
            if(descRe.getText().equals("")|| prixTicket.getText().equals("") || TypeRe.getSelectionModel().getSelectedItem().toString().equals("")||dateT.getValue().equals("")){
                       Notifications notifications=Notifications.create();
                       notifications.graphic(new ImageView(ig));
                       notifications.text("Hello please fill the required fields");
                       notifications.show();
                
            }else{
                  ServiceReclamation se = new ServiceReclamation();
                  String desc  = se.makeFine(descRe.getText());
                        se.ajouter( 
                        new Reclamation(
                        prixTicket.getText(),
                        TypeRe.getSelectionModel().getSelectedItem().toString(),
                        desc,
                        Date.valueOf(dateT.getValue()) ));
                        Image ig1 = new Image("/esprit/com/src/right1.png");
                        Notifications notifications=Notifications.create();
                        notifications.graphic(new ImageView(ig1));
                        notifications.text("Reclamation Ajoutée");
                        notifications.title("Success Message");
                        notifications.show();
            }       
    }

    @FXML
    private void deleteRe(ActionEvent event) {  
        ServiceReclamation st = new ServiceReclamation();
        Reclamation t=new Reclamation();

        t=tableT.getSelectionModel().getSelectedItems().get(0);

        st.supprimer(t);
        refreshi(null);
        System.out.println(t);
        //System.out.println(tick);
    }

    
    @FXML
    void onTableItemSelect(MouseEvent event) {
        System.out.println(";ws;eoirhjugfo;i");
        Reclamation rec = tableT.getSelectionModel().getSelectedItem();
         this.Re = rec;
        System.out.println("ttt " + rec.toString());
       this.prixTicket.setText(rec.getIntituleReclamation());
       this.TypeRe.setValue(rec.getEtatReclamation());
       this.dateT.setValue(rec.getDateReclamation().toLocalDate());
       this.descRe.setText(rec.getDescription());
     
    }
    @FXML
    private void modifyRe(ActionEvent event) {
         ServiceReclamation st = new ServiceReclamation();
        String title = this.prixTicket.getText();
         String tt = this.prixTicket.getText();
        String etat = this.TypeRe.getValue();
        Date date = Date.valueOf(this.dateT.getValue());
       String desc = this.descRe.getText();
       
        Reclamation t=new Reclamation(title, etat, desc, date);
        
        st.modifier(this.Re.getIntituleReclamation(), t);
        refreshi(null);
        System.out.println(t);
    }
    
}
