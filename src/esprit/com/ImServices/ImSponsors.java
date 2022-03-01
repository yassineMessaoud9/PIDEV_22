/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.ImServices;

import esprit.com.Iservices.IservicesMethodes;
import esprit.com.entity.Plat;
import esprit.com.entity.Sponsors;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Yassine
 */
public class ImSponsors implements IservicesMethodes<Sponsors> {

    Connection cnx = ConnectionBd.getInstance().getCnx();

    @Override
    public void ajout(Sponsors t) {

        try {
            String req = "INSERT INTO sponsors(nomSponsors,prixDonations,dateDeb,dateFin)VALUES(?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getNomSponsors());
            pst.setDouble(2, t.getPrixDonations());
            pst.setDate(3, t.getDateDeb());
            pst.setDate(4, t.getDateFin());
            pst.executeUpdate();
            System.out.println("Sponsor Ajoutée !!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Sponsors> Show() {
  List<Sponsors> list = new ArrayList<>();
        
        try {
            String req="SELECT * from sponsors";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
             while (rs.next()) {                
                list.add(new Sponsors(rs.getInt("id"),rs.getString("nomSponsors"),rs.getDouble("prixDonations"),rs.getDate("dateDeb"),rs.getDate("dateFin")));
            }
        } catch (SQLException e) {
               System.err.println(e.getMessage());
        }
        return list;   
    }

    @Override
    public void Delete(Sponsors t) {
        try {
             String req = "DELETE FROM sponsors WHERE id=?";
             PreparedStatement pst = cnx.prepareStatement(req);
             pst.setInt(1, t.getId());
             pst.executeUpdate();
             System.out.println("Sponsors suprimée !");

        } catch (SQLException e) {
                        System.err.println(e.getMessage());

        }
    }

    @Override
    public void Edit(Sponsors t) {

        try {
            String req = "UPDATE sponsors SET nomSponsors=?,prixDonations=?,dateDeb=?,dateFin=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(5, t.getId());
            pst.setString(1, t.getNomSponsors());
            pst.setDouble(2, t.getPrixDonations());
            pst.setDate(3, t.getDateDeb());
            pst.setDate(4, t.getDateFin());
            pst.executeUpdate();
            System.out.println("Sponsor " + t.getNomSponsors()+ " Modifiée !");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    @Override
    public List<Sponsors> Find(String t) {
 List<Sponsors> list1= new ArrayList<>();
         List<Sponsors> list2= Show();
         
         list1= list2.stream().filter(c -> c.getNomSponsors().startsWith(t)).collect(Collectors.toList());
return list1;               
           }


    @Override
    public void tri()  {
List<Sponsors> list1= new ArrayList<>();
         List<Sponsors> list2= Show();
         
         list1= list2.stream().sorted((o1,o2)->o1.getNomSponsors().compareTo(o2.getNomSponsors())).collect(Collectors.toList());
         System.out.println(list1);  
    }

}
