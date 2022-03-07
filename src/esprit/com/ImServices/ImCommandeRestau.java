/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.ImServices;

import esprit.com.Iservices.IservicesMethodes;
import esprit.com.entity.CommandePlat;
import esprit.com.entity.CommandeRestau;
import esprit.com.utils.ConnectionBd;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Yassine
 */
public class ImCommandeRestau implements IservicesMethodes<CommandeRestau> {

    Connection cnx = ConnectionBd.getInstance().getCnx();

    @Override
    public void ajout(CommandeRestau t) {
        try {
            String req = "INSERT INTO commandrestau(prix_commande,date_commande,idUser,latitude,longitude,Num_Commande )VALUES(?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setDouble(1, t.getPrix_commande());
            pst.setDate(2, t.getDate_commande());
            pst.setInt(3, t.getIdU());
            pst.setDouble(4, t.getLatitude());
            pst.setDouble(5, t.getLongitude());
pst.setInt(6, t.getNum_Commande());
            pst.executeUpdate();
            System.out.println("Commande Ajoutée !!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<CommandeRestau> Show() {
        List<CommandeRestau> list = new ArrayList<>();
        try {
            String req = "SELECT * from commandrestau";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.add(new CommandeRestau(rs.getInt("num_commande"), rs.getDouble("prix_commande"), rs.getDate("date_commande"),rs.getInt("idUser"), rs.getDouble("latitude"), rs.getDouble("longitude"),rs.getInt("etat")));
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public void Delete(CommandeRestau t) {
        try {
            String req = "DELETE FROM commandrestau WHERE num_commande=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setObject(1, t.getDate_commande());
            pst.executeUpdate();
            System.out.println("Commande suprimée !");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void Edit(CommandeRestau t) {
        try {
            String req = "UPDATE commandrestau SET prix_commande=?,date_commande=?,idUser=?,latitude=?,longitude=? WHERE num_commande=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(6, t.getNum_Commande());
            pst.setDouble(1, t.getPrix_commande());
            pst.setDate(2, t.getDate_commande());
            pst.setInt(3, t.getIdU());
            pst.setDouble(4, t.getLatitude());
            pst.setDouble(5, t.getLongitude());
      

            pst.executeUpdate();
            System.out.println("Commande " + t.getNum_Commande()+ " Modifiée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   

 
    @Override
    public void tri() {
List<CommandeRestau> list1= new ArrayList<>();
         List<CommandeRestau> list2= Show();
         
 
    }

    @Override
    public List<CommandeRestau> Find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    public void ajoutPlatCommande(CommandePlat t) {
        try {
            String req = "INSERT INTO commandplat(idCommande,Plat)VALUES(?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
        
            pst.setInt(1,  t.getIdCommande());
            pst.setInt(2, t.getPlat());

            pst.executeUpdate();
            System.out.println("plat commande ajouté  Ajoutée !!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    
    public List<CommandeRestau> afficherUtilisateur() {
           List<CommandeRestau> list = new ArrayList<CommandeRestau>();
        
        try {
                String req = "SELECT * FROM commandrestau as cr , commandplat as cp ,plat as pl, utilisateur as ut WHERE cr.Num_Commande=cp.idCommande AND cr.idUser=ut.idU and cp.Plat=pl.idPlat and ut.idU=?;";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, ImUtilisateur.idUser);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
               list.add(new CommandeRestau(rs.getInt("Num_Commande"), rs.getDouble("prix_commande"), rs.getDate("date_commande"), rs.getString("nomPlat"),rs.getString("nom"),rs.getInt("etat")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
     public List<CommandeRestau> afficherAdmin() {
           List<CommandeRestau> list = new ArrayList<CommandeRestau>();
        
        try { 
               String req = "SELECT * FROM commandrestau as cr , commandplat as cp ,plat as pl, utilisateur as ut WHERE cr.Num_Commande=cp.idCommande AND cr.idUser=ut.idU and cp.Plat=pl.idPlat;";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
               list.add(new CommandeRestau(rs.getInt("Num_Commande"), rs.getDouble("prix_commande"), rs.getDate("date_commande"), rs.getDouble("latitude"), rs.getDouble("longitude"),rs.getString("nomPlat"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getInt("etat")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}
