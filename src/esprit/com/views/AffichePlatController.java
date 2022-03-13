/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.ImServices.ImPlat;
import esprit.com.entity.Plat;
import esprit.com.utils.ConnectionBd;
import esprit.com.views.OnePlatController.MyListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class AffichePlatController implements Initializable {
    Connection cnx = ConnectionBd.getInstance().getCnx();

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private MyListener myListener;
        ObservableList<Plat> obsPlatlist = FXCollections.observableArrayList();

    MouseEvent event;
    private List<Plat> plat = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    
     public List<Plat> Show() {
        List<Plat> list = new ArrayList<>();
        try {
            String req = "SELECT * from plat";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.add(new Plat(rs.getInt("idPlat"), rs.getString("nomPlat"), rs.getDouble("prixPlat"), rs.getString("photoPlat"), rs.getString("description")));
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        return list;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        plat.addAll(Show());

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < plat.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("OnePlat.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OnePlatController itemController = fxmlLoader.getController();
                itemController.setData(plat.get(i), myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
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
    private void back(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("MenuClient.fxml"));
        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }
    
}
