/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionetesi.manager;

import it.unisa.gestionetesi.beans.Allegati;
import it.unisa.gestionetesi.beans.Tag;
import it.unisa.gestionetesi.beans.Tesi;
import it.unisa.integrazione.database.DBConnection;
import it.unisa.integrazione.manager.concrete.ConcreteFisicPerson;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Damiano
 */
public class ManagerTesi {
    
    private Connection aConnection;
    
    public ManagerTesi() throws ClassNotFoundException, SQLException, IOException {
        aConnection = DBConnection.connect();
    }
    
      public void inserisciTesiQuery(Tesi T) throws ClassNotFoundException, SQLException, IOException {
        aConnection = DBConnection.connect();
        Tesi tesi = T;
        Statement aStatement = aConnection.createStatement();
        String query =  "INSERT INTO `tesi`(`"+tesi.getData_inizio()+"`, `"+tesi.getData_fine()+"`, `"+tesi.getData_fine_prevista()+"`, `"+tesi.getTitolo()+"`, `"+tesi.getAbstract_tesi()+"`, `"+tesi.getDescrizione()+"`, `"+tesi.getId_studente()+"`, `"+tesi.getStato_tesi()+"`) "
                + "VALUES ([`Data_Inizio`],[`Data_Fine`],[`Data_Fine_Prevista`],[`Titolo`],[`Abstract`],[`Descrizione`],[`ID_Studente`],[`Stato_Tesi`])";
        aStatement.executeQuery(query);
        aConnection.close();
    }
      
      public void inserisciTagQuery(Tag t) throws ClassNotFoundException, SQLException, IOException{
           aConnection = DBConnection.connect();
        Statement aStatement = aConnection.createStatement();
        String query =  "INSERT INTO `Tag`(`"+t.getNomeTag()+") VALUES ([`Nome`])";
        aStatement.executeQuery(query);
        aConnection.close();
      }
    
    public void inserisciAllegatiQuery(Allegati al) throws ClassNotFoundException, SQLException, IOException{
           aConnection = DBConnection.connect();
        Statement aStatement = aConnection.createStatement();
        String query =  "INSERT INTO `Allegato`(`"+al.getLinkOggetto()+"`, `"+al.getIdTesi()+"`, `"+al.getStato()+"`) VALUES ([`Oggetto`],[`ID_Tesi`],[`Stato`])";
        aStatement.executeQuery(query);
        aConnection.close();
      }
    
    public void inserisciTagTesiQuery(Allegati al) throws ClassNotFoundException, SQLException, IOException{
           aConnection = DBConnection.connect();
        Statement aStatement = aConnection.createStatement();
    //      va fatto in modo atomico con l'inserimento dei tag
    //    aStatement.executeQuery(query);
        aConnection.close();
      }
    
}
