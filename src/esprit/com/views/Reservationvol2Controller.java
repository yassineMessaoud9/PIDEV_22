/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.entity.vol;
import esprit.com.utils.ConnectionBd;
import esprit.com.views.ItemvolController.MyListener;
import java.io.IOException;
import javafx.geometry.Insets;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gamer
 */
public class Reservationvol2Controller implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    
   
    private MyListener myListener;
    private List<vol> vols = new ArrayList<>();
    Connection cnx = ConnectionBd.getInstance().getCnx();
    
    private List<vol> getData() {
     List<vol> vols = new ArrayList<>();
     vol vol;
     try {
            String req = "SELECT * from vol";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {        
                vols.add(new vol(rs.getInt("numvol"),rs.getDate("dateallervol"),rs.getString("tempallervol"), rs.getDate("dateretourvol"), rs.getString("tempretourvol"),
                rs.getString("destination"),  rs.getString("classvol"),rs.getFloat("prixvol")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(vols);
    return vols;
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     vols.addAll(getData());
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < vols.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("itemvol.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                ItemvolController itemController = fxmlLoader.getController();
                    itemController.setData(vols.get(i),myListener);
                if (column == 2) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row); 
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE); 
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
    }    
    }  

    @FXML
    private void meteo(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("meteo.fxml"));
        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }
    
      
}
