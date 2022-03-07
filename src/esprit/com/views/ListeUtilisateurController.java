/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImUtilisateur;
import static esprit.com.ImServices.ImUtilisateur.PHOTO;
import static esprit.com.ImServices.ImUtilisateur.idUser;
import static esprit.com.ImServices.ImUtilisateur.nameUser;
import esprit.com.entity.Utilisateur;
import esprit.com.utils.ConnectionBd;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class ListeUtilisateurController implements Initializable {

    private Utilisateur Utilisateur;
    private ImUtilisateur uti;

    private String path;
    private int id = idUser;
    @FXML
    private TableView<Utilisateur> TableUtilisateur;
    @FXML
    private TableColumn<Utilisateur, String> nom;
    @FXML
    private TableColumn<Utilisateur, String> prenom;
    @FXML
    private TableColumn<Utilisateur, String> adresse;
    @FXML
    private TableColumn<Utilisateur, String> email;
    @FXML
    private TableColumn<Utilisateur, String> pays;
    @FXML
    private TableColumn<Utilisateur, String> role;
    @FXML
    private TableColumn<Utilisateur, Integer> isActive;
    @FXML
    private TableColumn<Utilisateur, ImageView> photo;

    ObservableList<Utilisateur> obsUtilisateurlist = FXCollections.observableArrayList();
    @FXML
    private TextField mprenom;
    @FXML
    private TextField madresse;
    @FXML
    private TextField memail;
    @FXML
    private TextField mpays;
    @FXML
    private TextField mrole;
    @FXML
    private TextField mActive;
    @FXML
    private TextField mpohto;
    @FXML
    private TextField mnom;
    @FXML
    private ComboBox<String> TriChoice;
    @FXML
    private TextField Rechercher;
    @FXML
    private Text textMOd;
    @FXML
    private Button Logout;
    @FXML
    private Text idUserr;
    @FXML
    private ImageView image;
    private Image image1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadData();
    }

    private void LoadData() {
        TableUtilisateur.setEditable(true);
        ImUtilisateur im = new ImUtilisateur();
        im.affiche().stream().forEach((p) -> {
            obsUtilisateurlist.add(p);
        });
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nom.setCellFactory(TextFieldTableCell.forTableColumn());
        nom.setOnEditCommit(new EventHandler<CellEditEvent<Utilisateur, String>>() {
            @Override
            public void handle(CellEditEvent<Utilisateur, String> event) {
                Utilisateur uti = event.getRowValue();
               uti.setNom(event.getNewValue());
               ImUtilisateur utIm = new ImUtilisateur();
               utIm.modifier(uti);
//uti.modifier(new Utilisateur(Utilisateur.getIdU(), nom.getText(), prenom.getText(), adresse.getText(), email.getText(), photo.getText(), pays.getText(), role.getText(), Integer.parseInt(isActive.getText())));

            }

        });
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        prenom.setCellFactory(TextFieldTableCell.forTableColumn());
        prenom.setOnEditCommit(new EventHandler<CellEditEvent<Utilisateur, String>>() {
            @Override
            public void handle(CellEditEvent<Utilisateur, String> event) {
                Utilisateur uti = event.getRowValue();
                uti.setPrenom(event.getNewValue());
               ImUtilisateur utIm = new ImUtilisateur();
               utIm.modifier(uti);

            }

        });
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        adresse.setCellFactory(TextFieldTableCell.forTableColumn());
        adresse.setOnEditCommit(new EventHandler<CellEditEvent<Utilisateur, String>>() {
            @Override
            public void handle(CellEditEvent<Utilisateur, String> event) {
                Utilisateur uti = event.getRowValue();
                uti.setAdresse(event.getNewValue());
                               ImUtilisateur utIm = new ImUtilisateur();
               utIm.modifier(uti);

            }

        });
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        email.setCellFactory(TextFieldTableCell.forTableColumn());
        email.setOnEditCommit(new EventHandler<CellEditEvent<Utilisateur, String>>() {
            @Override
            public void handle(CellEditEvent<Utilisateur, String> event) {
                Utilisateur uti = event.getRowValue();
                uti.setEmail(event.getNewValue());
                               ImUtilisateur utIm = new ImUtilisateur();
               utIm.modifier(uti);

            }

        });
        pays.setCellValueFactory(new PropertyValueFactory<>("pays"));
        pays.setCellFactory(TextFieldTableCell.forTableColumn());
        pays.setOnEditCommit(new EventHandler<CellEditEvent<Utilisateur, String>>() {
            @Override
            public void handle(CellEditEvent<Utilisateur, String> event) {
                Utilisateur uti = event.getRowValue();
                uti.setPays(event.getNewValue());
                               ImUtilisateur utIm = new ImUtilisateur();
               utIm.modifier(uti);

            }

        });
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        role.setCellFactory(TextFieldTableCell.forTableColumn());
        role.setOnEditCommit(new EventHandler<CellEditEvent<Utilisateur, String>>() {
            @Override
            public void handle(CellEditEvent<Utilisateur, String> event) {
                Utilisateur uti = event.getRowValue();
                uti.setRole(event.getNewValue());
                               ImUtilisateur utIm = new ImUtilisateur();
               utIm.modifier(uti);

            }

        });

        isActive.setCellValueFactory(new PropertyValueFactory<>("Active"));
       isActive.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        isActive.setOnEditCommit(new EventHandler<CellEditEvent<Utilisateur, Integer>>() {
            @Override
            public void handle(CellEditEvent<Utilisateur, Integer> event) {
                Utilisateur uti = event.getRowValue();
                uti.setActive(event.getNewValue());
                               ImUtilisateur utIm = new ImUtilisateur();
               utIm.modifier(uti);

            }

        });

        photo.setCellValueFactory(new PropertyValueFactory<>("photo"));
      //  photo.setCellFactory(TextFieldTableCell.forTableColumn());

        TableUtilisateur.setItems(obsUtilisateurlist);

        TriChoice.getItems().addAll("aucun", "Trier Selon Nom", "Trier Selon Pays", "Trier Selon Compte Activé");

        Rechercher.textProperty().addListener((obs, oldText, newText) -> {
            List<Utilisateur> ae = im.Search(newText);
            TableUtilisateur.getItems().setAll(ae);

        });

        idUserr.setText(nameUser);
        System.out.println(PHOTO);

        image1 = new Image("/esprit/com/logo/" + PHOTO);
        image.setImage(image1);

    }

    @FXML
    private void Delete(ActionEvent event) throws IOException, SQLException {
        ImUtilisateur imt = new ImUtilisateur();
        Utilisateur ut = new Utilisateur();

        ObservableList obsUtilisateurlist, Pointage;
        obsUtilisateurlist = TableUtilisateur.getItems();
        Pointage = TableUtilisateur.getSelectionModel().getSelectedItems();
        ut = TableUtilisateur.getSelectionModel().getSelectedItems().get(0);

        imt.Supprimer(new Utilisateur(ut.getIdU()));

        System.out.println(ut);
        System.out.println(obsUtilisateurlist);

        Pointage.forEach(obsUtilisateurlist::remove);

    }

    @FXML
    private void onTableItemSelect(MouseEvent event) {

        mnom.opacityProperty();
        Utilisateur = TableUtilisateur.getSelectionModel().getSelectedItem();

        mnom.setText(Utilisateur.getNom());
        mprenom.setText(Utilisateur.getPrenom());
        madresse.setText(Utilisateur.getAdresse());
        memail.setText(Utilisateur.getEmail());
        mpays.setText(Utilisateur.getPays());
        mrole.setText(Utilisateur.getRole());
        mActive.setText(String.valueOf(Utilisateur.isActive()));
        mpohto.setText(Utilisateur.getPhoto());
        textMOd.setText(Utilisateur.getNom());

    }

    public void clearFields() {
        mnom.clear();
        mprenom.clear();
        madresse.clear();
        memail.clear();
        mpays.clear();
        mrole.clear();
        mActive.clear();
        mpohto.clear();
    }

    @FXML
    private void EditUtili(ActionEvent event) throws IOException {
        ImUtilisateur uti = new ImUtilisateur();

        Utilisateur.setNom(nom.getText());
        Utilisateur.setPrenom(prenom.getText());
        Utilisateur.setAdresse(adresse.getText());
        Utilisateur.setEmail(email.getText());
        Utilisateur.setPays(pays.getText());
        Utilisateur.setRole(role.getText());
        Utilisateur.setActive(Integer.parseInt(isActive.getText()));
        Utilisateur.setPhoto(photo.getText());
        //   uti.modifier(new Utilisateur(1,"ayass","mess","Ariana Soghra","maha.mess@gmail.com","yassine","photo","tunis","utilisateur",1));
        uti.modifier(new Utilisateur(Utilisateur.getIdU(), nom.getText(), prenom.getText(), adresse.getText(), email.getText(), photo.getText(), pays.getText(), role.getText(), Integer.parseInt(isActive.getText())));

        new Alert(Alert.AlertType.INFORMATION, Utilisateur.getNom() + " Modifier !!", ButtonType.APPLY.CLOSE).show();
        clearFields();
        obsUtilisateurlist.set(TableUtilisateur.getSelectionModel().getFocusedIndex(), Utilisateur);

    }

    private void TrieNom() throws IOException {
        ImUtilisateur uti = new ImUtilisateur();
        Utilisateur Utilisateur = new Utilisateur();
        List<Utilisateur> a = uti.triNom();
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        pays.setCellValueFactory(new PropertyValueFactory<>("pays"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));

        isActive.setCellValueFactory(new PropertyValueFactory<>("activated"));
        photo.setCellValueFactory(new PropertyValueFactory<>("photo"));

        TableUtilisateur.getItems().setAll(a);

    }

    private void TriePays() throws IOException {
        ImUtilisateur uti = new ImUtilisateur();
        Utilisateur Utilisateur = new Utilisateur();
        List<Utilisateur> a = uti.triPays();
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        pays.setCellValueFactory(new PropertyValueFactory<>("pays"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));

        isActive.setCellValueFactory(new PropertyValueFactory<>("Active"));
        photo.setCellValueFactory(new PropertyValueFactory<>("photo"));

        TableUtilisateur.getItems().setAll(a);

    }

    private void TrieActive() throws IOException {
        ImUtilisateur uti = new ImUtilisateur();
        Utilisateur Utilisateur = new Utilisateur();
        List<Utilisateur> a = uti.triActive();
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        pays.setCellValueFactory(new PropertyValueFactory<>("pays"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));

        isActive.setCellValueFactory(new PropertyValueFactory<>("activated"));
        photo.setCellValueFactory(new PropertyValueFactory<>("photo"));

        TableUtilisateur.getItems().setAll(a);

    }

    @FXML
    private void TriChoice(ActionEvent event) throws IOException {
        if (TriChoice.getValue().equals("Trier Selon Nom")) {
            TrieNom();
        } else if (TriChoice.getValue().equals("Trier Selon Pays")) {
            TriePays();
        } else if (TriChoice.getValue().equals("Trier Selon Compte Activé")) {
            TrieActive();
        }
    }

    @FXML
    private void Logout(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("Login.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    @FXML
    private void Sponsors(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("ListCommandeClient.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    @FXML
    private void Plat(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("AjouterCommande.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

}
