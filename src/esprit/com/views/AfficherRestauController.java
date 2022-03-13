/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ServiceRestaurant;
import esprit.com.entity.Restaurant;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MediaHelp
 */
public class AfficherRestauController implements Initializable {

    @FXML
    private TableView<Restaurant> tablerestau;
    @FXML
    private TableColumn<Restaurant, String> idnomrestau;
    @FXML
    private TableColumn<Restaurant, String> idtyperestau;
    @FXML
    private TableColumn<Restaurant, Integer> idnombretable;
    @FXML
    private TableColumn<Restaurant, String> idlocalisation;
    @FXML
    private TableColumn<Restaurant, Integer> idtelephone;
    @FXML
    private TableColumn<Restaurant, String> idphoto;
    ObservableList<Restaurant> obsrestaulist = FXCollections.observableArrayList();
    @FXML
    private TextField nomrestau;
    @FXML
    private ComboBox<String> typerestau;
    @FXML
    private TextField nbrtable;
    @FXML
    private TextField localisation;
    @FXML
    private TextField telephone;
    @FXML
    private TextField photo;
    private Restaurant restau;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ServiceRestaurant sR = new ServiceRestaurant();
        sR.afficher().stream().forEach((p) -> {
            obsrestaulist.add(p);
        });

        idnomrestau.setCellValueFactory(new PropertyValueFactory<>("nomrestau"));
        idtyperestau.setCellValueFactory(new PropertyValueFactory<>("typerestau"));
        idnombretable.setCellValueFactory(new PropertyValueFactory<>("nbrtable"));
        idlocalisation.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        idtelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        idphoto.setCellValueFactory(new PropertyValueFactory<>("photo"));

        tablerestau.setItems(obsrestaulist);
        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "5FORCHETTE ",
                        "4 FORCHETTE ",
                        " 3 FORCHETTE"
                );
        typerestau.setItems(options);

    }

    @FXML
    private void onTableItemSelect(MouseEvent event) {
        nomrestau.opacityProperty();
        restau = tablerestau.getSelectionModel().getSelectedItem();
        nomrestau.setText(restau.getNomrestau());

        typerestau.setValue(restau.getTyperestau());
        nbrtable.setText(String.valueOf(restau.getNbrtable()));
        localisation.setText(restau.getLocalisation());

        telephone.setText(String.valueOf(restau.getTelephone()));
        photo.setText(restau.getPhoto());
    }

    public void clearFields() {
        nomrestau.clear();
        //     typerestau.Items.clear();
        nbrtable.clear();
        localisation.clear();
        telephone.clear();
        photo.clear();
    }

    @FXML
    private void onUpdateRestau(ActionEvent event) {
        ServiceRestaurant sR = new ServiceRestaurant();

        restau.setNomrestau(nomrestau.getText());
        restau.setTyperestau(typerestau.getSelectionModel().getSelectedItem().toString());
        restau.setNbrtable(Integer.parseInt(nbrtable.getText()));
        restau.setLocalisation(localisation.getText());
        restau.setTelephone(Integer.parseInt(telephone.getText()));

        restau.setPhoto(photo.getText());

        sR.modifier(new Restaurant(restau.getIdrestau(), nomrestau.getText(), typerestau.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(nbrtable.getText()), localisation.getText(), Integer.parseInt(telephone.getText()), photo.getText()));

        new Alert(Alert.AlertType.INFORMATION, "ok", ButtonType.CLOSE).show();
        clearFields();
        obsrestaulist.set(tablerestau.getSelectionModel().getFocusedIndex(), restau);
    }

    @FXML
    private void deletehotel(ActionEvent event) {
        ServiceRestaurant sR = new ServiceRestaurant();
        Restaurant t = new Restaurant();

        ObservableList obshotellist, a;
        obsrestaulist = tablerestau.getItems(); 
        a = tablerestau.getSelectionModel().getSelectedItems();
        t = tablerestau.getSelectionModel().getSelectedItems().get(0);

        sR.supprimer(new Restaurant(t.getIdrestau()));

        System.out.println(t);
        System.out.println(a);
        a.forEach(obsrestaulist::remove);

        // ListCompetition.getItems()
//             competitions = serviceCompetition.AfficherCompetition();
        clearFields();

    }

    @FXML
    private void getview(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("ajouterRestaurant.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    @FXML
    private void resetmenu(ActionEvent event) throws IOException {

        Parent page2 = FXMLLoader.load(getClass().getResource("MenuAdmin2.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }
}
    
