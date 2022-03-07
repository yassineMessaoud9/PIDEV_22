/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import com.mysql.cj.Query;
import esprit.com.Iservices.Igestionvol;
import esprit.com.entity.adresse;
import esprit.com.entity.avion;
import esprit.com.entity.compagnieaerienne;
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
public class Imcompagnieaerienne implements Igestionvol<compagnieaerienne> {
     Connection cnx = ConnectionBd.getInstance().getCnx();

// ajouter compagnie
    @Override
    public void ajouter(compagnieaerienne t) {
        try {
            String req = "INSERT INTO compagnieaerienne (nomcompagnie,idadresse) VALUES (?,?)";
            PreparedStatement pst = cnx.prepareCall(req);
            pst.setString(1,t.getNomcompagnie());
            pst.setInt(2,t.getIdadresse());
            pst.executeUpdate(); 
            System.out.println("compagnieaerienne ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    // modifier compagnie 3 champs

    @Override
    public void modifier(compagnieaerienne t) {
         try{
            String req = "UPDATE compagnieaerienne SET nomcompagnie=?,idadresse=? WHERE idcompagnie=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(3,t.getIdcompagnie());
            pst.setString(1,t.getNomcompagnie());
            pst.setInt(2,t.getIdadresse());
            pst.executeUpdate();
            System.out.println("compagnieaerienne modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //modifier compagnie 2 champs
    public void modifier2(compagnieaerienne t) {
         try{
            String req = "UPDATE compagnieaerienne SET nomcompagnie=? WHERE idcompagnie=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(2,t.getIdcompagnie());
            pst.setString(1,t.getNomcompagnie());
            pst.executeUpdate();
            System.out.println("compagnieaerienne modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
//supprimer compagnie
    @Override
    public void supprimer(compagnieaerienne t) {
         try {
            String req = "DELETE FROM compagnieaerienne WHERE idcompagnie=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,t.getIdcompagnie());
            pst.executeUpdate();
            System.out.println("compagnieaerienne suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    //afficher liste des compagnie 
   
    @Override
    public List<compagnieaerienne> afficher() {
List<compagnieaerienne> list = new ArrayList<>();
        
        try {
            String req = "SELECT * from compagnieaerienne";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new compagnieaerienne (rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;

    }
//chercher compagnie a partir id 
    
    public void recherche(int id) {
        List<compagnieaerienne> list1= new ArrayList<>();
         List<compagnieaerienne> list2= afficher();
         
         list1= list2.stream().filter(c -> c.getIdcompagnie()==id).collect(Collectors.toList());
         System.out.println(list1); 
    }

    //tri compagnie selon nom compagnie 
    public void tri() {
         List<compagnieaerienne> list1= new ArrayList<>();
         List<compagnieaerienne> list2= afficher();
         
         list1= list2.stream().sorted((o1,o2)->o1.getNomcompagnie().compareTo(o2.getNomcompagnie())).collect(Collectors.toList());
         System.out.println(list1);
    }
    
    //chercher compagnie jointure ne marche pas correctement 
       public void rechercher(int id , String nom , String pays) {
           
           try {
            String req = "SELECT * FROM compagnieaerienne as C, adresse as A WHERE C.idadresse =A.idadresse AND C.idcompagnie=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
               nom=rs.getString("nomcompagnie");
               pays=rs.getString("paysadresse");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
         
    }
       //chercher compagnie a partir du nom compagnie
       
       public List<compagnieaerienne> cherchercompagnie (String val){
        
      List<compagnieaerienne> list1= new ArrayList<>();
         List<compagnieaerienne> list2= afficher();
         
         list1= list2.stream().filter(c -> c.getNomcompagnie().startsWith(val)).collect(Collectors.toList());
         System.out.println(list1);
         return list1;
    }
       // jointure pour que le combo box a les adresse du compagnie 
       
       public List<compagnieaerienne> jointure() {
           List<compagnieaerienne> list = new ArrayList<compagnieaerienne>();
        
        try {
            String req = "select nomcompagnie , paysadresse from compagnieaerienne join adresse using (idadresse);";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
               list.add(new compagnieaerienne(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
  
    
    

    
}
