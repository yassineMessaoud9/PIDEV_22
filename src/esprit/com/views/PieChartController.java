/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;
import esprit.com.Imservices.Imvoiture;
import esprit.com.entity.Voiture;
import esprit.com.utils.ConnectionBd;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ons
 */
public class PieChartController implements Initializable {

    @FXML
    private PieChart pieChart;

    ArrayList<Integer> cell= new ArrayList<Integer>();
    ArrayList<String> name= new ArrayList<String>();
    
     ObservableList<PieChart.Data> pieChartData;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          Connection cnx = ConnectionBd.getInstance().getCnx();
          
         List<Voiture> list = new ArrayList<Voiture>();
         
         pieChartData=FXCollections.observableArrayList();

        try {
            String req = "select marqueVoiture, tarif from voitureee ";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pieChartData.add(new PieChart.Data(rs.getString("marqueVoiture"),rs.getInt("tarif")));
                name.add(rs.getString("marqueVoiture"));
                cell.add(rs.getInt("tarif"));
                
                list.add(new Voiture(rs.getString("marqueVoiture"), rs.getInt("tarif")));
            }
        } catch (SQLException ex) {
           
            System.out.println(ex.getMessage());
        }


     pieChart.setData(pieChartData);
     pieChart.setTitle("les voitures selon leurs tarifs");
    }    

    @FXML
    private void back(MouseEvent event) throws IOException {
           Parent page2 = FXMLLoader.load(getClass().getResource("affichevoiture.fxml"));

                Scene scene2 = new Scene(page2);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene2);
                app_stage.show();
    }
    
}
