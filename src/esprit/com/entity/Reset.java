/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entity;

/**
 *
 * @author Yassine
 */
public class Reset {
    private int id;
    private String email;
    private int code;
    private  String timeMils;
    
    public Reset(String email,int code,String timeMils) {
        this.email = email;
        this.code = code;
        this.timeMils=timeMils;
    }

    public Reset(int id, String email, int code) {
        this.id = id;
        this.email = email;
        this.code = code;
    }

    public Reset(int code) {
        this.code = code;
    }

    public Reset() {
    }

    public Reset(String email, int code) {
        this.email = email;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTimeMils() {
        return timeMils;
    }

    public void setTimeMils(String timeMils) {
        this.timeMils = timeMils;
    }
    
    
}
