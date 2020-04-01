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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Servlet_category_edit] Méthode GET appelée");
        request.setCharacterEncoding("UTF-8");

        // Récuperation des champs des formulaires html
        String CatID = request.getParameter("CatID");
        String CatName = request.getParameter("CatName");

        // Vérification de l'existance des paramètres POST : CatID & CarName
        if ( CatID != null && CatName != null ) {
            // Appel de la méthode qui avec les paramètres va UPDATE le champs de la base de donnée
            try {
                if ( CategoryDAO.EditCat( CatID,CatName ) ) System.out.println("[Servlet_category_edit] Edition nom catégorie effectué");
                else System.out.println("[Servlet_category_edit] Erreur d'édition nom catégorie");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Redirection vers notre accueil (la carte)
        System.out.println("[Servlet_category_del] Envoi de la redirection");
        response.sendRedirect("home");
    }
}
