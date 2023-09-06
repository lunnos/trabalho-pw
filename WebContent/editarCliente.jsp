<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="paginaErro.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Cliente</title>
</head>
<body>
	<jsp:useBean id="clienteBean" class="pessoas.Cliente" scope="request"/>
	<jsp:setProperty property="idCliente" name="clienteBean" param="idCliente"/>
	
	<%
	Cliente c = clienteBean.findByID();
	String id = String.valueOf(clienteBean.getIdCliente());
	%>
	<h1>Editar Cliente</h1>
	<form method="POST" action="direcionaEdit.jsp">
		<input type="hidden" name="idPessoa" value <%=id%>"/>
		Nome:<input type="text" name="nome" value="<%=c.getNome()%>"/>
		Endereço: <input type="text" name="endereco" value="<%=c.getEndereco()%>"/>
		Telefone: <input type="text" name="telefone" value="<%=c.getTelefone()%>"/>
		CPF: <input type="text" name="cpf" value="<%=c.getCpf()%>"/>
		<input type="submit" value="OK">
		<input type="reset" value="Limpar">		
	</form>
</body>
</html>