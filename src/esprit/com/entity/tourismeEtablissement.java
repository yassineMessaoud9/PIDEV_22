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
public class tourismeEtablissement
        
{
     private int  idtourisme ;
     private String nomtourisme;
       private String paystourisme;
         private String logo;
            private int  etoile ;
               private int  telephone ;

    public tourismeEtablissement(int idtourisme, String nomtourisme, String paystourisme, String logo, int etoile, int telephone) {
        this.idtourisme = idtourisme;
        this.nomtourisme = nomtourisme;
        this.paystourisme = paystourisme;
        this.logo = logo;
        this.etoile = etoile;
        this.telephone = telephone;
    }

    public tourismeEtablissement(String nomtourisme, String paystourisme, String logo, int etoile, int telephone) {
        this.nomtourisme = nomtourisme;
        this.paystourisme = paystourisme;
        this.logo = logo;
        this.etoile = etoile;
        this.telephone = telephone;
    }

    public int getIdtourisme() {
        return idtourisme;
    }

    public void setIdtourisme(int idtourisme) {
        this.idtourisme = idtourisme;
    }

    public String getNomtourisme() {
        return nomtourisme;
    }

    public void setNomtourisme(String nomtourisme) {
        this.nomtourisme = nomtourisme;
    }

    public String getPaystourisme() {
        return paystourisme;
    }

    public void setPaystourisme(String paystourisme) {
        this.paystourisme = paystourisme;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getEtoile() {
        return etoile;
    }

    public void setEtoile(int etoile) {
        this.etoile = etoile;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "tourismeEtablissement{" + "idtourisme=" + idtourisme + ", nomtourisme=" + nomtourisme + ", paystourisme=" + paystourisme + ", logo=" + logo + ", etoile=" + etoile + ", telephone=" + telephone + '}';
    }

    public tourismeEtablissement(int idtourisme) {
        this.idtourisme = idtourisme;
    }
    
}
