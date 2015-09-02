package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;

import model.Cliente;

/**
 * Servlet implementation class cadastro
 */
@WebServlet("/cadastro")
public class cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		Cliente cliente = new Cliente();
		cliente.setNome(nome);

		ClienteDao dao = new ClienteDao();
		String retorno = dao.salvar(cliente);
		if (retorno.equals("sucesso")) {
			response.sendRedirect("index.jsp");
		} else {
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<h1> Erro ao tentar salvar cliente!</h1>");
			out.print("<br>");
			out.print("<a href='index.jsp'>Voltar</a>");
			out.print("</html>");
		}
	}

}
