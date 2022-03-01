/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

import java.sql.Date;


/**
 *
 * @author Yassine
 */
public class Sponsors {
    private int id;
    private String nomSponsors;
    private double prixDonations;
    private Date dateDeb;
    private Date dateFin;

    public Sponsors(int id, String nomSponsors, double prixDonations, Date dateDeb, Date dateFin) {
        this.id = id;
        this.nomSponsors = nomSponsors;
        this.prixDonations = prixDonations;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
    }

    public Sponsors() {
    }

    public Sponsors(int id) {
        this.id = id;
    }

    public Sponsors(String nomSponsors, double prixDonations, Date dateDeb, Date dateFin) {
        this.nomSponsors = nomSponsors;
        this.prixDonations = prixDonations;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomSponsors() {
        return nomSponsors;
    }

    public void setNomSponsors(String nomSponsors) {
        this.nomSponsors = nomSponsors;
    }

    public double getPrixDonations() {
        return prixDonations;
    }

    public void setPrixDonations(double prixDonations) {
        this.prixDonations = prixDonations;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Sponsors{" + "id=" + id + ", nomSponsors=" + nomSponsors + ", prixDonations=" + prixDonations + ", dateDeb=" + dateDeb + ", dateFin=" + dateFin + '}';
    }

   
    
}
