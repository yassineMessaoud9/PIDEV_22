/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mailertest.util.JavaMail;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Utilisateur
 */
public class ReclamationbackController implements Initializable {

    @FXML
    private TextField subject;
    @FXML
    private TextField emailRecipient;
    @FXML
    private TextArea description;
    @FXML
    private Button idsend;
    @FXML
    private TableView<?> tableUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void sendmail(ActionEvent event) {
        
         Image ig = new Image("/esprit/com/ImageNotif/wrong1.png");
            if(subject.getText().equals("")|| emailRecipient.getText().equals("") || description.getText().equals("")){
                       Notifications notifications=Notifications.create();
                       notifications.graphic(new ImageView(ig));
                       notifications.text("Hello please fill the required fields");
                       notifications.show();
                
            }else{
                    Image ig1 = new Image("/esprit/com/ImageNotif/right1.png");
                    JavaMail jvm = new JavaMail();
                    jvm.sendTextMail(subject.getText(), emailRecipient.getText(),description.getText());
                        Notifications notifications=Notifications.create();
                        notifications.graphic(new ImageView(ig1));
                        notifications.text("Mail sent successfully");
                        notifications.title("Success Message");
                        notifications.show();

                
            }
      
         
    }
    
}
