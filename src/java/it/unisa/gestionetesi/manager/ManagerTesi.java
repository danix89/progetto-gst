/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionetesi.manager;

import it.unisa.gestionetesi.db.ConnectionDB;
import it.unisa.gestionetesi.beans.Allegati;
import it.unisa.gestionetesi.beans.RelatoreTesi;
import it.unisa.gestionetesi.beans.Tag;
import it.unisa.gestionetesi.beans.Tesi;
import it.unisa.gestionetesi.db.ConnectionDB;
import it.unisa.integrazione.database.DBConnection;
import it.unisa.integrazione.manager.concrete.ConcreteFisicPerson;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damiano
 */
public class ManagerTesi {

    private ConnectionDB aConnection;
    private Connection db;
    Statement tesiStatement;

    public ManagerTesi() throws ClassNotFoundException, SQLException, IOException, InstantiationException, IllegalAccessException {
        aConnection = new ConnectionDB("root", "");
        db = aConnection.getConnection();
    }

    public void inserisciTesiQuery(Tesi T) {

        try {
            Tesi tesi = T;

            tesiStatement = db.createStatement();
            db.setAutoCommit(false);
            String query = "INSERT INTO `tesi`(Descrizione, ID_Studente, Stato_Tesi)"
                    + "VALUES ('" + tesi.getDescrizione() + "', 0, '0')";
            tesiStatement.execute(query, Statement.RETURN_GENERATED_KEYS);

            db.commit();

        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserisciRelatoreTesiQuery(RelatoreTesi rt) {

        try {
            RelatoreTesi relatoreTesi = rt;

            Statement aStatement = db.createStatement();
            String query = "INSERT INTO `relatori_tesi`(ID_Tesi, ID_Docente)"
                    + "VALUES ('" + relatoreTesi.getId_tesi() + "', '" + relatoreTesi.getId_docente() + "')";
            aStatement.execute(query);

        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int ultimaTesiInserita() {

        int ultimaTesiInserita = -1;

        try {

            ResultSet rs = tesiStatement.getGeneratedKeys();

            if (rs.next()) {
                ultimaTesiInserita = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ultimaTesiInserita;
    }

    public void inserisciTagQuery(Tag t) throws ClassNotFoundException, SQLException, IOException {

        Statement aStatement = db.createStatement();
        String query = "INSERT INTO `Tag` ([`Nome`]) VALUES (`" + t.getNomeTag() + ")";
        aStatement.executeQuery(query);

    }

    public void inserisciAllegatiQuery(Allegati al) throws ClassNotFoundException, SQLException, IOException {

        Statement aStatement = db.createStatement();
        String query = "INSERT INTO `Allegato` ([`Oggetto`],[`ID_Tesi`],[`Stato`]) VALUES (`" + al.getLinkOggetto() + "`, `" + al.getIdTesi() + "`, `" + al.getStato() + "`)";
        aStatement.executeQuery(query);

    }

    public void inserisciTagTesiQuery(Tesi tesi, Tag tag) throws ClassNotFoundException, SQLException, IOException {

        Statement aStatement = db.createStatement();
        String query = "INSERT INTO `tag_tesi`([`ID_tesi`],[`ID_tag`]) VALUES ([`" + tesi.getId_tesi() + "`],[`" + tag.getId() + ")";
        aStatement.executeQuery(query);

    }

    public Tesi selezionaTesi(int id_student) {
        Tesi T = null;
        try {
            Statement aStatement = db.createStatement();
            String query = "SELECT * FROM 'Tesi' WHERE ID_Studente=" + id_student + "";

            ResultSet rs = aStatement.executeQuery(query);
            int id_tesi = 0;
            String data_inizio = null;
            String data_fine = null;
            String data_fine_prevista = null;
            String titolo = null;
            String abstractTesi = null;
            String descrizione = null;
            int id_studente = 0;
            String stato_tesi = null;

            while (rs.next()) {
                id_tesi = rs.getInt("ID");
                data_inizio = rs.getString("Data_Inizio");
                data_fine = rs.getString("Data_Fine");
                data_fine_prevista = rs.getString("Data_Fine_Prevista");
                titolo = rs.getString("Titolo");
                abstractTesi = rs.getString("Abstract");
                descrizione = rs.getString("Descrizione");
                id_studente = rs.getInt("ID_Studente");
                stato_tesi = rs.getString("Stato_Tesi");
            }

            if (stato_tesi != null) {
                T = new Tesi(id_tesi, data_inizio, data_fine, data_fine_prevista, titolo, abstractTesi, descrizione, id_studente, stato_tesi);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return T;
    }

    public void accettaTesi() {

    }

    public void rifiutaTesi() {

    }

}
