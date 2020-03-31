package be.ifosup.category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_category_edit", urlPatterns = {"/edit-category"})
public class Servlet_category_edit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Servlet_category_edit] Méthode GET appelée");
        request.setCharacterEncoding("UTF-8");

        String CatID = request.getParameter("CatID");
        String CatName = request.getParameter("CatName");

        if ( CatID != null && CatName != null ) {
            // Edit nom catégorie
            try {
                if ( CategoryDAO.EditCat( CatID,CatName ) ) System.out.println("[Servlet_category_edit] Edition nom catégorie effectué");
                else System.out.println("[Servlet_category_edit] Erreur d'édition nom catégorie");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //redirection
        System.out.println("[Servlet_category_del] Envoi de la redirection");
        response.sendRedirect("home");

    }
}
