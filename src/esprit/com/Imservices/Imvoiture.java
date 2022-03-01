/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;


import esprit.com.Iservices.gestionLocationVoiture;
import esprit.com.entity.Agencelocation;
import esprit.com.entity.Voiture;
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
 * @author ons
 */
public class Imvoiture implements gestionLocationVoiture<Voiture> {
      Connection cnx = ConnectionBd.getInstance().getCnx();

    @Override
    public void ajouter(Voiture t) {
          try {
            String req = "INSERT INTO voiture ( matricule,marqueVoiture,photoVoiture,nbplace,nbrchevaux,tarif,idAgence) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getMatricule());
            pst.setString(2, t.getMarqueVoiture());
            pst.setString(3, t.getPhotoVoiture());
            pst.setInt(4, t.getNbplace());
            pst.setInt(5, t.getNbrchevaux());
            pst.setString(6, t.getTarif());
            pst.setInt(7, t.getIdAgence());
            
            pst.executeUpdate();
            System.out.println("Voiture ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Voiture t) {
         try{
            String req = "UPDATE voiture SET marqueVoiture=?,photoVoiture=?,nbplace=?,nbrchevaux=?,tarif=?,idAgence=? WHERE matricule=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(6, t.getMatricule());
           pst.setString(1, t.getMarqueVoiture());
            pst.setString(2, t.getPhotoVoiture());
            pst.setInt(3, t.getNbplace());
            pst.setInt(4, t.getNbrchevaux());
             pst.setString(5, t.getTarif());
            pst.setInt(6, t.getIdAgence());
            pst.executeUpdate();
            System.out.println("Voiture  modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void supprimer(Voiture t) {
      try {
            String req = "DELETE FROM voiture WHERE matricule=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getMatricule());
            pst.executeUpdate();
            System.out.println("Voiture suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Voiture> afficher() {
           List<Voiture> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM voiture ";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Voiture(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getString(6), rs.getInt(7)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
    public void rechercherVoiture(int matricule){
      List<Voiture> list1= new ArrayList<>();
         List<Voiture> list2= afficher();
         
         list1= list2.stream().filter(c -> c.getMatricule()==matricule).collect(Collectors.toList());
         System.out.println(list1);
               
     }
                public void TRIVoiture(){
      List<Voiture> list1= new ArrayList<>();
         List<Voiture> list2= afficher();
         
         list1= list2.stream().sorted((o1,o2)->o1.getMarqueVoiture().compareTo(o2.getMarqueVoiture())).collect(Collectors.toList());
         System.out.println(list1);
               
     }
                
                
   
    public List<Voiture> afficherTest() {
           List<Voiture> list = new ArrayList<Voiture>();
        
        try {
            String req = "select matricule, marqueVoiture, photoVoiture, nbplace,nbrchevaux,tarif, nomAgence from voiture JOIN agencelocation USING (idAgence)";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
               list.add(new Voiture(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
                
                
  
          
                
        
                    
                    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
                 
public  List<Object> rechercher() {
          String nom =null;
             List<Object> list1= new ArrayList<>();
                List<Object> list2= new ArrayList<>();
           try {
            String req = "select matricule, marqueVoiture, photoVoiture, nbplace,nbrchevaux,tarif, nomAgence from voiture JOIN agencelocation USING (idAgence)";
            PreparedStatement pst = cnx.prepareStatement(req);
           
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()) {
                list2.add(rs.getInt(1)); 
                
                 list2.add(rs.getString(2));
                  list2.add(rs.getString(3));
                   list2.add(rs.getInt(4));
                    list2.add(rs.getInt(5));
                      list2.add(rs.getString(6));
                       list2.add(rs.getString(7));
                      
                      // list1.add(list2);
                     
                      System.out.println(list2);
                       
                      
            }
              
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return list1;
    


}}