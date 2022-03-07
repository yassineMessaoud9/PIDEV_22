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
 * @author Gamer
 */
public class vol {
private int numvol ;
private Date dateallervol;
private String tempsallervol;
private Date dateretourvol;
private String tempsretourrvol;
private String destination;
private String classvol;
private Float prixvol;
private String typevol;
private int idcompagnie;
private int numserieavion;
private int nbrvol ;

    public vol(int numvol, Date dateallervol, String tempsallervol, Date dateretourvol, String tempsretourrvol, String destination, String classvol, Float prixvol) {
        this.numvol = numvol;
        this.dateallervol = dateallervol;
        this.tempsallervol = tempsallervol;
        this.dateretourvol = dateretourvol;
        this.tempsretourrvol = tempsretourrvol;
        this.destination = destination;
        this.classvol = classvol;
        this.prixvol = prixvol;
    }

    public vol(Date dateallervol, String tempsallervol, Date dateretourvol, String tempsretourrvol, String destination, String classvol, Float prixvol) {
        this.dateallervol = dateallervol;
        this.tempsallervol = tempsallervol;
        this.dateretourvol = dateretourvol;
        this.tempsretourrvol = tempsretourrvol;
        this.destination = destination;
        this.classvol = classvol;
        this.prixvol = prixvol;
    }

    public vol(String destination) {
        this.destination = destination;
    }

    public int getNbrvol() {
        return nbrvol;
    }

    public void setNbrvol(int nbrvol) {
        this.nbrvol = nbrvol;
    }
    


    public vol(int numvol,Date dateallervol, String tempsallervol, Date dateretourvol, String tempsretourrvol, String destination, String classvol, Float prixvol, String typevol) {
        this.numvol=numvol;
        this.dateallervol = dateallervol;
        this.tempsallervol = tempsallervol;
        this.dateretourvol = dateretourvol;
        this.tempsretourrvol = tempsretourrvol;
        this.destination = destination;
        this.classvol = classvol;
        this.prixvol = prixvol;
        this.typevol = typevol;
    }


    public vol(int numvol, Date dateallervol, String tempsallervol, Date dateretourvol, String tempsretourrvol, String destination, String classvol, Float prixvol, String typevol, int idcompagnie, int numserieavion) {
        this.numvol = numvol;
        this.dateallervol = dateallervol;
        this.tempsallervol = tempsallervol;
        this.dateretourvol = dateretourvol;
        this.tempsretourrvol = tempsretourrvol;
        this.destination = destination;
        this.classvol = classvol;
        this.prixvol = prixvol;
        this.typevol = typevol;
        this.idcompagnie = idcompagnie;
        this.numserieavion = numserieavion;
    }

    public vol(Date dateallervol, String tempsallervol, Date dateretourvol, String tempsretourrvol, String destination, String classvol, Float prixvol, String typevol, int idcompagnie, int numserieavion) {
        this.dateallervol = dateallervol;
        this.tempsallervol = tempsallervol;
        this.dateretourvol = dateretourvol;
        this.tempsretourrvol = tempsretourrvol;
        this.destination = destination;
        this.classvol = classvol;
        this.prixvol = prixvol;
        this.typevol = typevol;
        this.idcompagnie = idcompagnie;
        this.numserieavion = numserieavion;
    }

    public Date getDateallervol() {
        return dateallervol;
    }

    public void setDateallervol(Date dateallervol) {
        this.dateallervol = dateallervol;
    }

    public String getTempsallervol() {
        return tempsallervol;
    }

    public void setTempsallervol(String tempsallervol) {
        this.tempsallervol = tempsallervol;
    }

    public Date getDateretourvol() {
        return dateretourvol;
    }

    public void setDateretourvol(Date dateretourvol) {
        this.dateretourvol = dateretourvol;
    }

    public String getTempsretourrvol() {
        return tempsretourrvol;
    }

    public void setTempsretourrvol(String tempsretourrvol) {
        this.tempsretourrvol = tempsretourrvol;
    }



 

    public vol(int numvol) {
        this.numvol = numvol;
    }
    

    public vol() {
    }

    public int getNumvol() {
        return numvol;
    }

    public void setNumvol(int numvol) {
        this.numvol = numvol;
    }



    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getClassvol() {
        return classvol;
    }

    public void setClassvol(String classvol) {
        this.classvol = classvol;
    }

    public Float getPrixvol() {
        return prixvol;
    }

    public void setPrixvol(Float prixvol) {
        this.prixvol = prixvol;
    }

    public String getTypevol() {
        return typevol;
    }

    public void setTypevol(String typevol) {
        this.typevol = typevol;
    }

    public int getIdcompagnie() {
        return idcompagnie;
    }

    public void setIdcompagnie(int idcompagnie) {
        this.idcompagnie = idcompagnie;
    }

    public int getNumserieavion() {
        return numserieavion;
    }

    public void setNumserieavion(int numserievol) {
        this.numserieavion = numserieavion;
    }

    @Override
    public String toString() {
        return "vol{" + "numvol=" + numvol + ", dateallervol=" + dateallervol + ", tempsallervol=" + tempsallervol + ", dateretourvol=" + dateretourvol + ", tempsretourrvol=" + tempsretourrvol + ", destination=" + destination + ", classvol=" + classvol + ", prixvol=" + prixvol + ", typevol=" + typevol + ", idcompagnie=" + idcompagnie + ", numserieavion=" + numserieavion + '}';
    }








}
