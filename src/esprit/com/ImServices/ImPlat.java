/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.ImServices;

import esprit.com.Iservices.IservicesMethodes;
import esprit.com.entity.Plat;
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
 * @author Yassine
 */
public class ImPlat implements IservicesMethodes<Plat> {

    Connection cnx = ConnectionBd.getInstance().getCnx();

    @Override
    public void ajout(Plat t) {
        try {
            String req = "INSERT INTO plat(nomPlat,prixPlat,photoPlat,description)VALUES(?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getNomPlat());
            pst.setDouble(2, t.getPrixPlat());
            pst.setString(3, t.getPhotoPlat());
            pst.setString(4, t.getDescription());
            pst.executeUpdate();
            System.out.println("Plat Ajoutée !!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Plat> Show() {
        List<Plat> list = new ArrayList<>();
        try {
            String req = "SELECT * from plat";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.add(new Plat(rs.getInt("idPlat"), rs.getString("nomPlat"), rs.getDouble("prixPlat"), rs.getString("photoPlat"), rs.getString("description")));
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public void Delete(Plat t) {

        try {
            String req = "DELETE FROM plat WHERE idPlat=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getIdPlat());
            pst.executeUpdate();
            System.out.println("Plat suprimée !");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    @Override
    public void Edit(Plat t) {

        try {
            String req = "UPDATE plat SET nomPlat=?,prixPlat=?,photoPlat=?,description=? WHERE idPlat=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(5, t.getIdPlat());
            pst.setString(1, t.getNomPlat());
            pst.setDouble(2, t.getPrixPlat());
            pst.setString(3, t.getPhotoPlat());
            pst.setString(4, t.getDescription());
            pst.executeUpdate();
            System.out.println("Plat " + t.getNomPlat() + " Modifiée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    @Override
    public void tri()  {
List<Plat> list1= new ArrayList<>();
         List<Plat> list2= Show();
         
         list1= list2.stream().sorted((o1,o2)->o1.getNomPlat().compareTo(o2.getNomPlat())).collect(Collectors.toList());
         System.out.println(list1);    }

    @Override
    public List<Plat> Find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
