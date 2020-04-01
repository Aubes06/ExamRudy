package be.ifosup.member;

import be.ifosup.dishe.DisheDAO;
import be.ifosup.dishe.DisheService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet_member_list", urlPatterns = {"/member"})
public class Servlet_member_list extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("email");

        if ( email != null ) {
            response.sendRedirect("member");
        } else {
            response.sendRedirect("login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Necéssaires pour renvoyé la liste des différentes categories dans le menu déroulant
            HttpSession session = request.getSession(true);
            String email = (String) session.getAttribute("email");

            if ( email != null ) {
                MemberService members = new MemberDAO().getMembers();

                request.setAttribute("members",members.recupMembers());
                request.setAttribute("user_email",email);

                request.getRequestDispatcher("/views/member.jsp").forward(request,response);
            } else response.sendRedirect("login");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
