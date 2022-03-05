/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.Iservices.IserviceEveReT;
import esprit.com.entity.Evenement;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Utilisateur
 */
public class ServiceEvenement implements IserviceEveReT <Evenement>{
     Connection cnx = ConnectionBd.getInstance().getCnx();
     
     



    
    public void ajouter(Evenement t) {
     
        
        try {
            String req = "INSERT INTO evenement (intituleEve,paysEve,prixEve,datedebutEve,datefinEve,addressEve,typeEve,photoEve,nbplaceEve,descriptionEve) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getIntituleEve());
            pst.setString(2, t.getPays());
            pst.setFloat(3, t.getPrixEve());
            pst.setDate(4, t.getDatedebutEve());
            pst.setDate(5, t.getDatefinEve());
            pst.setString(6,t.getAddressEve());
            pst.setString(7,t.getTypeEve());
            pst.setString(8,t.getPhotoEve());
            pst.setInt(9,t.getNbplaceEve());
            pst.setString(10,t.getDescriptionEve());    
            
            pst.executeUpdate();
            System.out.println("Evenement ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   
    public void supprimer(Evenement t) {
       try {
            String req = "DELETE FROM evenement WHERE intituleEve=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getIntituleEve());
            pst.executeUpdate();
            System.out.println("Evenement suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

  
    public void modifier(String title, Evenement t) {  
        try{
            String req = "UPDATE evenement SET intituleEve=?, paysEve=?, prixEve=?,datedebutEve=?, datefinEve=?  , addressEve=?, typeEve=?, photoEve=?,nbplaceEve=?, descriptionEve=? WHERE idEve=?";
            PreparedStatement pst = cnx.prepareStatement(req);       
            pst.setString(1, t.getIntituleEve());
            pst.setString(2, t.getPays());
            pst.setFloat(3, t.getPrixEve());
            pst.setDate(4, t.getDatedebutEve());
            pst.setDate(5, t.getDatefinEve());
            pst.setString(6,t.getAddressEve());
            pst.setString(7,t.getTypeEve());
            pst.setString(8,t.getPhotoEve());
            pst.setInt(9,t.getNbplaceEve());
            pst.setString(10,t.getDescriptionEve()); 
            pst.setInt(11,this.aff(title)); 
            pst.executeUpdate();
            System.out.println("Evenement modifiée !");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public Integer aff(String title) {
        try {
            String req = "SELECT idEve from Evenement where intituleEve=?;";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, title);
            ResultSet rs = pst.executeQuery();
            rs.next();      
            return rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    public List<Evenement> afficher() {
        
        List<Evenement> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM Evenement";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Evenement(rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getDate(5), rs.getDate(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
        
    public List<Evenement> afficherjointure() {
        
        List<Evenement> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM Evenement";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Evenement(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getDate(5), rs.getDate(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    public List<Evenement> search (String val){
        
      List<Evenement> list1= new ArrayList<>();
         List<Evenement> list2= afficher();
         
         list1= list2.stream().filter(c -> c.getIntituleEve().startsWith(val)).collect(Collectors.toList());
         System.out.println(list1);
         return list1;
    }
        public List<Evenement> TRIPrix(){
        
         List<Evenement> list1= new ArrayList<>();
         List<Evenement> list2= afficher();
         
        list1=list2.stream().sorted((o1,o2)->(int)(o2.getPrixEve() - o1.getPrixEve())).collect(Collectors.toList());
        System.out.println(list1);

        return list1;
               
               
     }
    
    
}
