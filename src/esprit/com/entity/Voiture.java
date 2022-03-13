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
    private int id_voiture ;
    private int matricule ;
    private String marqueVoiture;
    private String photoVoiture;
    private int nbplace;
    private int nbrchevaux;
    private int tarif;
    private int idAgence;
    private String nomAgence;

    public Voiture() {
    }

    public Voiture(int matricule) {
        this.matricule = matricule;
    }

    public Voiture(String marqueVoiture, int tarif) {
        this.marqueVoiture = marqueVoiture;
        this.tarif = tarif;
    }

    public Voiture(String marqueVoiture, String photoVoiture, int nbplace, int nbrchevaux, int tarif) {
        this.marqueVoiture = marqueVoiture;
        this.photoVoiture = photoVoiture;
        this.nbplace = nbplace;
        this.nbrchevaux = nbrchevaux;
        this.tarif = tarif;
    }

  

    public Voiture(int id_voiture, int matricule, String marqueVoiture, String photoVoiture, int nbplace, int nbrchevaux, int tarif, int idAgence, String nomAgence) {
        this.id_voiture = id_voiture;
        this.matricule = matricule;
        this.marqueVoiture = marqueVoiture;
        this.photoVoiture = photoVoiture;
        this.nbplace = nbplace;
        this.nbrchevaux = nbrchevaux;
        this.tarif = tarif;
        this.idAgence = idAgence;
        this.nomAgence = nomAgence;
    }

    public Voiture(int id_voiture, int matricule, String marqueVoiture, String photoVoiture, int nbplace, int nbrchevaux, int tarif) {
        this.id_voiture = id_voiture;
        this.matricule = matricule;
        this.marqueVoiture = marqueVoiture;
        this.photoVoiture = photoVoiture;
        this.nbplace = nbplace;
        this.nbrchevaux = nbrchevaux;
        this.tarif = tarif;
    }

    public Voiture(int id_voiture, int matricule, String marqueVoiture, String photoVoiture, int nbplace, int nbrchevaux, int tarif, String nomAgence) {
        this.id_voiture = id_voiture;
        this.matricule = matricule;
        this.marqueVoiture = marqueVoiture;
        this.photoVoiture = photoVoiture;
        this.nbplace = nbplace;
        this.nbrchevaux = nbrchevaux;
        this.tarif = tarif;
        this.nomAgence = nomAgence;
    }
    

    public Voiture(int id_voiture, int matricule, String marqueVoiture, String photoVoiture, int nbplace, int nbrchevaux, int tarif, int idAgence) {
        this.id_voiture = id_voiture;
        this.matricule = matricule;
        this.marqueVoiture = marqueVoiture;
        this.photoVoiture = photoVoiture;
        this.nbplace = nbplace;
        this.nbrchevaux = nbrchevaux;
        this.tarif = tarif;
        this.idAgence = idAgence;
    }
    

    public Voiture(int matricule, String marqueVoiture, String photoVoiture, int nbplace, int nbrchevaux, int tarif, int idAgence) {
        this.matricule = matricule;
        this.marqueVoiture = marqueVoiture;
        this.photoVoiture = photoVoiture;
        this.nbplace = nbplace;
        this.nbrchevaux = nbrchevaux;
        this.tarif = tarif;
        this.idAgence = idAgence;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
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

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
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
        return "Voiture{" + "id_voiture=" + id_voiture + ", matricule=" + matricule + ", marqueVoiture=" + marqueVoiture + ", photoVoiture=" + photoVoiture + ", nbplace=" + nbplace + ", nbrchevaux=" + nbrchevaux + ", tarif=" + tarif + ", idAgence=" + idAgence +'}';
    }



    
}
