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
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserManager userManager = (UserManager)getServletContext().getAttribute("userManager");
        System.out.println("userManager is " + userManager + " in the home servlet.");
        
        CharacterManager characterManager = (CharacterManager)getServletContext().getAttribute("characterManager");
        System.out.println("characterManager is " + characterManager + " in the home servlet.");
        
        User user = (User)request.getSession().getAttribute("user");
        System.out.println("Logged in as user: " + user);
        if (user != null) {
            characterManager.allCharsFromUser(user.getID());
        }
        
        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
