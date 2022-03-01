/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Iservices;

import esprit.com.entity.Restaurant;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import esprit.com.entity.parent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MediaHelp
 */
public class serviceparent implements  Iservice <parent> {
 Connection bd1=ConnectionBd.getInstance().getCnx(); 
    
    public void ajouter(parent t) {
      try {
            String req = "INSERT INTO parent (nom) VALUES (?) ";
           PreparedStatement pst = bd1.prepareStatement(req);
          
              pst.setString(1, t.getNom());
        
              pst.executeUpdate();
            System.out.println("PARENT ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }



    @Override
    public void supprimer(parent t) {
          try {
            String req = "DELETE FROM parent WHERE id=?";
            PreparedStatement pst =  bd1.prepareStatement(req);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
            System.out.println("parent uprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(parent t) {
               try {
           String req = "UPDATE parent SET nom='" + t.getNom()+ "' WHERE id=" + t.getId();
         Statement st = bd1.createStatement();
            st.executeUpdate(req);
            System.out.println("personne modifé !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

 //   @Override
    public List<parent> afficher() {
      List<parent> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM parent";
            Statement st = bd1.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                list.add(new parent(rs.getInt("id"),rs.getString("nom")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          
        return list;

  
    
}
}
    

   
    

