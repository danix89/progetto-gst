/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionetesi.servlet;

import it.unisa.gestionetesi.beans.Cronologia;
import it.unisa.gestionetesi.manager.ManagerCronologia;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ciro
 */
public class RecuperaCronologiaStudente extends HttpServlet {

    Logger logger = Logger.getLogger("RecuperaCronologiaStud");
    ManagerCronologia managerCronologia;

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
            throws ServletException, IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
            logger.info("SERVLET PRENDE ID STUDENTE");
            String id_studente = request.getParameter("id_studente");

            managerCronologia = new ManagerCronologia();
            ArrayList<Cronologia> listaNotifiche = managerCronologia.elencaEventiStudente(id_studente);

            JSONObject dati_cronologia = new JSONObject();
            JSONArray array_dati = new JSONArray();
            
            for(int i=0;i<listaNotifiche.size();i++){
            
            dati_cronologia.put("ID", listaNotifiche.get(i).getId_cronologia());
            dati_cronologia.put("testo", listaNotifiche.get(i).getTesto());
            dati_cronologia.put("ID_Studente", listaNotifiche.get(i).getId_studente());
            dati_cronologia.put("ID_Docente", listaNotifiche.get(i).getId_docente());
            dati_cronologia.put("Data_Notifica", listaNotifiche.get(i).getData_notifica());
            array_dati.put(i, dati_cronologia);
            
            }
            
            logger.info("SERVLET PASSA I DATI");

            //     session.setAttribute("ID_Studente", listaNotifiche[0].getId_studente());
            out.print(array_dati.toString());

        } catch (JSONException ex) {
            logger.info("FALLIMENTO JSON: " + ex.getMessage());
            Logger.getLogger(RecuperaCronologiaStudente.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RecuperaCronologiaStudente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RecuperaCronologiaStudente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RecuperaCronologiaStudente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RecuperaCronologiaStudente.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RecuperaCronologiaStudente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RecuperaCronologiaStudente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RecuperaCronologiaStudente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RecuperaCronologiaStudente.class.getName()).log(Level.SEVERE, null, ex);
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
