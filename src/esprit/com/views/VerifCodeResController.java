/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImUtilisateur;
import static esprit.com.ImServices.ImUtilisateur.EmailRes;
import esprit.com.entity.Reset;
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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class VerifCodeResController implements Initializable {

    public String email = "aa";
    @FXML
    private TextField code;
    @FXML
    private Text mqte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Verif(ActionEvent event) throws IOException {
        ImUtilisateur uti = new ImUtilisateur();
        if (code.getText().equals("")) {
            mqte.setText("Champ Manquant");
        } else if (uti.reset(new Reset(Integer.parseInt(code.getText())))) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierMdp.fxml"));
            Parent root = loader.load();
            code.getScene().setRoot(root);

            ModifierMdpController apc = loader.getController();
            apc.setTxt1(EmailRes);

        } else {
            mqte.setText("Un erreur survenu");

        }
        {
        }
    }

}
