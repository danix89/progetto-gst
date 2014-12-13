/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionetesi.servlet;

import it.unisa.gestionetesi.beans.Tesi;
import it.unisa.gestionetesi.manager.ManagerTesi;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ciro
 */
public class accettaTesi extends HttpServlet {

    private ManagerTesi manager_tesi;
    private Tesi T = null;
    private int id_tesi;
    private int stato_tesi;

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
            throws ServletException, IOException, ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String accetta_tesi = request.getParameter("accetta");
            String rifiuta_tesi = request.getParameter("rifiuta");

            manager_tesi = new ManagerTesi();

            if (accetta_tesi != null) {

                id_tesi = Integer.parseInt(accetta_tesi);
                T = manager_tesi.recuperaTesi(id_tesi);
                stato_tesi = Integer.parseInt(T.getStato_tesi());

                if (stato_tesi == 0) {
                    manager_tesi.accettaTesi(id_tesi);
                }

                if (stato_tesi == 2) {
                    manager_tesi.accettaCompletamentoTesi(id_tesi);
                }
            }

            if (rifiuta_tesi != null) {
                id_tesi = Integer.parseInt(rifiuta_tesi);
                T = manager_tesi.recuperaTesi(id_tesi);
                stato_tesi = Integer.parseInt(T.getStato_tesi());

                if (stato_tesi == 0) {
                    manager_tesi.rifiutaTesi(id_tesi);
                }
                if (stato_tesi == 2) {
                    manager_tesi.rifiutaCompletamentoTesi(id_tesi);
                }
            }

            response.sendRedirect("gestioneTesi.jsp");

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
            Logger.getLogger(accettaTesi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(accettaTesi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(accettaTesi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(accettaTesi.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(accettaTesi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(accettaTesi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(accettaTesi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(accettaTesi.class.getName()).log(Level.SEVERE, null, ex);
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
