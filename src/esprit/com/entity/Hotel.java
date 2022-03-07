/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

/**
 *
 * @author MediaHelp
 */
public class Hotel {

    private int idhotel;
    private String nomhotel;
    private String adresse;
    private int etoile;
    private int nbrChambre;
    private String photo;

    public Hotel(int idhotel, String nomhotel, String adresse, int etoile, int nbrChambre, String photo) {
        this.idhotel = idhotel;
        this.nomhotel = nomhotel;
        this.adresse = adresse;
        this.etoile = etoile;
        this.nbrChambre = nbrChambre;
        this.photo = photo;
    }

    public Hotel(String nomhotel, String adresse, int etoile, int nbrChambre, String photo) {
        this.nomhotel = nomhotel;
        this.adresse = adresse;
        this.etoile = etoile;
        this.nbrChambre = nbrChambre;
        this.photo = photo;
    }

    public Hotel(int idhotel) {
        this.idhotel = idhotel;
    }

    public Hotel() {

    }

    public int getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(int idhotel) {
        this.idhotel = idhotel;
    }

    public String getNomhotel() {
        return nomhotel;
    }

    public void setNomhotel(String nomhotel) {
        this.nomhotel = nomhotel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getEtoile() {
        return etoile;
    }

    public void setEtoile(int etoile) {
        this.etoile = etoile;
    }

    public int getNbrChambre() {
        return nbrChambre;
    }

    public void setNbrChambre(int nbrChambre) {
        this.nbrChambre = nbrChambre;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Hotel{" + "idhotel=" + idhotel + ", nomhotel=" + nomhotel + ", adresse=" + adresse + ", etoile=" + etoile + ", nbrChambre=" + nbrChambre + ", photo=" + photo + '}';
    }

}
