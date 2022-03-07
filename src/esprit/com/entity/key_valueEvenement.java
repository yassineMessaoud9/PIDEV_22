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
public class key_valueEvenement {
        private int id;
        private String intituleEve;

    public key_valueEvenement(int id, String intituleEve) {
        this.id = id;
        this.intituleEve = intituleEve;
    }

    public key_valueEvenement(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getIntituleEve() {
        return intituleEve;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIntituleEve(String intituleEve) {
        this.intituleEve = intituleEve;
    }

    @Override
    public String toString() {
        return  intituleEve;
    }
        
    
    
}
