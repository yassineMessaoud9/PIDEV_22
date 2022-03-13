/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imadresse;
import esprit.com.Imservices.Imcompagnieaerienne;
import esprit.com.entity.adresse;
import esprit.com.entity.compagnieaerienne;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Gamer
 */
public class CompagnieboardController implements Initializable {

    @FXML
    private TableView<compagnieaerienne> tablecompagnie;
    @FXML
    private TableColumn<compagnieaerienne, String> nomcompagnie;
    @FXML
    private TableColumn<compagnieaerienne, Integer> adressecompagnie;
    ObservableList<compagnieaerienne> com=FXCollections.observableArrayList();
    @FXML
    private TextField nvcompagnienom;
    private  compagnieaerienne compagnieaerienne;
    @FXML
    private TextField cherchcomp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // table view compagnie aerienne
        
       Imcompagnieaerienne sa = new Imcompagnieaerienne();
      sa.jointure().stream().forEach((p) -> {com.add(p);});// avoir le pays
      nomcompagnie.setCellValueFactory(new PropertyValueFactory<>("nomcompagnie"));
      adressecompagnie.setCellValueFactory(new PropertyValueFactory<>("pays"));
      tablecompagnie.setItems(com); 
      // cherche 
      cherchcomp.textProperty().addListener((obs, oldText, newText) -> {
      Imcompagnieaerienne fsp = new Imcompagnieaerienne();
      List<compagnieaerienne> ae = fsp.cherchercompagnie(newText);
      tablecompagnie.getItems().setAll(ae);
       });    
    }    

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("Ajoutercompagnie.fxml"));

         Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();   
    }

    @FXML
    
    // supprimer compagnie
    private void supprimer(ActionEvent event) {
       Imcompagnieaerienne Im = new Imcompagnieaerienne ();
       compagnieaerienne A=new compagnieaerienne();
        ObservableList adr,adres;
        adr=tablecompagnie.getItems();
        adres=tablecompagnie.getSelectionModel().getSelectedItems();
        A=tablecompagnie.getSelectionModel().getSelectedItems().get(0);
        Im.supprimer(new compagnieaerienne(A.getIdcompagnie()));        
        adres.forEach(adr::remove);
        Notifications notifications=Notifications.create();   
        notifications.text("compagnie supprimer");
        notifications.title("Success Message");  
        notifications.show();
    }
    
    


    @FXML
    private void modifier(ActionEvent event) {
       Imcompagnieaerienne d= new Imcompagnieaerienne();
       compagnieaerienne.setNomcompagnie(nvcompagnienom.getText());
       d.modifier2(new compagnieaerienne (compagnieaerienne.getIdcompagnie(),nvcompagnienom.getText()));
       clearFields();
       com.set(tablecompagnie.getSelectionModel().getFocusedIndex(),compagnieaerienne);
       Notifications notifications=Notifications.create();   
       notifications.text("compagnie modifier");
       notifications.title("Success Message");  
       notifications.show();
    }
     public void clearFields(){
        nvcompagnienom.clear(); 
    }
     
    @FXML
    private void Annuler(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void select(MouseEvent event) {
        compagnieaerienne = tablecompagnie.getSelectionModel().getSelectedItem();
        nvcompagnienom.setText(compagnieaerienne.getNomcompagnie());   
    }

    @FXML
    private void retour(MouseEvent event) throws IOException {
         Parent page2 = FXMLLoader.load(getClass().getResource("MenuAdmin2.fxml"));
          Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }
    
}
