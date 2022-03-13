/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImUtilisateur;
import esprit.com.Imservices.Imlocation;
import esprit.com.Imservices.Imsaison;
import esprit.com.Imservices.Imvoiture;
import esprit.com.entity.KeyValueVoiture;
import esprit.com.entity.Location;
import esprit.com.entity.Saison;
import esprit.com.entity.Voiture;
import esprit.com.utils.ConnectionBd;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ons
 */
public class AjoutlocationController implements Initializable {

    int x, y, z, t;
    float tariff;
    int matricule;
    @FXML
    private DatePicker adatedebut;
    @FXML
    private DatePicker adatefin;

    private ComboBox<String> amarquevoiture;
    Timestamp date;
    @FXML
    private ChoiceBox<KeyValueVoiture> select_field;
    private KeyValueVoiture KeyValueVoiture;

    Imvoiture servicevoiture = new Imvoiture();
    @FXML
    private ImageView imgbg;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Image Imaage = new Image("/images/ajoutlocation.png");

        imgbg.setImage(Imaage);

        LoadDataUser();
        LoadDataSaison();

        servicevoiture.afficherTest().forEach((p) -> {
            select_field.getItems().add(new KeyValueVoiture(p.getMatricule(), p.getMarqueVoiture(), p.getTarif()));

        });
        select_field.setOnAction(event -> {
            matricule = select_field.getValue().getMatricule();
            System.out.println(matricule);
            tariff = select_field.getValue().getTarif();
            System.out.println(tariff);
        });

    }

//return
    @FXML
    private void Return(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("Usermain.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    //ajouter location
    @FXML
    private void ajouterLocation(ActionEvent event) throws IOException {
        if (ctrl() == false) {
            new Alert(Alert.AlertType.ERROR, "datedebut ne peut pas etre superieur a datefin", ButtonType.CLOSE).show();
        } else {

            Imlocation l = new Imlocation();
            LocalDateTime now = LocalDateTime.now();

            float montant = calculerMontant();
            l.ajouter(new Location(Date.valueOf(adatedebut.getValue()), Date.valueOf(adatefin.getValue()), Timestamp.valueOf(now), montant, ImUtilisateur.idUser, matricule, 4));

            JOptionPane.showMessageDialog(null, "  location ajouter!   votre montant à payer est: " + calculerMontant() + " dt");

            Parent page2 = FXMLLoader.load(getClass().getResource("MenuClient.fxml"));

            Scene scene2 = new Scene(page2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene2);
            app_stage.show();

        }
    }

//affichr la liste des voitures dans le choice box
    private void LoadDataVoiture() {

        Connection cnx = ConnectionBd.getInstance().getCnx();
        // List<Voiture> list = new ArrayList<>();
        try {
            String req = "SELECT * from voitureee ";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                amarquevoiture.getItems().addAll(rs.getString("marqueVoiture"));

                x = rs.getInt("matricule");
                System.out.println(x);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //load user data
    private void LoadDataUser() {
        Connection cnx = ConnectionBd.getInstance().getCnx();
        try {
            String req = "SELECT idU,prenom from utilisateur";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                y = rs.getInt("idU");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //load saison data      
    private void LoadDataSaison() {
        Connection cnx = ConnectionBd.getInstance().getCnx();
        try {
            String req = "SELECT idSaison,nomSaison from saison";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                z = rs.getInt("idSaison");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //calculer montant         
    public float calculerMontant() {
        Saison saison = new Saison();
        if (saison.getNomSaison() == "primtemps") {
            return (tariff * calculerNobreJours());
        } else if (saison.getNomSaison() == "reveillon") {
            return (tariff * calculerNobreJours() * 3);
        } else if (saison.getNomSaison() == "hiver") {
            return (tariff * calculerNobreJours() * 1);
        } else {
            return (tariff * calculerNobreJours() * 2);
        }

    }

    //calculer nbr jours      
    public int calculerNobreJours() {
        String datea = adatedebut.getValue().toString();
        String dater = adatefin.getValue().toString();
        String[] aller = datea.split("-");
        String[] retour = dater.split("-");
        int nbrjrs = Integer.valueOf(retour[2]) - Integer.valueOf(aller[2]);
        int nbrmoi = (Integer.valueOf(retour[1]) - Integer.valueOf(aller[1])) * 30;
        int nbrannee = (Integer.valueOf(retour[0]) - Integer.valueOf(aller[0])) * 360;

        return (nbrjrs + nbrmoi + nbrannee);
    }

    //controle de saisie date 
    public boolean ctrl() {
        String d = adatedebut.getValue().toString();
        String f = adatefin.getValue().toString();
        String[] d1 = d.split("-");
        String[] f1 = f.split("-");
        if (Integer.valueOf(d1[0]) <= Integer.valueOf(f1[0]) && Integer.valueOf(d1[1]) <= Integer.valueOf(f1[1]) && Integer.valueOf(d1[2]) <= Integer.valueOf(f1[2])) {
            return true;
        }
        return false;
    }

    @FXML
    private void Return(MouseEvent event) throws IOException {
         Parent page2 = FXMLLoader.load(getClass().getResource("MenuClient.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

}
