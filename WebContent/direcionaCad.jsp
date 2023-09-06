<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="pessoas.Cliente"%>
<%@page errorPage="paginaErro.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Direciona Cadastro</title>
</head>
<body>
	<jsp:useBean id="clienteBean" class="pessoas.Cliente" scope="request"/>
	<jsp:setProperty name="clienteBean" property="*" />
	<%
		if(clienteBean.insert()>0){
	%>
	<jsp:forward page="cadSucesso.jsp"/>
	<%
		} else {
			%>
	<jsp:forward page="cadErro.jsp"/>
		<%}%>
</body>
</html>