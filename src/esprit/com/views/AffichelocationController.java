/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imlocation;
import esprit.com.entity.Location;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ons
 */
public class AffichelocationController implements Initializable {

    @FXML
    private TableColumn<Location, Date> idDateDebutLocation;
    @FXML
    private TableColumn<Location, Date> idDateFinLocation;
    @FXML
    private TableColumn<Location, Date> idDateLocation;
    @FXML
    private TableColumn<Location, String> idNomUser;
    @FXML
    private TableColumn<Location, String> idMarqueVoiture;
    @FXML
    private TableColumn<Location, String> idSaisonLocation;
    @FXML
    private TableColumn<Location, Double> idMontant;

      private Location location;
            
     ObservableList<Location> obslocationlist=FXCollections.observableArrayList();
    @FXML
    private TableView<Location> tableaulocaffiche;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           Imlocation l= new Imlocation();
       
        l.afficherlocation().stream().forEach((p) -> {obslocationlist.add(p);});
        
     idDateDebutLocation.setCellValueFactory(new PropertyValueFactory<>("date_debutlocation"));
     idDateFinLocation.setCellValueFactory(new PropertyValueFactory<>("date_finlocation"));
     idDateLocation.setCellValueFactory(new PropertyValueFactory<>("date_location"));
      idNomUser.setCellValueFactory(new PropertyValueFactory<>("nom"));
      idMarqueVoiture.setCellValueFactory(new PropertyValueFactory<>("marqueVoiture"));
     idSaisonLocation.setCellValueFactory(new PropertyValueFactory<>("nomSaison"));
         idMontant.setCellValueFactory(new PropertyValueFactory<>("montant"));
      
       tableaulocaffiche.setItems(obslocationlist);
        System.out.println(l.afficher());
                    }
    

   

    @FXML
    private void delete(MouseEvent event) throws IOException, SQLException {
                     Imlocation l = new Imlocation();
                    Location a=new Location();

        
      ObservableList obslocationlist,agl;
        obslocationlist=tableaulocaffiche.getItems();
      agl=tableaulocaffiche.getSelectionModel().getSelectedItems();
            a=tableaulocaffiche.getSelectionModel().getSelectedItems().get(0);

      l.supprimer(new Location(a.getIdLocation()));
        System.out.println(a.getIdLocation());
        System.out.println(a);
                System.out.println(agl);

        
      agl.forEach(obslocationlist::remove);

     
    }  
    
     @FXML
    private void back(MouseEvent event) throws IOException {
          Parent page2 = FXMLLoader.load(getClass().getResource("locationvoituremain.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    @FXML
    private void getAddView(MouseEvent event) throws IOException {
          Parent page2 = FXMLLoader.load(getClass().getResource("ajoutlocation.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }
}
