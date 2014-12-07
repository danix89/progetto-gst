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

        ResultSet res;
        try {
            Statement aStatement = db.createStatement();
            String queryNuovoEvento = "INSERT INTO `db_distra`.`cronologia` ( `Testo`, `ID_Docente`, `ID_Studente`) "
                    + "VALUES ('" + crono.getTesto() + "', '" + crono.getId_docente() + "', '" + crono.getId_studente();
            res=aStatement.executeQuery(queryNuovoEvento);
            
        } catch (SQLException ex) {
            logger.info("query fallita: "+ex.getMessage());
            Logger.getLogger(ManagerCronologia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
