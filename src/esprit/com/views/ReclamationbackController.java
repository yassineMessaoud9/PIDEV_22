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
import mailertest.util.JavaMail;

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
          JavaMail jvm = new JavaMail();

	 jvm.sendTextMail(subject.getText(), emailRecipient.getText(),description.getText());
         
         
    }
    
}
