package be.ifosup.home;

import be.ifosup.dishe.DisheDAO;
import be.ifosup.dishe.DisheService;
import be.ifosup.login.LoginDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletHome", urlPatterns = {"/home"})
public class ServletHome extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[ServletHome] Méthode GET appelée");

        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("email");
        String search = request.getParameter("search");

        if ( email != null ) {
            //au cas ou le mail existe
            try {
                System.out.println("[ServletHome] Appel de DisheDAO");
                DisheService dishes_categories = new DisheDAO().getDishesCategories();
                request.setAttribute("dishes_categories",dishes_categories.getDishes());
                request.setAttribute("email",email);

                System.out.println("[ServletHome] Appel de de la vue");
                request.getRequestDispatcher("/views/home.jsp").forward(request,response);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("login");
        }
    }
}
