/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;
import esprit.com.Imservices.Imvoiture;
import javafx.geometry.Insets;
import esprit.com.entity.Voiture;
import esprit.com.utils.ConnectionBd;
import esprit.com.views.ItemController.MyListener;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ons
 */
public class UsermainController implements Initializable {

    Connection cnx = ConnectionBd.getInstance().getCnx();

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private MyListener myListener;

    MouseEvent event;
    private List<Voiture> voitures = new ArrayList<>();

    //get data
    private List<Voiture> getData() {
        List<Voiture> voitures = new ArrayList<>();
        Voiture voiture;

        try {
            String req = "SELECT marqueVoiture,photoVoiture,nbplace,nbrchevaux,tarif FROM voitureee ";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                voitures.add(new Voiture(rs.getString("marqueVoiture"), rs.getString("photoVoiture"), rs.getInt("nbplace"), rs.getInt("nbrchevaux"), rs.getInt("tarif")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(voitures);
        return voitures;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        voitures.addAll(getData());

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < voitures.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(voitures.get(i), myListener);

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

}
