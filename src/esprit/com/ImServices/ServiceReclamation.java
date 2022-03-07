/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.Iservices.IserviceEveReT;
import esprit.com.entity.Reclamation;
import esprit.com.entity.Ticket;
import esprit.com.entity.TypeReclamation;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Utilisateur
 */
public class ServiceReclamation implements IserviceEveReT<Reclamation>{
    
      Connection cnx = ConnectionBd.getInstance().getCnx();

    
    public void ajouter(Reclamation t) {
     
        
        try {
            String req = "INSERT INTO Reclamation(intituleReclamation,etatReclamation,description, dateReclamation) VALUES (?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
           // pst.setString(1, t.getTypeReclamation().name());
            pst.setString(3, t.getDescription());
           pst.setDate(4, t.getDateReclamation());
            pst.setString(1, t.getIntituleReclamation());
            pst.setString(2, t.getEtatReclamation());
            //pst.setInt(5, t.getIdUser());
         
            pst.executeUpdate();
            System.out.println("Reclamation ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   
      @Override
    public void supprimer(Reclamation t) {
       try {
            String req = "DELETE FROM Reclamation WHERE intituleReclamation=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getIntituleReclamation());
            pst.executeUpdate();
            System.out.println("Reclamation suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

  
    public void modifier(String tt, Reclamation t) {
        int id = this.afficherOne(tt);
        System.out.println("el idd houwa: " + id);
        try{
            String req = "UPDATE Reclamation SET description=?,dateReclamation=?,intituleReclamation=?,etatReclamation=? WHERE idReclamation=?;";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(5, id);
            //pst.setInt(7,t.getIdUser());
            //pst.setString(1, t.getTypeReclamation().name());
            pst.setString(1, t.getDescription());
            pst.setDate(2, t.getDateReclamation());
            pst.setString(3, t.getIntituleReclamation());
            pst.setString(4,t.getEtatReclamation());
            pst.executeUpdate();
            System.out.println("Reclamation modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public List<Reclamation> afficher() {
        
        List<Reclamation> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM Reclamation";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {            
                list.add(new Reclamation(
       
                    rs.getString(5),
                    TypeReclamation.find(rs.getString(2)),
                    rs.getString(6),
                    rs.getDate(4),
                    rs.getString(3)
                   ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
    public List<Reclamation> search (String val){
        
      List<Reclamation> list1= new ArrayList<>();
         List<Reclamation> list2= afficher();
         
         list1= list2.stream().filter(c -> c.getIntituleReclamation().startsWith(val)).collect(Collectors.toList());
         System.out.println(list1);
         return list1;
    }
    public int afficherOne(String title) {
        
        List<Reclamation> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM Reclamation where intituleReclamation='"+title+"';";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            rs.next()   ;       
          
            return rs.getInt(1);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return -1;
    }
    public void TRIPrix(){
        
         List<Reclamation> list1= new ArrayList<>();
         List<Reclamation> list2= afficher();
         
        list1=list2.stream().sorted((o1,o2)->(int)(o2.getIdReclamation() - o1.getIdReclamation())).collect(Collectors.toList());
        System.out.println(list1);

  
               
               
     }
    public String makeFine(String val){
        List<String> badWords = new ArrayList<>();
        badWords.add("putin");
        badWords.add("shit");
        badWords.add("merde");
        badWords.add("shitty");
        badWords.add("fuck");
        badWords.add("motherlucker");

        String[] splited = val.split("\\s+");//split  bel espace
        String newval = "";//where we gonna stock
        for(String word : splited){
            String stars = "";//string for affectings stars
            for(String bad : badWords){
                if(word.toLowerCase().equals(bad.toLowerCase())){//low or uppercase
                    for(int i = 0; i<= word.length()-1; i++){
                        stars += "*";//get the stars
                    }
                    
                    newval += stars + " ";//affect it to newval
                    break;
                }
            }
            if(stars.equals("")){
                newval += word + " ";//concat
            }
        }
        return newval;
    }

    @Override
    public void modifier(Reclamation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
