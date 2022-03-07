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
public class Restaurant  {
       
     
           private int idrestau	;
             private  String nomrestau;
              private  String typerestau;
              private int nbrtable	;
                private  String localisation;
                private int telephone;
            private  String photo;

    public Restaurant(int idrestau, String nomrestau, String typerestau, int nbrtable, String localisation, int telephone, String photo) {
        this.idrestau = idrestau;
        this.nomrestau = nomrestau;
        this.typerestau = typerestau;
        this.nbrtable = nbrtable;
        this.localisation = localisation;
        this.telephone = telephone;
        this.photo = photo;
    }
      public Restaurant() {
      
    }

    public Restaurant(String nomrestau, String typerestau, int nbrtable, String localisation, int telephone, String photo) {
        this.nomrestau = nomrestau;
        this.typerestau = typerestau;
        this.nbrtable = nbrtable;
        this.localisation = localisation;
        this.telephone = telephone;
        this.photo = photo;
    }

    public Restaurant(int idrestau) {
        this.idrestau = idrestau;
    }

    public int getIdrestau() {
        return idrestau;
    }

    public void setIdrestau(int idrestau) {
        this.idrestau = idrestau;
    }

    public String getNomrestau() {
        return nomrestau;
    }

    public void setNomrestau(String nomrestau) {
        this.nomrestau = nomrestau;
    }

    public String getTyperestau() {
        return typerestau;
    }

    public void setTyperestau(String typerestau) {
        this.typerestau = typerestau;
    }

    public int getNbrtable() {
        return nbrtable;
    }

    public void setNbrtable(int nbrtable) {
        this.nbrtable = nbrtable;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "idrestau=" + idrestau + ", nomrestau=" + nomrestau + ", typerestau=" + typerestau + ", nbrtable=" + nbrtable + ", localisation=" + localisation + ", telephone=" + telephone + ", photo=" + photo + '}';
    }


}