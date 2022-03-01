/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.ServiceEvenement;
import esprit.com.entity.Evenement;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import triptodo.Passable;

/**
 * FXML Controller class
 *
 * @author Utilisateur
 */
public class ModEventController implements Initializable {

  
    
    private Evenement tt;
  @FXML
    private TextField title;

    @FXML
    private TextField pays1;

    @FXML
    private TextField prix1;

    @FXML
    private TextField adr1;

    @FXML
    private TextField taswira1;

    @FXML
    private ComboBox<String> type1;

    @FXML
    private DatePicker dated1;

    @FXML
    private DatePicker datef1;

    @FXML
    private TextField place1;

    @FXML
    private TextField desc1;

    @FXML
    private Button mod;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList ("Carnaval","festival", "rio de jeniro");
           type1.setItems(list);
        this.tt = (Evenement)Passable.getInstance().obj;
        
       title.setText(this.tt.getIntituleEve());
        pays1.setText(this.tt.getPays());
       prix1.setText(this.tt.getPrixEve() + "");
       adr1.setText(this.tt.getAddressEve());
       taswira1.setText(this.tt.getPhotoEve());
       dated1.setValue(this.tt.getDatedebutEve().toLocalDate());
       datef1.setValue(this.tt.getDatedebutEve().toLocalDate());
       place1.setText(this.tt.getNbplaceEve() + "");
       desc1.setText(this.tt.getDescriptionEve());
       
    }    

    @FXML
    private void moddd(ActionEvent event) {
        
        ServiceEvenement se= new ServiceEvenement();
        Evenement t = new Evenement(
                title.getText(),
                pays1.getText(),
                Float.parseFloat(prix1.getText()),
                Date.valueOf(this.dated1.getValue()),
                Date.valueOf(this.datef1.getValue()) ,
                adr1.getText(), 
                "d",
                taswira1.getText() ,
           
                Integer.parseInt(place1.getText()), 
                desc1.getText());
       // System.out.println(t.toString());
        se.modifier(this.tt.getIntituleEve(), t);
        
    }
    
}
