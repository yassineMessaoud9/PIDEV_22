/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Iservices;

import esprit.com.entity.ReservationHotel;
import esprit.com.entity.tourismeEtablissement;
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
public class ServicetourismeEtablissment implements  Iservice <tourismeEtablissement> {
  Connection bd1=ConnectionBd.getInstance().getCnx();
    @Override
    public void ajouter(tourismeEtablissement t) {
        try {
            String req = "INSERT INTO tourismeetablissement( nomtourisme,paystourisme,logo,etoile,telephone) VALUES ('" + t.getNomtourisme()+ "','" + t.getPaystourisme()+ "','" + t.getLogo()+ "','" + t.getEtoile()+ "','" + t.getTelephone()+ "')";
            Statement st = bd1.createStatement();
            st.executeUpdate(req);
            System.out.println("etablissement touristique ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(tourismeEtablissement t) {
        try {
            String req = "DELETE FROM tourismeetablissement WHERE idtourisme =?";
            PreparedStatement pst =  bd1.prepareStatement(req);
            pst.setInt(1, t.getIdtourisme());
            pst.executeUpdate();
            System.out.println("tourisme suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(tourismeEtablissement t) {
      try {
           String req = "UPDATE tourismeetablissement SET  nomtourisme=?, paystourisme=?, logo=?, etoile=? ,telephone= ? WHERE `idtourisme` = ?";
           PreparedStatement pst = bd1.prepareStatement(req);
           
              pst.setString(1, t.getNomtourisme());
            pst.setString(2, t.getPaystourisme());
            pst.setString(3, t.getLogo());
            pst.setInt(4, t.getEtoile());
             pst.setInt(5, t.getTelephone());
              pst.setInt(6, t.getIdtourisme());
              pst.executeUpdate();
            System.out.println("etablissement touristique Modifièè !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<tourismeEtablissement> afficher() {
         List<tourismeEtablissement> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM tourismeetablissement";
            Statement st = bd1.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                list.add(new tourismeEtablissement(rs.getInt("idtourisme"), rs.getString("nomtourisme"), rs.getString("paystourisme"), rs.getString("logo"),rs.getInt("etoile"),rs.getInt("telephone")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    }

 
    

