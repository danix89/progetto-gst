/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionetesi.servlet;

import it.unisa.gestionetesi.manager.ManagerUtente;
import it.unisa.model.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author CosimoAlessandro
 */
public class PopolaSelectProfessori extends HttpServlet {
    private ManagerUtente managerUtente;
    private ArrayList<Person> listaUtenti= null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            managerUtente = new ManagerUtente();
            JSONArray jarrayProfessori = new JSONArray();
            JSONObject utente= new JSONObject();
            String posizione = request.getParameter("posizione");
            
            listaUtenti= managerUtente.listaUtenti(posizione);
            
            for (int i = 0; i < listaUtenti.size(); i++) {
            
            utente.put("codice_fiscale", listaUtenti.get(i).getSsn());
            utente.put("nome", listaUtenti.get(i).getName());
            utente.put("cognome", listaUtenti.get(i).getSurname());
            
            jarrayProfessori.put(utente);
  
            }
            
            JSONObject mainObj = new JSONObject();
            mainObj.put("mainOb", jarrayProfessori);

            out.print(mainObj.toString());

            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PopolaSelectProfessori.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PopolaSelectProfessori.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(PopolaSelectProfessori.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PopolaSelectProfessori.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(PopolaSelectProfessori.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
