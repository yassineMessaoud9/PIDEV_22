/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.Iservices.IserviceEveReT;
import esprit.com.entity.Avis;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Utilisateur
 */
public class ServiceAvis implements IserviceEveReT <Avis>{
    Connection cnx = ConnectionBd.getInstance().getCnx();

    
    public void ajouter(Avis  a ) {
     
        
        try {
            String req = "INSERT INTO Avis (rate, summary, idu) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, a.getRate());
            pst.setString(2, a.getSummary());
            pst.setInt(3, a.getIdu());
            pst.executeUpdate();
            System.out.println("Avis ajoutée !");
            
        } catch (SQLException ex) {
        
            System.out.println(ex.getMessage());
        }
    }

   
    public void supprimer(Avis a ) {
       try {
            String req = "DELETE FROM Avis WHERE idAvis=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, a.getId());
            pst.executeUpdate();
            System.out.println("Avis suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

  
    public void modifier(Avis a) {
        try{
            String req = "UPDATE Avis  SET  rate=?, summary=?, idu=?  WHERE idAvis=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(4, a.getId());
            pst.setInt(1, a.getRate());
            pst.setString(2, a.getSummary());
            pst.setInt(3, a.getIdu());           
            pst.executeUpdate();
            System.out.println("Avis modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public List<Avis> afficher() {
        
        List<Avis> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM Avis ";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Avis(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
     public List<Avis> afficher(String role) {
        
        List<Avis> list = new ArrayList<>();
        
        try {
            String req = "SELECT *FROM avis  inner join utilisateur  on avis.idu=utilisateur.idU where utilisateur.role=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, role);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Avis(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
    
    
}
