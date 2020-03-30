package be.ifosup.dishe;

import be.ifosup.todo.Todo;

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
        System.out.println("[ServletDishe] Méthode POST appelée");
        request.setCharacterEncoding("UTF-8");

        // Recuperation des champs
        String label = request.getParameter("DisLabel");
        String description = request.getParameter("DisDescription");
        String price = request.getParameter("DisPrice");
        String category = request.getParameter("DisCategory");
        System.out.println("[ServletDishe] Récupération des champs terminée");

        // ajout d'un dishe
        try {
            if ( DisheDAO.addDishe( label, description, price, category ) ) System.out.println("[ServletDishe] Ajout d'un plat éffectué");
            else System.out.println("[ServletDishe] Erreur de l'ajout d'un plat");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //redirection
        System.out.println("[ServletDishe] Envoi de la redirection");
        response.sendRedirect("home");

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
