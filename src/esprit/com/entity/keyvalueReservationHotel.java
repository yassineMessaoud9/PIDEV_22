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
public class keyvalueReservationHotel {
    private int idhotel;
     private String nomhotel;

    public keyvalueReservationHotel(int idhotel) {
        this.idhotel = idhotel;
    }

    public keyvalueReservationHotel(int idhotel, String nomhotel) {
        this.idhotel = idhotel;
        this.nomhotel = nomhotel;
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

    @Override
    public String toString() {
        return nomhotel;
    }
     
    
}
