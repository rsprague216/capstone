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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserManager userManager = (UserManager)getServletContext().getAttribute("userManager");
        System.out.println("userManager is " + userManager + " in the login servlet.");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = userManager.userByLogin(username);
        
        if (user != null){
            System.out.println("User pulled in " + user + " from the database in the login servlet.");
            System.out.println(user.getUserName() + " | " + user.getHashedPassword() + " | " + user.getSalt()[0] + " | " + user.getID());
            System.out.println("Password is " + password + "in login servlet.");
            if (user.checkPassword(password)/*user.getName().equals(username)*/) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/home");
            } else {
                user = null;
                request.setAttribute("error", "Username and password do not match.");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "The username you entered does not exist in our database.");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
