/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImUtilisateur;
import esprit.com.entity.Reset;
import esprit.com.entity.Utilisateur;
import esprit.com.mail.Sendmail;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class ModifierMdpController implements Initializable {

    @FXML
    private PasswordField Nvmdp;
    @FXML
    private PasswordField cnfMdp;
    @FXML
    private Text txt1;
@FXML
    private Text txt;

    public Text getTxt1() {
        return txt1;
    }

    public void setTxt1(String txt1) {
        this.txt1.setText(txt1);
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void SubmitMdp(ActionEvent event) throws IOException {
        Sendmail sn = new Sendmail();
        String Obj="Reset Password";
        String Subject = "Bonjour "+txt1.getText()+" Votre mot passe est modifier avec succes";
        ImUtilisateur iut = new ImUtilisateur();
        if((Nvmdp.getText().equals(""))&&(cnfMdp.getText().equals(""))){
                        txt.setText("Champ Manquant");

             }else if (!Nvmdp.getText().equals(cnfMdp.getText())) {
            txt.setText("Mode pass Non Compatible");
        } else {
             iut.modifierMopasst(new Utilisateur(txt1.getText(),cnfMdp.getText()));
                         txt.setText("Mode pass Modifer");

                          sn.envoyer(txt1.getText(), Obj, Subject);
                          
                Parent page2 = FXMLLoader.load(getClass().getResource("Login.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();

        }
    }
    }

