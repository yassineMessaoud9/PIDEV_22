/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.Iservices.IserviceEveReT;
import esprit.com.entity.Ticket;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Utilisateur
 */
public class ServiceTicket implements IserviceEveReT<Ticket>{
    
     Connection cnx = ConnectionBd.getInstance().getCnx();

    
    public void ajouter(Ticket t) {
     
        
        try {
            String req = "INSERT INTO Ticket( prixTicket,dateTicket) VALUES (?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setFloat(1, t.getPrixTicket());
            pst.setDate(2, t.getDateTicket());
            //pst.setInt(3, t.getIdut());
         
  
            
            pst.executeUpdate();
            System.out.println("Ticket ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   
    public void supprimer(Ticket t) {
       try {
            String req = "DELETE FROM Ticket WHERE prixTicket=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setFloat(1, t.getPrixTicket());
            pst.executeUpdate();
            System.out.println("Ticket suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

  
    public void modifier(Ticket t) {
        System.out.println("ggg " + t.toString());
        try{
            String req = "UPDATE Ticket SET prixTicket=?, dateTicket=? WHERE idTicket=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(3,t.getIdTicket());
            pst.setFloat(1, t.getPrixTicket());
            pst.setDate(2, t.getDateTicket());
            //pst.setInt(4,t.getIdut());
            pst.executeUpdate();
            System.out.println("Ticket modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public List<Ticket> afficher() {
        
        List<Ticket> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM Ticket";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Ticket(rs.getInt(1), rs.getFloat(2), rs.getDate(3)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
       public ObservableList<Ticket> getticketliste() throws SQLException {
           String req = "SELECT * FROM Ticket";
        ObservableList<Ticket> ticketList = FXCollections.observableArrayList();
        
         List <Ticket> list = new ArrayList<>(); 
         
            
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                list.add(new Ticket( rs.getFloat(1), rs.getDate(2)));
            }
       
        
        return ticketList;

    }
    public List<Ticket> search (Float val){
        
      List<Ticket> list1= new ArrayList<>();
         List<Ticket> list2= afficher();
         
         list1= list2.stream().filter(c -> c.getPrixTicket() == val).collect(Collectors.toList());
         System.out.println(list1);
         return list1;
    }
    public List<Ticket> TRIPrix(){
        
         List<Ticket> list1= new ArrayList<>();
         List<Ticket> list2= afficher();
         
        list1=list2.stream().sorted((o1,o2)->(int)(o2.getPrixTicket() - o1.getPrixTicket())).collect(Collectors.toList());
        System.out.println(list1);

        return list1;
               
               
     }
     public List<Ticket> TRIDate(){
        
         List<Ticket> list1= new ArrayList<>();
         List<Ticket> list2= afficher();
         
        list1=list2.stream().sorted((o1,o2)->(int)(o2.getDateTicket().compareTo(o1.getDateTicket()))).collect(Collectors.toList());
        System.out.println(list1);

        return list1;
               
               
     }
    
    
}
