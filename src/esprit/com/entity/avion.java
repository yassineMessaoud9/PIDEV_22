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
public class avion {
  private int numserieavion ;
  private String marque ;
  private int nbrplace ;

    public avion(int numserieavion, String marque, int nbrplace) {
        this.numserieavion = numserieavion;
        this.marque = marque;
        this.nbrplace = nbrplace;
    }

    public avion(String marque, int nbrplace) {
        this.marque = marque;
        this.nbrplace = nbrplace;
    }

    public avion(int numserieavion) {
        this.numserieavion = numserieavion;
    }
    

    public avion() {
    }

    public int getNumserieavion() {
        return numserieavion;
    }

    public void setNumserieavion(int numserieavion) {
        this.numserieavion = numserieavion;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getNbrplace() {
        return nbrplace;
    }

    public void setNbrplace(int nbrplace) {
        this.nbrplace = nbrplace;
    }

    @Override
    public String toString() {
        return "avion{" + "numserieavion=" + numserieavion + ", marque=" + marque + ", nbrplace=" + nbrplace + '}';
    }
  
 


 
    
   
    

  



}
