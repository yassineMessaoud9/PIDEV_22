/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

import java.sql.Date;

/**
 *
 * @author MediaHelp
 */
public class ReservationHotel {
    private int idReservationHotel ;
  
   
      private String typeChambre;
          private int nbrNuit;
     private  Date dateReservation;
     private int nbrPersonne;
      private  Date dateallerReser;
       private  Date dateretourReser;
      
       private int  idU;
        private int idTourisme;

    public ReservationHotel(int idReservationHotel, String typeChambre, int nbrNuit, Date dateReservation, int nbrPersonne, Date dateallerReser, Date dateretourReser, int idU, int idTourisme) {
        this.idReservationHotel = idReservationHotel;
        this.typeChambre = typeChambre;
        this.nbrNuit = nbrNuit;
        this.dateReservation = dateReservation;
        this.nbrPersonne = nbrPersonne;
        this.dateallerReser = dateallerReser;
        this.dateretourReser = dateretourReser;
        this.idU = idU;
        this.idTourisme = idTourisme;
    }

    public ReservationHotel(int idReservationHotel, String typeChambre, int nbrNuit, Date dateReservation, int nbrPersonne, Date dateallerReser, Date dateretourReser) {
        this.idReservationHotel = idReservationHotel;
        this.typeChambre = typeChambre;
        this.nbrNuit = nbrNuit;
        this.dateReservation = dateReservation;
        this.nbrPersonne = nbrPersonne;
        this.dateallerReser = dateallerReser;
        this.dateretourReser = dateretourReser;
    }

    public ReservationHotel() {
    }



    public ReservationHotel(String typeChambre, int nbrNuit, Date dateReservation, int nbrPersonne, Date dateallerReser, Date dateretourReser, int idU, int idTourisme) {
        this.typeChambre = typeChambre;
        this.nbrNuit = nbrNuit;
        this.dateReservation = dateReservation;
        this.nbrPersonne = nbrPersonne;
        this.dateallerReser = dateallerReser;
        this.dateretourReser = dateretourReser;
        this.idU = idU;
        this.idTourisme = idTourisme;
    }

    public ReservationHotel(int idReservationHotel) {
        this.idReservationHotel = idReservationHotel;
    }

 

    public int getIdReservationHotel() {
        return idReservationHotel;
    }

    public void setIdReservationHotel(int idReservationHotel) {
        this.idReservationHotel = idReservationHotel;
    }

    public int getNbrNuit() {
        return nbrNuit;
    }

    public void setNbrNuit(int nbrNuit) {
        this.nbrNuit = nbrNuit;
    }

    public String getTypeChambre() {
        return typeChambre;
    }

    public void setTypeChambre(String typeChambre) {
        this.typeChambre = typeChambre;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Date getDateallerReser() {
        return dateallerReser;
    }

    public void setDateallerReser(Date dateallerReser) {
        this.dateallerReser = dateallerReser;
    }

    public Date getDateretourReser() {
        return dateretourReser;
    }

    public void setDateretourReser(Date dateretourReser) {
        this.dateretourReser = dateretourReser;
    }

    public int getNbrPersonne() {
        return nbrPersonne;
    }

    public void setNbrPersonne(int nbrPersonne) {
        this.nbrPersonne = nbrPersonne;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getIdTourisme() {
        return idTourisme;
    }

    public void setIdTourisme(int idTourisme) {
        this.idTourisme = idTourisme;
    }

    @Override

 
    public String toString() {
        return "ReservationHotel{" + "idReservationHotel=" + idReservationHotel + ", typeChambre=" + typeChambre + ", nbrNuit=" + nbrNuit + ", dateReservation=" + dateReservation + ", nbrPersonne=" + nbrPersonne + ", dateallerReser=" + dateallerReser + ", dateretourReser=" + dateretourReser + ", idU=" + idU + ", idTourisme=" + idTourisme + '}';
    }

    public ReservationHotel(String typeChambre, int nbrNuit, Date dateReservation, int nbrPersonne, Date dateallerReser, Date dateretourReser) {
        this.typeChambre = typeChambre;
        this.nbrNuit = nbrNuit;
        this.dateReservation = dateReservation;
        this.nbrPersonne = nbrPersonne;
        this.dateallerReser = dateallerReser;
        this.dateretourReser = dateretourReser;
    }
   
        

}