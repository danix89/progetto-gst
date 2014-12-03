<%-- 
    Document   : test
    Created on : 2-dic-2014, 23.44.25
    Author     : Damiano
--%>


<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SELECT Operation</title>
    </head>
    <body>

        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost/DB_Gestione_Tesi"
                           user="root"  password=""/>

        <sql:query dataSource="${snapshot}" var="result">
            SELECT * from Student;
        </sql:query>

        <table border="1" width="100%">
            <tr>
                <th>Matricola</th>
                <th>Email</th>
            </tr>
            <c:forEach var="row" items="${result.rows}">
                <tr>
                    <td><c:out value="${row.matricola}"/></td>
                    <td><c:out value="${row.universityEmail}"/></td>

                </tr>
            </c:forEach>
        </table>

    </body>
</html>