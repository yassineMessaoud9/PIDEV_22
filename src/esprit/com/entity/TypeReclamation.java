/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

import java.util.EnumSet;



/**
 *
 * @author Utilisateur
 */
public class TypeReclamation {
    public enum Types{
         en_cours, traite;
    }
    public static Types find(String abbr){
 
    for(Types v :EnumSet.allOf(TypeReclamation.Types.class)){
        if( v.toString().equals(abbr)){
            return v;
        }
    }
    return null;
}
}
