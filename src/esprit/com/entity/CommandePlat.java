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
public class CommandePlat {
    
    private int id ; 
    private int idCommande ; 
    private int plat ; 

    public CommandePlat() {
    }

    public CommandePlat(int id, int idCommande, int plat) {
        this.id = id;
        this.idCommande = idCommande;
        this.plat = plat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getPlat() {
        return plat;
    }

    public void setPlat(int plat) {
        this.plat = plat;
    }

    public CommandePlat(int idCommande, int plat) {
        this.idCommande = idCommande;
        this.plat = plat;
    }

    @Override
    public String toString() {
        return "CommandePlat{" + "id=" + id + ", idCommande=" + idCommande + ", plat=" + plat + '}';
    }
    
    
    
    
    
    
    
    
    
}
