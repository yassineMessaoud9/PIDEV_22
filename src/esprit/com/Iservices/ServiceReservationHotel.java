/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Iservices;

import esprit.com.entity.ReservationHotel;
import esprit.com.entity.ReservationRestaurant;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MediaHelp
 */
public class ServiceReservationHotel implements  Iservice <ReservationHotel>{
     Connection bd1=ConnectionBd.getInstance().getCnx(); 

    @Override
    public void ajouter(ReservationHotel t) {
         try {
            String req = "INSERT INTO reservationhotels(typeChambre,nbrnuit,datereservation,nbrPersonne,dateallerReser,dateretourReser,idU,idhotel ) VALUES (?,?,?,?,?,?,?,?) ";
           PreparedStatement pst = bd1.prepareStatement(req);
             pst.setString(1, t.getTypeChambre());
              pst.setInt(2, t.getNbrNuit());
            pst.setDate(3, t.getDateReservation());
             pst.setInt(4, t.getNbrPersonne());
              pst.setDate(5, t.getDateallerReser());
                 pst.setDate(6, t.getDateretourReser());
               pst.setInt(7, t.getIdU());
               pst.setInt(8, t.getIdTourisme());
              pst.executeUpdate();
            System.out.println("resetrvation HOTEL ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

 public void modifier(ReservationHotel t) {
       try {
            String req = "UPDATE reservationhotels SET  typeChambre= ?,nbrnuit= ? ,dateReservation=?, nbrPersonne =?,dateallerReser=? ,dateretourReser=?,idU=?,idhotel=? WHERE `idReservationHotel` = ?";
           PreparedStatement pst = bd1.prepareStatement(req);
             pst.setString(1, t.getTypeChambre());
              pst.setInt(2, t.getNbrNuit());
            pst.setDate(3, t.getDateReservation());
             pst.setInt(4, t.getNbrPersonne());
              pst.setDate(5, t.getDateallerReser());
                 pst.setDate(6, t.getDateretourReser());
               pst.setInt(7, t.getIdU());
               pst.setInt(8, t.getIdTourisme());
                 pst.setInt(9, t.getIdReservationHotel());
              pst.executeUpdate();
            System.out.println("resetrvation HOTEL modifiè !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
  
   
         
    }


   
    public void supprimer(ReservationHotel  t) {
     
           try {
            String req = "DELETE FROM reservationhotels WHERE idReservationhotel =?";
            PreparedStatement pst =  bd1.prepareStatement(req);
            pst.setInt(1, t.getIdReservationHotel());
            pst.executeUpdate();
            System.out.println("reservationhotel suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

      public List<ReservationHotel> afficher() {
        List<ReservationHotel> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM reservationhotels";
            Statement st = bd1.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                list.add(new ReservationHotel(rs.getInt("idReservationHotel"), rs.getString("typeChambre"), rs.getInt("nbrnuit"), rs.getDate("datereservation"),rs.getInt("nbrpersonne"),rs.getDate("dateallerReser"),rs.getDate("dateretourReser"),rs.getInt("idU"),rs.getInt("idhotel")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
       public List<ReservationHotel> afficher2() {
        List<ReservationHotel> list = new ArrayList<>();
        
        try {
            String req = "SELECT typeChambre,nbrnuit,datereservation,nbrpersonne,dateallerReser,dateretourReser FROM reservationhotels";
            Statement st = bd1.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                list.add(new ReservationHotel( rs.getString("typeChambre"), rs.getInt("nbrnuit"), rs.getDate("datereservation"),rs.getInt("nbrpersonne"),rs.getDate("dateallerReser"),rs.getDate("dateretourReser")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
     public void modifier2(ReservationHotel t) {
       try {
            String req = "UPDATE reservationhotels SET  typeChambre= ?,nbrnuit= ? ,dateReservation=?, nbrPersonne =?,dateallerReser=? ,dateretourReser=? WHERE `idReservationHotel` = ?";
           PreparedStatement pst = bd1.prepareStatement(req);
             pst.setString(1, t.getTypeChambre());
              pst.setInt(2, t.getNbrNuit());
            pst.setDate(3, t.getDateReservation());
             pst.setInt(4, t.getNbrPersonne());
              pst.setDate(5, t.getDateallerReser());
                 pst.setDate(6, t.getDateretourReser());
              
                 pst.setInt(7, t.getIdReservationHotel());
              pst.executeUpdate();
            System.out.println("resetrvation HOTEL modifiè !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }}
       

