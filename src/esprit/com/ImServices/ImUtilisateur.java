/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.ImServices;

import esprit.com.entity.Utilisateur;
import esprit.com.utils.ConnectionBd;
import esprit.tn.security.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import esprit.com.Iservices.IServicesUtilisateur;
import esprit.com.entity.Reset;
import esprit.com.entity.Role;
import esprit.com.mail.Sendmail;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Yassine
 */
public class ImUtilisateur implements IServicesUtilisateur<Utilisateur> {

    public static String nameUser;
    public static int idUser;
    public static String EmailRes;
    public static String PHOTO;

    Connection cnx = ConnectionBd.getInstance().getCnx();

    @Override
    public void registre(Utilisateur t) {
        Sendmail sn = new Sendmail();
        String hashed = BCrypt.hashpw(t.getMotpasse(), BCrypt.gensalt());
        String subject = "Inscription au sein de TRIP TO DO";
        String Object = " Bienvenu " + t.getNom() + " Au TripToDo , Merci pour votre inscription";
        try {
            String reqs = "INSERT INTO utilisateur(nom,prenom,adresse,email,motpasse,photo,pays,role,activated)VALUES('" + t.getNom() + "','" + t.getPrenom() + "',"
                    + "'" + t.getAdresse() + "','" + t.getEmail() + "',"
                    + "'" + hashed + "','" + t.getPhoto() + "','" + t.getPays() + "','" + t.getRole() + "','" + t.isActive() + "')";
            Statement st = cnx.createStatement();
            st.execute(reqs);
            sn.envoyer(t.getEmail(), subject, Object);
            System.out.println("Utilisateur ajoutée !");

        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }
    }

    @Override
    public String login(Utilisateur t) {
        String role = "";
        try {

            if (t.getEmail() != null && t.getMotpasse() != null) {

                String req = "SELECT * from utilisateur";
                PreparedStatement pst = cnx.prepareStatement(req);

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {

                    if (rs.getString("email").equals(t.getEmail()) && BCrypt.checkpw(t.getMotpasse(), rs.getString("motpasse")) == true) {
                        if (rs.getString("activated").equals("Active")) {
                            idUser = rs.getInt("idU");
                            nameUser = rs.getString("nom");
                            role = rs.getString("role");
                            PHOTO=rs.getString("photo");
                            System.out.println(" Salut :" + nameUser);

                        } else {
                            System.err.println("Compte Desactiver !");
                        }
                    } else {
                        System.err.println("Verifier vos donneés !");
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return role;
    }

    @Override
    public List<Utilisateur> affiche() {
        List<Utilisateur> list = new ArrayList<>();
        try {
            String req = "SELECT * from utilisateur";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next() && (rs.getInt("idU")!=idUser)) {
                list.add(new Utilisateur(rs.getInt("idU"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("email"), rs.getString("motpasse"),
                        rs.getString("photo"), rs.getString("pays"), rs.getString("role"), rs.getString("activated")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return list;
    }

    @Override
    public void Supprimer(Utilisateur t) {

        try {
            String req = "DELETE FROM utilisateur WHERE idU=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getIdU());
            pst.executeUpdate();
            System.out.println("Utilisateur suprimée !");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void modifier(Utilisateur t) {
        String hashed = BCrypt.hashpw(t.getMotpasse(), BCrypt.gensalt());

        try {
            String reqs = "UPDATE utilisateur SET nom=?,prenom=?,adresse=?,email=?,motpasse=?, photo=?, pays=?, role=?, activated=? WHERE idU=?";
            PreparedStatement pst = cnx.prepareStatement(reqs);
            pst.setInt(10, t.getIdU());
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setString(3, t.getAdresse());
            pst.setString(4, t.getEmail());
            pst.setString(5, hashed);
            pst.setString(6, t.getPhoto());
            pst.setString(7, t.getPays());
            pst.setString(8, t.getRole());
            pst.setString(9, t.isActive());
            pst.executeUpdate();
            System.out.println("Utilisateur Modifiée !");

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
    }
    
     public void modifierMopasst(Utilisateur t) {
        String hashed = BCrypt.hashpw(t.getMotpasse(), BCrypt.gensalt());

        try {
            String reqs = "UPDATE utilisateur SET motpasse=? WHERE email=?";
            PreparedStatement pst = cnx.prepareStatement(reqs);
       
            pst.setString(2, t.getEmail());
            pst.setString(1, hashed);
          
            pst.executeUpdate();
            System.out.println("Mot de pass Modifiée !");

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
    }
    
  
//|

    @Override
    public List<Utilisateur> Search(String t) {

        List<Utilisateur> list1 = new ArrayList<>();
        List<Utilisateur> list2 = affiche();
        list1 = (list2.stream().filter(c -> c.getNom().startsWith(t)).collect(Collectors.toList()));
        
return list1;
    }

    public List<Utilisateur> triNom() {

        List<Utilisateur> list1 = new ArrayList<>();
        List<Utilisateur> list2 = affiche();

        list1 = list2.stream().sorted((o1, o2) -> o1.getNom().compareTo(o2.getNom())).collect(Collectors.toList());
        return list1;

    }
  public List<Utilisateur> triPays() {

        List<Utilisateur> list1 = new ArrayList<>();
        List<Utilisateur> list2 = affiche();

        list1 = list2.stream().sorted((o1, o2) -> o1.getPays().compareTo(o2.getPays())).collect(Collectors.toList());
        return list1;

    }
  public List<Utilisateur> triActive() {

        List<Utilisateur> list1 = new ArrayList<>();
        List<Utilisateur> list2 = affiche();

        list1 = list2.stream().sorted((o1, o2) -> o1.isActive().compareTo(o2.isActive())).collect(Collectors.toList());
        return list1;

    }
    public boolean reset(Reset t) {
        long end = System.currentTimeMillis();
        try {
            String req = "SELECT * from reset where code=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getCode());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                long StartTime = Long.parseLong(rs.getString("timeMils"));
                long calT = end - StartTime;
                if (calT < 120000) {
                    EmailRes=rs.getString("email");
return true;
                } else {
                    String reqs = "DELETE FROM reset WHERE code=?";
                    PreparedStatement psts = cnx.prepareStatement(reqs);
                    psts.setInt(1, t.getCode());
                    psts.executeUpdate();
                    System.err.println("Time OUT !! Code Introuvable.");
                    return false;
                }
            } else {
                System.err.println("Code Incorrect !");
return false ;
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;

        }
    }

}
