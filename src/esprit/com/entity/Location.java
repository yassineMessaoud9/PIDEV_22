/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

import java.sql.Date;
import java.sql.Timestamp;
/**
 *
 * @author ons
 */
public class Location {
  
    private int idLocation ;
    private Date date_debutlocation;
    private Date date_finlocation;
     private Timestamp date_location;
    private float montant;
    private int idU;
    private int matricule;
    private int id_saison;
    private String nom;
    private String marqueVoiture;
    private String nomSaison;

    public Location() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarqueVoiture() {
        return marqueVoiture;
    }

    public void setMarqueVoiture(String marqueVoiture) {
        this.marqueVoiture = marqueVoiture;
    }

    public String getNomSaison() {
        return nomSaison;
    }

    public void setNomSaison(String nomSaison) {
        this.nomSaison = nomSaison;
    }

    public Location( Date date_debutlocation, Date date_finlocation, Timestamp date_location, float montant, String nom, String marqueVoiture, String nomSaison) {
        
        this.date_debutlocation = date_debutlocation;
        this.date_finlocation = date_finlocation;
        this.date_location = date_location;
        this.montant = montant;
        this.nom = nom;
        this.marqueVoiture = marqueVoiture;
        this.nomSaison = nomSaison;
    }

   
    

    @Override
    public String toString() {
        return "Location{" + "idLocation=" + idLocation + ", date_debutlocation=" + date_debutlocation + ", date_finlocation=" + date_finlocation + ", date_location=" + date_location + ", montant=" + montant + ", nom=" + nom + ", marqueVoiture=" + marqueVoiture + ", nomSaison=" + nomSaison + '}';
    }

  

    public Location(int idLocation, Date date_debutlocation, Date date_finlocation, Timestamp date_location, float montant, int idU, int matricule, int id_saison) {
        this.idLocation = idLocation;
        this.date_debutlocation = date_debutlocation;
        this.date_finlocation = date_finlocation;
        this.date_location = date_location;
        this.montant = montant;
        this.idU = idU;
        this.matricule = matricule;
        this.id_saison = id_saison;
    }

    public Location(int idLocation) {
        this.idLocation = idLocation;
    }

    public Location(Date date_debutlocation, Date date_finlocation, Timestamp date_location, float montant, int idU, int matricule, int id_saison) {
        this.date_debutlocation = date_debutlocation;
        this.date_finlocation = date_finlocation;
        this.date_location = date_location;
        this.montant = montant;
        this.idU = idU;
        this.matricule = matricule;
        this.id_saison = id_saison;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public Date getDate_debutlocation() {
        return date_debutlocation;
    }

    public void setDate_debutlocation(Date date_debutlocation) {
        this.date_debutlocation = date_debutlocation;
    }

    public Date getDate_finlocation() {
        return date_finlocation;
    }

    public void setDate_finlocation(Date date_finlocation) {
        this.date_finlocation = date_finlocation;
    }

    public Timestamp getDate_location() {
        return date_location;
    }

    public void setDate_location(Timestamp date_location) {
        this.date_location = date_location;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public int getId_saison() {
        return id_saison;
    }

    public void setId_saison(int id_saison) {
        this.id_saison = id_saison;
    }
     

  

}