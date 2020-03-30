package be.ifosup.category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_category_del", urlPatterns = {"/del-category"})
public class Servlet_category_del extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Servlet_category_del] Méthode GET appelée");
        request.setCharacterEncoding("UTF-8");

        String CatID = request.getParameter("CatID");

        if ( CatID != null ) {
            // Suppresion d'une catégorie
            try {
                if ( CategoryDAO.delCategory( CatID ) ) System.out.println("[Servlet_category_del] Suppresion d'une catégorie éffectué");
                else System.out.println("[Servlet_category_del] Erreur de la suppresion de la catégorie");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //redirection
        System.out.println("[Servlet_category_del] Envoi de la redirection");
        response.sendRedirect("home");

    }
}
