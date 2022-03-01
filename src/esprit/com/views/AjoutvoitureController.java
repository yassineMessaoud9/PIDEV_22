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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    @FXML
    private ComboBox<String> aagence;
    private TextField anomagence;
    @FXML
    private TextField atarif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    LoadData();
    }    

    @FXML
    private void ajouterVoiture(ActionEvent event) throws IOException {
         Imvoiture v= new Imvoiture();
     v.ajouter(new Voiture(Integer.parseInt(amatricule.getText()),amarque.getText(),aphoto.getText(),Integer.parseInt(aplaces.getText()),Integer.parseInt(achevaux.getText()),atarif.getText(),Integer.parseInt(anomagence.getText())));
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
            aagence.getItems().addAll(rs.getInt("idAgence"));
           
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
   }
    
}
