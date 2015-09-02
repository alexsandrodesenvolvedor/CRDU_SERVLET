<%@page import="dao.ClienteDao"%>
<%@page import="java.util.List"%>
<%@page import="model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina principal</title>
</head>
<body>
	<a href="cadastroCliente.jsp">Cadastrar cliente</a>
	<%
		ClienteDao dao = new ClienteDao();
		List<Cliente> clientes = dao.listar();
	%>

	<table border="1" rules="all">

		<tr>
			<td>Nome</td>
			<td>Cpf</td>
			<td></td>
		</tr>


		<%
			for (int i = 0; i < clientes.size(); i++) {
				Cliente cliente = clientes.get(i);
		%>
		<tr>
			<td><%=cliente.getNome()%>
			<td><%=cliente.getCpf()%>
			<td><a href="alterarCadastro.jsp?cpf=<%=cliente.getCpf()%>">Atualizar</a></td>
			<td><a href="removerCliente.jsp?cpf=<%=cliente.getCpf()%>">Remover</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>