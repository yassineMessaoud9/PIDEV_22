/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imadresse;
import esprit.com.Imservices.Imavion;
import esprit.com.Imservices.Imvol;
import esprit.com.entity.adresse;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gamer
 */
public class VolboardController implements Initializable {

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
    private DatePicker nvdatealler;
    @FXML
    private TextField nvtempaller;
    @FXML
    private DatePicker nvdateretour;
    @FXML
    private TextField nvtempsretour;
    @FXML
    private TextField nvdestination;
    @FXML
    private TextField nvclassvol;
    @FXML
    private TextField nvprix;
    @FXML
    private TextField nvtype;
    private vol vol;

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
    }    

    @FXML
    private void supp(ActionEvent event) {
                Imvol st = new Imvol ();
        vol t=new vol();

        
      ObservableList adr,adres;
      adr=tablevol.getItems();
      adres=tablevol.getSelectionModel().getSelectedItems();
      t=tablevol.getSelectionModel().getSelectedItems().get(0);

      st.supprimer(new vol(t.getNumvol()));

        System.out.println(t);
                System.out.println(adr);

        
      adres.forEach(adr::remove);
     // clearFields();
        
        
    }
    void refresh(){
       Imvol sa = new Imvol();
            List<vol> s =sa.afficher();
        
      //sa.afficher().stream().forEach((p) -> {vl.add(p);});
        //System.out.println(sa.afficher());
      datealler.setCellValueFactory(new PropertyValueFactory<>("dateallervol"));  
      tempaller.setCellValueFactory(new PropertyValueFactory<>("tempsallervol"));
      dateretour.setCellValueFactory(new PropertyValueFactory<>("dateretourvol"));
      tempretour.setCellValueFactory(new PropertyValueFactory<>("tempsretourrvol"));
      destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
      classvol.setCellValueFactory(new PropertyValueFactory<>("classvol"));
      prixvol.setCellValueFactory(new PropertyValueFactory<>("prixvol"));
      typevol.setCellValueFactory(new PropertyValueFactory<>("typevol"));
   
      matricule.setCellValueFactory(new PropertyValueFactory<>("numserieavion"));
        tablevol.getItems().setAll(s);
    }
    /* public void clearFields(){
        
      
       
    }*/
     /* private void selectvol() {
        
        
       
    }*/
    
    @FXML
    private void modif(ActionEvent event) {
         Imvol d= new Imvol();
      
       
       /*vol.setDateallervol(mpays.getText());
       vol.setTempsallervol(mrue.getText());
       vol.setDateretourvol(mpays.getText());
       vol.setTempsretourrvol(mrue.getText());
       vol.setDestination(mpays.getText());
       vol.setClassvol(mrue.getText());
       vol.setPrixvol(mpays.getText());
       vol.setTypevol(mrue.getText());
       
       
       vol.setContactadresse(Integer.parseInt(mcontact.getText()));*/

       

      
      d.modifier2(new vol(vol.getNumvol(),
                        Date.valueOf(nvdatealler.getValue()),
                        nvtempaller.getText(),
                        Date.valueOf(nvdateretour.getValue()),
                        nvtempsretour.getText(),
                        nvdestination.getText(),
                        nvclassvol.getText(),
                        Float.parseFloat(nvprix.getText()),
                        nvtype.getText()
                        
      
                ));
      refresh();
     
     
     vl.set(tablevol.getSelectionModel().getFocusedIndex(),vol);
        clearFields(); 
    }

    @FXML
    private void annuler(ActionEvent event) {
        clearFields();
    }
     public void clearFields(){
      
    
    nvtempaller.clear();
   
    nvtempsretour.clear();
    nvdestination.clear();
     nvclassvol.clear();
     nvprix.clear();
     nvtype.clear();
       
    }

    @FXML
    private void onselect(MouseEvent event) {
        vol = tablevol.getSelectionModel().getSelectedItem();
  
 
        nvdatealler.setValue(vol.getDateallervol().toLocalDate());
        nvtempaller.setText(vol.getTempsallervol());
        //mcontact.setText(vol.valueOf(adresse.getContactadresse()));
        nvdateretour.setValue(vol.getDateretourvol().toLocalDate());
        
        nvtempsretour.setText(vol.getTempsretourrvol());
        
        nvdestination.setText(vol.getDestination());
        nvclassvol.setText(vol.getClassvol());
        nvprix.setText(String.valueOf(vol.getPrixvol()));
        nvtype.setText(vol.getTypevol());
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
           Parent page2 = FXMLLoader.load(getClass().getResource("ajoutervol.fxml"));
        Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
        
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }
    
    
    
    
}
