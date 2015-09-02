<%@page import="model.Cliente"%>
<%@page import="dao.ClienteDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualizar cadastro de cliente</title>
</head>
<body>
	<%
		int cpf = Integer.parseInt(request.getParameter("cpf"));
		ClienteDao dao= new ClienteDao();
		Cliente cliente = dao.selecionar(cpf);
%>
	<form action='atualizarCliente' method="post">
		Nome: <input type="text" name="nome" value="<%=cliente.getNome() %>">
		<input type="hidden" name="cpf" value="<%=cliente.getCpf() %>">
		<input type="submit" value="Atualizar">
	</form>
	<a href="index.jsp">Voltar</a>
</body>
</html>