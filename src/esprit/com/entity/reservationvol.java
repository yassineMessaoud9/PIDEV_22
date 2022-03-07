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
public class reservationvol {
  private int idreservationvol;
  private int idU;
  private int numvol;

    public reservationvol(int idreservationvol, int idU, int numvol) {
        this.idreservationvol = idreservationvol;
        this.idU = idU;
        this.numvol = numvol;
    }

    public reservationvol(int idU, int numvol) {
        this.idU = idU;
        this.numvol = numvol;
    }

    public reservationvol(int idreservationvol) {
        this.idreservationvol = idreservationvol;
    }
    

    public reservationvol() {
    }

    public int getIdreservationvol() {
        return idreservationvol;
    }

    public void setIdreservationvol(int idreservationvol) {
        this.idreservationvol = idreservationvol;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getNumvol() {
        return numvol;
    }

    public void setNumvol(int numvol) {
        this.numvol = numvol;
    }

    @Override
    public String toString() {
        return "reservationvol{" + "idreservationvol=" + idreservationvol + ", idU=" + idU + ", numvol=" + numvol + '}';
    }
  



}
