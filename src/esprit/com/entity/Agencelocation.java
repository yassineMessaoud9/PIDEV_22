/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

/**
 *
 * @author ons
 */
public class Agencelocation {
    private int idAgence ;
    private String nomAgence;
    private int contactAgence;
    private String adressAgence;
    private String logoAgence;
   

    public Agencelocation() {
    }

    public Agencelocation(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    @Override
    public String toString() {
        return "Agencelocation{" + "idAgence=" + idAgence + ", nomAgence=" + nomAgence + ", contactAgence=" + contactAgence + ", adressAgence=" + adressAgence + ", logoAgence=" + logoAgence + '}';
    }

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public int getContactAgence() {
        return contactAgence;
    }

    public void setContactAgence(int contactAgence) {
        this.contactAgence = contactAgence;
    }

    public String getAdressAgence() {
        return adressAgence;
    }

    public void setAdressAgence(String adressAgence) {
        this.adressAgence = adressAgence;
    }

    public String getLogoAgence() {
        return logoAgence;
    }

    public void setLogoAgence(String logoAgence) {
        this.logoAgence = logoAgence;
    }

    public Agencelocation(String nomAgence, int contactAgence, String adressAgence, String logoAgence) {
        this.nomAgence = nomAgence;
        this.contactAgence = contactAgence;
        this.adressAgence = adressAgence;
        this.logoAgence = logoAgence;
    }

    public Agencelocation(int idAgence, String nomAgence, int contactAgence, String adressAgence) {
        this.idAgence = idAgence;
        this.nomAgence = nomAgence;
        this.contactAgence = contactAgence;
        this.adressAgence = adressAgence;
    }

    public Agencelocation(int idAgence, String nomAgence, int contactAgence, String adressAgence, String logoAgence) {
        this.idAgence = idAgence;
        this.nomAgence = nomAgence;
        this.contactAgence = contactAgence;
        this.adressAgence = adressAgence;
        this.logoAgence = logoAgence;
    }

    public Agencelocation(int idAgence) {
        this.idAgence = idAgence;
    }

    public Agencelocation(String nomAgence, int contactAgence, String adressAgence) {
        this.nomAgence = nomAgence;
        this.contactAgence = contactAgence;
        this.adressAgence = adressAgence;
    }

    
    
}
