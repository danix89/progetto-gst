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
        <div class="panel panel-color panel-danger"><!-- Add class "collapsed" to minimize the panel -->
            <div class="panel-heading">
                <h3 class="panel-title">Informazioni Tesi</h3>

                <div class="panel-options">
                    <a href="#" data-toggle="panel">
                        <span class="collapse-icon">&ndash;</span>
                        <span class="expand-icon">+</span>
                    </a>                  
                </div>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-12 text-center">
                        <p>La tua richiesta è stata inviata<br>resta in attesa della risposta del professore</p>
                    </div>


                </div>
            </div>

        </div>
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