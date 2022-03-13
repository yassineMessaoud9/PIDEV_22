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
public class keyValueAgence {
      private int idAgence ;
    private String nomAgence;

    public keyValueAgence(int idAgence, String nomAgence) {
        this.idAgence = idAgence;
        this.nomAgence = nomAgence;
    }

    public keyValueAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public keyValueAgence(String nomAgence) {
        this.nomAgence = nomAgence;
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

    @Override
    public String toString() {
        return nomAgence ;
    }
    
    
    
}
