/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import com.esprit.upload.Upload;
import esprit.com.ImServices.ServiceRestaurant;
import esprit.com.entity.Restaurant;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author MediaHelp
 */
public class AjouterRestaurantController implements Initializable {

    private File file;
    String pic;

    @FXML
    private TextField idnomrestau;
    @FXML
    private ComboBox<String> idtyperestau;
    @FXML
    private TextField idnbrtable;
    @FXML
    private TextField idlocalisation;
    @FXML
    private TextField idtelephone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      ObservableList<String> options = 
    FXCollections.observableArrayList(
        "5FORCHETTE ",
        "4 FORCHETTE ",
        " 3 FORCHETTE"
    );
            idtyperestau.setItems(options);

    }    

    @FXML
    private void ajouterRestau(ActionEvent event) {
         ServiceRestaurant sR = new ServiceRestaurant();
 if (idnomrestau.getText().equals("")|| Integer.parseInt(idnbrtable.getText())==0 || idlocalisation.getText().equals("")|| Integer.parseInt(idtelephone.getText())==0 || (idtyperestau.getSelectionModel().getSelectedItem().toString().equals("") )){ 
                            new Alert(Alert.AlertType.ERROR,"les champs ne peut pas etre vides" ,ButtonType.CLOSE).show();
       
         }
 else if (Integer.parseInt(idnbrtable.getText())==0){ 
                            new Alert(Alert.AlertType.NONE,"le  champs numero table ne peut pas etre null " ,ButtonType.CLOSE).show();
       
         }
 else if (idnomrestau.getText() .length()>10){ 
                            new Alert(Alert.AlertType.ERROR,"les champs ne peut depasser les 10 caracteres" ,ButtonType.CLOSE).show();
       
         }
 else if ( Integer.parseInt(idtelephone.getText())<9999999|| Integer.parseInt( idtelephone.getText())>99999999){ 
                            new Alert(Alert.AlertType.ERROR,"telephone invalide veuillez saisir 8 CHIFFRES" ,ButtonType.CLOSE).show();
       
         }
 else if ((idlocalisation.getText() .length()>10)){ 
                            new Alert(Alert.AlertType.ERROR,"telephone invalide veuillez saisir 8 CHIFFRES" ,ButtonType.CLOSE).show();
       
         }
 else 
 {
        sR.ajouter(new Restaurant( idnomrestau.getText(),idtyperestau.getSelectionModel().getSelectedItem().toString(),Integer.parseInt(idnbrtable.getText()),idlocalisation.getText(),Integer.parseInt(idtelephone.getText()),pic));

       JOptionPane.showMessageDialog(null, "RESTAU ajoutèe");
                 Notifications notifications=Notifications.create();
        notifications.text("Restaurant Ajouté");
        notifications.title("Success Message");
     //   notifications.hideAfter(Duration.seconds(4));
       //notifications.darkStyle();
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();

    }
    }

    @FXML
    private void resetmenu2(ActionEvent event) throws IOException {
          
           Parent page2 = FXMLLoader.load(getClass().getResource("menu.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }
    
    @FXML
        private void upload() throws IOException {

        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(null);
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

      //  path.setText("File:" + file);
        //pic=(file.toURI().toString());
        pic = new Upload().upload(file, "\\imageRestaurant");
        System.out.println(pic);

    }

    }
    
    

