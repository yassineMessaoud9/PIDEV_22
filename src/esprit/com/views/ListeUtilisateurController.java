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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class ListeUtilisateurController implements Initializable {

    private Utilisateur Utilisateur;
    private ImUtilisateur uti;
    private String acuser;
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
    private TableColumn<Utilisateur, String> isActive;
    @FXML
    private TableColumn<Utilisateur, ImageView> photo;

    ObservableList<Utilisateur> obsUtilisateurlist = FXCollections.observableArrayList();
    private TextField mprenom;
    private TextField madresse;
    private TextField memail;
    private TextField mpays;
    private TextField mrole;
    private TextField mActive;
    private TextField mpohto;
    private TextField mnom;
    @FXML
    private ComboBox<String> TriChoice;
    @FXML
    private TextField Rechercher;
    @FXML
    private Text textMOd;
    @FXML
    private Text idUserr;
    @FXML
    private ImageView image;
    private Image image1;
    @FXML
    private ComboBox<String> banUser;
    Stage primaryStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/MenuAdmin.fxml"));

        LoadData();
        banUser.getItems().addAll("Active", "Desactive");

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
        PropertyValueFactory p = new PropertyValueFactory<>("Active");

        isActive.setCellValueFactory(p);

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

        Utilisateur = TableUtilisateur.getSelectionModel().getSelectedItem();

        acuser = Utilisateur.isActive();

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

    private void EditUtili(ActionEvent event) throws IOException {
        ImUtilisateur uti = new ImUtilisateur();

        Utilisateur.setNom(nom.getText());
        Utilisateur.setPrenom(prenom.getText());
        Utilisateur.setAdresse(adresse.getText());
        Utilisateur.setEmail(email.getText());
        Utilisateur.setPays(pays.getText());
        Utilisateur.setRole(role.getText());
        Utilisateur.setActive(isActive.getText());
        Utilisateur.setPhoto(photo.getText());
        //   uti.modifier(new Utilisateur(1,"ayass","mess","Ariana Soghra","maha.mess@gmail.com","yassine","photo","tunis","utilisateur",1));
        uti.modifier(new Utilisateur(Utilisateur.getIdU(), nom.getText(), prenom.getText(), adresse.getText(), email.getText(), photo.getText(), pays.getText(), role.getText(), isActive.getText()));

        new Alert(Alert.AlertType.INFORMATION, Utilisateur.getNom() + " Modifier !!", ButtonType.APPLY.CLOSE).show();
        clearFields();
        obsUtilisateurlist.set(TableUtilisateur.getSelectionModel().getFocusedIndex(), Utilisateur);

    }

    private void DesactUser(String acuser) {
        try {
            Connection cnx = ConnectionBd.getInstance().getCnx();
            String reqs = "UPDATE utilisateur SET activated=? WHERE idU=?";
            PreparedStatement pst = cnx.prepareStatement(reqs);
            pst.setString(1, acuser);
            pst.setInt(2, Utilisateur.getIdU());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

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

    private void Logout(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("Login.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    private void Sponsors(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("ListCommandeClient.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    private void Plat(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("AjouterCommande.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    @FXML
    private void ChangeRole(ActionEvent event) {
        ImUtilisateur uti = new ImUtilisateur();
        Utilisateur Utilisateur = new Utilisateur();

        if (banUser.getValue().equals("Active")) {
            String ac = "Active";
            DesactUser(ac);
            JOptionPane.showMessageDialog(null, "Utilisateur Active ! ");
            LoadData();
        } else if (banUser.getValue().equals("Desactive")) {
            String ac = "Desactive";

            DesactUser(ac);
            JOptionPane.showMessageDialog(null, "Utilisateur Desactive ! ");
            LoadData();
        }

    }

}
