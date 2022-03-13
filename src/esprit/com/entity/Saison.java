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
public class Saison {
      private int idSaison ;
    private String nomSaison;

    public Saison() {
    }

    public Saison(int idSaison) {
        this.idSaison = idSaison;
    }

    public Saison(int idSaison, String nomSaison) {
        this.idSaison = idSaison;
        this.nomSaison = nomSaison;
    }

    public Saison(String nomSaison) {
        this.nomSaison = nomSaison;
    }

    @Override
    public String toString() {
        return "Saison{" + "idSaison=" + idSaison + ", nomSaison=" + nomSaison + '}';
    }

    public int getIdSaison() {
        return idSaison;
    }

    public void setIdSaison(int idSaison) {
        this.idSaison = idSaison;
    }

    public String getNomSaison() {
        return nomSaison;
    }

    public void setNomSaison(String nomSaison) {
        this.nomSaison = nomSaison;
    }
  
}
