/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.ImServices;

import esprit.com.Iservices.IservicesMethodes;
import esprit.com.entity.Reset;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Yassine
 */
public class imReset{

        Connection cnx = ConnectionBd.getInstance().getCnx();
        

    public boolean ajout(Reset t) {
     
            try {
            String req = "SELECT * from utilisateur where email=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getEmail());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
            String reqs = "INSERT INTO reset(email,code,timeMils)VALUES(?,?,?)";
            PreparedStatement psts = cnx.prepareStatement(reqs);
            psts.setString(1, t.getEmail());
            psts.setInt(2, t.getCode());
            psts.setString(3, t.getTimeMils());
            psts.executeUpdate();
            return true;
            } 
            else {
return false;
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
            return true;
    }

   
    
}
