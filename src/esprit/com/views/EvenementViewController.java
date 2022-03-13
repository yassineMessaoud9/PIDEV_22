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
import javafx.stage.FileChooser;
import com.esprit.upload.Upload;
import java.io.File;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

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
    @FXML
    private Button idupload;
    
    private File file;
    String pic;
    Text path;
    @FXML
    private Label path1;
    
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList ("Carnaval","festival", "rio de jeniro");
            type.setItems(list);
            //add.setGraphic(new ImageView(new Image("C:\\Users\\Utilisateur\\Downloads\\TripToDo\\TripToDo\\src\\esprit\\com\\src\\check-mark.png")));
         
    }    
    @FXML
    private void ajouterE(ActionEvent event) throws IOException {
        ServiceEvenement se = new ServiceEvenement();
         Image ig = new Image("/esprit/com/ImageNotif/wrong1.png");
        if(title.getText().equals("")|| pays.getText().equals("")||Float.parseFloat(prix.getText())== 0 || desc.getText().equals(""))
        {
                Notifications notifications=Notifications.create();
                notifications.graphic(new ImageView(ig));
                notifications.text("Hello please fill the required fields");
                notifications.show();
        }
        else if(ctrl()==false){
                Notifications notifications=Notifications.create();
                notifications.graphic(new ImageView(ig));
                notifications.text("date debut ne peux pas etre superieur a date fin");
                notifications.show();
        }
        else 
        {
                se.ajouter( 
                new Evenement(
                title.getText(),
                pays.getText(),
                Float.parseFloat(prix.getText()),
                Date.valueOf(dated.getValue()),
                Date.valueOf(datef.getValue()),
                adr.getText(),
                type.getSelectionModel().getSelectedItem().toString(),        
                pic,
                Integer.parseInt(place.getText()),
                desc.getText()));
    
     
                Image ig1 = new Image("/esprit/com/ImageNotif/right1.png");
                Notifications notifications=Notifications.create();
                notifications.graphic(new ImageView(ig1));
                notifications.text("Evenement Ajoutée");
                notifications.title("Success Message");
                notifications.show();
        }
        
    }

    @FXML
    private void upload(ActionEvent event) throws IOException {
          FileChooser fileChooser = new FileChooser();
            file= fileChooser.showOpenDialog(null);
             FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (.jpg)", ".JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (.png)", ".PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            path1.setText("File:"+file);
            //pic=(file.toURI().toString());
            pic=new Upload().upload(file,"\\UploadFile");
            System.out.println(pic);
    }
    public boolean ctrl()
        {   String d=dated.getValue().toString();
            String f=datef.getValue().toString();
            String[] first=d.split("-");
            String[] last=f.split("-");
            if(Integer.valueOf(first[0])<=Integer.valueOf(last[0])  && Integer.valueOf(first[1])<=Integer.valueOf(last[1]) && Integer.valueOf(first[2])<=Integer.valueOf(last[2]) )
          return true;
         return false;

        }

    @FXML
    private void ack(ActionEvent event) throws IOException {
         Parent page2 = FXMLLoader.load(getClass().getResource("MenuAdmin2.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }
    
    
}
