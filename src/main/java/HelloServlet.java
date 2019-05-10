import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    	String id = req.getParameter("id");
    	try {
    		resp.setContentType("text/html");
			resp.getOutputStream().println("<h1>Olá, meu primeiro exemplo de servlet</h1>");
			resp.getOutputStream().println("<p>O id enviado foi "+id+"</p>");
    	} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
}
