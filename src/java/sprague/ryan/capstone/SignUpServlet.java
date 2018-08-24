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
@WebServlet(name = "SignUpServlet", urlPatterns = {"/signup"})
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserManager userManager = (UserManager)getServletContext().getAttribute("userManager");
        System.out.println("userManager is " + userManager + " in the signup servlet.");
        
        String firstName = request.getParameter("fName");
        String lastName = request.getParameter("lName");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        System.out.println("Password is " + password + " in signup servlet.");
        System.out.println("Confirm password is " + confirmPassword + " in signup servlet.");
        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "password fields do not match.");
            request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
        } else if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            request.setAttribute("error", "one or more of the fields is empty.");
            request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
        } else {
            User user = new User(firstName, lastName, email, username, password);
            System.out.println("Salt is " + user.getSalt() + " in sign up servlet.");
            userManager.addUser(user);
            request.getSession().setAttribute("user", userManager.userByLogin(user.getUserName()));
            response.sendRedirect("/home");
        }
    }
}
