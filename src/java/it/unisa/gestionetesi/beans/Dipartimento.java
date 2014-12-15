/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionetesi.beans;

/**
 *
 * @author CosimoAlessandro
 */
public class Dipartimento {
    
    private String abbreviazione;
    private String titolo;
    private String moodle;
    private String token;
    
    public Dipartimento(){
        
    }

    public String getAbbreviazione() {
        return abbreviazione;
    }

    public void setAbbreviazione(String abbreviazione) {
        this.abbreviazione = abbreviazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getMoodle() {
        return moodle;
    }

    public void setMoodle(String moodle) {
        this.moodle = moodle;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
    
}
