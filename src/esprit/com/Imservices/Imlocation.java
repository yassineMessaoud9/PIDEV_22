/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.Iservices.gestionLocationVoiture;
import esprit.com.entity.Location;
import esprit.com.entity.Voiture;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ons
 */
public class Imlocation implements gestionLocationVoiture <Location> {
 Connection cnx = ConnectionBd.getInstance().getCnx();
  
  


    @Override
    public void ajouter(Location t) {
        try {
            String req = "INSERT INTO locationvoiture ( idLocation,datedebutLocation,datefinLocation,dateLocation,montant,idU,matricule,id_saison) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
           
            pst.setInt(1, t.getIdLocation());
            pst.setDate(2, t.getDate_debutlocation());
            pst.setDate(3, t.getDate_finlocation());
            pst.setTimestamp(4,t.getDate_location());
            pst.setFloat(5, t.getMontant());
            pst.setInt(6, t.getIdU());
            pst.setInt(7, t.getMatricule());
            pst.setInt(8, t.getId_saison());   
            pst.executeUpdate();
            System.out.println("Location ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Location t) {
       try{
            String req = "UPDATE locationvoiture SET datedebutLocation=?,datefinLocation=?,dateLocation=?,montant=?,idU=?,matricule=?,id_saison=? WHERE idLocation=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getIdLocation());
            pst.setDate(2, t.getDate_debutlocation());
            pst.setDate(3, t.getDate_finlocation());
            pst.setTimestamp(4, t.getDate_location());
            pst.setFloat(5, t.getMontant());
            pst.setInt(6, t.getIdU());
            pst.setInt(7, t.getMatricule());
            pst.setInt(7, t.getId_saison());
            pst.executeUpdate();
            System.out.println("Location  modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Location t) {
   try {
            String req = "DELETE FROM locationvoiture WHERE idLocation=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getIdLocation());
            pst.executeUpdate();
            System.out.println("Location suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

    
    
    
    
    
    
    @Override
    public List<Location> afficher() {
        List<Location> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM locationvoiture";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                                list.add(new Location(
                                        rs.getInt(1),
                                        rs.getDate(2),
                                        rs.getDate(3),
                                        rs.getTimestamp(4),
                                        rs.getFloat(5),
                                        rs.getInt(6), 
                                        rs.getInt(7),
                                         rs.getInt(8)
                                        ));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
       public List<Location> afficherlocation() {
           List<Location> list = new ArrayList<Location>();
        
        try {
            String req = "SELECT datedebutLocation, datefinLocation,dateLocation,montant,prenom,marqueVoiture,nomSaison FROM locationvoiture as l  , utilisateur as u ,voitureee as v, saison as s WHERE l.matricule=v.matricule AND l.idU=u.idU AND l.id_saison=s.idSaison;";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
               list.add(new Location(rs.getDate(1), rs.getDate(2), rs.getTimestamp(3), rs.getFloat(4), rs.getString(5),rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }

       
      
       
}