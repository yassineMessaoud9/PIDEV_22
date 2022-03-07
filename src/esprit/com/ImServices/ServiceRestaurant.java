/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.ImServices;

import esprit.com.Iservices.Iservice;
import esprit.com.entity.Hotel;
import esprit.com.entity.Restaurant;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author MediaHelp
 */
public class ServiceRestaurant implements Iservice<Restaurant>{
 Connection cnx=ConnectionBd.getInstance().getCnx();

    @Override
    public void ajouter(Restaurant t) {
         try {
            String req = "INSERT INTO restaurant(nomrestau,typerestau,nbrtable,localisation,telephone,photo ) VALUES (?,?,?,?,?,?) ";
           PreparedStatement pst = cnx.prepareStatement(req);
             pst.setString(1, t.getNomrestau());
              pst.setString(2, t.getTyperestau());
            pst.setInt(3, t.getNbrtable());
             pst.setString(4, t.getLocalisation());
               pst.setInt(5, t.getTelephone());
              pst.setString(6, t.getPhoto());
            
              pst.executeUpdate();
            System.out.println(" restaurant ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Restaurant t) {
           try {
            String req = "DELETE FROM restaurant WHERE idrestau =?";
            PreparedStatement pst =  cnx.prepareStatement(req);
            pst.setInt(1, t.getIdrestau());
            pst.executeUpdate();
            System.out.println("restaurant suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Restaurant t) {
         try {
            String req = "UPDATE restaurant SET  nomrestau= ? ,typerestau= ?, nbrtable = ?, localisation= ? , telephone =? , photo =?  WHERE idrestau = ?";
           PreparedStatement pst = cnx.prepareStatement(req);
                pst.setString(1, t.getNomrestau());
              pst.setString(2, t.getTyperestau());
            pst.setInt(3, t.getNbrtable());
             pst.setString(4, t.getLocalisation());
               pst.setInt(5, t.getTelephone());
              pst.setString(6, t.getPhoto());
              pst.setInt(7, t.getIdrestau());
            
              pst.executeUpdate();
            System.out.println(" restau modifiè !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Restaurant> afficher() {
         List<Restaurant> list = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM restaurant";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                list.add(new Restaurant(rs.getInt("idrestau"), rs.getString("nomrestau"), rs.getString("typerestau"), rs.getInt("nbrtable"), rs.getString("localisation"),rs.getInt("telephone"),rs.getString("photo")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
      public List<Restaurant> rechercherRestau(int   telephone){
      List<Restaurant> list1= new ArrayList<>();
         List<Restaurant> list2= afficher();
         
         list1= list2.stream().filter(c ->c.getTelephone()==telephone).collect(Collectors.toList());
return list1;               
     }
                public void TRIRestaus(){
      List<Restaurant> list1= new ArrayList<>();
         List<Restaurant> list2= afficher();
         
         list1= list2.stream().sorted((o1,o2)->o1.getIdrestau()-o2.getIdrestau()).collect(Collectors.toList());
         System.out.println(list1);
               
     }
    }
   
 
   
   
