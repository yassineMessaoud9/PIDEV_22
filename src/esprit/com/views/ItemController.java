/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.entity.Voiture;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author ons
 */
public class ItemController  {

    private Label nameLabel;
    private Label priceLable;
    @FXML
    private ImageView img;

      private Voiture voiture;
    private MyListener myListener;
    @FXML
    private Label marque;
    @FXML
    private Label nbrplace;
    @FXML
    private Label nbrchau;
    @FXML
    private Label tarif;
    @FXML
    private Label nbrplace1;
    @FXML
    private Label tarif1;
    @FXML
    private Label nbrplace11;
    @FXML
    private Label nbrchau1;
    @FXML
    private Label tarif2;
    @FXML
    private Label tarif11;
    
   @FXML
    private void click(MouseEvent mouseEvent) throws IOException {
       Parent page2 = FXMLLoader.load(getClass().getResource("ajoutlocation.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }
    
    
    
    
    private void reserver(MouseEvent event) throws IOException {
            Parent page2 = FXMLLoader.load(getClass().getResource("ajoutlocation.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }
   
     public void setData(Voiture voiture, MyListener myListener) throws MalformedURLException {
        this.voiture = voiture;
        this.myListener = myListener;
        marque.setText(voiture.getMarqueVoiture());
        nbrplace.setText(String.valueOf(voiture.getNbplace()));
        nbrchau.setText(String.valueOf(voiture.getNbrchevaux()));
        tarif.setText(String.valueOf(voiture.getTarif()));
        String imagebase=voiture.getPhotoVoiture();
         Image image = new Image(imagebase);
       img.setImage(image);
         
         
         
    }
    
    
    public interface MyListener {
    public void onClickListener(Voiture voiture);
}

}
