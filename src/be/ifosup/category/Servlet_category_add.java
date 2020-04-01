package be.ifosup.category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_category_add", urlPatterns = {"/add-category"})
public class Servlet_category_add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Servlet_category_add] Méthode POST appelée");
        request.setCharacterEncoding("UTF-8");

        // Récuperation des champs des formulaires html
        String label = request.getParameter("CatLabel");
        System.out.println("[Servlet_category_add] Récupération des champs terminée");

        // Vérification de l'existance des paramètres POST : CatID & CarName
        if ( label != null ) {
            // Création d'une nouvelle categorie dans la base de donnée
            try {
                if ( CategoryDAO.addCategory( label ) ) System.out.println("[Servlet_category_add] Ajout d'une categorie éffectué");
                else System.out.println("[Servlet_category_add] Erreur de l'ajout d'une catégorie");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Redirection vers notre accueil (la carte)
        System.out.println("[Servlet_category_add] Envoi de la redirection");
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
