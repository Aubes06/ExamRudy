package be.ifosup.member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_member_list", urlPatterns = {"/member"})

public class Servlet_member_list  extends HttpServlet{

    // création d'une instance de todoService
    private MemberService memberService = new MemberService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // récupérer les Todos
        request.setAttribute("members", MemberService.recupMembers());
        // afficher la page
        request.getRequestDispatcher("/views/member.jsp").forward(request, response);
    }
}
