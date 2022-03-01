/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imvoiture;
import esprit.com.entity.Agencelocation;
import esprit.com.entity.Voiture;
import esprit.com.utils.ConnectionBd;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 * FXML Controller class
 *
 * @author ons
 */
public class AffichevoitureController implements Initializable {

    @FXML
    private TableView<Voiture> tableauvaffiche;
    @FXML
    private TableColumn<Voiture, Integer> idMatricule;
    @FXML
    private TableColumn<Voiture, String> idMarque;
    @FXML
    private TableColumn<Voiture, String> idPhoto;
    @FXML
    private TableColumn<Voiture, Integer> idNbrPlace;
    @FXML
    private TableColumn<Voiture, Integer> idNbrCh;
   

       private   Voiture voiture ;
       
        ObservableList<Voiture> obsvoiturelist=FXCollections.observableArrayList();
    @FXML
    private TextField mIdNom;
    @FXML
    private TextField mIdContact;
    @FXML
    private TextField mIdAdresse;
    @FXML
    private TextField mIdLogo;
    @FXML
    private TableColumn<Voiture, String> idtarif;
 
    @FXML
    private TableColumn<Voiture, String> idNomAgence;

    /**
     * Initializes the controller class.
     */
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    

            Connection cnx = ConnectionBd.getInstance().getCnx();
            
      
            Imvoiture v= new Imvoiture();
            
            v.afficherTest().stream().forEach((p) -> {obsvoiturelist.add(p);});
              
            idMatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));          
            idMarque.setCellValueFactory(new PropertyValueFactory<>("marqueVoiture"));            
            idPhoto.setCellValueFactory(new PropertyValueFactory<>("photoVoiture"));           
            idNbrPlace.setCellValueFactory(new PropertyValueFactory<>("nbplace"));           
            idNbrCh.setCellValueFactory(new PropertyValueFactory<>("nbrchevaux"));         
            idtarif.setCellValueFactory(new PropertyValueFactory<>("tarif"));
            idNomAgence.setCellValueFactory(new PropertyValueFactory<>("nomAgence"));
             
                tableauvaffiche.setItems(obsvoiturelist);
                 System.out.println( v.afficherTest());
            //  try {
            //String req= "select nomAgence from voiture JOIN agencelocation USING (idAgence) ";
            //PreparedStatement pst = cnx.prepareStatement(req);
            
            
           // ResultSet rs = pst.executeQuery();
          // Map <String,Object> newMap = new HashMap<String,Object>()  ;
                   
                   
           // while(rs.next()) {
           //  newMap.put("idNomAgence",rs.getString(1));
                
           //   System.out.println(newMap);  
                
           // }
               // System.out.println(rs);
               
               
                // }
                //  } catch (SQLException ex) {
                //   System.out.println(ex.getMessage());
                //  }
                
                
                
                
                
                
        
    }

    @FXML
    private void onUpdateVoiture(ActionEvent event) {
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
  public void onTableItemSelect(){
      mIdNom.opacityProperty();
  voiture = tableauvaffiche.getSelectionModel().getSelectedItem();
  
 
      mIdNom.setText(voiture.getNomAgence());
     
  }
    
}
       
       
       
    

      
     
        
    

