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
public interface IservicesMethodes<T> {
    public void ajout(T t);
  public List<T> Show();
    public void Delete(T t);
    public void Edit(T t);
    public List<T> Find(String t);
     public void tri();

}
