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
public class fille  extends parent{
    
    private String prenom;
     private int  id1;

    public fille(int id,String nom,String prenom)
    { 
        super(id,nom);
        this.prenom = prenom;
    }
 public fille(String nom,String prenom)
    { 
        super(nom);
        this.prenom = prenom;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public fille(int id) {
        super(id);
    }

    public int getId() {
        return id1;
    }

    public void setId(int id) {
        this.id1 = id;
    }

    public fille(int id, String nom, String prenom, int id1) {
        super(id, nom);
        this.prenom = prenom;
        this.id1 = id1;
    }
  public fille( String nom, String prenom, int id1) {
        super(nom);
        this.prenom = prenom;
        this.id1 = id1;
    }
    public fille(String prenom, int id1, String nom) {
        super(nom);
        this.prenom = prenom;
        this.id1 = id1;
    }

    public fille(int id1, int id) {
        super(id);
     
        this.id1 = id1;
    }

  

  
    
   

  

    @Override
    public String toString() {
        return "fille{" + "prenom=" + prenom + '}';
    }
    
    
}
