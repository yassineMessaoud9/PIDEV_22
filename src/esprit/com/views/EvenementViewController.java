package esprit.com.views;

import esprit.com.Imservices.ServiceEvenement;
import esprit.com.entity.Evenement;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import java.sql.Date;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EvenementViewController implements Initializable {

    @FXML
    private Button add;

    @FXML
    private TextField title;

    @FXML
    private TextField pays;

    @FXML
    private TextField prix;

    @FXML
    private TextField adr;

    @FXML
    private TextField taswira;

    @FXML
    private ComboBox type;

    @FXML
    private DatePicker dated;

    @FXML
    private DatePicker datef;

    @FXML
    private TextField place;

    @FXML
    private TextField desc;
    ZoneId defaultZoneId = ZoneId.systemDefault();
    
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList ("Carnaval","festival", "rio de jeniro");
            type.setItems(list);
            //add.setGraphic(new ImageView(new Image("C:\\Users\\Utilisateur\\Downloads\\TripToDo\\TripToDo\\src\\esprit\\com\\src\\check-mark.png")));
         
    }    
    @FXML
    private void ajouterE(ActionEvent event) throws IOException {
        ServiceEvenement se = new ServiceEvenement();
       
  
        se.ajouter( 
                new Evenement(
                title.getText(),
                pays.getText(),
                Float.parseFloat(prix.getText()),
                Date.valueOf(dated.getValue()),
                Date.valueOf(datef.getValue()),
                adr.getText(),
                type.getSelectionModel().getSelectedItem().toString(),        
                taswira.getText(),
                Integer.parseInt(place.getText()),
                desc.getText()));
    
     
        JOptionPane.showMessageDialog(null, "Evenement ajoutée");
        
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("EvenementView.fxml"));
        //Parent root=loader.load();
        //tfNom.getScene().setRoot(root);
        //EvenementViewController apc=loader.getController();
        //apc.setIdN(tfNom.getText());
        //apc.setIdp(tfprenom.getText());
        
    }
    
    
}
