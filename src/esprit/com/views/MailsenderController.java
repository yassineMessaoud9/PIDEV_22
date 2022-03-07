/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import static com.sun.org.glassfish.external.amx.AMXUtil.prop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import javax.mail.PasswordAuthentication;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.PrinterJob;
import javafx.scene.Node;

import javafx.print.PrinterJob;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author MediaHelp
 */
public class MailsenderController implements Initializable {

    @FXML
    private TextField toadress;
    @FXML
    private AnchorPane report;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void handle(ActionEvent event) {
         System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
             Window primaryStage = null;
             job.showPrintDialog(primaryStage); 
            
             Node root=this.report;   
              job.printPage(root);
              job.endJob();
        /* String path="";
     JFileChooser j = new JFileChooser();
     j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
     int x=j.showSaveDialog(j);
      if (x==JFileChooser.APPROVE_OPTION){
     path=j.getSelectedFile().getPath();
      }
      
       Document doc = new Document();
 try {
     PdfWriter writer =  PdfWriter.getInstance(doc,new FileOutputStream(path+"PDF.pdf"));
     
      
  } catch (FileNotFoundException ex) {
       Logger.getLogger(MailsenderController.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (DocumentException ex) {   
            Logger.getLogger(MailsenderController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    } */
    }
    }}


    


  


      
      
    

    

