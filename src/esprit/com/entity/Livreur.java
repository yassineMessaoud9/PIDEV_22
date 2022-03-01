/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;


/**
 *
 * @author Yassine
 */
public class Livreur {
    private int idLivreur;
    private  String nomLivreur;
    private String cin;
    private int telephone;

    public Livreur(int idLivreur, String nomLivreur, String cin, int telephone) {
        this.idLivreur = idLivreur;
        this.nomLivreur = nomLivreur;
        this.cin = cin;
        this.telephone = telephone;
    }

    public Livreur(String nomLivreur, String cin, int telephone) {
        this.nomLivreur = nomLivreur;
        this.cin = cin;
        this.telephone = telephone;
    }

    public Livreur(int idLivreur) {
        this.idLivreur = idLivreur;
    }

    public int getIdLivreur() {
        return idLivreur;
    }

    public void setIdLivreur(int idLivreur) {
        this.idLivreur = idLivreur;
    }

    public String getNomLivreur() {
        return nomLivreur;
    }

    public void setNomLivreur(String nomLivreur) {
        this.nomLivreur = nomLivreur;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Livreur{" + "idLivreur=" + idLivreur + ", nomLivreur=" + nomLivreur + ", cin=" + cin + ", telephone=" + telephone + '}';
    }
    
    
}
