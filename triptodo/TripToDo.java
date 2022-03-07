

package triptodo;

import esprit.com.Imservices.Imadresse;
import esprit.com.Imservices.Imavion;
import esprit.com.Imservices.Imcompagnieaerienne;
import esprit.com.Imservices.Imreservationvol;
import esprit.com.Imservices.Imvol;
import esprit.com.entity.adresse;
import esprit.com.entity.avion;
import esprit.com.entity.compagnieaerienne;
import esprit.com.entity.reservationvol;
import esprit.com.entity.vol;
import esprit.com.utils.ConnectionBd;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Gamer
 */
public class TripToDo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        // TODO code application logic here
        
      //Imadresse Imadresse= new Imadresse();
      //  Imadresse.ajouter(new adresse("aaa","wes",175));
      //Imadresse.modifier(new adresse(1,"tunis","10 rue mohamed el khames",71743659));
       // Imadresse.supprimer(new adresse(2));
        //Imadresse.supprimer(new adresse(3));
      //  System.out.print(Imadresse.afficher());
      //Imavion Imavion= new Imavion();
      //Imavion.ajouter(new avion("boing",171));
      //Imavion.modifier(new avion(1,"boing",200));
      //Imavion.supprimer(new avion(1));
      //System.out.print(Imavion.afficher());
       Imcompagnieaerienne Imcompagnieaerienne= new Imcompagnieaerienne();
       //Imcompagnieaerienne.rechercher(3);
       // System.out.print(Imcompagnieaerienne.afficher());
       // Imcompagnieaerienne.modifier(new compagnieaerienne(2,"marwaagrebi",1));
       // Imcompagnieaerienne.supprimer(new compagnieaerienne(2));
       Imvol Imvol= new Imvol();
       Imvol.nbrvol(new vol("france"));
        int re=   Imvol.nbrvol(new vol("paris"));
        System.out.println(re);
      ///  Imvol.ajouter(new vol(Date.valueOf("2022-1-6"),"13:30",Date.valueOf("2022-2-10"),"13:15","marsa","firstclass",60.45f,"allerretour",3,2));
      // Imvol.modifier(new vol(9,Date.valueOf("2022-1-6"),"12:30",Date.valueOf("2022-5-6"),"12:14","france","firstclass",60.45f,"allerretour",3,2)); 
       // Imvol.supprimer(new vol(6));
       //System.out.print(Imvol.afficher());
       // Imreservationvol Imreservationvol= new Imreservationvol();
       // Imreservationvol.ajouter(new reservationvol(1,7));
       // System.out.print(Imreservationvol.afficher());
       //Imreservationvol.supprimer(new reservationvol(2));
      
       // Imadresse.recherche(5);
       //Imadresse.tri();
       
      // List<compagnieaerienne> a=  Imcompagnieaerienne.jointure();
        //System.out.println(a);
       
       
        
        
        
        
   
      
    }

}
