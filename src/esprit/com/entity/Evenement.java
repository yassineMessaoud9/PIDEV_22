/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

import java.sql.Date;

/**
 *
 * @author Utilisateur
 */
public class Evenement {
    
    private int id;
    private String intituleEve;
    private String pays;
    private float prixEve;
    private Date datedebutEve;
    private Date datefinEve;
    private String addressEve;
    private String typeEve;
    private String photoEve;
    private int nbplaceEve;
    private String descriptionEve;

    public Evenement() {
    }
    
    

    public Evenement(int id, String intituleEve, String pays, float prixEve, Date datedebutEve, Date datefinEve, String addressEve, String typeEve, String photoEve, int nbplaceEve, String descriptionEve) {
        this.id = id;
        this.intituleEve = intituleEve;
        this.pays = pays;
        this.prixEve = prixEve;
        this.datedebutEve = datedebutEve;
        this.datefinEve = datefinEve;
        this.addressEve = addressEve;
        this.typeEve = typeEve;
        this.photoEve = photoEve;
        this.nbplaceEve = nbplaceEve;
        this.descriptionEve = descriptionEve;
    }
public Evenement(int id, String intituleEve, String pays, float prixEve, String addressEve, String typeEve, String photoEve, int nbplaceEve, String descriptionEve) {
        this.id = id;
        this.intituleEve = intituleEve;
        this.pays = pays;
        this.prixEve = prixEve;
        this.addressEve = addressEve;
        this.typeEve = typeEve;
        this.photoEve = photoEve;
        this.nbplaceEve = nbplaceEve;
        this.descriptionEve = descriptionEve;
    }

    public Evenement(String intituleEve, String pays, float prixEve, Date datedebutEve, Date datefinEve, String addressEve, String typeEve, String photoEve, int nbplaceEve, String descriptionEve) {
        this.intituleEve = intituleEve;
        this.pays = pays;
        this.prixEve = prixEve;
        this.datedebutEve = datedebutEve;
        this.datefinEve = datefinEve;
        this.addressEve = addressEve;
        this.typeEve = typeEve;
        this.photoEve = photoEve;
        this.nbplaceEve = nbplaceEve;
        this.descriptionEve = descriptionEve;
    }
       public Evenement(String intituleEve, String pays, float prixEve, String addressEve, String typeEve, String photoEve,Date datedebutEve, Date datefinEve ,String descriptionEve) {
        this.intituleEve = intituleEve;
        this.pays = pays;
        this.prixEve = prixEve;
        this.addressEve = addressEve;
        this.typeEve = typeEve;
        this.photoEve = photoEve;
        this.datedebutEve = datedebutEve;
        this.datefinEve = datefinEve;
        this.descriptionEve = descriptionEve;
    }
    

    public Evenement(int id) {
        this.id = id;
    }

   

    public int getId() {
        return id;
    }

    public String getIntituleEve() {
        return intituleEve;
    }

    public String getPays() {
        return pays;
    }

    public float getPrixEve() {
        return prixEve;
    }

    public Date getDatedebutEve() {
        return datedebutEve;
    }

    public Date getDatefinEve() {
        return datefinEve;
    }

    public String getAddressEve() {
        return addressEve;
    }

    public String getTypeEve() {
        return typeEve;
    }

    public String getPhotoEve() {
        return photoEve;
    }

    public int getNbplaceEve() {
        return nbplaceEve;
    }

    public String getDescriptionEve() {
        return descriptionEve;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIntituleEve(String intituleEve) {
        this.intituleEve = intituleEve;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setPrixEve(float prixEve) {
        this.prixEve = prixEve;
    }

    public void setDatedebutEve(Date datedebutEve) {
        this.datedebutEve = datedebutEve;
    }

    public void setDatefinEve(Date datefinEve) {
        this.datefinEve = datefinEve;
    }

    public void setAddressEve(String addressEve) {
        this.addressEve = addressEve;
    }

    public void setTypeEve(String typeEve) {
        this.typeEve = typeEve;
    }

    public void setPhotoEve(String photoEve) {
        this.photoEve = photoEve;
    }

    public void setNbplaceEve(int nbplaceEve) {
        this.nbplaceEve = nbplaceEve;
    }

    public void setDescriptionEve(String descriptionEve) {
        this.descriptionEve = descriptionEve;
    }

 

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", intituleEve=" + intituleEve + ", pays=" + pays + ", prixEve=" + prixEve + ", datedebutEve=" + datedebutEve + ", datefinEve=" + datefinEve + ", addressEve=" + addressEve + ", typeEve=" + typeEve + ", photoEve=" + photoEve + ", nbplaceEve=" + nbplaceEve + ", descriptionEve=" + descriptionEve + '}';
    }
           
    
}
