/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author MediaHelp
 */
public class ReservationRestaurant {
        private int idReservationRestaurant ;
       private Date Datereservationrestau;
      private Date datedebutres;
       private Date datefinres;
         private int idU;
           private int idtourisme;

    public ReservationRestaurant(int idReservationRestaurant, Date Datereservationrestau, Date datedebutres, Date datefinres, int idU, int idtourisme) {
        this.idReservationRestaurant = idReservationRestaurant;
        this.Datereservationrestau = Datereservationrestau;
        this.datedebutres = datedebutres;
        this.datefinres = datefinres;
        this.idU = idU;
        this.idtourisme = idtourisme;
    }
       public ReservationRestaurant(int idReservationRestaurant, Date Datereservationrestau, Date datedebutres, Date datefinres) {
        this.idReservationRestaurant = idReservationRestaurant;
        this.Datereservationrestau = Datereservationrestau;
        this.datedebutres = datedebutres;
        this.datefinres = datefinres;
    }


    public ReservationRestaurant(Date Datereservationrestau, Date datedebutres, Date datefinres, int idU, int idtourisme) {
        this.Datereservationrestau = Datereservationrestau;
        this.datedebutres = datedebutres;
        this.datefinres = datefinres;
        this.idU = idU;
        this.idtourisme = idtourisme;
    }

    public int getIdReservationRestaurant() {
        return idReservationRestaurant;
    }

    public void setIdReservationRestaurant(int idReservationRestaurant) {
        this.idReservationRestaurant = idReservationRestaurant;
    }

    public Date getDatereservationrestau() {
        return Datereservationrestau;
    }

    public void setDatereservationrestau(Date Datereservationrestau) {
        this.Datereservationrestau = Datereservationrestau;
    }

    public Date getDatedebutres() {
        return datedebutres;
    }

    public void setDatedebutres(Date datedebutres) {
        this.datedebutres = datedebutres;
    }

    public Date getDatefinres() {
        return datefinres;
    }

    public void setDatefinres(Date datefinres) {
        this.datefinres = datefinres;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getIdtourisme() {
        return idtourisme;
    }

    public void setIdtourisme(int idtourisme) {
        this.idtourisme = idtourisme;
    }

    @Override
    public String toString() {
        return "ReservationRestaurant{" + "idReservationRestaurant=" + idReservationRestaurant + ", Datereservationrestau=" + Datereservationrestau + ", datedebutres=" + datedebutres + ", datefinres=" + datefinres + ", idU=" + idU + ", idtourisme=" + idtourisme + '}';
    }

    
   

    public ReservationRestaurant(int idReservationRestaurant) {
        this.idReservationRestaurant = idReservationRestaurant;
    }

 
    public ReservationRestaurant(Date Datereservationrestau, Date datedebutres, Date datefinres) {
        this.Datereservationrestau = Datereservationrestau;
        this.datedebutres = datedebutres;
        this.datefinres = datefinres;
    }

    public ReservationRestaurant() {
    }

  

   
}

