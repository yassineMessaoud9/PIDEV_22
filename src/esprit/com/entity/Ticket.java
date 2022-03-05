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
public class Ticket {
   private int idTicket;
    private float prixTicket;
    private Date dateTicket;
    private int idEve;
    private String intituleEve;

    public Ticket() {
    }

    public Ticket(int idTicket) {
        this.idTicket = idTicket;
    }

    public Ticket(int idTicket, float prixTicket, Date dateTicket, String intituleEve) {
        this.idTicket = idTicket;
        this.prixTicket = prixTicket;
        this.dateTicket = dateTicket;
        this.intituleEve = intituleEve;
    }
    

    public Ticket(float prixTicket) {
        this.prixTicket = prixTicket;
    }

    public int getIdEve() {
        return idEve;
    }

    public void setIdEve(int idEve) {
        this.idEve = idEve;
    }
    

    public Ticket(int idTicket, float prixTicket, Date dateTicket, int idut) {
        this.idTicket = idTicket;
        this.prixTicket = prixTicket;
        this.dateTicket = dateTicket;
    }
       public Ticket(int idTicket, float prixTicket, Date dateTicket) {
        this.idTicket = idTicket;
        this.prixTicket = prixTicket;
        this.dateTicket = dateTicket;
    }
    public Ticket(float prixTicket, Date dateTicket) {
        this.prixTicket = prixTicket;
        this.dateTicket = dateTicket;
    }
    
    
    

    public Ticket(float prixTicket, Date dateTicket, int idEve) {
        this.prixTicket = prixTicket;
        this.dateTicket = dateTicket;
        this.idEve=idEve;
    }
    
     public Ticket(int idut, Date dateTicket, float prixTicket) {
        this.prixTicket = prixTicket;
        this.dateTicket = dateTicket;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public float getPrixTicket() {
        return prixTicket;
    }

    public Date getDateTicket() {
        return dateTicket;
    }


    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public void setPrixTicket(float prixTicket) {
        this.prixTicket = prixTicket;
    }

    public void setDateTicket(Date dateTicket) {
        this.dateTicket = dateTicket;
    }

    public String getIntituleEve() {
        return intituleEve;
    }

    public void setIntituleEve(String intituleEve) {
        this.intituleEve = intituleEve;
    }
    

    @Override
    public String toString() {
        return "Ticket{" + "idTicket=" + idTicket + ", prixTicket=" + prixTicket + ", dateTicket=" + dateTicket + ", intituleEve=" + intituleEve + '}';
    }

  
   
    
    
    
}
