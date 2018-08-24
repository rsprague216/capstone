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
@WebServlet(name = "CharacterCreatorServlet", urlPatterns = {"/newchar"})
public class CharacterCreatorServlet extends HttpServlet {
    
    int[] statNums = new int[6];
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/home");
        } else {
            for (int i = 0; i < statNums.length; i++) {
                statNums[i] = Character.statRoll();
            }
            request.getSession().setAttribute("statNums", statNums);

            request.getRequestDispatcher("/WEB-INF/characterCreator.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CharacterManager characterManager = (CharacterManager)getServletContext().getAttribute("characterManager");
        System.out.println("characterManager is " + characterManager + " in the character creator servlet.");
        Character newChar;
        String name = request.getParameter("charName");
        String race = request.getParameter("race");
        String gender = request.getParameter("gender");
        String alignment = request.getParameter("alignment");
        String charClass = request.getParameter("charClass");
        System.out.println("alignment is " + alignment + "in the character creator");
        
        int strength = Integer.parseInt(request.getParameter("strStat"));
        int dexterity = Integer.parseInt(request.getParameter("dexStat"));
        int constitution = Integer.parseInt(request.getParameter("conStat"));
        int intelligence = Integer.parseInt(request.getParameter("intStat"));
        int wisdom = Integer.parseInt(request.getParameter("wisStat"));
        int charisma = Integer.parseInt(request.getParameter("chrStat"));
        
        
        
        newChar = new Character(name, gender, race, charClass, alignment, strength, dexterity, constitution, intelligence, wisdom, charisma, 0);
        
        request.getSession().setAttribute("character", newChar);
        
        request.setAttribute("strMod", newChar.getModifier(newChar.getStrength()));
        response.sendRedirect("/savenewchar");
    }
}
