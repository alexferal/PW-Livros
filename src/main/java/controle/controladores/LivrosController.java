package controle.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Livro;
import modelo.LivroDAO;
import modelo.fabrica.DAOFactory;
import modelo.fabrica.DAOFactoryImpl;

public class LivrosController implements Command {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		DAOFactory daoFactory = new DAOFactoryImpl();
		LivroDAO livroDAO = daoFactory.criarLivroDAO("Classe");
    	List<Livro> livros = livroDAO.listarLivros();
    	try {
    		request.setAttribute("livros", livros);
    		request.getRequestDispatcher("livros.jsp").forward(request, response);
		} catch (ServletException e) {
			throw new CommandException(e.getMessage(), 400);
		} catch (IOException e) {
			throw new CommandException(e.getMessage(), 500);
		}
	}

}
