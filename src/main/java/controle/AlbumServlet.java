package controle;

import modelo.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import sun.security.pkcs11.wrapper.Constants;

@WebServlet(urlPatterns="/albuns")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class AlbumServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        AlbumDAO albumDAOClasse = AlbumDAOClasse.getInstance();
        List<Album> albums = albumDAOClasse.listarAlbuns();

        try {
            req.setAttribute("albuns", albums);
            req.getRequestDispatcher("albuns.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //todo: fazer listagem de álbuns
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        if(ServletFileUpload.isMultipartContent(req)){

            String titulo = req.getParameter("titulo");
            String autor = req.getParameter("autor");
            boolean publicado = Boolean.parseBoolean(req.getParameter("publicado"));

            Album album = new Album(titulo, autor, publicado);

            String uploadPath = getServletContext().getRealPath("") + File.separator + "Imagens";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdir();



            try {
                List<String> fotos = new ArrayList<String>();
                for (Part part : req.getParts()) {
                    if (part.getContentType() != null){
                        String fileName = getFileName(part);
                        fotos.add(fileName);
                        System.out.println(fileName);
                        part.write(uploadPath + File.separator + fileName);
                    }

                }
                album.setFotos(fotos);

                AlbumDAO albumDAO = AlbumDAOClasse.getInstance();
                albumDAO.criarAlbum(album);

                req.setAttribute("albuns", albumDAO.listarAlbuns());
                req.getRequestDispatcher("albuns.jsp").forward(req, resp);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }

	}

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "Default";
    }
}
