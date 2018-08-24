package sprague.ryan.capstone;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ryan Sprague
 */
@WebServlet(name = "ImproveStatsToDetailsServlet", urlPatterns = {"/resettodetails"})
public class ImproveStatsToDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/home");
        } else {
            Character myChar = (Character)request.getSession().getAttribute("character");

            request.getSession().setAttribute("stat1", null);
            request.getSession().setAttribute("stat2", null);
            response.sendRedirect("characterlist/info?id=" + myChar.getId());
        }
    }
}
