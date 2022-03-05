/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class TestMapController implements Initializable {

    @FXML
    private WebView webview;
    private WebEngine webengine;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        webengine = webview.getEngine();

        url = this.getClass().getResource("map/index.html");
        webengine.load(url.toString());

       
      
}

    @FXML
    private void tt(ActionEvent event) {
           /*     System.err.println("test");

         webengine.getLoadWorker().stateProperty().addListener(
     new ChangeListener<State>() {  
    @Override public void changed(ObservableValue<? extends State> ov, State oldState, State newState) {
      if (newState == State.SUCCEEDED) {
        String win;
          win = String.valueOf( webengine.executeScript("nom")).toString();
      //  win.setMember("lat", new JavaApp());
        System.err.println(win);
      }
    }
  });*/
           
            Double lat = (Double) webview.getEngine().executeScript("lat");
            Double lon = (Double) webview.getEngine().executeScript("lon");


        System.out.println("Lat: " + lat);
                System.out.println("LOn " + lon);


    }

// JavaScript interface object
private class JavaApp {
  public void exit() {
    Platform.exit();
  }

    }
}
