/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Iservices;

import esprit.com.entity.Hotel;
import esprit.com.entity.ReservationHotel;
import esprit.com.entity.ReservationRestaurant;
import esprit.com.utils.ConnectionBd;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author MediaHelp
 */
public class ServiceHotel  implements Iservice<Hotel> {
   Connection bd1=ConnectionBd.getInstance().getCnx();

    @Override
    public void ajouter(Hotel t) {
       try {
            String req = "INSERT INTO hotel(nomhotel,adresse,etoile,nbrChambre,photo ) VALUES (?,?,?,?,?) ";
           PreparedStatement pst = bd1.prepareStatement(req);
             pst.setString(1, t.getNomhotel());
              pst.setString(2, t.getAdresse());
            pst.setInt(3, t.getEtoile());
             pst.setInt(4, t.getNbrChambre());
               pst.setString(5, t.getPhoto());
            
              pst.executeUpdate();
            System.out.println(" HOTEL ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Hotel t) {
         try {
            String req = "DELETE FROM hotel WHERE idhotel =?";
            PreparedStatement pst =  bd1.prepareStatement(req);
            pst.setInt(1, t.getIdhotel());
            pst.executeUpdate();
            System.out.println("hotel suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Hotel t) {
        try {
            String req = "UPDATE hotel SET  nomhotel= ?, adresse= ? ,etoile= ?, nbrChambre = ?, photo= ? WHERE idhotel = ?";
           PreparedStatement pst = bd1.prepareStatement(req);
             pst.setString(1, t.getNomhotel());
              pst.setString(2, t.getAdresse());
            pst.setInt(3, t.getEtoile());
             pst.setInt(4, t.getNbrChambre());
               pst.setString(5, t.getPhoto());
                 pst.setInt(6, t.getIdhotel());
            
              pst.executeUpdate();
            System.out.println(" HOTEL modifiè !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public List<Hotel> afficher() {
         List<Hotel> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM hotel";
            Statement st = bd1.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                list.add(new Hotel(rs.getInt("idhotel"), rs.getString("nomhotel"), rs.getString("adresse"), rs.getInt("etoile"), rs.getInt("nbrChambre"),rs.getString("photo")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
     public List<Hotel> rechercherHotel(String val){
      List<Hotel> list1= new ArrayList<>();
         List<Hotel> list2= afficher();
         
         list1= list2.stream().filter(c ->c.getNomhotel().startsWith(val)).collect(Collectors.toList());
        return list1;
               
     }
                public  List<Hotel> TRIHotel(){
      List<Hotel> list1= new ArrayList<>();
         List<Hotel> list2= afficher();
         
         list1= list2.stream().sorted((o1,o2)->o1.getNomhotel().compareTo(o2.getNomhotel())).collect(Collectors.toList());
return list1;               
     }
         
                public  List<Hotel> TRIHotelNbrchambre(){
      List<Hotel> list1= new ArrayList<>();
         List<Hotel> list2= afficher();
         
         list1= list2.stream().sorted((o1,o2)->o1.getNbrChambre()-o2.getNbrChambre()).collect(Collectors.toList());
return list1;               
     }
      
     
    }

    
            
        
        
    
    



