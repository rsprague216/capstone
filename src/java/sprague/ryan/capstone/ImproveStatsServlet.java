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
@WebServlet(name = "ImproveStatsServlet", urlPatterns = {"/improvestats"})
public class ImproveStatsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        
        if (user == null) {
            response.sendRedirect("/home");
        } else {
            CharacterManager characterManager = (CharacterManager)getServletContext().getAttribute("characterManager");
            System.out.println("characterManager is " + characterManager + " in improve stat servlet.");
            
            SkillManager skillManager = (SkillManager)getServletContext().getAttribute("skillManager");
            
            CharSkillManager charSkillManager = (CharSkillManager)getServletContext().getAttribute("charSkillManager");
            
            Character myChar = (Character)request.getSession().getAttribute("character");
            System.out.println("character is " + myChar + " in improve stats servlet.");


            String stat1 = (String)request.getSession().getAttribute("stat1");
            String stat2 = (String)request.getSession().getAttribute("stat2");
            System.out.println("stat1: " + stat1);
            System.out.println("stat2: " + stat2);

            switch (stat1) {
                case "str": myChar.incrementStrength(); break;
                case "dex": myChar.incrementDexterity(); break;
                case "con": myChar.incrementConstitution(); break;
                case "int": myChar.incrementIntelligence(); break;
                case "wis": myChar.incrementWisdom(); break;
                case "chr": myChar.incrementCharisma(); break;
                default: break;
            }

            switch (stat2) {
                case "str": myChar.incrementStrength(); break;
                case "dex": myChar.incrementDexterity(); break;
                case "con": myChar.incrementConstitution(); break;
                case "int": myChar.incrementIntelligence(); break;
                case "wis": myChar.incrementWisdom(); break;
                case "chr": myChar.incrementCharisma(); break;
                default: break;
            }

            LevelUp.levelUp(myChar);
            
            Skill skillArray[] = skillManager.getSkill(myChar.getCharClass(), myChar.getLevel());
            LevelUp.getSkillsForLevel(skillArray, myChar, charSkillManager);

            characterManager.updateChar(myChar);

            response.sendRedirect("/resettodetails");
            //response.sendRedirect("home?charName=" + java.net.URLEncoder.encode(myChar.getName(), "UTF-8"));

            //request.getRequestDispatcher("/WEB-INF/improveStats.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
