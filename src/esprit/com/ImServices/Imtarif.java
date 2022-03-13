/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.Iservices.gestionLocationVoiture;
import esprit.com.entity.Agencelocation;
import esprit.com.entity.Tarif;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ons
 */
public class Imtarif  implements gestionLocationVoiture<Tarif> {
      Connection cnx = ConnectionBd.getInstance().getCnx();

    @Override
    public void ajouter(Tarif t) {
       try {
            String req = "INSERT INTO tarif ( prix,matricule,idSaison) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
           
            pst.setFloat(1, t.getPrix());
            pst.setInt(2, t.getMatricule());
            pst.setInt(3, t.getIdSaison());
         
            
            pst.executeUpdate();
            System.out.println("Tarif ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Tarif t) {
        try{
            String req = "UPDATE tarif SET prix=?,matricule=?,idSaison=? WHERE idTarif=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(3, t.getIdTarif());
             pst.setFloat(1, t.getPrix());
            pst.setInt(2, t.getMatricule());
            pst.setInt(3, t.getIdSaison());
         
          
            pst.executeUpdate();
            System.out.println("Tarif  modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }


    @Override
    public void supprimer(Tarif t) {
        try {
            String req = "DELETE FROM tarif WHERE idTarif=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getIdTarif());
            pst.executeUpdate();
            System.out.println("Tarif suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

    @Override
    public List<Tarif> afficher() {
     List<Tarif> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM tarif";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Tarif(rs.getInt(1), rs.getFloat(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }

        }

  
  



