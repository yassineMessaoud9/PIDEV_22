/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImCommandeRestau;
import esprit.com.ImServices.ImPlat;
import static esprit.com.ImServices.ImUtilisateur.nameUser;
import static esprit.com.ImServices.ImUtilisateur.idUser;

import esprit.com.entity.CommandePlat;
import esprit.com.entity.CommandeRestau;
import esprit.com.entity.Plat;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javax.swing.text.DateFormatter;
import java.sql.Date;
import java.time.LocalDateTime;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class AjouterCommandeController implements Initializable {

    private CommandeRestau CommandeRestau;
    public static Double prix1 ; 
    public static Plat Plat;
    @FXML
    public  TableView<Plat> tablePlat;
    @FXML
    private TableColumn<Plat, String> nomplat;
    @FXML
    private TableColumn<Plat, Double> prixPlat;
    @FXML
    private TableColumn<Plat, String> descriptionPlat;
    @FXML
    private Button commander;
    @FXML
    private Text Prix;
    ObservableList<Plat> obsPlat = FXCollections.observableArrayList();
    @FXML
    private Text idUserr;
    @FXML
    private TextField latitude;
    @FXML
    private TextField adress;
    @FXML
    private TextField longitude;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadData();
    }

    @FXML
    private void commander(ActionEvent event) {
        
        
        int nombreAleatoire = 1000 + (int)(Math.random() * ((1000000 - 1000) + 1));


   LocalDate now = LocalDate.now();  
   System.out.println(now);  
 


        CommandeRestau cm = new CommandeRestau(nombreAleatoire , prix1,Date.valueOf(now),idUser,Double.parseDouble(latitude.getText()) , Double.parseDouble(longitude.getText()),adress.getText()) ; 
        
        
        ImCommandeRestau Imc = new ImCommandeRestau() ;
        Imc.ajout(cm);
        tablePlat.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        int x = tablePlat.getSelectionModel().getSelectedItems().size();
        for (int i = 0; i < x; i++) {
            Plat=tablePlat.getSelectionModel().getSelectedItems().get(i);
    
           Imc.ajoutPlatCommande(new CommandePlat(cm.getNum_Commande(),Plat.getIdPlat())) ; 
          
          
           

        }
     
        
    
        
        
        
    }

    private void LoadData() {
        ImPlat imp = new ImPlat();
        imp.Show().stream().forEach((p) -> {
            obsPlat.add(p);
        });
        nomplat.setCellValueFactory(new PropertyValueFactory<>("nomPlat"));
        prixPlat.setCellValueFactory(new PropertyValueFactory<>("prixPlat"));
        descriptionPlat.setCellValueFactory(new PropertyValueFactory<>("description"));
        tablePlat.setItems(obsPlat);
idUserr.setText(nameUser);
    }


    
    
    @FXML
    private void onTableItemsSelect(MouseEvent event) {
        
        
        ImCommandeRestau imCo = new ImCommandeRestau() ; 
                
        Double S =0.0;
        Double P=0.0;
        
        Prix.setText(String.valueOf(S).toString());
        tablePlat.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        int x = tablePlat.getSelectionModel().getSelectedItems().size();
        for (int i = 0; i < x; i++) {
            Plat=tablePlat.getSelectionModel().getSelectedItems().get(i);
    
            
           P=Plat.getPrixPlat();
           S +=P;
           Prix.setText(String.valueOf(S).toString());
           prix1 = S ; 

        }
    }

   
}
