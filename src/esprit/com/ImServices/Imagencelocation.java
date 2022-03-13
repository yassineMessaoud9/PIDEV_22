/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.Iservices.gestionLocationVoiture;
import esprit.com.entity.Agencelocation;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.activation.DataSource;

/**
 *
 * @author ons
 */
public class Imagencelocation implements gestionLocationVoiture<Agencelocation>{
    
       Connection cnx = ConnectionBd.getInstance().getCnx();

   


    @Override
    public void ajouter(Agencelocation t) {
  try {
            String req = "INSERT INTO agencelocation ( nomAgence,contactAgence,addressAgence,logoAgence) VALUES (?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getNomAgence());
            pst.setInt(2, t.getContactAgence());
            pst.setString(3, t.getAdressAgence());
            pst.setString(4, t.getLogoAgence());
         
            
            pst.executeUpdate();
            System.out.println("Agence de location ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   

    @Override
    public void modifier(Agencelocation t) {
       try{
            String req = "UPDATE agencelocation SET nomAgence=?,contactAgence=?,addressAgence=?,logoAgence=? WHERE idAgence=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            
           pst.setString(1, t.getNomAgence());
            pst.setInt(2, t.getContactAgence());
            pst.setString(3, t.getAdressAgence());
            pst.setString(4, t.getLogoAgence());
          pst.setInt(5, t.getIdAgence());
            pst.executeUpdate();
            System.out.println("Agence de location  modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

    @Override
    public void supprimer(Agencelocation t) {
  try {
            String req = "DELETE FROM agencelocation WHERE idAgence=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getIdAgence());
            pst.executeUpdate();
            System.out.println("Agence de location suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

    @Override
    public List<Agencelocation> afficher() {
         List<Agencelocation> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM agencelocation";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Agencelocation(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
    public List<Agencelocation> afficherNom() {
         List<Agencelocation> list = new ArrayList<>();
        
        try {
            String req = "select nomAgence from agencelocation where idAgence= 1 ";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Agencelocation( rs.getString(1)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }

    public void modifier(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
           public List<Agencelocation> TriAgenceNom(){
           
      List<Agencelocation> list1= new ArrayList<>();
         List<Agencelocation> list2= afficher();
         
         list1= list2.stream().sorted((o1,o2)->o1.getNomAgence().compareTo(o2.getNomAgence())).collect(Collectors.toList());
         System.out.println(list1);
          return   list1;   
     }
 
      public List<Agencelocation> search (String val){
        
      List<Agencelocation> list1= new ArrayList<>();
         List<Agencelocation> list2= afficher();
         
         list1= list2.stream().filter(c -> c.getNomAgence().startsWith(val)).collect(Collectors.toList());
         System.out.println(list1);
         return list1;
    }
   
   
       
    
}
