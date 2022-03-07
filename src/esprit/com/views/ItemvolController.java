/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.Imservices.Imreservationvol;
import esprit.com.entity.reservationvol;
import esprit.com.entity.vol;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Gamer
 */
public class ItemvolController  {

    @FXML
    private Label priceLable1;
    @FXML
    private Label nameLabel1;
    @FXML
    private Label nameLabel11;
    @FXML
    private Label nameLabel12;
    @FXML
    private Label nameLabel13;
    @FXML
    private Label nameLabel131;
    @FXML
    private Label destination;
    @FXML
    private Label prix;
    @FXML
    private Label datealler;
    @FXML
    private Label tempsaller;
    @FXML
    private Label dateretour;
    @FXML
    private Label tempsretour;
    @FXML
    private Label classe;
    private vol vol;
  private MyListener myListener;
    @FXML
    private Label priceLable11;
    /**
     * Initializes the controller class.
     */
       @FXML
    private void click(MouseEvent mouseEvent) throws IOException {
       Parent page2 = FXMLLoader.load(getClass().getResource("ajoutlocation.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }
    
   
   public void setData(vol vol, MyListener myListener) {
        this.vol = vol;
        this.myListener = myListener;
        destination.setText(vol.getDestination());
        prix.setText(String.valueOf(vol.getPrixvol()));
        datealler.setText(String.valueOf(vol.getDateallervol()));
       
        tempsaller.setText(vol.getTempsallervol());
         dateretour.setText(String.valueOf(vol.getDateretourvol()));
        tempsretour.setText(vol.getTempsretourrvol());
        classe.setText(vol.getClassvol());
       
    }

    @FXML
    private void reservervol2(ActionEvent event) {
        Imreservationvol Imreservationvol= new Imreservationvol();
        
        Imreservationvol.ajouter(new reservationvol(1,vol.getNumvol()));
        JOptionPane.showMessageDialog(null,"reservation ajoutée");
        
        
        
    }
    
    
    public interface MyListener {
    public void onClickListener(vol vol);
}
    
}
