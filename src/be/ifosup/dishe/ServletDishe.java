package be.ifosup.dishe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletDishe", urlPatterns = {"/dishe"})
public class ServletDishe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Necéssaires pour renvoyé la liste des différentes categories dans le menu déroulant
            DisheService dishes = new DisheDAO().getDishes();
            request.setAttribute("dishes",dishes.getDishes());

            String DisID = request.getParameter("id");
            System.out.println(DisID);
            if ( DisID != null ) {
                DisheService dishe = new DisheDAO().getDishe(DisID);
                request.setAttribute("DisID",DisID);
                request.setAttribute("dishe",dishe.getDishes());
                request.getRequestDispatcher("/views/dishes/dishe.jsp").forward(request,response);
            } else {
                request.getRequestDispatcher("/views/dishes/dishes.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
