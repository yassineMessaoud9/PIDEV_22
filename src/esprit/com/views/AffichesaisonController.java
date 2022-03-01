/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import com.jfoenix.controls.JFXComboBox;
import esprit.com.Imservices.Imagencelocation;
import esprit.com.Imservices.Imsaison;
import esprit.com.entity.Agencelocation;
import esprit.com.entity.Saison;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.NativeJava.type;

/**
 * FXML Controller class
 *
 * @author ons
 */
public class AffichesaisonController implements Initializable {
        @FXML
    private TableColumn<Saison, String> idNom;

    ObservableList<Saison> obssaionelist=FXCollections.observableArrayList();
    @FXML
    private TableView<Saison> tabsaison;
 
    
private Saison saison;
    @FXML
    private TextField mIdNomsaison;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           Imsaison ag= new Imsaison();
       
        ag.afficher().stream().forEach((p) -> {obssaionelist.add(p);});
        
     idNom.setCellValueFactory(new PropertyValueFactory<>("nomSaison"));
     
        tabsaison.setItems(obssaionelist);
        
      
    }  
    
     public void clearFields(){
       mIdNomsaison.clear();
      
    }
    

    @FXML
    private void SetOnTable(MouseEvent event) {
              mIdNomsaison.opacityProperty();
              
             saison = tabsaison.getSelectionModel().getSelectedItem();
  
 
            mIdNomsaison.setText(saison.getNomSaison());

      
    }

    @FXML
    private void UpdateSaison(MouseEvent event) {
        
          Imsaison sais= new Imsaison();
      
       
       saison.setNomSaison(mIdNomsaison.getText());
    

      
      sais.modifier(new Saison(saison.getIdSaison(),mIdNomsaison.getText()));
      
     new Alert(Alert.AlertType.INFORMATION,"mchet",ButtonType.CLOSE).show();
     clearFields();
     obssaionelist.set(tabsaison.getSelectionModel().getFocusedIndex(),saison);

        
    }

    @FXML
    private void DeleteSaion(ActionEvent event) {
                           Imsaison sais = new Imsaison();
                    Saison s=new Saison();

        
      ObservableList obssaionelist,sai;
        obssaionelist=tabsaison.getItems();
      sai=tabsaison.getSelectionModel().getSelectedItems();
            s=tabsaison.getSelectionModel().getSelectedItems().get(0);

      sais.supprimer(new Saison(s.getIdSaison()));

        System.out.println(s);
                System.out.println(sai);

        
      sai.forEach(obssaionelist::remove);
  clearFields();
     
    }

    @FXML
    private void getAddView(MouseEvent event) throws IOException {
           
       Parent page2 = FXMLLoader.load(getClass().getResource("ajoutsaison.fxml"));

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
