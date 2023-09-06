<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="paginaErro.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Excluir Cliente</title>
</head>
<body>
	<jsp:useBean id="clienteBean" class="pessoas.Cliente" scope="request"/>
	<jsp:setProperty property="idCliente" name="clienteBean" param="idCliente"/>
	
	<%if(clienteBean.delete(clienteBean)>0){
		%>
		<jsp:forward page="listPessoas.jsp"/>
		<%
	}else{
		out.println("<br/>Erro ao excluir cliente!");
		out.println("<br/><a href=listarClientes.jsp> Voltar para a lista </a>");
	}
		%>
	
</body>
</html>