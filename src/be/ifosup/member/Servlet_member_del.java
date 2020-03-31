package be.ifosup.member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_member_del" , urlPatterns = {"/delmember"})

public class Servlet_member_del extends HttpServlet {

    private MemberService memberService = new MemberService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // appeler la méthode supprime
        memberService.supprime(new Member(request.getParameter("nom"),request.getParameter("email") ));

        // redirection
        response.sendRedirect("member");
    }
}