package be.ifosup.dishe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_dishe_del", urlPatterns = {"/del-dishe"})
public class Servlet_dishe_del extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("email");

        if ( email != null ) {
            System.out.println("[Servlet_dishe_del] Méthode GET appelée");
            request.setCharacterEncoding("UTF-8");

            String DisID = request.getParameter("DisID");

            if ( DisID != null ) {
                try {
                    if ( DisheDAO.delDishe( DisID ) ) System.out.println("[Servlet_dishe_del] Suppresion d'un plat éffectué");
                    else System.out.println("[Servlet_dishe_del] Erreur de la suppresion du plat");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Redirection vers notre accueil (la carte)
            System.out.println("[Servlet_dishe_del] Envoi de la redirection");
            response.sendRedirect("home");
        }  else {
            response.sendRedirect("login");
        }

    }
}
