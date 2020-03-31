package be.ifosup.dishe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_dishe_edit", urlPatterns = {"/edit-dishe"})
public class Servlet_dishe_edit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Servlet_dishe_edit] Méthode GET appelée");
        request.setCharacterEncoding("UTF-8");

        String DisID = request.getParameter("DisheID");
        String DisName = request.getParameter("DisheName");
        String DisDesc = request.getParameter("DisheDesc");
        String DisPrice = request.getParameter("DishePrice");

        if ( DisID != null ) {
            // Suppresion d'un plat
            try {
                if ( DisheDAO.EditDishe( DisID,DisName,DisDesc,DisPrice ) ) System.out.println("[Servlet_dishe_edit] Édition du plat effectué");
                else System.out.println("[Servlet_dishe_edit] Erreur d'édition) du plat");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //redirection
        System.out.println("[Servlet_dishe_edit] Envoi de la redirection");
        response.sendRedirect("home");

    }
}
