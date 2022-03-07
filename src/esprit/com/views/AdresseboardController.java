/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imadresse;
import esprit.com.entity.adresse;
import static java.awt.SystemColor.text;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
/**
 * FXML Controller class
 *
 * @author Gamer
 */
public class AdresseboardController implements Initializable {
    

    @FXML
    private TableColumn<adresse, String> pays;
    @FXML
    private TableColumn<adresse, String> rue;
    @FXML
    private TableColumn<adresse, Integer> contact;
     ObservableList<adresse> adr=FXCollections.observableArrayList();
    @FXML
    private TableView<adresse> tableadresse;
    @FXML
    private TextField mpays;
    @FXML
    private TextField mrue;
    @FXML
    private TextField mcontact;
    private adresse adresse ;
    @FXML
    private Button ajouter;
    @FXML
    private RadioButton triepays;
    @FXML
    private TextField recherchepays;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Imadresse sa = new Imadresse();
        tableadresse.setEditable(true);
        
      sa.afficher().stream().forEach((p) -> {adr.add(p);});
      pays.setCellValueFactory(new PropertyValueFactory<>("paysadresse"));
      
      rue.setCellValueFactory(new PropertyValueFactory<>("rueadresse"));
      contact.setCellValueFactory(new PropertyValueFactory<>("contactadresse"));
 
       tableadresse.setItems(adr);
     
        pays.setCellFactory(TextFieldTableCell.forTableColumn());
        pays.setOnEditCommit(new EventHandler<CellEditEvent<adresse, String>>() {
           
            @Override
            public void handle(CellEditEvent<adresse, String> event) {
                adresse uti = event.getRowValue();
                uti.setPaysadresse(event.getNewValue());
               Imadresse sa = new Imadresse();
               sa.modifier(uti);

            }

        });
        rue.setCellFactory(TextFieldTableCell.forTableColumn());
        rue.setOnEditCommit(new EventHandler<CellEditEvent<adresse, String>>() {
           
            @Override
            public void handle(CellEditEvent<adresse, String> event) {
                adresse uti = event.getRowValue();
                uti.setRueadresse(event.getNewValue());
               Imadresse sa = new Imadresse();
               sa.modifier(uti);

            }});
        contact.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        contact.setOnEditCommit((CellEditEvent<adresse, Integer> event) -> {
            adresse uti = event.getRowValue();
            uti.setContactadresse(event.getNewValue());
            Imadresse sa1 = new Imadresse();
            sa1.modifier(uti);
        });
       
       
               recherchepays.textProperty().addListener((obs, oldText, newText) -> {
                Imadresse fsp = new Imadresse();
                List<adresse> ae = fsp.chercherPays(newText);
                tableadresse.getItems().setAll(ae);
       });
       
    }    

    @FXML
    private void supprimeradresse(ActionEvent event) throws IOException, SQLException {
        Imadresse st = new Imadresse ();
        adresse t=new adresse();

        
      ObservableList adr,adres;
      adr=tableadresse.getItems();
      adres=tableadresse.getSelectionModel().getSelectedItems();
      t=tableadresse.getSelectionModel().getSelectedItems().get(0);

      st.supprimer(new adresse(t.getIdadresse()));

        System.out.println(t);
                System.out.println(adr);

        
      adres.forEach(adr::remove);
      clearFields();
        
    }
     public void clearFields(){
        mpays.clear();
        mrue.clear();
        mcontact.clear();
       
    }

    @FXML
    private void selectadresse() {
        mpays.opacityProperty();
        adresse = tableadresse.getSelectionModel().getSelectedItem();
  
 
        mpays.setText(adresse.getPaysadresse());
        mrue.setText(adresse.getRueadresse());
        mcontact.setText(String.valueOf(adresse.getContactadresse()));
        
    }
   

    
    @FXML
    private void modifier(ActionEvent event) {
        Imadresse d= new Imadresse();
      
       
       adresse.setPaysadresse(mpays.getText());
       adresse.setRueadresse(mrue.getText());
       adresse.setContactadresse(Integer.parseInt(mcontact.getText()));

       

      
      d.modifier(new adresse(adresse.getIdadresse(),mpays.getText(),mrue.getText(),Integer.parseInt(mcontact.getText())));
      
     
     clearFields();
     adr.set(tableadresse.getSelectionModel().getFocusedIndex(),adresse);
        
        
        
        
        
        
        
    }

    @FXML
    private void annuler(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException{
        
        Parent page2 = FXMLLoader.load(getClass().getResource("ajouteradresse.fxml"));

         Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
        
        
        
       // FXMLLoader loader= new FXMLLoader(getClass().getResource("ajouteradresse.fxml"));
        //Parent root = loader.load() ;
        //Scene scene = new Scene(root);
        //Stage stage = new Stage();
        //stage.setScene(scene);
       // stage.show();
        //stage.setResizable(false);
    }

    @FXML
    private void triepays(ActionEvent event) {
         Imadresse adre = new Imadresse();
         adresse a =new adresse();
         
         List<adresse> tableautrie=adre.tri();
         pays.setCellValueFactory(new PropertyValueFactory<>("paysadresse"));
         rue.setCellValueFactory(new PropertyValueFactory<>("rueadresse"));
         contact.setCellValueFactory(new PropertyValueFactory<>("contactadresse"));
         ObservableList<adresse> data=FXCollections.observableArrayList(adr);
         tableadresse.getItems().setAll(tableautrie);            
         
        
        
    
        
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
    

