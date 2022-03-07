/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImCommandeRestau;
import static esprit.com.ImServices.ImUtilisateur.EmailRes;
import esprit.com.entity.CommandeRestau;
import esprit.com.mail.Sendmail;
import esprit.com.utils.ConnectionBd;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JOptionPane;
import netscape.javascript.JSObject;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class AfficheCommandAdminController implements Initializable {
    
    @FXML
    private WebView webview;
    private WebEngine webengine;
    CommandeRestau CommandeRestau;
    public TableColumn<CommandeRestau, Double> longitude;
    public TableColumn<CommandeRestau, Double> latitude;
    private String x;
    private JSObject javascriptConnector;
    private JSObject javascriptConnector2;
    int com;
    private JavaConnector javaConnector = new JavaConnector();
    
    @FXML
    private TableColumn<CommandeRestau, String> ncom;
    @FXML
    private TableColumn<CommandeRestau, String> nplat;
    @FXML
    private TableColumn<CommandeRestau, String> nomU;
    @FXML
    private TableColumn<CommandeRestau, Double> Prix;
    @FXML
    private TableColumn<CommandeRestau, Date> dateCom;
    @FXML
    private TableView<CommandeRestau> TabComAdm;
    
    Sendmail sn;
    ObservableList<CommandeRestau> obslist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        webengine = webview.getEngine();
        
        url = this.getClass().getResource("map/recupMap.html");
        
        webengine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<State>() {
            public void changed(ObservableValue ov, State oldState, State newState) {
                if (newState == State.SUCCEEDED) {
                    JSObject window = (JSObject) webengine.executeScript("window");
                    window.setMember("javaConnector", javaConnector);
                    
                    JSObject javascriptConnector = (JSObject) webengine.executeScript("longitude");
                    JSObject javascriptConnector2 = (JSObject) webengine.executeScript("latitude");
                    
                }
            }
        }
        );
        
        webengine.load(url.toString());
        
    }
    
    @FXML
    private void ConfirmePlat(ActionEvent event) {
        
        Connection cnx = ConnectionBd.getInstance().getCnx();
        CommandeRestau ct = new CommandeRestau();
        String sub="Restau Trip To DO";
                String Obj="Commande confirmer";

        try {
            String req = "UPDATE commandrestau SET etat=1 WHERE num_commande=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, com);
            sn.envoyer(EmailRes, sub, req);
                    JOptionPane.showMessageDialog(null, "Commande Accepter !");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void loadData() {
        ImCommandeRestau imc = new ImCommandeRestau();
        imc.afficherAdmin().stream().forEach((p) -> {
            obslist.add(p);
        });
        ncom.setCellValueFactory(new PropertyValueFactory<>("Num_Commande"));
        Prix.setCellValueFactory(new PropertyValueFactory<>("prix_commande"));
        dateCom.setCellValueFactory(new PropertyValueFactory<>("date_commande"));
        nplat.setCellValueFactory(new PropertyValueFactory<>("nomPlat"));
        nomU.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        TabComAdm.setItems(obslist);
    }
    private void onTableItemSelect(MouseEvent event) {

        CommandeRestau = TabComAdm.getSelectionModel().getSelectedItem();

     com = CommandeRestau.getNum_Commande();

    }
 
    public class JavaConnector {
        
        public Double longitude = 48.8588336;
        public Double latitude = 2.2769956;
        
    }
}
