package be.ifosup.member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_member_del", urlPatterns = {"/del-member"})
public class Servlet_member_del extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Servlet_member_del] Méthode GET appelée");
        request.setCharacterEncoding("UTF-8");

        String UseID = request.getParameter("UseID");

        if ( UseID != null ) {
            // Suppresion d'une catégorie
            try {
                if ( MemberDAO.delMember( UseID ) ) System.out.println("[Servlet_member_del] Suppresion d'un membre éffectué");
                else System.out.println("[Servlet_member_del] Erreur d'un membre de la catégorie");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //redirection
        System.out.println("[Servlet_member_del] Envoi de la redirection");
        response.sendRedirect("member");

    }
}
