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
public class Voiture {
    private int matricule ;
    private String marqueVoiture;
    private String photoVoiture;
    private int nbplace;
    private int nbrchevaux;
    private String tarif;
    private int idAgence;
    private String nomAgence;

    public Voiture() {
    }


    public Voiture(int matricule, String marqueVoiture, String photoVoiture, int nbplace, int nbrchevaux, String tarif, String nomAgence) {
        this.matricule = matricule;
        this.marqueVoiture = marqueVoiture;
        this.photoVoiture = photoVoiture;
        this.nbplace = nbplace;
        this.nbrchevaux = nbrchevaux;
        this.tarif = tarif;
        this.nomAgence = nomAgence;
    }
@Override
    public String toString() {
        return "Voiture{" + "matricule=" + matricule + ", marqueVoiture=" + marqueVoiture + ", photoVoiture=" + photoVoiture + ", nbplace=" + nbplace + ", nbrchevaux=" + nbrchevaux + ", tarif=" + tarif + ", nomAgence=" + nomAgence + '}';
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

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public String getPhotoVoiture() {
        return photoVoiture;
    }

    public void setPhotoVoiture(String photoVoiture) {
        this.photoVoiture = photoVoiture;
    }

    public int getNbplace() {
        return nbplace;
    }

    public void setNbplace(int nbplace) {
        this.nbplace = nbplace;
    }

    public int getNbrchevaux() {
        return nbrchevaux;
    }

    public void setNbrchevaux(int nbrchevaux) {
        this.nbrchevaux = nbrchevaux;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public Voiture(int matricule) {
        this.matricule = matricule;
    }

    public Voiture(int matricule, String marqueVoiture, String photoVoiture, int nbplace, int nbrchevaux, String tarif, int idAgence) {
        this.matricule = matricule;
        this.marqueVoiture = marqueVoiture;
        this.photoVoiture = photoVoiture;
        this.nbplace = nbplace;
        this.nbrchevaux = nbrchevaux;
        this.tarif = tarif;
        this.idAgence = idAgence;
    }

    public Voiture(String marqueVoiture, String photoVoiture, int nbplace, int nbrchevaux, String tarif, int idAgence) {
        this.marqueVoiture = marqueVoiture;
        this.photoVoiture = photoVoiture;
        this.nbplace = nbplace;
        this.nbrchevaux = nbrchevaux;
        this.tarif = tarif;
        this.idAgence = idAgence;
    }

    public Voiture(int matricule, String marqueVoiture, String photoVoiture, int nbplace, int nbrchevaux, String tarif) {
        this.matricule = matricule;
        this.marqueVoiture = marqueVoiture;
        this.photoVoiture = photoVoiture;
        this.nbplace = nbplace;
        this.nbrchevaux = nbrchevaux;
        this.tarif = tarif;
    }

    
    
}
