/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImCommandeRestau;
import esprit.com.ImServices.ImPlat;
import static esprit.com.ImServices.ImUtilisateur.nameUser;
import static esprit.com.ImServices.ImUtilisateur.idUser;

import esprit.com.entity.CommandePlat;
import esprit.com.entity.CommandeRestau;
import esprit.com.entity.Plat;
import static esprit.com.views.TestMapController.lat;
import static esprit.com.views.TestMapController.lon;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javax.swing.text.DateFormatter;
import java.sql.Date;
import java.time.LocalDateTime;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class AjouterCommandeController implements Initializable {


    private Stage stage;
    private CommandeRestau CommandeRestau;
    public static Double prix1;
    public static Plat Plat;
    
    Double latitude;
    Double   longitude ;
    @FXML
    public TableView<Plat> tablePlat;
    @FXML
    private TableColumn<Plat, String> nomplat;
    @FXML
    private TableColumn<Plat, Double> prixPlat;
    @FXML
    private TableColumn<Plat, String> descriptionPlat;
    @FXML
    private Button commander;
    @FXML
    private Text Prix;
    ObservableList<Plat> obsPlat = FXCollections.observableArrayList();
    private Text idUserr;
    @FXML
    private WebView webmap;
    private WebEngine webengine;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadData();
                webengine = webmap.getEngine();

        url = this.getClass().getResource("map/index.html");
        webengine.load(url.toString());


    }

    @FXML
    private void commander(ActionEvent event) {
        int etat=0;
             latitude =  Double.parseDouble(webmap.getEngine().executeScript("lat").toString());
             
            longitude =  Double.parseDouble(webmap.getEngine().executeScript("lon").toString());
             
             
                     System.out.println("Lat AjoutCom: " + latitude);
                System.out.println("LOn AjoutCom" + longitude);

       int nombreAleatoire = 1000 + (int) (Math.random() * ((1000000 - 1000) + 1));

        LocalDate now = LocalDate.now();
        System.out.println(now);

        CommandeRestau cm = new CommandeRestau(nombreAleatoire, prix1, Date.valueOf(now), idUser, latitude, longitude,etat);

        ImCommandeRestau Imc = new ImCommandeRestau();
        Imc.ajout(cm);
        tablePlat.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        int x = tablePlat.getSelectionModel().getSelectedItems().size();
        for (int i = 0; i < x; i++) {
            Plat = tablePlat.getSelectionModel().getSelectedItems().get(i);

            Imc.ajoutPlatCommande(new CommandePlat(cm.getNum_Commande(), Plat.getIdPlat()));
            Notifications notifications = Notifications.create();
            notifications.text("Commande ajoutée");
            notifications.title("Sucess Message");
            notifications.show();
        }

    }

    private void LoadData() {
        ImPlat imp = new ImPlat();
        imp.Show().stream().forEach((p) -> {
            obsPlat.add(p);
        });
        nomplat.setCellValueFactory(new PropertyValueFactory<>("nomPlat"));
        prixPlat.setCellValueFactory(new PropertyValueFactory<>("prixPlat"));
        descriptionPlat.setCellValueFactory(new PropertyValueFactory<>("description"));
        tablePlat.setItems(obsPlat);
      //  idUserr.setText(nameUser);
        
        
        

    }

    @FXML
    private void onTableItemsSelect(MouseEvent event) {

        ImCommandeRestau imCo = new ImCommandeRestau();

        Double S = 0.0;
        Double P = 0.0;

        Prix.setText(String.valueOf(S).toString());
        tablePlat.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        int x = tablePlat.getSelectionModel().getSelectedItems().size();
        for (int i = 0; i < x; i++) {
            Plat = tablePlat.getSelectionModel().getSelectedItems().get(i);

            P = Plat.getPrixPlat();
            S += P;
            Prix.setText(String.valueOf(S).toString());
            prix1 = S;

        }
    }

    private void ButnOpenMap(ActionEvent event) throws IOException {

      FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("testMap.fxml"));
Parent rootl = (Parent) fxmlLoader.load();
Stage stage = new Stage();
stage.initStyle(StageStyle.DECORATED);
stage.setTitle("Second Window");
stage.setScene(new Scene(rootl));
stage.show();
        stage.setResizable(false);


    }

    @FXML
    private void back(MouseEvent event)throws IOException {
         Parent page2 = FXMLLoader.load(getClass().getResource("MenuClient.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }


}
