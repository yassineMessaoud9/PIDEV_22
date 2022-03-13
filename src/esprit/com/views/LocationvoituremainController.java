/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ons
 */
public class LocationvoituremainController implements Initializable {

    @FXML
    private Text ag;
    @FXML
    private Text sais;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToAgence(MouseEvent event) throws IOException {
          Parent page2 = FXMLLoader.load(getClass().getResource("afficheAgence.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    @FXML
    private void goToSaison(MouseEvent event) throws IOException {
       Parent page2 = FXMLLoader.load(getClass().getResource("affichesaison.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    
    }
    
    
    @FXML
    private void goToVoiture(MouseEvent event) throws IOException {
       Parent page2 = FXMLLoader.load(getClass().getResource("affichevoiture.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    
    }

    @FXML
    private void goToLocation(MouseEvent event) throws IOException {
          Parent page2 = FXMLLoader.load(getClass().getResource("affichelocation.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }
  
    @FXML
    private void gointerface(ActionEvent event) throws IOException {
            Parent page2 = FXMLLoader.load(getClass().getResource("Usermain.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    
    
    
}
