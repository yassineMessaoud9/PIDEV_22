/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.entity.mailingSend;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author MediaHelp
 */
public class MailingController implements Initializable {

    @FXML
    private TextField to;
    @FXML
    private TextField subject;
    @FXML
    private TextField password;
    @FXML
    private TextField username;
    @FXML
    private TextField message;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mailing(ActionEvent event) {
        mailingSend sd=new mailingSend();
        sd.send(username.getText(), password.getText(), to.getText(),subject.getText(), message.getText());
        
        
 
}

    @FXML
    private void Back(ActionEvent event) throws IOException {
        
          Parent page2 = FXMLLoader.load(getClass().getResource("MenuAdmin2.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }

    
    
}
