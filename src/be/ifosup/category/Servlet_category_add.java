package be.ifosup.category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_category_add", urlPatterns = {"/add-category"})
public class Servlet_category_add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Servlet_category_add] Méthode POST appelée");
        request.setCharacterEncoding("UTF-8");

        // Recuperation des champs
        String label = request.getParameter("CatLabel");
        System.out.println("[Servlet_category_add] Récupération des champs terminée");

        // File Gestion



        // End of File Gestion



        // ajout d'un dishe
        try {
            if ( CategoryDAO.addCategory( label ) ) System.out.println("[Servlet_category_add] Ajout d'une categorie éffectué");
            else System.out.println("[Servlet_category_add] Erreur de l'ajout d'une catégorie");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //redirection
        System.out.println("[Servlet_category_add] Envoi de la redirection");
        response.sendRedirect("home");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
