package controle;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.controladores.Command;
import controle.controladores.CommandException;

@WebServlet(urlPatterns="/frontcontroller")
public class FrontController extends HttpServlet {

	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 doPost(req, resp);
	 }
	 
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 
		 String nomeComando = req.getParameter("comando");
		 System.out.println("Requisição para a página = "+req.getRequestURI());
		 
		 try {
			Command command = (Command) Class.forName("controle.controladores." + nomeComando).newInstance();
			command.execute(req, resp);
		} catch (InstantiationException e) {
			resp.sendError(404);
		} catch (IllegalAccessException e) {
			resp.sendError(401);
		} catch (ClassNotFoundException e) {
			resp.sendError(404);
		} catch (CommandException e) {
			resp.sendError(e.getStatusHttp());
		}
		 
		 
	 }
}
