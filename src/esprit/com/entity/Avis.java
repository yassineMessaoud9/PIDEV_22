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
    private String name;


    public Avis(int id, int rate, String name) {
        this.id = id;
        this.rate = rate;
        this.name = name;
        
    }

    public Avis( String name,int rate) {
      
        this.name = name;
          this.rate = rate;
    }

 
    
    
    public Avis() {
    }

    public Avis(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }




    public int getId() {
        return id;
    }

    public int getRate() {
        return rate;
    }

    public void setName(String name) {
        this.name = name;
    }

 

    public void setId(int id) {
        this.id = id;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Avis{" + "id=" + id + ", rate=" + rate + ", name=" + name + '}';
    }


    
    
 
    
}
