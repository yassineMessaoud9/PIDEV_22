/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

/**
 *
 * @author Gamer
 */
public class jointure {
    private int idcompagnie ;
   private String nomcompagnie ;

    public jointure(int idcompagnie, String nomcompagnie) {
        this.idcompagnie = idcompagnie;
        this.nomcompagnie = nomcompagnie;
    }

    public jointure(int idcompagnie) {
        this.idcompagnie = idcompagnie;
    }

    public jointure(String nomcompagnie) {
        this.nomcompagnie = nomcompagnie;
    }

    public int getIdcompagnie() {
        return idcompagnie;
    }

    public void setIdcompagnie(int idcompagnie) {
        this.idcompagnie = idcompagnie;
    }

    public String getNomcompagnie() {
        return nomcompagnie;
    }

    public void setNomcompagnie(String nomcompagnie) {
        this.nomcompagnie = nomcompagnie;
    }

    @Override
    public String toString() {
        return nomcompagnie ;
    }
   
    
}
