package be.ifosup.member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletTodo_supprime" , urlPatterns = {"/supTodo"})

public class Servlet_member_del {

    private MemberService memberService = new MemberService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // appeler la méthode supprime
        memberService.supprime(new Member(request.getParameter("nom"),request.getParameter("email") ));

        // redirection
        response.sendRedirect("todo");
    }
}