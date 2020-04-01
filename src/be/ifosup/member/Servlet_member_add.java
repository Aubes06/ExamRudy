package be.ifosup.member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_member_add", urlPatterns = {"/add-member"})
public class Servlet_member_add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Servlet_member_add] Méthode POST appelée");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("email");

        if ( email != null ) {
            // Recuperation des champs
            String name = request.getParameter("UseName");
            String email_param = request.getParameter("UseEmail");
            String password = request.getParameter("UsePassword");
            System.out.println("[Servlet_member_add] Récupération des champs terminée");


            try {
                if ( MemberDAO.addMember( email, email_param, password) ) System.out.println("[Servlet_member_add] Ajout d'un membre éffectué");
                else System.out.println("[Servlet_member_add] Erreur de l'ajout d'un membre");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //redirection
            System.out.println("[Servlet_member_add] Envoi de la redirection");
            response.sendRedirect("member");
        } else {
            response.sendRedirect("login");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("email");

        if ( email != null ) {
            response.sendRedirect("member");
        } else {
            response.sendRedirect("login");
        }
    }
}
