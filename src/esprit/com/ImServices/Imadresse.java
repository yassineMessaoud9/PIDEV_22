/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.Iservices.Igestionvol;
import esprit.com.entity.adresse;
import esprit.com.entity.vol;
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
// Ajouter adresse dans la base de donnee
public class Imadresse implements Igestionvol<adresse> {
    Connection cnx = ConnectionBd.getInstance().getCnx();
    @Override
    public void ajouter(adresse t) {
        try {
            String req = "INSERT INTO adresse (paysadresse,rueadresse,contactadresse) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareCall(req);
            pst.setString(1,t.getPaysadresse());
            pst.setString(2,t.getRueadresse());
            pst.setInt(3,t.getContactadresse());
            pst.executeUpdate(); 
            System.out.println("adresse ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }       
        
    
// Modifier adresse dans la base de donnee
    @Override
    public void modifier(adresse t) {
           try{
            String req = "UPDATE adresse SET paysadresse=?,rueadresse=?,contactadresse=? WHERE idadresse=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(4,t.getIdadresse());
            pst.setString(1,t.getPaysadresse());
            pst.setString(2,t.getRueadresse());
            pst.setInt(3,t.getContactadresse());

            
            pst.executeUpdate();
            System.out.println("adresse modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    // Supprimer adresse dans la base de donnee

    @Override
    public void supprimer(adresse t) {
        try {
            String req = "DELETE FROM adresse WHERE idadresse=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,t.getIdadresse());
            pst.executeUpdate();
            System.out.println("adresse suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
// Afiicher les adresse de la base de donnee
    @Override
    public List<adresse> afficher() {
        List<adresse> list = new ArrayList<>();
        
        try {
            String req = "SELECT * from adresse";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new adresse(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

 // chercher adresse depuis l'id   
    public void recherche(int id) {
        List<adresse> list1= new ArrayList<>();
         List<adresse> list2= afficher();
         
         list1= list2.stream().filter(c -> c.getIdadresse()==id).collect(Collectors.toList());
         System.out.println(list1);
               
       
    }

// trier les adresse de le nom du pays    
    public List<adresse> tri() {
         
   
         List<adresse> list1= new ArrayList<>();
         List<adresse> list2= afficher();
         
         list1= list2.stream().sorted((o1,o2)->o1.getPaysadresse().compareTo(o2.getPaysadresse())).collect(Collectors.toList());
         System.out.println(list1);
               return list1;
     
    }
 // chercher adresse depuis pays   
     public adresse afficheravancer(String Pays) {
        List<adresse> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM adresse where paysadresse='" + Pays + "'";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new adresse(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list.get(0);
    }
     public List<adresse> chercherPays (String val){
        
      List<adresse> list1= new ArrayList<>();
         List<adresse> list2= afficher();
         
         list1= list2.stream().filter(c -> c.getPaysadresse().startsWith(val)).collect(Collectors.toList());
         System.out.println(list1);
         return list1;
    }
}
