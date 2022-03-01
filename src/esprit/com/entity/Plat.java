/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

/**
 *
 * @author Yassine
 */
public class Plat {
    
    private int idPlat;
    private String nomPlat;
    private double prixPlat;
    private String photoPlat;
    private String description;

    public Plat() {
    }

    public Plat(int idPlat) {
        this.idPlat = idPlat;
    }

    public Plat(int idPlat, String nomPlat, double prixPlat, String photoPlat, String description) {
        this.idPlat = idPlat;
        this.nomPlat = nomPlat;
        this.prixPlat = prixPlat;
        this.photoPlat = photoPlat;

        this.description = description;
             }

    public Plat(String nomPlat, double prixPlat, String photoPlat, String description) {
        this.nomPlat = nomPlat;
        this.prixPlat = prixPlat;
        this.photoPlat = photoPlat;
        this.description = description;
                
        
    }

    public int getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(int idPlat) {
        this.idPlat = idPlat;
    }

    public String getNomPlat() {
        return nomPlat;
    }

    public void setNomPlat(String nomPlat) {
        this.nomPlat = nomPlat;
    }

    public double getPrixPlat() {
        return prixPlat;
    }

    public void setPrixPlat(double prixPlat) {
        this.prixPlat = prixPlat;
    }

    public String getPhotoPlat() {
        return photoPlat;
    }

    public void setPhotoPlat(String photoPlat) {
        this.photoPlat = photoPlat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Plat{" + "idPlat=" + idPlat + ", nomPlat=" + nomPlat + ", prixPlat=" + prixPlat + ", photoPlat=" + photoPlat + ", description=" + description + '}';
    }


    
  
    
}
