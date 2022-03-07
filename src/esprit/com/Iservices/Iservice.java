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
public interface Iservice <T> {
    public void ajouter(T t);
     public void supprimer(T t);
      public void modifier(T t);
       public List<T> afficher();
    
}
