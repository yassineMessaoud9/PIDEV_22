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
public class Suivi {

    private int id;
    private int idCommande;
    private String etat;
    private double longitude;
    private double latitude;
    private String Adress;

    public Suivi(int id, int idCommande, String etat, double longitude, double latitude, String Adress) {
        this.id = id;
        this.idCommande = idCommande;
        this.etat = etat;
        this.longitude = longitude;
        this.latitude = latitude;
        this.Adress = Adress;
    }

    public Suivi(int idCommande, String etat, double longitude, double latitude, String Adress) {
        this.idCommande = idCommande;
        this.etat = etat;
        this.longitude = longitude;
        this.latitude = latitude;
        this.Adress = Adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    @Override
    public String toString() {
        return "Suivi{" + "id=" + id + ", idCommande=" + idCommande + ", etat=" + etat + ", longitude=" + longitude + ", latitude=" + latitude + ", Adress=" + Adress + '}';
    }

    
}
