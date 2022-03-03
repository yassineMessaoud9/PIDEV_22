/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.ServiceAvis;
import esprit.com.entity.Avis;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author Utilisateur
 */
public class AvisController implements Initializable {

    @FXML
    private Rating idrate;
    @FXML
    private Button subtn;
    @FXML
    private TextField idnom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Addrate(ActionEvent event) {
         Image ig = new Image("/esprit/com/src/wrong1.png");
        if(idnom.getText().equals("")|| idrate.getRating()==0){
          
            Notifications notifications=Notifications.create();
            notifications.graphic(new ImageView(ig));
            notifications.text("Hello please fill the required fields");
            notifications.title("Failed Message");
            //notifications.hideAfter (Duration.);
           // notifications.darkStyle();
            //notifications.position(Pos.BASELINE CENTER);
            notifications.show();
            
        }
        else{
             Image ig1 = new Image("/esprit/com/src/right1.png");
            ServiceAvis sa = new ServiceAvis();
            sa.ajouter(new Avis(idnom.getText(),(int)idrate.getRating()));
            Notifications notifications=Notifications.create();
               notifications.graphic(new ImageView(ig1));
            notifications.text("Avis ajoutéé");
            notifications.title("Success Message");
            //notifications.darkStyle();
              notifications.show();
        }
    }
    
}
