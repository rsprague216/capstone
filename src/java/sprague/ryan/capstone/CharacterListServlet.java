package sprague.ryan.capstone;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ryan Sprague
 */
@WebServlet(name = "CharacterListServlet", urlPatterns = {"/characterlist"})
public class CharacterListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");

        
        if (user == null) {
            response.sendRedirect("/home");
        } else {
            System.out.println("user is loaded as " + user + " in the character list servlet.");
            System.out.println("user id is " + user.getID() + " in character list servlet.");
            
            CharacterManager characterManager = (CharacterManager)getServletContext().getAttribute("characterManager");
            System.out.println("characterManager is " + characterManager + " in the character list servlet.");

            request.setAttribute("characters", characterManager.allCharsFromUser(user.getID()));

            request.getRequestDispatcher("/WEB-INF/characterlist.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
