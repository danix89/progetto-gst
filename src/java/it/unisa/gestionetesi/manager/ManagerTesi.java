/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionetesi.manager;

import it.unisa.gestionetesi.db.ConnectionDB;
import it.unisa.gestionetesi.beans.Allegati;
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

/**
 *
 * @author Damiano
 */
public class ManagerTesi {

    private ConnectionDB aConnection;
    private Connection db;

    public ManagerTesi() throws ClassNotFoundException, SQLException, IOException, InstantiationException, IllegalAccessException {
        aConnection = new ConnectionDB("root", "");
        db = aConnection.getConnection();
    }

    public void inserisciTesiQuery(Tesi T) throws ClassNotFoundException, SQLException, IOException {

        Tesi tesi = T;
        Statement aStatement = db.createStatement();
        String query = "INSERT INTO `tesi`(Data_Inizio, Data_Fine, Data_Fine_Prevista, Titolo, Abstract, Descrizione, ID_Studente, Stato_Tesi)" 
                + "VALUES ('"+tesi.getData_inizio()+"','"+tesi.getData_fine()+"','"+tesi.getData_fine_prevista()+"','"+tesi.getTitolo()+"','"+tesi.getAbstract_tesi()+"','"+tesi.getDescrizione()+"','"+tesi.getId_studente()+"','"+tesi.getStato_tesi()+"')";
        aStatement.executeQuery(query);
    }

    public int ultimaTesiInserita() throws SQLException, ClassNotFoundException, IOException {

        Statement aStatement = db.createStatement();
        ResultSet rs = aStatement.executeQuery("select last_insert_id() as last_id from tesi");
        int ultimaTesiInserita = rs.getInt("last_id");

        return ultimaTesiInserita;
    }

    public void inserisciTagQuery(Tag t) throws ClassNotFoundException, SQLException, IOException {
        
        Statement aStatement = db.createStatement();
        String query = "INSERT INTO `Tag`(`" + t.getNomeTag() + ") VALUES ([`Nome`])";
        aStatement.executeQuery(query);
        
    }

    public void inserisciAllegatiQuery(Allegati al) throws ClassNotFoundException, SQLException, IOException {
        
        Statement aStatement = db.createStatement();
        String query = "INSERT INTO `Allegato`(`" + al.getLinkOggetto() + "`, `" + al.getIdTesi() + "`, `" + al.getStato() + "`) VALUES ([`Oggetto`],[`ID_Tesi`],[`Stato`])";
        aStatement.executeQuery(query);
       
    }

    public void inserisciTagTesiQuery(Allegati al) throws ClassNotFoundException, SQLException, IOException {
        
        Statement aStatement = db.createStatement();
    //      va fatto in modo atomico con l'inserimento dei tag
        //    aStatement.executeQuery(query);
      
    }

}
