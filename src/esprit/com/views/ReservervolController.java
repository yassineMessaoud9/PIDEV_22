/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImUtilisateur;
import esprit.com.Imservices.Imreservationvol;
import esprit.com.Imservices.Imvol;
import esprit.com.entity.reservationvol;
import esprit.com.entity.vol;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Gamer
 */
public class ReservervolController implements Initializable {
private vol vol;
public int idV;
private int idU=1;
    @FXML
    private TableView<vol> tablevol;
    @FXML
    private TableColumn<vol, Date> datealler;
    @FXML
    private TableColumn<vol, String> tempaller;
    @FXML
    private TableColumn<vol, Date> dateretour;
    @FXML
    private TableColumn<vol, String> tempretour;
    @FXML
    private TableColumn<vol, String> destination;
    @FXML
    private TableColumn<vol, String> classvol;
    @FXML
    private TableColumn<vol, Float> prixvol;
    @FXML
    private TableColumn<vol, String> typevol;
    
    @FXML
    private TableColumn<vol, Integer> matricule;
    ObservableList<vol> vl=FXCollections.observableArrayList();
    @FXML
    private TextField rr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Imvol sa = new Imvol();
            List<vol> s =sa.afficher();
        
      sa.afficher().stream().forEach((p) -> {vl.add(p);});
        System.out.println(sa.afficher());
      datealler.setCellValueFactory(new PropertyValueFactory<>("dateallervol"));  
      tempaller.setCellValueFactory(new PropertyValueFactory<>("tempsallervol"));
      dateretour.setCellValueFactory(new PropertyValueFactory<>("dateretourvol"));
      tempretour.setCellValueFactory(new PropertyValueFactory<>("tempsretourrvol"));
      destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
      classvol.setCellValueFactory(new PropertyValueFactory<>("classvol"));
      prixvol.setCellValueFactory(new PropertyValueFactory<>("prixvol"));
      typevol.setCellValueFactory(new PropertyValueFactory<>("typevol"));
      
      matricule.setCellValueFactory(new PropertyValueFactory<>("numserieavion"));
 
       tablevol.setItems(vl);
        // TODO
    }    

    @FXML
    private void onselect(MouseEvent event) {
        vol=tablevol.getSelectionModel().getSelectedItem();
        idV=vol.getNumvol();
        System.out.println(idV);
        
    }

    @FXML
    private void reserver(ActionEvent event) throws IOException {
      //  System.out.println("Work");
      
        Imreservationvol Imreservationvol= new Imreservationvol();
        
        Imreservationvol.ajouter(new reservationvol(ImUtilisateur.idUser,idV));
        JOptionPane.showMessageDialog(null,"reservation ajoutée");
    }

    @FXML
    private void consulter(ActionEvent event) throws IOException {
          Parent page2 = FXMLLoader.load(getClass().getResource("meteo.fxml"));

         Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
        
        
        
    }
    
}
