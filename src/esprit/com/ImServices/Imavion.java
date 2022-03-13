/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;


import esprit.com.Iservices.Igestionvol;
import esprit.com.entity.adresse;
import esprit.com.entity.avion;
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
public class Imavion implements Igestionvol<avion> {
    Connection cnx = ConnectionBd.getInstance().getCnx();

    @Override
// Ajouter avion dans la base de donnee   
    public void ajouter(avion t) {
        try {
            String req = "INSERT INTO avion (marque,nbrplace) VALUES (?,?)";
            PreparedStatement pst = cnx.prepareCall(req);
            pst.setString(1,t.getMarque());
            pst.setInt(2,t.getNbrplace());
            pst.executeUpdate(); 
            System.out.println("avion ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
  // Modifier avion dans la base de donnee
    @Override
    public void modifier(avion t) {
         try{
            String req = "UPDATE avion SET marque=?,nbrplace=? WHERE numserieavion=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(3,t.getNumserieavion());
            pst.setString(1,t.getMarque());
            pst.setInt(2,t.getNbrplace());

            
            pst.executeUpdate();
            System.out.println("avion modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
// Supprimer avion dans la base de donnee
    @Override
    public void supprimer(avion t) {
         try {
            String req = "DELETE FROM avion WHERE numserieavion=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,t.getNumserieavion());
            pst.executeUpdate();
            System.out.println("avion suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
// Afficher lise des avion
    @Override
    public List<avion> afficher() {

        List<avion> list = new ArrayList<>();
        
        try {
            String req = "SELECT * from avion";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new avion(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;

    }

// Chercher avion depuis id
    public List<avion> recherche(int id) {
         List<avion> list1= new ArrayList<>();
         List<avion> list2= afficher();
         
         list1= list2.stream().filter(c -> c.getNumserieavion()==id).collect(Collectors.toList());
         System.out.println(list1);
         return list1;
    }
    
// trie avion selon marque
    public List<avion> trimarq() {
         List<avion> list1= new ArrayList<>();
         List<avion> list2= afficher();
         list1= list2.stream().sorted((o1,o2)->o1.getMarque().compareTo(o2.getMarque())).collect(Collectors.toList());
         System.out.println(list1);
         return list1;
    }
    
// trie avion selon matricule
    public List<avion> trimat() {
         List<avion> list1= new ArrayList<>();
         List<avion> list2= afficher();
         list1= list2.stream().sorted((o1,o2)->o1.getNumserieavion()-(o2.getNumserieavion())).collect(Collectors.toList());
         System.out.println(list1);
         return list1;
    }
    
 // trie avion selon nombre de place 
    public List<avion> trinbrp() {
         List<avion> list1= new ArrayList<>();
         List<avion> list2= afficher();
         list1= list2.stream().sorted((o1,o2)->o1.getNbrplace()-(o2.getNbrplace())).collect(Collectors.toList());
         System.out.println(list1);
         return list1;
    }
    
 // chercher avion selon numserie 
   public avion afficheravancerrecherchenumserieavion(int num) {
        List<avion> list = new ArrayList<>(); 
        try {
            String req = "SELECT * FROM avion where numserieavion='" + num + "'";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new avion(rs.getInt(1), rs.getString(2),rs.getInt(3)));
      }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list.get(0);
    }   
}
