/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

import esprit.com.Iservices.Iservice;
import esprit.com.utils.ConnectionBd;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author MediaHelp
 */
public class parent {
    private int id;
     private String nom;

    public parent(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public parent(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public parent(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "parent{" + "id=" + id + ", nom=" + nom + '}';
    }


    
    
}
