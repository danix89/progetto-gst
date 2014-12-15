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
public class CorsoLaurea {
    
private String titolo;
private String matricola;
private String abbr_dipartimento;
private String link;
private int ciclo;
private int attivo;

public CorsoLaurea(){}

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getAbbr_dipartimento() {
        return abbr_dipartimento;
    }

    public void setAbbr_dipartimento(String abbr_dipartimento) {
        this.abbr_dipartimento = abbr_dipartimento;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getAttivo() {
        return attivo;
    }

    public void setAttivo(int attivo) {
        this.attivo = attivo;
    }


    
}
