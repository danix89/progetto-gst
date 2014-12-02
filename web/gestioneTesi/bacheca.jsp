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
            int statoStudente = 0;          // '0' stato iniziale, '1' richiesta inviata, '2' tesi in corso, '3' tesi completata 
            boolean isStudente = true;
            boolean isProfessore = !isStudente;

            if (isStudente) {
        %>
        <%@ include file="studente/informazioniStudente.jsp" %>
        <hr>
        <%
            if (statoStudente == 0) {
        %>         
        <%@ include file="studente/tesiStudente.jsp" %>          
        <%
            }
            if (statoStudente == 1) {
        %>  
        <!-- includere la pagina corrispondente alla richiesta inviata -->
        <%
            }
            if (statoStudente == 2) {
        %>  
        <!-- includere la pagina corrispondente alla tesi in corso  -->
        <%
            }
            if (statoStudente == 3) {
        %>  
        <!-- includere la pagina corrispondente alla tesi completata  -->
        <%
                }
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