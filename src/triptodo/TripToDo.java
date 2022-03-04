/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triptodo;

import esprit.com.Imservices.Imagencelocation;
import esprit.com.Imservices.Imlocation;
import esprit.com.Imservices.Imsaison;
import esprit.com.Imservices.Imvoiture;
import esprit.com.entity.Agencelocation;
import esprit.com.entity.Location;
import esprit.com.entity.Saison;
import esprit.com.entity.Voiture;
import esprit.com.utils.ConnectionBd;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
/**
 *

 */
public class TripToDo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         ConnectionBd bd1=ConnectionBd.getInstance();
  // Imagencelocation ag= new Imagencelocation();
  
   Imlocation l= new Imlocation();
   Imvoiture v= new Imvoiture();
    // Imsaison sais= new Imsaison();
    // sais.modifier(new Saison(2,"hi"));
    
     
     
 // List<Location> a=  l. afficherlocation();
        //System.out.println(a);
//v.ajouter(new Voiture (12387456, "kia", "photo", 5, 5, "50dt", "agence"));


//v.modifier(new Voiture(1111,"bmw ","lien",5,11,"10dt",1));
System.out.print(v.afficherTest());


//ag.supprimeragencelocation(new Agencelocation(1));
//System.out.print(ag.afficheragencelocation());

//l.ajouterlocation(new Location(2,Date.valueOf("2002-02-05"),Date.valueOf("2002-02-05"),Timestamp.valueOf(LocalDateTime.of(2022, 5 , 12, 8, 15, 20, 345000000)),100,1,333333,1)) ;

//v.supprimer(new Voiture(1111, "MAr", "lien", 5, 11, "10dt", 16));



//v.TRIVoiture();

//v.rechercherVoiture(333333);

    

    }
    
}
