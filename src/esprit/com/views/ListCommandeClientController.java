/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImCommandeRestau;
import esprit.com.entity.CommandeRestau;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class ListCommandeClientController implements Initializable {

    @FXML
    private Button Logout;
    @FXML
    private TableColumn<CommandeRestau, String> ncom;
    @FXML
    private TableColumn<CommandeRestau, Double> prixcom;
    @FXML
    private TableColumn<CommandeRestau, Date> datecom;
    @FXML
    private TableColumn<CommandeRestau, Double> lat;
    @FXML
    private TableColumn<CommandeRestau, Double> logit;
    @FXML
    private TableColumn<CommandeRestau, String> nompat;
    @FXML
    private TableColumn<CommandeRestau, String> nomutili;
    @FXML
    private TableColumn<CommandeRestau, String> prenomUti;
    @FXML
    private TableColumn<CommandeRestau, String> email;
    @FXML
    private TableColumn<CommandeRestau, String> adress;
    ObservableList<CommandeRestau> obslist = FXCollections.observableArrayList();
    @FXML
    private TableView<CommandeRestau> TableCOm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Load();
        // TODO
    }

    private void Load() {
        ImCommandeRestau imc = new ImCommandeRestau();
        imc.afficherTest().stream().forEach((p) -> {
            obslist.add(p);
        });
        ncom.setCellValueFactory(new PropertyValueFactory<>("Num_Commande"));
        prixcom.setCellValueFactory(new PropertyValueFactory<>("prix_commande"));
        datecom.setCellValueFactory(new PropertyValueFactory<>("date_commande"));
        lat.setCellValueFactory(new PropertyValueFactory<>("latitude"));
        logit.setCellValueFactory(new PropertyValueFactory<>("longitude"));
        adress.setCellValueFactory(new PropertyValueFactory<>("Adress"));
        nompat.setCellValueFactory(new PropertyValueFactory<>("nomPlat"));
        nomutili.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomUti.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableCOm.setItems(obslist);

    }

    @FXML
    private void Logout(ActionEvent event) {
    }

    @FXML
    private void Sponsors(ActionEvent event) {
    }

    @FXML
    private void Plat(ActionEvent event) {
    }
}
