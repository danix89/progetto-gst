<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cronologia <% out.println(" Nome"); %></title>
    </head>
    <body>

        <%
            boolean isStudent = true;
            boolean isProfessor = !isStudent;

            if (isStudent) {
        %>
        <%@ include file="studente/cronologiaStudente.jsp" %>
        <%
            }
            if (isProfessor) {
        %>
        <!-- Includere la cronolotia del Professore -->
        <%
            }
        %>

    </body>
</html>