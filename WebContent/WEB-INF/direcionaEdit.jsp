<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Direciona Editar</title>
</head>
<body>
	<jsp:useBean id="clienteBean" class="pessoas.Cliente" scope="request"/>
	<jsp:setProperty property="*" name="clienteBean"/>
	<%
	if(clienteBean.update()>0){
	%>
	<jsp:forward page="listarClientes.jsp"/>
	<%}%>
</body>
</html>