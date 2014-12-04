<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Bacheca <% out.println(" Nome"); %></title>
    </head>
    <body>

        <%
            int statoStudente = -1;          // '-1' stato iniziale, '0' richiesta inviata, '1' tesi in corso, '2' tesi completata, '3' tesi archiviata 
            boolean isStudente = true;
            boolean isProfessore = !isStudente;

            if (isStudente) {
        %>
        <%@ include file="studente/informazioniStudente.jsp" %>
        <hr>
        <%@ include file="studente/tesiStudente.jsp" %>          
        <%
            }

            if (isProfessore) {
        %>

        <%@ include file="professore/informazioniProfessore.jsp" %>
        <hr>
        <%@ include file="professore/listaTesisti.jsp" %>

        <%
            }
        %>

        <a href="./Test">Test Servlet!</a>

    </body>
</html>