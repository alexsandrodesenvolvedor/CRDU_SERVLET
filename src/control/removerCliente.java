package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;

/**
 * Servlet implementation class removerCliente
 */
@WebServlet("/removerCliente")
public class removerCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int cpf = Integer.parseInt(request.getParameter("cpf"));

		ClienteDao dao = new ClienteDao();
		String retorno = dao.remover(cpf);
		if (retorno.equals("sucesso")) {
			response.sendRedirect("index.jsp");
		} else {
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<h1> Erro ao tentar remover cliente!</h1>");
			out.print("<br>");
			out.print("<a href='index.jsp'>Voltar</a>");
			out.print("</html>");
		}
	}

}
