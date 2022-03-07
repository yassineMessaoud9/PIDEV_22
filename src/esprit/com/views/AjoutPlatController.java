/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import com.esprit.upload.Upload;
import esprit.com.ImServices.ImPlat;
import esprit.com.entity.Plat;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class AjoutPlatController implements Initializable {
 private File file;
    String pic;

    @FXML
    private TextField nomPlat;
    @FXML
    private TextField descP;
    private TextField phtoPlat;
    @FXML
    private TextField PrixPlat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  @FXML
    private void AjoutPat(ActionEvent event) {
        ImPlat imp = new ImPlat();
        imp.ajout(new Plat(nomPlat.getText(),Double.parseDouble(PrixPlat.getText()),pic,descP.getText()));
                        JOptionPane.showMessageDialog(null, "Plat ajoutée !");

    }

    @FXML
    private void photoPlat(ActionEvent event) throws IOException {
        
        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(null);
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

     //   path.setText("File:" + file);
        //pic=(file.toURI().toString());
        pic = new Upload().upload(file,"\\imagePlat");
        System.out.println(pic);

    }
}
