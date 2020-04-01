package be.ifosup.dishe;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet_dishe_edit", urlPatterns = {"/edit-dishe"})
public class Servlet_dishe_edit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Servlet_dishe_edit] Méthode POST appelée");
        request.setCharacterEncoding("UTF-8");

        // Initiation des variables à laquel on viendra initier les parametre POS correspondant
        String id = null;
        String label = null;
        String description = null;
        String price = null;
        String category = null;

        // Recupération de la variable du répertoire Web Local
        ServletContext servletContext = getServletContext();
        String contextPath = servletContext.getRealPath(File.separator);


        String fieldvalue = null;
        String fieldname = null;
        String filename = null;
        String file_extension = null;
        InputStream filecontent = null;

        // Routine qui ajoute l'image
        try {
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

            for (FileItem item : items) {
                if (item.isFormField()) {
                    // Traiter les champs classiques ici (input type="text|radio|checkbox|etc", select, etc).
                    fieldname = item.getFieldName();
                    fieldvalue = item.getString("UTF-8");

                    // Matching des attributs intéressants
                    if ( fieldname.equals("DisheID")  ) id = fieldvalue;
                    if ( fieldname.equals("DisheName") ) label = fieldvalue;
                    if ( fieldname.equals("DisheDesc") ) description = fieldvalue;
                    if ( fieldname.equals("DishePrice") ) price = fieldvalue;
                    if ( fieldname.equals("DisheCategory") ) category = fieldvalue;

                } else {

                    // Traiter les champs de type fichier (input type="file").
                    filename = FilenameUtils.getName(item.getName());
                    filecontent = item.getInputStream();
                    file_extension = FilenameUtils.getExtension(filename);
                }
            }

            try {
                // Ajout d'un plat dans la base de donnée
                if ( DisheDAO.EditDishe( id,label,description,price,category ) ) {
                    System.out.println("[Servlet_dishe_edit] Modification d'un plat éffectué");

                    System.out.println(id+" : "+filename+" > "+contextPath);
                    if ( id != null && file_extension != null )
                        Files.copy(filecontent, Paths.get(contextPath+"\\img\\dishes\\"+id+"."+file_extension), new StandardCopyOption[]{StandardCopyOption.REPLACE_EXISTING});
                }
                else System.out.println("[Servlet_dishe_edit] Erreur de l'ajout d'un plat");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (FileUploadException e) {
            throw new ServletException("Échec de l'analyse de la requête multipart.", e);
        }


        // Redirection vers notre accueil (la carte)
        System.out.println("[Servlet_dishe_add] Envoi de la redirection");
        response.sendRedirect("home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("email");

        if ( email != null ) {
            response.sendRedirect("home");
        } else {
            response.sendRedirect("login");
        }
    }
}
