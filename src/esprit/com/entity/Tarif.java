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
public class Tarif {
    private int idTarif ;
    private float prix;
    private int matricule;
    private int idSaison;  

    @Override
    public String toString() {
        return "Tarif{" + "idTarif=" + idTarif + ", prix=" + prix + ", matricule=" + matricule + ", idSaison=" + idSaison + '}';
    }

    public Tarif() {
    }

    public Tarif(int idTarif) {
        this.idTarif = idTarif;
    }

    public Tarif(int idTarif, float prix, int matricule, int idSaison) {
        this.idTarif = idTarif;
        this.prix = prix;
        this.matricule = matricule;
        this.idSaison = idSaison;
    }

    public Tarif(float prix, int matricule, int idSaison) {
        this.prix = prix;
        this.matricule = matricule;
        this.idSaison = idSaison;
    }

    public int getIdTarif() {
        return idTarif;
    }

    public void setIdTarif(int idTarif) {
        this.idTarif = idTarif;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public int getIdSaison() {
        return idSaison;
    }

    public void setIdSaison(int idSaison) {
        this.idSaison = idSaison;
    }
    
    
    
}
