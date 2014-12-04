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

    public void inserisciTesiQuery(Tesi T)  {
        
        try {
            Tesi tesi = T;
            
            tesiStatement = db.createStatement();
            db.setAutoCommit(false);
            String query = "INSERT INTO `tesi`(Descrizione, ID_Studente, Stato_Tesi)"
                    + "VALUES ('"+tesi.getDescrizione()+"', 0, '0')";
            tesiStatement.execute(query, Statement.RETURN_GENERATED_KEYS);
            
            db.commit();
        
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserisciRelatoreTesiQuery(RelatoreTesi rt)  {
        
        try {
            RelatoreTesi relatoreTesi = rt;
            
            Statement aStatement = db.createStatement();
            String query = "INSERT INTO `relatori_tesi`(ID_Tesi, ID_Docente)"
                    + "VALUES ('"+relatoreTesi.getId_tesi()+"', '"+relatoreTesi.getId_docente()+"')";
            aStatement.execute(query);
          
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int ultimaTesiInserita()  {
        
        int ultimaTesiInserita=-1;

        try {

            ResultSet rs = tesiStatement.getGeneratedKeys();
            
            if(rs.next()){
            ultimaTesiInserita = rs.getInt(1);
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
