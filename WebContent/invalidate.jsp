<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="paginaErro.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Encerrar Sess�o</title>
    </head>
    <body>    
        <%
            session.invalidate();
        %>
        <jsp:forward page = "login.html" /> 
    </body>
</html>
