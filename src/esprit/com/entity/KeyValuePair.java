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
public class KeyValuePair {
    private int idadresse ;
    private String paysadresse;

    public KeyValuePair(int idadresse, String paysadresse) {
        this.idadresse = idadresse;
        this.paysadresse = paysadresse;
    }

    public KeyValuePair(int idadresse) {
        this.idadresse = idadresse;
    }

    public KeyValuePair(String paysadresse) {
        this.paysadresse = paysadresse;
    }

    public int getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(int idadresse) {
        this.idadresse = idadresse;
    }

    public String getPaysadresse() {
        return paysadresse;
    }

    public void setPaysadresse(String paysadresse) {
        this.paysadresse = paysadresse;
    }

    @Override
    public String toString() {
        return paysadresse ;
    }
    
    
    
}
