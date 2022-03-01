/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

/**
 *
 * @author Utilisateur
 */
public class Avis {
    private int id ;
    private int rate;
    private String summary;
    private int idu;

    public Avis(int id, int rate, String summary, int idu) {
        this.id = id;
        this.rate = rate;
        this.summary = summary;
        this.idu = idu;
    }

 
    
    
    public Avis() {
    }

    public Avis(int id) {
        this.id = id;
    }


    public Avis(int rate, String summary, int idu) {
        this.rate = rate;
        this.summary = summary;
        this.idu = idu;
    }
    

    public int getId() {
        return id;
    }

    public int getRate() {
        return rate;
    }

    public String getSummary() {
        return summary;
    }

    public int getIdu() {
        return idu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    @Override
    public String toString() {
        return "Avis{" + "id=" + id + ", rate=" + rate + ", summary=" + summary + ", idu=" + idu + '}';
    }
    
    
    
 
    
}
