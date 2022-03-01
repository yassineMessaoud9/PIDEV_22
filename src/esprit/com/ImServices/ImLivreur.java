/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.ImServices;

import esprit.com.Iservices.IservicesMethodes;
import esprit.com.entity.CommandeRestau;
import esprit.com.entity.Livreur;
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
public class ImLivreur implements IservicesMethodes<Livreur> {

    Connection cnx = ConnectionBd.getInstance().getCnx();

    @Override
    public void ajout(Livreur t) {
        try {
            String req = "INSERT INTO livreur(nomLivreur,cin,telephone)VALUES(?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getNomLivreur());
            pst.setString(2, t.getCin());
            pst.setInt(3, t.getTelephone());
            pst.executeUpdate();
            System.out.println("Livreur Ajouteé !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Livreur> Show() {
        List<Livreur> list = new ArrayList<>();
        
        try {
            String req="SELECT * from livreur";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
             while (rs.next()) {                
                list.add(new Livreur(rs.getInt("idLivreur"),rs.getString("nomLivreur"),rs.getString("cin"),rs.getInt("telephone")));
            }
        } catch (SQLException e) {
               System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void Delete(Livreur t) {
        
          try {
             String req = "DELETE FROM livreur WHERE idLivreur=?";
             PreparedStatement pst = cnx.prepareStatement(req);
             pst.setInt(1, t.getIdLivreur());
             pst.executeUpdate();
             System.out.println("Livreur suprimée !");

        } catch (SQLException e) {
                        System.out.println(e.getMessage());

        }
    }

    @Override
    public void Edit(Livreur t) {
        
        try {
            String req = "UPDATE livreur SET nomLivreur=?,cin=?,telephone=? WHERE idLivreur=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(4, t.getIdLivreur());
            pst.setString(1, t.getNomLivreur());
            pst.setString(2, t.getCin());
            pst.setInt(3, t.getTelephone());
            pst.executeUpdate();
            System.out.println("Livreur " + t.getNomLivreur()+ " Modifiée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    @Override
    public void tri()  {
List<Livreur> list1= new ArrayList<>();
         List<Livreur> list2= Show();
         
         list1= list2.stream().sorted((o1,o2)->o1.getNomLivreur().compareTo(o2.getNomLivreur())).collect(Collectors.toList());
         System.out.println(list1);    }
 @Override
    public List<Livreur> Find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
