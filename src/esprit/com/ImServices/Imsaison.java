/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.Iservices.gestionLocationVoiture;
import esprit.com.entity.Location;
import esprit.com.entity.Saison;
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
public class Imsaison implements gestionLocationVoiture <Saison> {
 Connection cnx = ConnectionBd.getInstance().getCnx();

    @Override
    public void ajouter(Saison t) {
 try {
            String req = "INSERT INTO saison ( idSaison,nomSaison) VALUES (?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
           
            pst.setInt(1, t.getIdSaison());
            pst.setString(2, t.getNomSaison());
           
            pst.executeUpdate();
            System.out.println("saison ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

    @Override
    public void modifier(Saison t) {
 try{
            String req = "UPDATE saison SET nomSaison=? WHERE idSaison=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(2, t.getIdSaison());
            pst.setString(1, t.getNomSaison());
             pst.executeUpdate();
         
            System.out.println("saison  modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

    @Override
    public void supprimer(Saison t) {
try {
            String req = "DELETE FROM saison WHERE idSaison=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getIdSaison());
            pst.executeUpdate();
            System.out.println("saison suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }     }

    @Override
    public List<Saison> afficher() {
        List<Saison> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM saison";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                                list.add(new Saison(
                                        rs.getInt(1),
                                        rs.getString(2)
                                       
                                        ));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    }
  
