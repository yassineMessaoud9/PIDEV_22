/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import esprit.com.Imservices.Imagencelocation;
import esprit.com.entity.Agencelocation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ons
 */
public class AfficheAgenceController implements Initializable {

    @FXML
    private TableColumn<Agencelocation, String> idNom;
    @FXML
    private TableColumn<Agencelocation, Integer> idContact;
    @FXML
    private TableColumn<Agencelocation, String> idAdresse;
     
    @FXML
    private TableView<Agencelocation> tableauaffiche;
    
    private Agencelocation agencevoiture;
            
     ObservableList<Agencelocation> obsagencelist=FXCollections.observableArrayList();
    @FXML
    private TextField mIdNom;
    @FXML
    private TextField mIdContact;
    @FXML
    private TextField mIdAdresse;
    @FXML
    private TableColumn<?, ?> idLogo;
    @FXML
    private TextField mIdLogo;
    @FXML
    private RadioButton idTriNom;
    @FXML
    private TextField tfsearch;

    /**
     * Initializes the controller class.
     */
    
    
    public void clearFields(){
       mIdNom.clear();
        mIdContact.clear();
        mIdAdresse.clear();
        mIdLogo.clear();
    }
    
    
    
    
    
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Imagencelocation ag= new Imagencelocation();
       
        ag.afficher().stream().forEach((p) -> {obsagencelist.add(p);});
        
     idAdresse.setCellValueFactory(new PropertyValueFactory<>("adressAgence"));
     idNom.setCellValueFactory(new PropertyValueFactory<>("nomAgence"));
     idContact.setCellValueFactory(new PropertyValueFactory<>("contactAgence"));
      idLogo.setCellValueFactory(new PropertyValueFactory<>("logoAgence"));
       tableauaffiche.setItems(obsagencelist);
       
       
        tfsearch.textProperty().addListener((obs, oldText, newText) -> {
                Imagencelocation fsp = new Imagencelocation();
                List<Agencelocation> ae = fsp.search(newText);
                tableauaffiche.getItems().setAll(ae);

        });
     
     
    }
  @FXML
  public void onTableItemSelect(){
      mIdNom.opacityProperty();
  agencevoiture = tableauaffiche.getSelectionModel().getSelectedItem();
  
 
      mIdNom.setText(agencevoiture.getNomAgence());
      mIdContact.setText(String.valueOf(agencevoiture.getContactAgence()));
      mIdAdresse.setText(agencevoiture.getAdressAgence());
      mIdLogo.setText(agencevoiture.getLogoAgence());
  }
  
  
    @FXML
  public void onUpdateAgence(ActionEvent event){
       Imagencelocation ag= new Imagencelocation();
      
       
       agencevoiture.setNomAgence(mIdNom.getText());
       agencevoiture.setContactAgence(Integer.parseInt(mIdContact.getText()));
       agencevoiture.setAdressAgence(mIdAdresse.getText());
      agencevoiture.setLogoAgence(mIdAdresse.getText());
       

      
      ag.modifier(new Agencelocation(agencevoiture.getIdAgence(),mIdNom.getText(),Integer.parseInt(mIdContact.getText()),mIdAdresse.getText(),mIdLogo.getText()));
      
     new Alert(Alert.AlertType.INFORMATION,"mchet",ButtonType.CLOSE).show();
     clearFields();
     obsagencelist.set(tableauaffiche.getSelectionModel().getFocusedIndex(),agencevoiture);

    
      
      }

    
      @FXML

    private void delete(ActionEvent event) throws IOException, SQLException {
                     Imagencelocation ag = new Imagencelocation();
                    Agencelocation a=new Agencelocation();

        
      ObservableList obsagencelist,agl;
        obsagencelist=tableauaffiche.getItems();
      agl=tableauaffiche.getSelectionModel().getSelectedItems();
            a=tableauaffiche.getSelectionModel().getSelectedItems().get(0);

      ag.supprimer(new Agencelocation(a.getIdAgence()));
      agl.forEach(obsagencelist::remove);
  clearFields();
     
    }

  

    @FXML
    private void trierNom(ActionEvent event) {
          Imagencelocation ag = new Imagencelocation();
        Agencelocation agencelocation =new Agencelocation();
         List<Agencelocation> a = ag.TriAgenceNom();
         idNom.setCellValueFactory(new PropertyValueFactory<>("nomAgence"));
         idContact.setCellValueFactory(new PropertyValueFactory<>("contactAgence"));
         idAdresse.setCellValueFactory(new PropertyValueFactory<>("nomAgence"));
       
         ObservableList<Agencelocation> data=FXCollections.observableArrayList(a);
         tableauaffiche.getItems().setAll(a);            
         System.out.println(agencelocation);
        
        
    }
    
      @FXML
    private void getAddView(MouseEvent event) throws IOException {
        
         
       
       Parent page2 = FXMLLoader.load(getClass().getResource("ajoutagencelocation.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
          Parent page2 = FXMLLoader.load(getClass().getResource("locationvoituremain.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }
    
    

     
      
      
     
      
      
      
      
      
      
      
      
      
      
      
                  
        
}
