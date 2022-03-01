/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triptodo;

import esprit.com.Imservices.ServiceAvis;
import esprit.com.Imservices.ServiceEvenement;
import esprit.com.Imservices.ServiceReclamation;
import esprit.com.Imservices.ServiceTicket;
import esprit.com.entity.Avis;
import esprit.com.entity.Evenement;
import esprit.com.entity.Reclamation;
import esprit.com.entity.Ticket;
import esprit.com.entity.TypeReclamation;
import esprit.com.utils.ConnectionBd;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
       ConnectionBd bd1=ConnectionBd.getInstance();
 
        ServiceEvenement sp = new ServiceEvenement();
        ServiceReclamation sr=new ServiceReclamation();
        ServiceTicket st =new ServiceTicket();
        ServiceAvis sa = new ServiceAvis();
        //sp.ajouter(new Evenement("riodejeniro","brazil",200, Date.valueOf("2020-12-12"),Date.valueOf("2020-12-16"),"rue barchalouna","carnaval","taswira carnaaval",1000,"this event is balblabla"));
        //sp.modifier(new Evenement(1,"riodejeniro","brazil",200, Date.valueOf("2020-12-20"),Date.valueOf("2020-12-26"),"rue barchalouna","carnaval","taswira carnaaval",1000,"this event is balblabla"));
       // sp.supprimer(new Evenement(7));
        //System.out.println(sp.afficher());      
        //recherche
        //sp.search(2);
        //Reclamation
        //sr.ajouter(new Reclamation(1,TypeReclamation.Types.en_cours,"this guy kept flaming me the whole event",Date.valueOf("2022-12-16"),"bug while picking","waiting for response",5));
        //sr.modifier(new Reclamation(2,"behaviour","this guy gifted me 1350 RP",Date.valueOf("2022-12-20"),"fre RP","already seen",5));
        //sr.supprimer(new Reclamation(2));
        //System.out.println(sr.afficher());
        //Ticket
        //st.ajouter(new Ticket(1,200,Timestamp.valueOf(LocalDateTime.of(2020, 6 , 12, 8, 15, 20, 345000000)),5));
        //System.out.println(st.afficher());
        //st.modifier(new Ticket(1,200,Timestamp.valueOf(LocalDateTime.of(2022, 5 , 12, 8, 15, 20, 345000000)),5));
        //st.supprimer(new Ticket(2));
        //tri
        //sr.TRIPrix();
        //Avis
        //sa.ajouter(new Avis(1,4,"yeser basaaa",5));
       // System.out.println(sa.afficher("admin"));
        //sa.modifier(new Avis(1,10,"very nice app",5));
        //sa.supprimer(new Avis(1));
    
    }
    
}
