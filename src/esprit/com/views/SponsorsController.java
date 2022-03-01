/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImSponsors;
import esprit.com.entity.Sponsors;
import esprit.com.entity.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class SponsorsController implements Initializable {
    
    private Sponsors Sponsors;
    @FXML
    private Button Logout;
    @FXML
    private TableColumn<Sponsors, String> ns;
    @FXML
    private TableColumn<Sponsors, String> pd;
    @FXML
    private TableColumn<Sponsors, Date> dd;
    @FXML
    private TableColumn<Sponsors, Date> df;
    @FXML
    private Button Delete;
    @FXML
    private Button EditSponsors;
    @FXML
    private Button ajtsp;
    @FXML
    private TextField Recherche;
    @FXML
    private TableView<Sponsors> TableSponsor;
    ObservableList<Sponsors> obsSponsors = FXCollections.observableArrayList();
    @FXML
    private TextField msp;
    @FXML
    private TextField mpd;
    @FXML
    private DatePicker mdd;
    @FXML
    private DatePicker mdf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadData();
    }
    
    @FXML
    private void Logout(ActionEvent event) {
    }
    
    @FXML
    private void Sponsors(ActionEvent event) {
    }
    
    @FXML
    private void Delete(ActionEvent event) {
        ImSponsors ims = new ImSponsors();
        Sponsors sp = new Sponsors();
        ObservableList obsSponsors, Pointage;
        obsSponsors = TableSponsor.getItems();
        Pointage = TableSponsor.getSelectionModel().getSelectedItems();
        sp = TableSponsor.getSelectionModel().getSelectedItems().get(0);
        
        ims.Delete(new Sponsors(sp.getId()));
        
        Pointage.forEach(obsSponsors::remove);
        
    }
    
    @FXML
    private void EditSponsors(ActionEvent event) {
        ImSponsors ims = new ImSponsors();
        Sponsors.setNomSponsors(msp.getText());
        Sponsors.setPrixDonations(Double.parseDouble(mpd.getText()));
        Sponsors.setDateDeb(Date.valueOf(mdd.getValue()));
        Sponsors.setDateFin(Date.valueOf(mdf.getValue()));
        ims.Edit(new Sponsors(Sponsors.getId(),msp.getText(),Double.parseDouble(mpd.getText()),Date.valueOf(mdd.getValue()),Date.valueOf(mdf.getValue())));
                
        new Alert(Alert.AlertType.INFORMATION, Sponsors.getNomSponsors()+ " Modifier !!", ButtonType.APPLY.CLOSE).show();
        clearFields();
        obsSponsors.set(TableSponsor.getSelectionModel().getFocusedIndex(), Sponsors);

    }
    
    @FXML
    private void AjoutSposors(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("AjoutSponsors.fxml"));
        
        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }
    
    @FXML
    private void Recherche(ActionEvent event) {
    }
    
    private void LoadData() {
        ImSponsors ims = new ImSponsors();
        
        ims.Show().stream().forEach((p) -> {
            obsSponsors.add(p);
        });
        ns.setCellValueFactory(new PropertyValueFactory<>("nomSponsors"));
        pd.setCellValueFactory(new PropertyValueFactory<>("prixDonations"));
        dd.setCellValueFactory(new PropertyValueFactory<>("dateDeb"));
        df.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        TableSponsor.setItems(obsSponsors);
        
        
        Recherche.textProperty().addListener((obs, oldText, newText) -> {
                List<Sponsors> ae = ims.Find(newText);
                TableSponsor.getItems().setAll(ae);
    }); 
                }
    
    public void clearFields() {
        msp.clear();
        mpd.clear();
        mdd.getEditor().clear();
        mdf.getEditor().clear();
    }
    
    @FXML
    private void onTableItemSelect(MouseEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        
        Sponsors = TableSponsor.getSelectionModel().getSelectedItem();
        msp.setText(Sponsors.getNomSponsors());
        mpd.setText(String.valueOf(Sponsors.getPrixDonations()).toString());
        this.mdd.setValue(Sponsors.getDateDeb().toLocalDate());
        this.mdf.setValue(Sponsors.getDateFin().toLocalDate());
        
    }
}
