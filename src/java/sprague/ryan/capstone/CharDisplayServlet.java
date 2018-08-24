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
@WebServlet(name = "CharDisplayServlet", urlPatterns = {"/chardisplay"})
public class CharDisplayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Character myChar;
        String name = request.getParameter("charName");
        request.getSession().setAttribute("charName", name);
        CharacterManager characterManager = (CharacterManager)getServletContext().getAttribute("characterManager");
        System.out.println("Character Manager is " + characterManager);
        myChar = characterManager.getCharacter(name);
        if (myChar != null) {
            request.setAttribute("myChar", myChar);
            System.out.println("myChar is " + myChar + "in the home servlet.");
            System.out.println("alignment is " + myChar.getAlignment());
        }
        
        
        request.getRequestDispatcher("/WEB-INF/chardisplay.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
