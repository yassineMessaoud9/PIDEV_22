/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.ImServices.ImUtilisateur;
import esprit.com.Iservices.Igestionvol;
import esprit.com.entity.adresse;
import esprit.com.entity.compagnieaerienne;
import esprit.com.entity.reservationvol;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Gamer
 */
public class Imreservationvol implements Igestionvol<reservationvol> {
    Connection cnx = ConnectionBd.getInstance().getCnx();
    
//ajouter reservation
    @Override
    public void ajouter(reservationvol t) {
         try {
            String req = "INSERT INTO reservationvol (idU,numvol) VALUES (?,?)";
            PreparedStatement pst = cnx.prepareCall(req);
            pst.setInt(1,ImUtilisateur.idUser);
            pst.setInt(2,t.getNumvol());
            pst.executeUpdate(); 
            System.out.println("reservationvol ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
//modifier reservation
    @Override
    public void modifier(reservationvol t) {
         try{
            String req = "UPDATE reservationvol SET idU=?,numvol=? WHERE idreservationvol=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(3,t.getIdreservationvol());
            pst.setInt(1,t.getIdU());
            pst.setInt(2,t.getNumvol());
            pst.executeUpdate();
            System.out.println("reservation vol modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
//supprimer reservation
    @Override
    public void supprimer(reservationvol t) {
        try {
            String req = "DELETE FROM reservationvol  WHERE idreservationvol=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,t.getIdreservationvol());
            pst.executeUpdate();
            System.out.println("reservationvol suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }

//liste de reservation 
    @Override
    public List<reservationvol> afficher() {
        List<reservationvol> list = new ArrayList<>();
        try {
            String req = "SELECT * from reservationvol";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new reservationvol(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

// rechercher reservation a partir de lid    
    public void recherche(int id) {
         List<reservationvol> list1= new ArrayList<>();
         List<reservationvol> list2= afficher();
         list1= list2.stream().filter(c -> c.getIdreservationvol()==id).collect(Collectors.toList());
         System.out.println(list1); 
    }

 
    public void tri() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
