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
public class KeyValueVoiture {
      private int matricule ;
    private String marqueVoiture;
     private float tarif ;

    public KeyValueVoiture(int matricule, String marqueVoiture, float tarif) {
        this.matricule = matricule;
        this.marqueVoiture = marqueVoiture;
        this.tarif = tarif;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public KeyValueVoiture(float tarif) {
        this.tarif = tarif;
    }

    public KeyValueVoiture(int matricule) {
        this.matricule = matricule;
    }

 

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getMarqueVoiture() {
        return marqueVoiture;
    }

    public void setMarqueVoiture(String marqueVoiture) {
        this.marqueVoiture = marqueVoiture;
    }

    @Override
    public String toString() {
        return marqueVoiture ;
    }

   
    
    
}
