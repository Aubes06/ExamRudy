package be.ifosup.home;

import be.ifosup.category.CategoryDAO;
import be.ifosup.category.CategoryService;
import be.ifosup.dishe.DisheDAO;
import be.ifosup.dishe.DisheService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletHome", urlPatterns = {"","/home"})
public class ServletHome extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println("[ServletDishe] Méthode GET appelée");

            System.out.println("[ServletDishe] Appel de DisheDAO");
            DisheService dishes_categories = new DisheDAO().getDishesCategories();
            request.setAttribute("dishes_categories",dishes_categories.getDishes());

            System.out.println("[ServletDishe] Appel de de la vue");
            request.getRequestDispatcher("/views/home.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
