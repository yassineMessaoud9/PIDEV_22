/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imadresse;
import esprit.com.Imservices.Imavion;
import esprit.com.entity.adresse;
import esprit.com.entity.avion;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
 * @author Gamer
 */
public class AvionboardController implements Initializable {

    @FXML
    private TableColumn<avion,String> numserie;
    @FXML
    private TableColumn<avion, String> marque;
    @FXML
    private TableColumn<avion, String> nbrplace;
    @FXML
    private TableView<avion> tableauavion;
     ObservableList<avion> av=FXCollections.observableArrayList();
    @FXML
    private Button ajout;
    @FXML
    private TextField nms;
    @FXML
    private TextField marq;
    @FXML
    private TextField nbp;
    private avion avion;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private TextField chercher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        Imavion sa = new Imavion();
        
        
        
      sa.afficher().stream().forEach((p) -> {av.add(p);});
      numserie.setCellValueFactory(new PropertyValueFactory<>("numserieavion"));
      marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
      nbrplace.setCellValueFactory(new PropertyValueFactory<>("nbrplace"));
 
      
     
      tableauavion.setItems(av);
        // TODO
        combo.getItems().addAll("aucun", "Trier Selon numero de serie", "Trier Selon marque", "Trier Selon nombre de place");
        
        
         chercher.textProperty().addListener((obs, oldText, newText) -> {
                Imavion fsp = new Imavion();
                List<avion> ae = fsp.recherche(Integer.parseInt(newText));
                tableauavion.getItems().setAll(ae);
         
         
         
                });
        
        
        
        
        
        
    }    

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
                Parent page2 = FXMLLoader.load(getClass().getResource("ajouteravion.fxml"));

         Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    @FXML
     
    
    private void modif(ActionEvent event) {
        Imavion d= new Imavion();
      
       
       avion.setNumserieavion(Integer.parseInt(nms.getText()));
       avion.setMarque(marq.getText());
       avion.setNbrplace(Integer.parseInt(nbp.getText()));

       

      
      d.modifier(new avion(Integer.parseInt(nms.getText()),marq.getText(),Integer.parseInt(nbp.getText())));
      
     
     clearFields();
     av.set(tableauavion.getSelectionModel().getFocusedIndex(),avion);
        
    }

    @FXML
    private void annu(ActionEvent event) {
        clearFields();
        
    }

    @FXML
    private void selectavion(MouseEvent event) {
       // marque.opacityProperty();
        avion = tableauavion.getSelectionModel().getSelectedItem();
  
 
        nms.setText(String.valueOf(avion.getNumserieavion()));
        marq.setText(avion.getMarque());
        nbp.setText(String.valueOf(avion.getNbrplace()));
    }
     public void clearFields(){
        nms.clear();
        marq.clear();
        nbp.clear();
       
    }

    @FXML
    private void supprimeravion(ActionEvent event) {
         Imavion av = new Imavion ();
        avion v=new avion();

        
      ObservableList avi,avio;
      avi=tableauavion.getItems();
      avio=tableauavion.getSelectionModel().getSelectedItems();
      v=tableauavion.getSelectionModel().getSelectedItems().get(0);

      av.supprimer(new avion(v.getNumserieavion()));

        System.out.println(v);
                System.out.println(avi);

        
      avio.forEach(avi::remove);
      clearFields();
    }

    
    private void trienums() {
         Imavion adre = new Imavion();
         adresse a =new adresse();
         
         List<avion> tableautrie=adre.trimat();
         numserie.setCellValueFactory(new PropertyValueFactory<>("numserieavion"));
         marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
         nbrplace.setCellValueFactory(new PropertyValueFactory<>("nbrplace"));
         ObservableList<avion> data=FXCollections.observableArrayList(av);
         tableauavion.getItems().setAll(tableautrie); 
    }

   
    private void triemarque() {
         Imavion adre = new Imavion();
         adresse a =new adresse();
         
         List<avion> tableautrie=adre.trimarq();
         numserie.setCellValueFactory(new PropertyValueFactory<>("numserieavion"));
         marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
         nbrplace.setCellValueFactory(new PropertyValueFactory<>("nbrplace"));
         ObservableList<avion> data=FXCollections.observableArrayList(av);
         tableauavion.getItems().setAll(tableautrie);  
    }

    
    private void trienbrplace() {
         Imavion adre = new Imavion();
         adresse a =new adresse();
         
         List<avion> tableautrie=adre.trinbrp();
         numserie.setCellValueFactory(new PropertyValueFactory<>("numserieavion"));
         marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
         nbrplace.setCellValueFactory(new PropertyValueFactory<>("nbrplace"));
         ObservableList<avion> data=FXCollections.observableArrayList(av);
         tableauavion.getItems().setAll(tableautrie);  
    }

    @FXML
    private void trie(ActionEvent event) {
        if (combo.getValue().equals("Trier Selon numero de serie")) {
            trienums();
        } else if (combo.getValue().equals("Trier Selon marque")) {
            triemarque();
        } else if (combo.getValue().equals("Trier Selon nombre de place")) {
            trienbrplace();
        }
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
