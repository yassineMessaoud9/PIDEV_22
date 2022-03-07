/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
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

     public Double longitude = 48.8588336;
     public Double latitude = 2.2769956;
    private String x;
    private JSObject javascriptConnector;
    private JSObject javascriptConnector2;

    private JavaConnector javaConnector = new JavaConnector();

    ;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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

    public class JavaConnector {

        public Double longitude = 48.8588336;
        public Double latitude = 2.2769956;

        
    }
}
