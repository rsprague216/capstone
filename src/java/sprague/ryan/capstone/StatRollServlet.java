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
@WebServlet(name = "StatRollServlet", urlPatterns = {"/newcharroll"})
public class StatRollServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SkillManager skillManager = (SkillManager)getServletContext().getAttribute("skillManager");
        System.out.println("skillManager is " + skillManager + " in the stat roll servlet.");
        
        CharacterManager characterManager = (CharacterManager)getServletContext().getAttribute("characterManager");
        System.out.println("characterManager is " + characterManager + " in the stat roll servlet.");
        
        CharSkillManager charSkillManager = (CharSkillManager)getServletContext().getAttribute("charSkillManager");
        System.out.println("charSkillManager is " + charSkillManager + " in the stat roll servlet.");
        
        User user = (User)request.getSession().getAttribute("user");
        System.out.println("User loaded as " + user + " in the stat roll servlet.");
        
        int[] stats = new int[6];
        for (int stat : stats) {
            stat = Character.statRoll();
        }
        
        request.getSession().setAttribute("statNums", stats);
        
        
        
        response.sendRedirect("newchar"/*?charName=" + java.net.URLEncoder.encode(newChar.getName(), "UTF-8")*/);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
