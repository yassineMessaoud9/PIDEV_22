/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imvoiture;
import esprit.com.entity.Agencelocation;
import esprit.com.entity.Voiture;
import esprit.com.utils.ConnectionBd;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ons
 */
public class AffichevoitureController implements Initializable {

    @FXML
    private TableView<Voiture> tableauvaffiche;
    @FXML
    private TableColumn<Voiture, Integer> idMatricule;
    @FXML
    private TableColumn<Voiture, String> idMarque;
    @FXML
    private TableColumn<Voiture, String> idPhoto;
    @FXML
    private TableColumn<Voiture, Integer> idNbrPlace;
    @FXML
    private TableColumn<Voiture, Integer> idNbrCh;

    private Voiture voiture;

    ObservableList<Voiture> obsvoiturelist = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Voiture, String> idtarif;

    @FXML
    private TableColumn<Voiture, String> idNomAgence;
    @FXML
    private TextField matricule;
    @FXML
    private TextField marque;
    @FXML
    private TextField nbrplaces;
    @FXML
    private TextField nbrchev;
    @FXML
    private TextField tarifpj;
    @FXML
    private TextField photo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Connection cnx = ConnectionBd.getInstance().getCnx();

        Imvoiture v = new Imvoiture();
        v.afficherTest().stream().forEach((p) -> {
            obsvoiturelist.add(p);
        });
        idMatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        idMarque.setCellValueFactory(new PropertyValueFactory<>("marqueVoiture"));
        idPhoto.setCellValueFactory(new PropertyValueFactory<>("photoVoiture"));
        idNbrPlace.setCellValueFactory(new PropertyValueFactory<>("nbplace"));
        idNbrCh.setCellValueFactory(new PropertyValueFactory<>("nbrchevaux"));
        idtarif.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        idNomAgence.setCellValueFactory(new PropertyValueFactory<>("nomAgence"));
        tableauvaffiche.setItems(obsvoiturelist);

    }

    @FXML
    private void onUpdateVoiture(ActionEvent event) {
        Imvoiture v = new Imvoiture();
        voiture.setMatricule(Integer.parseInt(matricule.getText()));
        voiture.setMarqueVoiture(marque.getText());
        voiture.setPhotoVoiture(photo.getText());
        voiture.setNbplace(Integer.parseInt(nbrplaces.getText()));
        voiture.setNbrchevaux(Integer.parseInt(nbrchev.getText()));
        voiture.setTarif(Integer.parseInt(tarifpj.getText()));
        System.out.println("Id V " + voiture.getId_voiture());
        v.modifier(new Voiture(voiture.getId_voiture(), Integer.parseInt(matricule.getText()), marque.getText(), photo.getText(), Integer.parseInt(nbrplaces.getText()), Integer.parseInt(nbrchev.getText()), Integer.parseInt(tarifpj.getText())));

        new Alert(Alert.AlertType.INFORMATION, "done", ButtonType.CLOSE).show();
        clearFields();
        obsvoiturelist.set(tableauvaffiche.getSelectionModel().getFocusedIndex(), voiture);

    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("MenuAdmin2.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    @FXML
    public void onTableItemSelect() {
        // matricule.opacityProperty();
        voiture = tableauvaffiche.getSelectionModel().getSelectedItem();

        matricule.setText(String.valueOf(voiture.getMatricule()));
        marque.setText(voiture.getMarqueVoiture());
        nbrplaces.setText(String.valueOf(voiture.getNbplace()));
        tarifpj.setText(String.valueOf(voiture.getTarif()));
        nbrchev.setText(String.valueOf(voiture.getNbrchevaux()));
        photo.setText(voiture.getPhotoVoiture());
        System.out.println(voiture.getId_voiture());

    }

    @FXML

    private void delete(ActionEvent event) throws IOException, SQLException {
        Imvoiture imv = new Imvoiture();
        Voiture v = new Voiture();

        ObservableList obsvoiturelist, agl;
        obsvoiturelist = tableauvaffiche.getItems();
        agl = tableauvaffiche.getSelectionModel().getSelectedItems();
        v = tableauvaffiche.getSelectionModel().getSelectedItems().get(0);

        imv.supprimer(new Voiture(v.getMatricule()));
        agl.forEach(obsvoiturelist::remove);
        clearFields();

    }

    public void clearFields() {
        matricule.clear();
        marque.clear();
        nbrplaces.clear();
        tarifpj.clear();
        nbrchev.clear();
        photo.clear();
    }

    @FXML
    private void getAddView(MouseEvent event) throws IOException {

        Parent page2 = FXMLLoader.load(getClass().getResource("ajoutvoiture.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    @FXML
    private void goToStatPage(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("Piechart.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    @FXML
    private void ShareFb(ActionEvent event) {
            try {
             String u  ="https://www.facebook.com/sharer/sharer.php?u=http://triptodo.me";
            URI uri= new URI(u);

            java.awt.Desktop.getDesktop().browse(uri);
            // System.out.println(String.valueOf(voiture.getMatricule()));

       } catch (Exception e) {
           
        e.printStackTrace();
       }
    }

}
