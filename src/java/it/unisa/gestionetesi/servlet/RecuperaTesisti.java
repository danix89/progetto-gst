/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionetesi.servlet;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import it.unisa.gestionetesi.beans.Tesi;
import it.unisa.gestionetesi.manager.ManagerTesi;
import it.unisa.gestionetesi.manager.ManagerUtente;
import it.unisa.model.Person;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonArray;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Damiano
 */
public class RecuperaTesisti extends HttpServlet {

    private ManagerTesi manager_tesi;
    private ManagerUtente manager_utente;
    private Person person;
    private ArrayList<Tesi> lista_tesi;
    private int lista_tesi_size = 0;
    private JSONArray jarray;
    private JSONObject tesi_data;
    private String id_stud;
    private String descr;
    private String[] nome_cognome;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws org.json.JSONException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, JSONException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String id_docente = request.getParameter("id_docente");
            manager_tesi = new ManagerTesi();
            manager_utente = new ManagerUtente();

            lista_tesi = manager_tesi.elencaTesiDocente(id_docente);

            jarray = new JSONArray();

            lista_tesi_size = lista_tesi.size();

            nome_cognome = new String[lista_tesi_size];
            
            System.out.print("lista_tesi_size: "+lista_tesi_size);

            for (int i = 0; i < lista_tesi_size; i++) {

                person = new Person();
                person = manager_utente.selezionaUtente(lista_tesi.get(i).getId_studente(), "studente");

                nome_cognome[i] = person.getName();
                System.out.print("Nome_cognome di i: "+i+nome_cognome[i]);

                tesi_data = new JSONObject();

                tesi_data.put("size", lista_tesi_size);
                tesi_data.put("id_studente", nome_cognome[i]);
                tesi_data.put("descrizione", lista_tesi.get(i).getDescrizione());

                jarray.put(i, tesi_data);
            }

            JSONObject mainObj = new JSONObject();
            mainObj.put("mainOb", jarray);

            out.print(mainObj.toString());

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RecuperaTesisti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RecuperaTesisti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RecuperaTesisti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RecuperaTesisti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(RecuperaTesisti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RecuperaTesisti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RecuperaTesisti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RecuperaTesisti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RecuperaTesisti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(RecuperaTesisti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
