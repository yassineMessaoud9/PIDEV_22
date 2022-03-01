/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.Iservices;

import java.util.List;

/**
 *
 * @author Yassine
 */
public interface IServicesUtilisateur<T> {
    
    public void registre(T t);
    public String login(T t);
   // public void reset(T t);
    public List<T> affiche();
    public void Supprimer(T t);
    public void modifier(T t);
    public List<T> Search(String t);
}
