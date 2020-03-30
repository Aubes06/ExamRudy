package be.ifosup.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletLogin", urlPatterns = {"/login"})
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //récupérer les deux champs du formulaire
        String email = request.getParameter("email");
        String password= request.getParameter("password");
        //vérification
        try {
            if (LoginDAO.valid(email,password)){
                request.getSession().setAttribute("email",email);
                System.out.println("OK");
                response.sendRedirect("todo");
            }else{
                request.setAttribute("errorMessage","Adresse e-mail et/ou mot de passe incorrecte !");
                request.getRequestDispatcher("/views/login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/login.jsp").forward(request,response);
    }
}
