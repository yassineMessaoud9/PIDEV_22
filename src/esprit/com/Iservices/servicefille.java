/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Iservices;

import esprit.com.entity.ReservationRestaurant;
import esprit.com.entity.fille;
import esprit.com.entity.parent;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MediaHelp
 */
public class servicefille  extends serviceparent   {
 Connection bd1=ConnectionBd.getInstance().getCnx(); 
   
    public void ajouter(fille t) {
            try {
               super.ajouter(t);

           String req = "INSERT INTO fille1(prenom,id) VALUES ('" + t.getPrenom()+ "','" + t.getId()+ "')";
            Statement st = bd1.createStatement();
            st.executeUpdate(req);
            System.out.println("fille ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void supprimer(fille t) {
        
            try {
               
            String req = "DELETE FROM fille1";
            PreparedStatement pst =  bd1.prepareStatement(req);
           
            pst.executeUpdate();
            System.out.println("fille suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void modifier(fille t) {
            try {
                
           String req = "UPDATE fille  SET prenom ='" + t.getPrenom()+ "' ";
         Statement st = bd1.createStatement();
            st.executeUpdate(req);
            System.out.println("fille modifé !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
    }

  
    public List<parent> afficher() {
        
          List<parent> list = new ArrayList<>();
           List<fille> list2 = new ArrayList<>();
    
      
        try {
              super.afficher();
              
            String req = "SELECT * FROM fille";
            Statement st = bd1.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                list2.add(new fille(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          
        return list;
    }


    
    }
    

