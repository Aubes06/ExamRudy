package be.ifosup.category;

import be.ifosup.dishe.DisheDAO;
import be.ifosup.dishe.DisheService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletCategory", urlPatterns = {"/category"})
public class ServletCategory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Necéssaires pour renvoyé la liste des différentes categories dans le menu déroulant
            CategoryService categories = new CategoryDAO().getCategories();
            request.setAttribute("categories",categories.getCategories());

            // Necéssaires pour renvoyé la liste des différentes plats dans le menu déroulant
            DisheService dishes = new DisheDAO().getDishes();
            request.setAttribute("dishes",dishes.getDishes());

            String CatID = request.getParameter("id");
            System.out.println(CatID);
            if ( CatID != null ) {
                //request.setAttribute("CatID",CatID);

                CategoryService category = new CategoryDAO().getCategory(CatID);
                request.setAttribute("category",category.getCategories());

                DisheService dishesByCategoryID = new DisheDAO().getDisheByCategoryID(CatID);
                request.setAttribute("dishesByCategoryID",dishesByCategoryID.getDishes());

                request.getRequestDispatcher("/views/categories/category.jsp").forward(request,response);
            } else {
                request.getRequestDispatcher("/views/categories/categories.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
