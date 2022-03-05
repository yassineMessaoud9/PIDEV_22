/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import com.esprit.upload.Upload;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import esprit.com.ImServices.ImUtilisateur;
import esprit.com.entity.Utilisateur;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.controlsfx.control.PrefixSelectionComboBox;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class SinscrireController implements Initializable {

    private File file;
    String pic;

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField adresse;
    @FXML
    private TextField pays;
    @FXML
    private TextField email;

    @FXML
    private Button submit;
    @FXML
    private PasswordField motpasse;
    @FXML
    private Text errorT;
    @FXML
    private Text path;
    private ImageView imgGif;
    @FXML
    private ComboBox<String> imageSele;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    imageSele.getItems().addAll( "Depuis Camera", "Depuis PC");
    }

    @FXML
    private void sisncrire(ActionEvent event) {
        ImUtilisateur uti = new ImUtilisateur();
        // uti.registre(new Utilisateur("ayass","mess","Ariana Soghra","amaha.messaoud3@gmail.com","yassine","photo","tunis",Role.Admin,"Admin+",100.9));
        String Role = "Admin";
        uti.registre(new Utilisateur(nom.getText(), prenom.getText(), adresse.getText(), email.getText(), motpasse.getText(), pic, pays.getText(), Role));
        JOptionPane.showMessageDialog(null, "Personne ajoutée ! , Un email vous a envoyé");

    }

    private void upload() throws IOException {

        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(null);
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        path.setText("File:" + file);
        //pic=(file.toURI().toString());
        pic = new Upload().upload(file, "\\logo");
        System.out.println(pic);

    }

    private void prendrePho() throws IOException {
        Random rnd = new Random();
        int number = rnd.nextInt(999999999);

        Webcam webcam = Webcam.getDefault();
        webcam.open();
        String filename = "";
        filename = number + "_" + ".jpg";
        ImageIO.write(webcam.getImage(), "JPG", new File("src\\esprit\\com\\logo\\" + filename));
        pic = filename;
        System.out.println(filename);

        webcam.close();

        /*   if (webcam != null) {
      System.out.println("Webcam: " + webcam.getName());
    } else {
      System.out.println("No webcam detected");
    }*/
        // sn.Notification("Felicitation", "Photo Prise");
        // Webcam.setDriver(new V4l4jDriver());
    }

    @FXML
    private void imageSelect(ActionEvent event) throws IOException {
        
        if (imageSele.getValue().equals("Depuis Camera")) {
            prendrePho();
        } else if(imageSele.getValue().equals("Depuis PC")){
            upload();
        }else{
            imageSele.setDisable(true);
        }
    }

}
