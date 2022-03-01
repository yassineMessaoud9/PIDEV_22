/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet_pi;

import esprit.com.Iservices.ServiceHotel;
import esprit.com.Iservices.ServiceReservationHotel;
import esprit.com.Iservices.ServiceReservationRestaurant;
import esprit.com.Iservices.ServiceRestaurant;
import esprit.com.Iservices.ServicetourismeEtablissment;
import esprit.com.Iservices.servicefille;
import esprit.com.Iservices.serviceparent;

import esprit.com.entity.Hotel;
import esprit.com.entity.ReservationHotel;
import esprit.com.entity.ReservationRestaurant;
import esprit.com.entity.Restaurant;
import esprit.com.entity.fille;
import esprit.com.entity.parent;
import esprit.com.entity.tourismeEtablissement;

import esprit.com.utils.ConnectionBd;
import java.text.DateFormat;
import java.text.ParseException;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author MediaHelp
 */
public class Projet_pi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      ServiceHotel sH = new ServiceHotel();
     {
        //  sH.ajouter(new Hotel("movenpick","u",5,3,"k;;kpm"));
    // sH.modifier(new Hotel(5,"hotelu","u",5,5,"taswira"));
//sH.rechercherHotel(4);
//sH.TRIHotel();
sH.supprimer(new Hotel(48));
 //sH.stat();
//System.out.println(sH.VoteNbr(4));


       ServiceRestaurant sR = new ServiceRestaurant();
     //  sR.modifier(new Restaurant(14,"planb","aouina","fastfood","photo"));
   
 sR.rechercherRestau(49987);
 sR.TRIRestaus();
  // sR.supprimer(new Restaurant(1));
//sR.ajouter(new Restaurant("planA","lms",3,"carthage",4,"photo"));
     // sR.modifier(new Restaurant(2,"4forchettoikp","lmmmmms",10,"carthage",49987,"SOURA"));
     //  System.out.println(sR.afficher());

         ServiceReservationRestaurant sRR = new ServiceReservationRestaurant();
         
        
         // sRR.supprimer(new ReservationRestaurant(12,13,Date.valueOf("2019-12-10") ,5,1));
//sRR.modifier(new ReservationRestaurant(14,Date.valueOf("2019-12-11"),Date.valueOf("2017-12-10"),Date.valueOf("2019-12-10")));
 // sRR.supprimer(new ReservationRestaurant(11));
 //sRR.modifier(new ReservationRestaurant(6,Date.valueOf("2013-12-10") ,Timestamp.valueOf(LocalDateTime.of(2021, 8 , 12, 9, 18, 21, 345000000)),Timestamp.valueOf(LocalDateTime.of(2022, 4 , 12, 8, 15, 20, 345000000)),1,3));
       // System.out.println(sRR.afficher());
         
      //  System.out.println(sRR.afficher());
       ServiceReservationHotel sRH = new ServiceReservationHotel();
    // sRH.ajouter(new ReservationHotel("lkkkk",2,Date.valueOf("2022-2-18"),200,Date.valueOf("2020-12-10"),Date.valueOf("2020-12-10"),1,4));
 // sRH.modifier(new ReservationHotel(1,"lkkk",2,Date.valueOf("2020-12-9"),20,Date.valueOf("2020-12-10"),Date.valueOf("2020-12-10"),1,4));
 System.out.println(sRH.afficher());
  // sRH.supprimer(new ReservationHotel(1));
     //sRH.supprimer(new ReservationHotel(10,9,26,"DOUBL",Date.valueOf("2021-12-11") ,99,1,10));
    
    ServicetourismeEtablissment stp = new ServicetourismeEtablissment();
 //   stp.modifier(new tourismeEtablissement (3,"mkk","asma","oudherfi",3,2));

    ///stp.ajouter(new tourismeEtablissement("hotel, marsHJUIKa","marsa","taswira",3,4));
  // System.out.println(stp.afficher()); 
  // System.out.println(sH.afficherHotel()); 
    }

    }
}
