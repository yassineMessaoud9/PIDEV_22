/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Imservices;

import esprit.com.Iservices.Igestionvol;

import esprit.com.entity.compagnieaerienne;
import esprit.com.entity.reservationvol;
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
public class Imvol implements Igestionvol<vol> {
         Connection cnx = ConnectionBd.getInstance().getCnx();

    @Override
    public void ajouter(vol t) {
        try {
            String req = "INSERT INTO vol (dateallervol,tempallervol,dateretourvol,tempretourvol,destination,classvol,prixvol,typevol,idcompagnie,numserieavion) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareCall(req);
            pst.setDate(1,t.getDateallervol());
            pst.setString(2,t.getTempsallervol());
            pst.setDate(3,t.getDateretourvol());
            pst.setString(4,t.getTempsretourrvol());
            pst.setString(5,t.getDestination());
            pst.setString(6,t.getClassvol());
            pst.setFloat(7,t.getPrixvol());
            pst.setString(8,t.getTypevol());
            pst.setInt(9,t.getIdcompagnie());
            pst.setInt(10,t.getNumserieavion());
            pst.executeUpdate(); 
            System.out.println("Vol ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(vol t) {
        try{
            String req = "UPDATE vol SET dateallervol=?,tempallervol=?,dateretourvol=?,tempretourvol=?,destination=?,classvol=?,prixvol=?,typevol=?,idcompagnie=?,numserieavion=? WHERE numvol=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(11,t.getNumvol());
            pst.setDate(1,t.getDateallervol());
            pst.setString(2,t.getTempsallervol());
            pst.setDate(3,t.getDateretourvol());
            pst.setString(4,t.getTempsretourrvol());
            pst.setString(5,t.getDestination());
            pst.setString(6,t.getClassvol());
            pst.setFloat(7,t.getPrixvol());
            pst.setString(8,t.getTypevol());
            pst.setInt(9,t.getIdcompagnie());
            pst.setInt(10,t.getNumserieavion());
            pst.executeUpdate();
            System.out.println("vol modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        public int nbrvol(vol t){
            int nbr = 0;
            List<vol> list = new ArrayList<>();
             try{
            String req = "SELECT COUNT(*) FROM `vol` WHERE destination=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1,t.getDestination());
            ResultSet rs = pst.executeQuery();
            System.out.println("nbr vol modifiée !"+ rs);
             while(rs.next()) {
              
                       nbr= rs.getInt(1);
                       
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
             return nbr;
        
        
        
        
        
        
        
        }
        public void modifier2(vol t) {
         try{
            String req = "UPDATE vol SET dateallervol=?,tempallervol=?,dateretourvol=?,tempretourvol=?,destination=?,classvol=?,prixvol=?,typevol=? WHERE numvol=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(9,t.getNumvol());
            pst.setDate(1,t.getDateallervol());
            pst.setString(2,t.getTempsallervol());
            pst.setDate(3,t.getDateretourvol());
            pst.setString(4,t.getTempsretourrvol());
            pst.setString(5,t.getDestination());
            pst.setString(6,t.getClassvol());
            pst.setFloat(7,t.getPrixvol());
            pst.setString(8,t.getTypevol());
            
            pst.executeUpdate();
            System.out.println("vol modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(vol t) {
         try {
            String req = "DELETE FROM vol WHERE numvol=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,t.getNumvol());
            pst.executeUpdate();
            System.out.println("vol suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<vol> afficher() {
        List<vol> list = new ArrayList<>();
        
        try {
            String req = "SELECT * from vol";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()) {
                list.add(new vol (
                        rs.getInt(1),
                        rs.getDate(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getFloat(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11)));
            }
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    
    public void recherche(int id) {
         List<vol> list1= new ArrayList<>();
         List<vol> list2= afficher();
        
         list1= list2.stream().filter(c -> c.getNumvol()==id).collect(Collectors.toList());
         System.out.println(list1); 
        
    }

    
    public void tri() {
         List<vol> list1= new ArrayList<>();
         List<vol> list2= afficher();
         
         list1= list2.stream().sorted((o1,o2)->o1.getClassvol().compareTo(o2.getClassvol())).collect(Collectors.toList());
         System.out.println(list1);
    }


    
}
