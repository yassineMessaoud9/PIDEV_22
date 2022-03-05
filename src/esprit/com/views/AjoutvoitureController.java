/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imagencelocation;
import esprit.com.Imservices.Imvoiture;
import esprit.com.entity.Agencelocation;
import esprit.com.entity.Voiture;
import esprit.com.entity.keyValueAgence;
import esprit.com.utils.ConnectionBd;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ons
 */
public class AjoutvoitureController implements Initializable {
        int x ;

    @FXML
    private TextField amatricule;
    @FXML
    private TextField amarque;
    @FXML
    private TextField aphoto;
    @FXML
    private TextField aplaces;
    @FXML
    private TextField achevaux;
    private ComboBox<String> aagence;
    
    private TextField anomagence;
    @FXML
    private TextField atarif;
    @FXML
    private ChoiceBox<keyValueAgence> selectagence;
    
    int idagence;
    
 Imagencelocation serviceagence = new Imagencelocation();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          serviceagence.afficher().forEach((p)->{
             selectagence.getItems().add(new keyValueAgence(p.getIdAgence(),p.getNomAgence())); 
             
             
        }); selectagence.setOnAction(event -> {
              idagence=selectagence.getValue().getIdAgence();
              System.out.println(idagence);
              
              });
    
    }    

    @FXML
    private void ajouterVoiture(ActionEvent event) throws IOException {
         Imvoiture v= new Imvoiture();
        System.out.println("agence eeee"+idagence);
     v.ajouter(new Voiture(Integer.parseInt(amatricule.getText()),amarque.getText(),aphoto.getText(),Integer.parseInt(aplaces.getText()),Integer.parseInt(achevaux.getText()),Integer.parseInt(atarif.getText()),idagence));
     JOptionPane.showMessageDialog(null, "Agence ajouter!");
     
       Parent page2 = FXMLLoader.load(getClass().getResource("affichevoiture.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    @FXML
    private void Return(ActionEvent event) throws IOException {
          Parent page2 = FXMLLoader.load(getClass().getResource("affichevoiture.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }
    
    
   private void LoadData(){
        Connection cnx = ConnectionBd.getInstance().getCnx();
       try {
            String req = "SELECT nomAgence,idAgence from agencelocation";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
            aagence.getItems().addAll(rs.getString("nomAgence"));
            x=rs.getInt("idAgence");
                System.out.println(x);
                        }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
   }
    
}
