

<%@page import="it.unisa.model.Person"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cronologia <% out.println(" Nome"); %></title>
    </head>
    <body>



        <%

            String toacc = (String) session.getAttribute("typeOfAccount");

            boolean isStudent = toacc.equals("studente");
            boolean isProfessor = toacc.equals("professore");

            if (isStudent) {
        %>
        <%@ include file="studente/cronologiaStudente.jsp" %>
        <%
            }
            if (isProfessor) {
        %>
        <%@ include file="professore/cronologiaDocente.jsp" %>
        <%
            }
        %>

    </body>
</html>