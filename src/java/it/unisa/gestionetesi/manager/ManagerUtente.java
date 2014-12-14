/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionetesi.manager;

import it.unisa.gestionetesi.db.ConnectionDB;
import it.unisa.model.Account;
import it.unisa.model.Person;
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
 * @author CosimoAlessandro
 */
public class ManagerUtente {

    private Logger logger = Logger.getLogger("db");
    private ConnectionDB aConnection;
    private Connection db;
    private Statement tesiStatement;

    public ManagerUtente() throws ClassNotFoundException, SQLException, IOException, InstantiationException, IllegalAccessException {
        aConnection = new ConnectionDB("root", "");
        db = aConnection.getConnection();
    }

    public Person selezionaUtente(String ssn, String tipo) {
        Person persona = new Person();

        ResultSet rs = null;

        try {
            Statement aStatement = db.createStatement();
            String query = "SELECT * FROM person JOIN account ON person.Account_email=account.email WHERE person.SSN= '" + ssn + "' AND account.typeOfAccount= '" + tipo + "' ";

            rs = aStatement.executeQuery(query);

            logger.info("Numero di righe PERSONA: " + rs.getRow());

            while (rs.next()) {
                persona.setSsn(rs.getString("SSN"));
                persona.setAddress(rs.getString("address"));
                persona.setCitizenship(rs.getString("citizenship"));
                persona.setCity(rs.getString("city"));
                persona.setCycle(rs.getInt("cycle"));
                persona.setGender(rs.getString("gender"));
                persona.setMatricula(rs.getString("matricula"));
                persona.setName(rs.getString("name"));
                persona.setPhone(rs.getString("phone"));
                persona.setPosition(rs.getString("position"));
                persona.setSurname(rs.getString("surname"));
                persona.setUniversity(rs.getString("university"));
                persona.setWebPage(rs.getString("web_page"));
                persona.setZipCode(rs.getString("zip_code"));
                persona.setDepartmentAbbreviation(rs.getString("Department_abbreviation"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
            logger.info("sono nel carch" + ex.getErrorCode());
        }
        return persona;
    }

    public Account selezionaAccount(String email) {
        Account account = new Account();

        ResultSet rs = null;

        try {
            Statement aStatement = db.createStatement();
            String query = "SELECT * FROM account WHERE email='" + email + "'";

            rs = aStatement.executeQuery(query);

            logger.info("Numero di righe ACCOUNT: " + rs.getRow());

            while (rs.next()) {
                account.setTyperOfAccount(rs.getString("typeOfAccount"));
                account.setEmail(rs.getString("email"));
                account.setActive(rs.getBoolean("active"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ManagerTesi.class.getName()).log(Level.SEVERE, null, ex);
            logger.info("sono nel carch" + ex.getErrorCode());
        }

        return account;

    }

    public ArrayList<Person> listaUtenti(String posizione) {
        
        Person persona= new Person();
        ResultSet rs = null;
        ArrayList<Person> listaUtenti=null;
        try {
            
            listaUtenti = new ArrayList<Person>();
            
            Statement aStatement = db.createStatement();
            String query = "SELECT * FROM person,account WHERE account.email=person.Account_email AND account.typeOfAccount='" + posizione + "'";
            
            rs = aStatement.executeQuery(query);
            
            while(rs.next()){
                persona.setSsn(rs.getString("SSN"));
                persona.setAddress(rs.getString("address"));
                persona.setCitizenship(rs.getString("citizenship"));
                persona.setCity(rs.getString("city"));
                persona.setCycle(rs.getInt("cycle"));
                persona.setGender(rs.getString("gender"));
                persona.setMatricula(rs.getString("matricula"));
                persona.setName(rs.getString("name"));
                persona.setPhone(rs.getString("phone"));
                persona.setPosition(rs.getString("position"));
                persona.setSurname(rs.getString("surname"));
                persona.setUniversity(rs.getString("university"));
                persona.setWebPage(rs.getString("web_page"));
                persona.setZipCode(rs.getString("zip_code"));
                persona.setDepartmentAbbreviation(rs.getString("Department_abbreviation"));
                
                listaUtenti.add(persona);
   
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerUtente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                    
            return listaUtenti;
    }

}
