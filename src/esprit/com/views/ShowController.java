/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.ServiceEvenement;
import esprit.com.entity.Evenement;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import triptodo.Passable;

/**
 * FXML Controller class
 *
 * @author Utilisateur
 */
public class ShowController implements Initializable {

    @FXML
    private TableView<Evenement> tableEve;
    @FXML
    private TableColumn<Evenement, String> col_titre;
    @FXML
    private TableColumn<Evenement, String> col_pays;
    @FXML
    private TableColumn<Evenement, Float> col_prix;
    @FXML
    private TableColumn<Evenement, Date> col_dated;
    @FXML
    private TableColumn<Evenement, Date> col_datef;
    @FXML
    private TableColumn<Evenement, String> col_adr;
    @FXML
    private TableColumn<Evenement, String> col_type;
    @FXML
    private TableColumn<Evenement, String> col_photo;
    @FXML
    private TableColumn<Evenement, Integer> col_nbr;
    @FXML
    private TableColumn<Evenement, String> col_desc;
    @FXML
    private Button btnback;
    @FXML
    private Button btnDel;
    @FXML
    private TextField tfsearch;
     
    ObservableList<Evenement> s=FXCollections.observableArrayList();
    @FXML
    private Button mod;
    @FXML
    private RadioButton Trip;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ServiceEvenement sp = new ServiceEvenement();
        List<Evenement> a = sp.afficher();
    
        col_titre.setCellValueFactory(new PropertyValueFactory<>("intituleEve"));
        col_pays.setCellValueFactory(new PropertyValueFactory<>("pays"));
        col_prix.setCellValueFactory(new PropertyValueFactory<>("prixEve"));
        col_dated.setCellValueFactory(new PropertyValueFactory<>("datedebutEve"));
        col_datef.setCellValueFactory(new PropertyValueFactory<>("datefinEve"));
        col_adr.setCellValueFactory(new PropertyValueFactory<>("addressEve"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("typeEve"));
        col_photo.setCellValueFactory(new PropertyValueFactory<>("photoEve"));
        col_nbr.setCellValueFactory(new PropertyValueFactory<>("nbplaceEve"));
        col_desc.setCellValueFactory(new PropertyValueFactory<>("descriptionEve"));
        tableEve.getItems().setAll(a);
  
        tfsearch.textProperty().addListener((obs, oldText, newText) -> {
                ServiceEvenement fsp = new ServiceEvenement();
                List<Evenement> ae = fsp.search(newText);
                tableEve.getItems().setAll(ae);

        });
    }    
        @FXML
    void show(ActionEvent event) {
     ServiceEvenement sp = new ServiceEvenement();
     List<Evenement> a = sp.afficher();
    
        col_titre.setCellValueFactory(new PropertyValueFactory<>("intituleEve"));
        col_pays.setCellValueFactory(new PropertyValueFactory<>("pays"));
        col_prix.setCellValueFactory(new PropertyValueFactory<>("prixEve"));
        col_dated.setCellValueFactory(new PropertyValueFactory<>("datedebutEve"));
        col_datef.setCellValueFactory(new PropertyValueFactory<>("datefinEve"));
        col_adr.setCellValueFactory(new PropertyValueFactory<>("addressEve"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("typeEve"));
        col_photo.setCellValueFactory(new PropertyValueFactory<>("photoEve"));
        col_nbr.setCellValueFactory(new PropertyValueFactory<>("nbplaceEve"));
        col_desc.setCellValueFactory(new PropertyValueFactory<>("descriptionEve"));
        tableEve.getItems().setAll(a);

    }
    @FXML
    void backtoadd(ActionEvent event) throws IOException {
         btnback.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("EvenementView.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

    }
    public void update(){
        col_titre.setCellValueFactory(new PropertyValueFactory<>("intituleEve"));
        col_pays.setCellValueFactory(new PropertyValueFactory<>("pays"));
        col_prix.setCellValueFactory(new PropertyValueFactory<>("prixEve"));
        col_dated.setCellValueFactory(new PropertyValueFactory<>("datedebutEve"));
        col_datef.setCellValueFactory(new PropertyValueFactory<>("datefinEve"));
        col_adr.setCellValueFactory(new PropertyValueFactory<>("addressEve"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("typeEve"));
        col_photo.setCellValueFactory(new PropertyValueFactory<>("photoEve"));
        col_nbr.setCellValueFactory(new PropertyValueFactory<>("nbplaceEve"));
        col_desc.setCellValueFactory(new PropertyValueFactory<>("descriptionEve"));
        ObservableList<Evenement> data=FXCollections.observableArrayList(s);
        tableEve.setItems(s);
        
    }
    
    @FXML
    void Delete(ActionEvent event)throws  IOException, SQLException {
        
        ServiceEvenement se= new ServiceEvenement();
        Evenement t = new Evenement();

        ObservableList s,eve;
        t = tableEve.getSelectionModel().getSelectedItems().get(0);

        se.supprimer(t);
        update();

        System.out.println(t);

       
    }
    @FXML
    void modd(ActionEvent event)throws  IOException, SQLException {
        
        ServiceEvenement se= new ServiceEvenement();
        Evenement t = new Evenement();

        ObservableList s,eve;
        t = tableEve.getSelectionModel().getSelectedItems().get(0);

        //se.supprimer(t);
        Passable.getInstance().obj = t;
       
        Parent root = FXMLLoader.load(getClass().getResource("modEvent.fxml"));
        

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        
        
        System.out.println(t);

       
    }

    @FXML
    private void triprix(ActionEvent event) {
            ServiceEvenement st = new ServiceEvenement();
        Evenement t=new Evenement();
         List<Evenement> a = st.TRIPrix();
        col_titre.setCellValueFactory(new PropertyValueFactory<>("intituleEve"));
        col_pays.setCellValueFactory(new PropertyValueFactory<>("pays"));
        col_prix.setCellValueFactory(new PropertyValueFactory<>("prixEve"));
        col_dated.setCellValueFactory(new PropertyValueFactory<>("datedebutEve"));
        col_datef.setCellValueFactory(new PropertyValueFactory<>("datefinEve"));
        col_adr.setCellValueFactory(new PropertyValueFactory<>("addressEve"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("typeEve"));
        col_photo.setCellValueFactory(new PropertyValueFactory<>("photoEve"));
        col_nbr.setCellValueFactory(new PropertyValueFactory<>("nbplaceEve"));
        col_desc.setCellValueFactory(new PropertyValueFactory<>("descriptionEve"));
         ObservableList<Evenement> data=FXCollections.observableArrayList(s);
         tableEve.getItems().setAll(a);            
         System.out.println(t);

       
    }
    
}
