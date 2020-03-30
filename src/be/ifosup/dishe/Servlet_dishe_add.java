package be.ifosup.dishe;

import be.ifosup.todo.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_dishe_add", urlPatterns = {"/add-dishe"})
public class Servlet_dishe_add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Servlet_dishe_add] Méthode POST appelée");
        request.setCharacterEncoding("UTF-8");

        // Recuperation des champs
        String label = request.getParameter("DisLabel");
        String description = request.getParameter("DisDescription");
        String price = request.getParameter("DisPrice");
        String category = request.getParameter("DisCategory");
        System.out.println("[Servlet_dishe_add] Récupération des champs terminée");

        // ajout d'un dishe
        try {
            if ( DisheDAO.addDishe( label, description, price, category ) ) System.out.println("[ServletDishe] Ajout d'un plat éffectué");
            else System.out.println("[Servlet_dishe_add] Erreur de l'ajout d'un plat");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //redirection
        System.out.println("[Servlet_dishe_add] Envoi de la redirection");
        response.sendRedirect("home");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
