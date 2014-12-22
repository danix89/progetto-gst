/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionetesi.manager;

import it.unisa.gestionetesi.beans.Cronologia;
import it.unisa.gestionetesi.db.ConnectionDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ciro
 */
public class ManagerCronologia {

    Logger logger = Logger.getLogger("db");
    private ConnectionDB aConnection;
    private Connection db;
    Statement tesiStatement;

    public ManagerCronologia() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        aConnection = new ConnectionDB("root", "");
        db = aConnection.getConnection();
    }

    public void inserisciEvento(Cronologia crono) {

        try {
            Statement aStatement = db.createStatement();

            String q = "INSERT INTO `cronologia`(testo, ID_Docente, ID_Studente, Tipo)"
                    + "VALUES ( '" + crono.getTesto() + " ', '" + crono.getId_docente() + "' , '" + crono.getId_studente() + "', '" + crono.getTipo() + "')";

            aStatement.execute(q);

        } catch (SQLException ex) {
            logger.info("query fallita: " + ex.getMessage());
            Logger.getLogger(ManagerCronologia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean eliminaEvento(int idCronologia) {

        boolean wellDone = true;
        try {
            Statement aStatement = db.createStatement();
            String queryNuovoEvento = "DELETE FROM `db_distra`.`cronologia` WHERE ID=" + idCronologia;
            wellDone = aStatement.execute(queryNuovoEvento);

        } catch (SQLException ex) {
            logger.info("query fallita: " + ex.getMessage());
            wellDone = false;
            Logger.getLogger(ManagerCronologia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wellDone;

    }

    public Cronologia selezionaEvento(int idCronologia) {
        Cronologia crono = null;

        ResultSet res = null;

        try {
            Statement aStatement = db.createStatement();
            String query = "SELECT * FROM cronologia WHERE ID='" + idCronologia + "' ";

            res = aStatement.executeQuery(query);

            int id_cronologia = 0;
            String testo = null, data_notifica = null, id_studente = null, id_docente = null, tipo = null;

            id_cronologia = res.getInt("ID");
            testo = res.getString("Testo");
            data_notifica = res.getString("Data_Notifica");
            id_studente = res.getString("ID_Studente");
            id_docente = res.getString("ID_Docente");
            tipo = res.getString("Tipo");
            crono = new Cronologia(id_cronologia, testo, data_notifica, id_studente, id_docente, tipo);

        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
            logger.info("sono nel catch: " + ex.getErrorCode());
        }
        return crono;
    }

    public ArrayList<Cronologia> elencaEventiStudente(String idStudente) {
        ArrayList<Cronologia> cronos = new ArrayList<Cronologia>();
        Cronologia c;
        ResultSet res = null;

        try {
            Statement aStatement = db.createStatement();
            String query = "SELECT * FROM cronologia WHERE ID_Studente='" + idStudente + "' ";

            res = aStatement.executeQuery(query);

            int id_cronologia = 0;
            String testo = null, data_notifica = null, id_studente = null, id_docente = null, tipo=null;

            while (res.next()) {

                id_cronologia = res.getInt("ID");
                testo = res.getString("Testo");
                data_notifica = res.getString("Data_Notifica");
                id_studente = res.getString("ID_Studente");
                id_docente = res.getString("ID_Docente");
                tipo=res.getString("Tipo");
                logger.info("TESTO:" + testo);
                c = new Cronologia(id_cronologia, testo, data_notifica, id_studente, id_docente, tipo);
                cronos.add(c);
            }

        } catch (SQLException ex) {
            logger.info("FALLIMENTO SQL: " + ex.getMessage());
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
            logger.info("sono nel catch: " + ex.getErrorCode());
        }

        System.out.print(cronos.toString());
        return cronos;
    }

    public ArrayList<Cronologia> elencaEventiDocente(String idDocente) throws SQLException {
        ArrayList<Cronologia> cronos = new ArrayList<Cronologia>();
        Cronologia c;
        ResultSet res = null;

        try {
            Statement aStatement = db.createStatement();
            String query = "SELECT * FROM cronologia WHERE ID_Docente='" + idDocente + "' ";

            res = aStatement.executeQuery(query);
            int id_cronologia = 0;
            String testo = null, data_notifica = null, id_studente = null, id_docente = null, tipo = null;

            while (res.next()) {
                tipo = res.getString("Tipo");
                id_cronologia = res.getInt("ID");
                testo = res.getString("Testo");
                data_notifica = res.getString("Data_Notifica");
                id_studente = res.getString("ID_Studente");
                id_docente = res.getString("ID_Docente");
                logger.info("TESTO:" + testo);
                c = new Cronologia(id_cronologia, testo, data_notifica, id_studente, id_docente, tipo);
                cronos.add(c);
            }

        } catch (SQLException ex) {
            logger.info("FALLIMENTO SQL: " + ex.getMessage());
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
            logger.info("sono nel catch: " + ex.getErrorCode());
        }
        return cronos;
    }

}
