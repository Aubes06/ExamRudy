package be.ifosup.member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_member_add", urlPatterns = {"/memberAdd"})

public class Servlet_member_add extends HttpServlet {

    private MemberService memberService = new MemberService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // force l'UTF8
        request.setCharacterEncoding("UTF-8");

        // récupération du champs dans le formulaire
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");

        // ajouter au
        memberService.ajouteMember( new Member(nom, email));

        // redirection avec la méthode get!
        response.sendRedirect("member");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/memberAdd.jsp").forward(request, response);
    }
}