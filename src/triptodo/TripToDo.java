/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triptodo;

import at.favre.lib.crypto.bcrypt.BCrypt;
import esprit.com.ImServices.ImCommandeRestau;
import esprit.com.ImServices.ImLivreur;
import esprit.com.ImServices.ImPlat;
import esprit.com.ImServices.ImSponsors;
import esprit.com.ImServices.ImUtilisateur;
import esprit.com.ImServices.ServiceHotel;
import esprit.com.ImServices.ServiceReservationHotel;
import esprit.com.ImServices.ServiceReservationRestaurant;
import esprit.com.ImServices.ServiceRestaurant;
import esprit.com.ImServices.imReset;
import esprit.com.ImServices.imSuivi;
import esprit.com.entity.CommandeRestau;
import esprit.com.entity.Hotel;
import esprit.com.entity.Livreur;
import esprit.com.entity.Plat;
import esprit.com.entity.ReservationHotel;
import esprit.com.entity.ReservationRestaurant;
import esprit.com.entity.Reset;
import esprit.com.entity.Restaurant;
import esprit.com.entity.Role;
import esprit.com.entity.Sponsors;
import esprit.com.entity.Suivi;
import esprit.com.entity.Utilisateur;
import esprit.com.mail.Sendmail;
import java.nio.file.Files;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.sql.Date;

/**
 *
 * @author Yassine
 */
public class TripToDo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //-------------------------------------- UTILISATEUR  --------------------------------

        ImUtilisateur uti = new ImUtilisateur();
 //uti.registre(new Utilisateur("ayass","mess","Ariana Soghra","medyassinee.messaoud@esprit.tn","maha","photo","tunis","Admin"));
     //  uti.modifier(new Utilisateur(6,"yassine.messaoud98@gmail.com","maha"));
          //  uti.modifierMopasst(new Utilisateur("maha.mess@gmail.com","maha"));
//System.out.println(uti.affiche());
        //uti.Supprimer(new Utilisateur(2));
     //   uti.modifier(new Utilisateur(1,"ayass","mesas","Ariana Soghra","maha.mess@gmail.com","photooo","tunis","utilisateur",1));
        // uti.Search(new Utilisateur(9)); 
       // uti.Search(new Utilisateur(5));
      // uti.tri();
        //-------------------------------------- PLAT  --------------------------------

       ImPlat imp = new ImPlat();
     //   imp.ajout(new Plat("Couscous",42.500,"PhotoPlat","couscous bel OSBEN"));
        //System.out.println(imp.Show());
       // imp.Edit(new Plat(1,"Couscous",12.500,"PhotoPlat","couscous bel OSBEN"));
       
               //-------------------------------------- LIVREUR  --------------------------------

      //  ImLivreur iml = new ImLivreur();
      // iml.ajout(new Livreur("yassine","05684794",23483139));
      //  System.out.println(iml.Show());
    //  iml.Delete(new Livreur(4));
    //  iml.Edit(new Livreur(1,"yassine","05684794",23484139));
   
    
    
                //-------------------------------------- Reset  --------------------------------
       // long start = System.currentTimeMillis();
        //String s = Long.toString(start);
          //    System.out.println(s);  
             // imReset imr = new imReset();
              // imr.ajout(new Reset("yassine",554,start));

    // this will convert any number sequence into 6 character.
    //return String.format("%06d", number);

    //  Sendmail sn = new Sendmail();
       // sn.envoyer("yassine.messaoud98@gmail.com");
    
      // uti.reset(new Reset(498739));
// some time passes


                //-------------------------------------- SPONSORS  --------------------------------
                
               ImSponsors ims = new ImSponsors();
              //  ims.ajout(new Sponsors("Délice",1500, Date.valueOf("2020-12-12"),Date.valueOf("2022-02-20"),"path logo"));
              // System.out.println(ims.Show());
             //ims.Edit(new Sponsors(3,"Mohsen",15.501,Date.valueOf("2022-02-20"),Date.valueOf("2022-02-20")));
         //   imSuivi isu= new imSuivi();
            //isu.ajout(new Suivi(1,"En cour",1.525,1.544,"adress"));
           // System.out.println(isu.Show());
           //double prix_commande, Date date_commande, int idPlat, int idU, double latitude, double longitude, String Adress
           ImCommandeRestau imc = new ImCommandeRestau();
          // imc.ajout(new CommandeRestau(10.2, Date.valueOf("2020-12-12"),[1,1],1,10.66,20.54,"Tunis"));
           
   //     System.out.println(imc.afficherTest());

        

/*
 ServiceHotel sH = new ServiceHotel();
     
         // sH.ajouter(new Hotel("esprit","u",5,3,"k;;kpm"));
   // sH.modifier(new Hotel(63,"hotelu","u",5,5,"taswira"));
     //   System.out.println(sH.rechercherHotel("asmakkk")); 
//System.out.println(sH.TRIHotel());
//sH.supprimer(new Hotel(63));  
 //sH.stat();
System.out.println(sH.TRIHotelNbrchambre());

*/

        //ServiceRestaurant sR = new ServiceRestaurant();
  //sR.supprimer(new Restaurant(53));
//sR.ajouter(new Restaurant("planAab","lms",3,"carthage",4,"photo"));
     // sR.modifier(new Restaurant(53,"4forchettoikp","lmmmmms",10,"carthage",49987,"SOURA"));
    //  System.out.println(sR.afficher());


        ServiceReservationHotel sRH = new ServiceReservationHotel();
   //  sRH.ajouter(new ReservationHotel("Tour",2,Date.valueOf("2022-2-18"),200,Date.valueOf("2020-12-10"),Date.valueOf("2020-12-10"),1,4));
 // sRH.modifier(new ReservationHotel(35,"Loool",2,Date.valueOf("2020-12-9"),20,Date.valueOf("2020-12-10"),Date.valueOf("2020-12-10"),1,4));
 //System.out.println(sRH.afficher());
  // sRH.supprimer(new ReservationHotel(35));
     //sRH.supprimer(new ReservationHotel(10,9,26,"DOUBL",Date.valueOf("2021-12-11") ,99,1,10));
    
    
        ServiceReservationRestaurant sRR = new ServiceReservationRestaurant();

    // sRR.supprimer(new ReservationRestaurant(12,13,Date.valueOf("2019-12-10") ,5,1));
//sRR.ajouter(new ReservationRestaurant(Date.valueOf("2019-12-11"),Date.valueOf("2017-12-10"),Date.valueOf("2019-12-10"),1,4));
 //sRR.supprimer(new ReservationRestaurant(17));
      //  System.out.println(sRR.afficher());
//sRR.modifier(new ReservationRestaurant(17,Date.valueOf("2019-12-11"),Date.valueOf("2017-12-10"),Date.valueOf("2019-12-10"),1,4));
   
    
    
    
    }


}
