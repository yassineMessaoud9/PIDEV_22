/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImUtilisateur;
import esprit.com.entity.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class LoginController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private PasswordField motpasse;
    private Text obli;
    @FXML
    private Button Login;
    @FXML
    private Button reset;
   int posiArrobase = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Login(ActionEvent event) throws IOException  {
        ImUtilisateur uti = new ImUtilisateur();
        
        
        
        if (email.getText().equals("") || motpasse.getText().equals("")) {

new Alert(Alert.AlertType.ERROR,"Tous les champs sont oligatoire",ButtonType.CLOSE).show();
        } else {
            if (!email.getText().contains("@")) {
new Alert(Alert.AlertType.ERROR,"Respecter format email!!",ButtonType.CLOSE).show();

            }else
                if (uti.login(new Utilisateur(email.getText(), motpasse.getText())).equals("Admin")) {

                Stage stage = (Stage) Login.getScene().getWindow();
                stage.close();
                //  etatlogin.setText("Bienvenue admin");
                //etatlogin.setStyle("-fx-text-fill: #16ff61;");
                Parent page2 = FXMLLoader.load(getClass().getResource("MenuAdmin2.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();

            }else
                    if (uti.login(new Utilisateur(email.getText(), motpasse.getText())).equals("Client")) {

                Stage stage = (Stage) Login.getScene().getWindow();
                stage.close();
                //  etatlogin.setText("Bienvenue admin");
                //etatlogin.setStyle("-fx-text-fill: #16ff61;");
                Parent page2 = FXMLLoader.load(getClass().getResource("MenuClient.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();}
                else{
new Alert(Alert.AlertType.ERROR,"Verifier vos donnes",ButtonType.CLOSE).show();
            }
            
            
    }

}

    @FXML
        private void reset(ActionEvent event) throws  IOException {
          Parent page2 = FXMLLoader.load(getClass().getResource("ResetPass.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();

    }

    @FXML
    private void sinscrire(ActionEvent event) throws IOException {
        
         Parent page2 = FXMLLoader.load(getClass().getResource("sinscrire.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }
}
