/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionetesi.manager;

import it.unisa.gestionetesi.beans.Allegati;
import it.unisa.gestionetesi.beans.RelatoreTesi;
import it.unisa.gestionetesi.beans.Tag;
import it.unisa.gestionetesi.beans.Tesi;
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
 * @author Damiano
 */
public class ManagerTesi {

    Logger logger = Logger.getLogger("db");
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
            // db.setAutoCommit(false);
            String query = "INSERT INTO `tesi`(Descrizione, ID_Studente, Stato_Tesi)"
                    + "VALUES ('" + tesi.getDescrizione() + "', '" + tesi.getId_studente() + "' , '0')";
            tesiStatement.execute(query, Statement.RETURN_GENERATED_KEYS);

            //db.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean inserisciRelatoreTesiQuery(RelatoreTesi rt) {
        boolean success = false;
        try {
            RelatoreTesi relatoreTesi = rt;

            Statement aStatement = db.createStatement();
            String query = "INSERT INTO `relatori_tesi`(ID_Tesi, ID_Docente)"
                    + "VALUES ('" + relatoreTesi.getId_tesi() + "', '" + relatoreTesi.getId_docente() + "')";
            aStatement.execute(query);
            success = true;
        } catch (SQLException ex) {
            success = false;
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
        }

        return success;
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
        String query = "INSERT INTO `Tag` (Nome) VALUES (`" + t.getNomeTag() + ")";
        aStatement.executeQuery(query);

    }

    public void inserisciAllegatiQuery(Allegati al) throws ClassNotFoundException, SQLException, IOException {

        Statement aStatement = db.createStatement();
        String query = "INSERT INTO `Allegato` (Oggetto,ID_Tesi,Stato) VALUES (`" + al.getLinkOggetto() + "`, `" + al.getIdTesi() + "`, `" + al.getStato() + "`)";
        aStatement.executeQuery(query);

    }

    public void inserisciTagTesiQuery(Tesi tesi, Tag tag) throws ClassNotFoundException, SQLException, IOException {

        Statement aStatement = db.createStatement();
        String query = "INSERT INTO `tag_tesi`(ID_tesi,ID_tag) VALUES ([`" + tesi.getId_tesi() + "`],[`" + tag.getId() + ")";
        aStatement.executeQuery(query);

    }

    public Tesi selezionaTesi(String id_student) {
        Tesi T = null;

        ResultSet rs = null;

        try {
            Statement aStatement = db.createStatement();
            String query = "SELECT * FROM tesi WHERE ID_Studente= '" + id_student + "' ";

            rs = aStatement.executeQuery(query);

            logger.info("Numero di righe: " + rs.getRow());

            int id_tesi = 0;
            String data_inizio = null;
            String data_fine = null;
            String data_fine_prevista = null;
            String titolo = null;
            String abstractTesi = null;
            String descrizione = null;
            String id_studente = null;
            String stato_tesi = null;

            while (rs.next()) {
                id_tesi = rs.getInt("ID");
                data_inizio = rs.getString("Data_Inizio");
                data_fine = rs.getString("Data_Fine");
                data_fine_prevista = rs.getString("Data_Fine_Prevista");
                titolo = rs.getString("Titolo");
                abstractTesi = rs.getString("Abstract");
                descrizione = rs.getString("Descrizione");
                id_studente = rs.getString("ID_Studente");
                stato_tesi = rs.getString("Stato_Tesi");
            }

            if (stato_tesi != null) {
                T = new Tesi(id_tesi, data_inizio, data_fine, data_fine_prevista, titolo, abstractTesi, descrizione, id_studente, stato_tesi);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
            logger.info("sono nel carch" + ex.getErrorCode());
        }
        return T;
    }

    public ArrayList<RelatoreTesi> selezionaRelatoriTesi(int id_tesi) {

        RelatoreTesi rt = null;
        ArrayList<RelatoreTesi> listaRelatori = null;
        ResultSet rs = null;

        try {

            listaRelatori = new ArrayList<RelatoreTesi>();

            Statement aStatement = db.createStatement();
            String query = "SELECT * FROM relatori_tesi JOIN person ON relatori_tesi.ID_Docente=person.SSN WHERE ID_Tesi= '"+id_tesi+"' ";
            rs = aStatement.executeQuery(query);
            
            while(rs.next()){
                rt= new RelatoreTesi();
                rt.setId_docente(rs.getString("ID_Docente"));
                rt.setNome(rs.getString("name"));
                rt.setCognome(rs.getString("surname"));
                rt.setId_tesi(rs.getInt("ID_Tesi"));
                
                listaRelatori.add(rt);
   
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaRelatori;
    }

    public void accettaTesi(int idTesi) throws SQLException {

        try {
            Statement aStatement = db.createStatement();
            String accetta = "UPDATE `db_distra`.`tesi` SET `Descrizione` = '', `Stato_Tesi` = '1' WHERE `tesi`.`ID` =" + idTesi;
            aStatement.executeUpdate(accetta);
            success = true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
            logger.info("errore nell'sql: " + ex.getErrorCode());
            success = false;
        }
        return success;
    }

    public boolean accettaCompletamentoTesi(int idTesi) throws SQLException {
        boolean success = false;
        try {
            Statement aStatement = db.createStatement();
            String accetta = "UPDATE `db_distra`.`tesi` SET `Stato_Tesi` = '3' WHERE `tesi`.`ID` =" + idTesi;
            aStatement.executeUpdate(accetta);
            success = true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
            logger.info("sei nel catch" + ex.getErrorCode());
            success = false;
        }
        return success;

    }

    public void rifiutaCompletamentoTesi(int idTesi) throws SQLException {
        boolean success = false;
        try {
            Statement aStatement = db.createStatement();
            String accetta = "UPDATE `db_distra`.`tesi` SET `Stato_Tesi` = '1' WHERE `tesi`.`ID` =" + idTesi;
            aStatement.executeUpdate(accetta);
            logger.info("sei nel try di rifiuta completamento tesi");

        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
            logger.info("sei nel catch di rifiuta completamento tesi" + ex.getErrorCode());
            success = false;
        }

    }

    public ArrayList<Tesi> elencaTesiDocente(String idRelatore) {

        /*
         *   return: elenco tesi associati al prof
         */
        ArrayList<Tesi> elencoTesi = new ArrayList<Tesi>();
        try {
            Statement aStatement = db.createStatement();
            Tesi T;

            String queryCercaTesi = "SELECT * FROM relatori_tesi, tesi WHERE relatori_tesi.ID_Tesi=tesi.ID AND relatori_tesi.ID_Docente='" + idRelatore + "'";

            ResultSet res;
            res = aStatement.executeQuery(queryCercaTesi);

            int id_tesi = 0;
            String data_inizio = null;
            String data_fine = null;
            String data_fine_prevista = null;
            String titolo = null;
            String abstractTesi = null;
            String descrizione = null;
            String id_studente = null;
            String stato_tesi = null;
            logger.info("elencaTesiDocente la query non crasha");
            while (res.next()) {

                id_tesi = res.getInt("ID");
                data_inizio = res.getString("Data_Inizio");
                data_fine = res.getString("Data_Fine");
                data_fine_prevista = res.getString("Data_Fine_Prevista");
                titolo = res.getString("Titolo");
                abstractTesi = res.getString("Abstract");
                descrizione = res.getString("Descrizione");
                id_studente = res.getString("ID_Studente");
                stato_tesi = res.getString("Stato_Tesi");

                if (stato_tesi != null) {
                    T = new Tesi(id_tesi, data_inizio, data_fine, data_fine_prevista, titolo, abstractTesi, descrizione, id_studente, stato_tesi);
                    elencoTesi.add(T);

                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class
                    .getName()).log(Level.SEVERE, null, ex);
            logger.info(
                    "la query crasha" + ex.getErrorCode());
        }

        return elencoTesi;

    }

    public Tesi recuperaTesi(int idTesi) {
        Tesi T = null;
        ResultSet rs = null;

        try {
            Statement aStatement = db.createStatement();
            String query = "SELECT * FROM tesi WHERE ID= '" + idTesi + "' ";

            rs = aStatement.executeQuery(query);

            logger.info("Numero di righe: " + rs.getRow());

            int id_tesi = 0;
            String data_inizio = null;
            String data_fine = null;
            String data_fine_prevista = null;
            String titolo = null;
            String abstractTesi = null;
            String descrizione = null;
            String id_studente = null;
            String stato_tesi = null;

            while (rs.next()) {
                id_tesi = rs.getInt("ID");
                data_inizio = rs.getString("Data_Inizio");
                data_fine = rs.getString("Data_Fine");
                data_fine_prevista = rs.getString("Data_Fine_Prevista");
                titolo = rs.getString("Titolo");
                abstractTesi = rs.getString("Abstract");
                descrizione = rs.getString("Descrizione");
                id_studente = rs.getString("ID_Studente");
                stato_tesi = rs.getString("Stato_Tesi");
            }

            if (stato_tesi != null) {
                T = new Tesi(id_tesi, data_inizio, data_fine, data_fine_prevista, titolo, abstractTesi, descrizione, id_studente, stato_tesi);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class
                    .getName()).log(Level.SEVERE, null, ex);
            logger.info(
                    "sono nel carch" + ex.getErrorCode());
        }
        return T;
    }

    public boolean inAttesaConferma(int idTesi) throws SQLException {

        Statement aStatement = db.createStatement();

        String queryStatoTesi = "SELECT stato_tesi FROM tesi WHERE ID='" + idTesi + "'";
        ResultSet res = aStatement.executeQuery(queryStatoTesi);

        return res.getInt("stato_tesi") == 0;

    }

    public boolean inAttesaCompletamento(int idTesi) throws SQLException {

        Statement aStatement = db.createStatement();

        String queryStatoTesi = "SELECT stato_tesi FROM tesi WHERE ID='" + idTesi + "'";
        ResultSet res = aStatement.executeQuery(queryStatoTesi);

        return res.getInt("stato_tesi") == 2;

    }

    public void rifiutaTesi(int idTesi) throws SQLException {

        try {
            Statement aStatement = db.createStatement();

            String rifiuta = "DELETE FROM tesi WHERE ID=" + idTesi;
            aStatement.executeUpdate(rifiuta);

        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
            logger.info("sei nel catch" + ex.getErrorCode());
        }

    }

}
