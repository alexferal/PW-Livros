package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Livro;
import modelo.LivroDAOBD;
import modelo.LivroDAOClasse;

@WebServlet(urlPatterns="/livros")
public class LivroServlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    	//LivroDAOClasse livroDAO = new LivroDAOClasse();
    	//List<Livro> livros = livroDAO.listarLivros();

		LivroDAOBD livroDAO = new LivroDAOBD();
		List<Livro> livros = livroDAO.buscarPorAutor(req.getParameter("autor"));
    	try {
    		req.setAttribute("livros", livros);
			req.getRequestDispatcher("livros.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
