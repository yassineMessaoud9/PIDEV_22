/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author MediaHelp
 */
public class NotifiicationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void notif(ActionEvent event) {
         Notifications notifications=Notifications.create();
        notifications.text("Hello there I'm Dilshan Rajika");
        notifications.title("Success Message");
     //   notifications.hideAfter(Duration.seconds(4));
       notifications.darkStyle();
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();

    }
    
}
