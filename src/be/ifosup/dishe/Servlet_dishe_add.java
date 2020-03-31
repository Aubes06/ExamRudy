package be.ifosup.dishe;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet_dishe_add", urlPatterns = {"/add-dishe"})
public class Servlet_dishe_add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Servlet_dishe_add] Méthode POST appelée");
        request.setCharacterEncoding("UTF-8");


        // Recuperation des champs
        //String label = request.getParameter("DisLabel");
        //String description = request.getParameter("DisDescription");
        //String price = request.getParameter("DisPrice");
        //String category = request.getParameter("DisCategory");
        //System.out.println("[Servlet_dishe_add] Récupération des champs terminée");
        String label = null;
        String description = null;
        String price = null;
        String category = null;

        ServletContext servletContext = getServletContext();
        String contextPath = servletContext.getRealPath(File.separator);
        PrintWriter out = response.getWriter();
        System.out.println("<br/>File system context path (in TestServlet): " + contextPath);

        String path = System.getenv("CATALINA_HOME");
        System.out.println(System.getProperty("catalina.base"));
        System.out.println(path);

        String fieldvalue = null;
        String fieldname = null;
        String filename = null;
        String file_extension = null;
        InputStream filecontent = null;

        // File Gestion

        try {
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

            for (FileItem item : items) {
                if (item.isFormField()) {

                    // Traiter les champs classiques ici (input type="text|radio|checkbox|etc", select, etc).
                    fieldname = item.getFieldName();
                    fieldvalue = item.getString();
                    //System.out.println(fieldname+" : "+fieldvalue);


                    if ( fieldname.equals("DisLabel")  ) label = fieldvalue;
                    if ( fieldname.equals("DisDescription") ) description = fieldvalue;
                    if ( fieldname.equals("DisPrice") ) price = fieldvalue;
                    if ( fieldname.equals("DisCategory") ) category = fieldvalue;

                } else {

                    // Traiter les champs de type fichier (input type="file").

                    fieldname = item.getFieldName();
                    filename = FilenameUtils.getName(item.getName());
                    filecontent = item.getInputStream();
                    file_extension = FilenameUtils.getExtension(filename);
                }


            }


            // End of File Gestion



            // ajout d'un dishe
            try {
                System.out.println("Label : "+label);
                System.out.println("description : "+description);
                System.out.println("price : "+price);
                System.out.println("category : "+category);
                if ( DisheDAO.addDishe( label, description, price, category ) ) {
                    System.out.println("[ServletDishe] Ajout d'un plat éffectué");
                    String DisID = DisheDAO.getDisheByLabel(label);
                    if ( DisID != null && file_extension != null )
                        Files.copy(filecontent, Paths.get(contextPath+"\\img\\dishes\\"+DisID+"."+file_extension), new StandardCopyOption[]{StandardCopyOption.REPLACE_EXISTING});
                }
                else System.out.println("[Servlet_dishe_add] Erreur de l'ajout d'un plat");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (FileUploadException e) {
            throw new ServletException("Échec de l'analyse de la requête multipart.", e);
        }


        //redirection
        System.out.println("[Servlet_dishe_add] Envoi de la redirection");
        response.sendRedirect("home");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
