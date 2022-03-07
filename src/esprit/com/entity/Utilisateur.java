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
public class Utilisateur {

    private int idU;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String motpasse;
    private String photo;
    private String pays;
    private String role;
    private String Active = "Active";

    public Utilisateur() {
    }

    public Utilisateur(int idU, String email, String motpasse) {
        this.idU = idU;
        this.email = email;
        this.motpasse = motpasse;
    }

    public Utilisateur(int idU, String nom, String prenom, String adresse, String email, String motpasse, String photo, String pays, String role, String Active) {
        this.idU = idU;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.motpasse = motpasse;
        this.photo = photo;
        this.pays = pays;
        this.role = role;
        this.Active = Active;
    }
    public Utilisateur(int idU, String nom, String prenom, String adresse, String email,  String photo, String pays, String role, String Active) {
        this.idU = idU;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.photo = photo;
        this.pays = pays;
        this.role = role;
        this.Active = Active;
    }

    public Utilisateur(String nom, String prenom, String adresse, String email, String motpasse, String photo, String pays, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.motpasse = motpasse;
        this.photo = photo;
        this.pays = pays;
        this.role = role;
    }

    public Utilisateur(int idU, String nom, String prenom, String adresse, String email, String photo, String pays, String role) {
        this.idU = idU;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.photo = photo;
        this.pays = pays;
        this.role = role;
    }

    public Utilisateur(int idU) {
        this.idU = idU;
    }

    public Utilisateur(String email, String motpasse) {
        this.email = email;
        this.motpasse = motpasse;
    }


    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotpasse() {
        return motpasse;
    }

    public void setMotpasse(String motpasse) {
        this.motpasse = motpasse;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getString() {
        return role;
    }

    public void setString(String role) {
        this.role = role;
    }

    public String isActive() {
        return Active;
    }

    public void setActive(String Active) {
        this.Active = Active;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "idU=" + idU + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email=" + email + ", photo=" + photo + ", pays=" + pays + ", role=" + role + ", Active=" + Active + '}';
    }

    
}
