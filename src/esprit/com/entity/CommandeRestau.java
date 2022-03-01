/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Yassine
 */
public class CommandeRestau {
    
    private int Num_Commande;
    private double prix_commande;
    private Date date_commande  ;
private int idU;
    private double latitude;
    private double longitude;
    private String Adress;
    private String nomPlat;
    private String nom;
    private String prenom;
    private String email;

    public CommandeRestau(int Num_Commande, double prix_commande, Date date_commande,  double latitude, double longitude, String Adress, String nomPlat, String nom, String prenom, String email) {
        this.Num_Commande = Num_Commande;
        this.prix_commande = prix_commande;
        this.date_commande = date_commande;
        this.latitude = latitude;
        this.longitude = longitude;
        this.Adress = Adress;
        this.nomPlat = nomPlat;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
    
    public CommandeRestau(int Num_Commande, double prix_commande, Date date_commande, int idU, double latitude, double longitude, String Adress) {
        this.Num_Commande = Num_Commande;
        this.prix_commande = prix_commande;
        this.date_commande = date_commande;
        this.idU = idU;
        this.latitude = latitude;
        this.longitude = longitude;
        this.Adress = Adress;
    }

    public int getNum_Commande() {
        return Num_Commande;
    }

    public void setNum_Commande(int Num_Commande) {
        this.Num_Commande = Num_Commande;
    }

    public double getPrix_commande() {
        return prix_commande;
    }

    public void setPrix_commande(double prix_commande) {
        this.prix_commande = prix_commande;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public String getNomPlat() {
        return nomPlat;
    }

    public void setNomPlat(String nomPlat) {
        this.nomPlat = nomPlat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CommandeRestau{" + "Num_Commande=" + Num_Commande + ", prix_commande=" + prix_commande + ", date_commande=" + date_commande + ", idU=" + idU + ", latitude=" + latitude + ", longitude=" + longitude + ", Adress=" + Adress + ", nomPlat=" + nomPlat + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + '}';
    }

    
    
}
