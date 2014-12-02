<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bacheca <% out.println(" Nome"); %></title>
</head>
<body>
    
    
<%@ include file="studente/informazioniStudente.jsp" %>

<hr>

<%@ include file="studente/tesiStudente.jsp" %>
<a href="./Test">Test Servlet!</a>

</body>
</html>