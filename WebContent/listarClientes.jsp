<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page errorPage="paginaErro.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Clientes</title>
</head>
<body>
<jsp:useBean id="clienteBean" class="pessoas.Cliente" scope="request"/>
<%
	List<Cliente> lista=clienteBean.listAll();
	request.setAttribute("lista", lista);
%>
<table border="1">
	<c:forEach var="cliente" items="${lista}">
<tr>
<td>${cliente.getNome()}</td>
<td>${cliente.getEndereco()}</td>
<td>${cliente.getTelefone()}</td>
<td>${cliente.getCpf()}</td>
<td><a href="excluirCliente.jsp?idCliente=${cliente.getIdCliente()}">Excluir</a></td>
<td><a href="editarCliente.jsp?idCliente=${cliente.getIdCliente()}">Editar</a></td>
</table>
</body>
</html>