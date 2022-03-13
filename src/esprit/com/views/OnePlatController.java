/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImUtilisateur;
import esprit.com.entity.Plat;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class OnePlatController implements Initializable {

    @FXML
    private Label NomPLat;
    @FXML
    private Label PrixPlat;
    @FXML
    private ImageView PhotoPat;
    @FXML
    private Button shareFb;
    public Plat plat;
    private MyListener myListener;
    private Image image1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (ImUtilisateur.ROLEU.equals("Admin")) {
            shareFb.setDisable(true);
        }
    }

    @FXML
    private void Commander(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("AjouterCommande.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();

    }

    public void setData(Plat plat, MyListener myListener) {
        this.plat = plat;
        this.myListener = myListener;
        NomPLat.setText(plat.getNomPlat());
        PrixPlat.setText(String.valueOf(plat.getPrixPlat()));
/*image1 = new Image(getClass().getResourceAsStream(plat.getPhotoPlat()));

       PhotoPat.setImage(image1);        */

    }

    @FXML
    private void click(MouseEvent event) throws IOException {
        /*Parent page2 = FXMLLoader.load(getClass().getResource("AjouterCommande.fxml"));
        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();*/
    }

    public interface MyListener {

        public void onClickListener(Plat plat);
    }
}
