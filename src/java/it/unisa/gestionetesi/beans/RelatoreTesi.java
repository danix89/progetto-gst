/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionetesi.beans;

/**
 *
 * @author Damiano
 */
public class RelatoreTesi {
    
    private String id_docente;
    private int id_tesi;
    
    public RelatoreTesi(String id_docente, int id_tesi){
        this.id_docente = id_docente;
        this.id_tesi = id_tesi;       
    }

    public String getId_docente() {
        return id_docente;
    }

    public void setId_docente(String id_docente) {
        this.id_docente = id_docente;
    }

    public int getId_tesi() {
        return id_tesi;
    }

    public void setId_tesi(int id_tesi) {
        this.id_tesi = id_tesi;
    }
    
    
    
}
