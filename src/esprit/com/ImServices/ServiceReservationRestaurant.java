/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.ImServices;

import esprit.com.Iservices.Iservice;
import esprit.com.entity.Hotel;
import esprit.com.entity.ReservationRestaurant;
import esprit.com.entity.Restaurant;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.sql.Timestamp;

/**
 *
 * @author MediaHelp
 */
public class ServiceReservationRestaurant implements Iservice<ReservationRestaurant> {

    Connection cnx = ConnectionBd.getInstance().getCnx();

    public void ajouter(ReservationRestaurant t) {
        try {
            String req = "INSERT INTO reservationrestaurant (datereservationrestau,datedebutres,datefinres,idU,idrestau ) VALUES (?,?,?,?,?) ";
            PreparedStatement pst = cnx.prepareStatement(req);

            pst.setDate(1, t.getDatereservationrestau());
            pst.setDate(2, t.getDatedebutres());
            pst.setDate(3, t.getDatefinres());
            pst.setInt(4, t.getIdU());
            pst.setInt(5, t.getIdtourisme());
            pst.executeUpdate();
            System.out.println("resetrvation restau ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(ReservationRestaurant t) {
        try {
            String req = "DELETE FROM reservationrestaurant WHERE idreservationrestau  =?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getIdReservationRestaurant());
            pst.executeUpdate();
            System.out.println("reservationrestau suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(ReservationRestaurant t) {
        try {
            String req = "UPDATE reservationrestaurant SET  datereservationrestau= ? ,datedebutres=?, datefinres =?,idU=? ,idrestau=? WHERE `idreservationrestau` = ?";
            PreparedStatement pst = cnx.prepareStatement(req);

            pst.setDate(1, t.getDatereservationrestau());
            pst.setDate(2, t.getDatedebutres());
            pst.setDate(3, t.getDatefinres());
            pst.setInt(4, t.getIdU());
            pst.setInt(5, t.getIdtourisme());
            pst.setInt(6, t.getIdReservationRestaurant());
            pst.executeUpdate();
            System.out.println("resetrvation restau modifiee !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifier2(ReservationRestaurant t) {
        try {
            String req = "UPDATE reservationrestaurant SET  datereservationrestau= ? ,datedebutres=?, datefinres =? WHERE `idreservationrestau` = ?";
            PreparedStatement pst = cnx.prepareStatement(req);

            pst.setDate(1, t.getDatereservationrestau());
            pst.setDate(2, t.getDatedebutres());
            pst.setDate(3, t.getDatefinres());

            pst.setInt(4, t.getIdReservationRestaurant());
            pst.executeUpdate();
            System.out.println("resetrvation restau modifiee !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<ReservationRestaurant> afficher() {
        List<ReservationRestaurant> list = new ArrayList<>();

        try {
            String req = "SELECT * FROM reservationrestaurant";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.add(new ReservationRestaurant(rs.getInt("idreservationrestau"), rs.getDate("datereservationrestau"), rs.getDate("datedebutres"), rs.getDate("datefinres"), rs.getInt("idU"), rs.getInt("idrestau")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
}
