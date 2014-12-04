/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionetesi.beans;

/**
 *
 * @author ciro
 */
public class Persona {

    private int ruolo; // ruolo: 1=studente 2=docente
    private int ciclo;
    private String SSN, nome, cognome, telefono, città, indirizzo, CAP, genere, cittadinanza, account_email,
            acronimo_dipartimento, pagina_web, università, matricola, posizione;

    public int getRuolo() {
        return ruolo;
    }

    public void setRuolo(int ruolo) {
        this.ruolo = ruolo;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCAP() {
        return CAP;
    }

    public void setCAP(String CAP) {
        this.CAP = CAP;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getCittadinanza() {
        return cittadinanza;
    }

    public void setCittadinanza(String cittadinanza) {
        this.cittadinanza = cittadinanza;
    }

    public String getAccount_email() {
        return account_email;
    }

    public void setAccount_email(String account_email) {
        this.account_email = account_email;
    }

    public String getAcronimo_dipartimento() {
        return acronimo_dipartimento;
    }

    public void setAcronimo_dipartimento(String acronimo_dipartimento) {
        this.acronimo_dipartimento = acronimo_dipartimento;
    }

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }

    public String getUniversità() {
        return università;
    }

    public void setUniversità(String università) {
        this.università = università;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

}
