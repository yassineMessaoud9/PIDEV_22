/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.ImServices;

import esprit.com.Iservices.IservicesMethodes;
import esprit.com.entity.Sponsors;
import esprit.com.entity.Suivi;
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
public class imSuivi implements IservicesMethodes<Suivi>{

        Connection cnx = ConnectionBd.getInstance().getCnx();
        
    @Override
    public void ajout(Suivi t) {

        try {
            String req = "INSERT INTO suivi(etat,idCommande,longitude,latitude,Adress)VALUES(?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getEtat());
            pst.setInt(2, t.getIdCommande());
            pst.setDouble(3, t.getLongitude());
            pst.setDouble(4, t.getLatitude());
            pst.setString(5, t.getAdress());
            pst.executeUpdate();
            System.out.println("Suivi Ajoutée !!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Suivi> Show() {
         List<Suivi> list = new ArrayList<>();
        
        try {
            String req="SELECT * from suivi";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
             while (rs.next()) {                
                list.add(new Suivi(rs.getInt("id"),rs.getInt("idCommande"),rs.getString("etat"),rs.getDouble("longitude"),rs.getDouble("latitude"),rs.getString("Adress")));
            }
        } catch (SQLException e) {
               System.err.println(e.getMessage());
        }
        return list;   
    }

    @Override
    public void Delete(Suivi t) {
          try {
             String req = "DELETE FROM suivi WHERE id=?";
             PreparedStatement pst = cnx.prepareStatement(req);
             pst.setInt(1, t.getId());
             pst.executeUpdate();
             System.out.println("Suivi suprimée !");

        } catch (SQLException e) {
                        System.out.println(e.getMessage());

        }
    }

    @Override
    public void Edit(Suivi t) {
   try {
            String req = "UPDATE suivi SET etat=?,idCommande=?,longitude=?,latitude=?,Adress=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(6, t.getId());
            pst.setString(1, t.getEtat());
            pst.setInt(2, t.getIdCommande());
            pst.setDouble(3, t.getLatitude());
            pst.setDouble(4, t.getLongitude());
            pst.setString(5, t.getAdress());

            pst.executeUpdate();
            System.out.println("Suivi Id " + t.getId()+ " Modifiée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

 


    @Override
    public void tri()  {
List<Suivi> list1= new ArrayList<>();
         List<Suivi> list2= Show();
         
         list1= list2.stream().sorted((o1,o2)->o1.getEtat().compareTo(o2.getEtat())).collect(Collectors.toList());
         System.out.println(list1);  
    }

  @Override
    public List<Suivi> Find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
