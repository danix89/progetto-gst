package it.unisa.gestionetesi.db;


import java.io.IOException;
import java.sql.*;

public class ConnectionDB {

    Connection db;
    String user;
    String password;
    String TABLE;
    String componentsTable;

    public ConnectionDB(String user, String password) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        this.user = user;
        this.password = password;
        // carico il driver JDBC
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        // mi connetto al database con i dati inseriti nel main
        // la password può non essere necessaria
        db = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "db_distra" + "?user=" + user + "&password=" + password);

        // connesso.. se niente è andato storto!
       
    }
    
    public Connection getConnection(){
        return db;
    }

}
