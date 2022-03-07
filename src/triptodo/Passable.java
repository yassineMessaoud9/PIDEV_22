/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triptodo;

/**
 *
 * @author Utilisateur
 */
public class Passable {
    private static Passable s = null;  
    
    public Object obj;
    
    private Passable(){
        
    }
    
    public static  Passable getInstance(){
        if ( s== null){
            s = new Passable();
        }
        return s;
    }

}
