/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

import java.sql.Date;

/**
 *
 * @author Utilisateur
 */

public class Reclamation {
    private int idReclamation;
    private TypeReclamation.Types typeReclamation;
    private String description;
    private Date dateReclamation;
    private String intituleReclamation;
    private String etatReclamation;
    private int idUser;

    public Reclamation() {
    }

    public Reclamation(String intituleReclamation,String etatReclamation, String description ) {
         this.etatReclamation = etatReclamation;
        this.description = description;
        this.intituleReclamation = intituleReclamation;
    }
    

    public Reclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }
    
    public Reclamation(TypeReclamation.Types typeReclamation, String description, Date dateReclamation, String intituleReclamation) {
        this.typeReclamation = typeReclamation;
        this.description = description;
        this.dateReclamation = dateReclamation;
        this.intituleReclamation = intituleReclamation;
    }
    
    
    public Reclamation(int idReclamation, TypeReclamation.Types typeReclamation, String description, Date dateReclamation, String intituleReclamation, String etatReclamation, int idUser) {
        this.idReclamation = idReclamation;
        this.typeReclamation = typeReclamation;
        this.description = description;
        this.dateReclamation = dateReclamation;
        this.intituleReclamation = intituleReclamation;
        this.etatReclamation = etatReclamation;
        this.idUser = idUser;
    }
    
    public Reclamation( String intituleReclamation, String etatReclamation, String description, Date dateReclamation){
         this.intituleReclamation = intituleReclamation;
         this.etatReclamation = etatReclamation;
         this.description = description;
         this.dateReclamation = dateReclamation;

         
         
    }
    public Reclamation(TypeReclamation.Types typeReclamation, String description, Date dateReclamation, String intituleReclamation, String etatReclamation, int idUser) {
        this.typeReclamation = typeReclamation;
        this.description = description;
        this.dateReclamation = dateReclamation;
        this.intituleReclamation = intituleReclamation;
        this.etatReclamation = etatReclamation;
        this.idUser = idUser;
    }

       public Reclamation( String intituleReclamation, TypeReclamation.Types typeReclamation ,String etatReclamation, Date dateReclamation,String description ){
         this.intituleReclamation = intituleReclamation;
         this.etatReclamation = etatReclamation;
         this.description = description;
         this.dateReclamation = dateReclamation;
               this.typeReclamation = typeReclamation;

         
         
    }

    public int getIdReclamation() {
        return idReclamation;
    }

    public TypeReclamation.Types getTypeReclamation() {
        return typeReclamation;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public String getIntituleReclamation() {
        return intituleReclamation;
    }

    public String getEtatReclamation() {
        return etatReclamation;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public void setTypeReclamation(TypeReclamation.Types typeReclamation) {
        this.typeReclamation = typeReclamation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public void setIntituleReclamation(String intituleReclamation) {
        this.intituleReclamation = intituleReclamation;
    }

    public void setEtatReclamation(String etatReclamation) {
        this.etatReclamation = etatReclamation;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    

    @Override
    public String toString() {
        return "Reclamation{" + "idReclamation=" + idReclamation + ", typeReclamation=" + typeReclamation + ", description=" + description + ", dateReclamation=" + dateReclamation + ", intituleReclamation=" + intituleReclamation + ", etatReclamation=" + etatReclamation + ", idUser=" + idUser + '}';
    }

   
    

}
