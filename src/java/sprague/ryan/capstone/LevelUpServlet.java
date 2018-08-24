package sprague.ryan.capstone;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ryan  Sprague
 */
@WebServlet(name = "LevelUpServlet", urlPatterns = {"/level_up"})
public class LevelUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/home");
        }
        // gain hit die
        // check what feature is given at new level.
        // if ability score, let user pick which stats to increase.
        // if skill display message saying what new skill(s) user gets, and choose if necessary.
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        CharacterManager characterManager = (CharacterManager)getServletContext().getAttribute("characterManager");
        System.out.println("characterManager is " + characterManager + " in the level up servlet.");
        
        SkillManager skillManager = (SkillManager)getServletContext().getAttribute("skillManager");
        System.out.println("Skill manager is " + skillManager + " in the level up servlet." );
        
        CharSkillManager charSkillManager = (CharSkillManager)getServletContext().getAttribute("charSkillManager");
        System.out.println("charSkillManager is " + charSkillManager + " in the level up servlet.");
        
        CharClassManager charClassManager = (CharClassManager)getServletContext().getAttribute("charClassManager");
        
        
        LevelManager levelManager = new LevelManager();
        String name = (String)request.getSession().getAttribute("charName");
        
        Character myChar = (Character)request.getSession().getAttribute("character");
        System.out.println("myChar is " + myChar + " in the level up servlet.");
        CharacterClass charClass = null;
        
        List<CharacterClass> charClassesList = charClassManager.allClassesForChar(myChar.getId());
        if (charClassesList.size() == 1) {
            charClass = charClassesList.get(0);
        } else {
            charClass = charClassManager.classByNameAndId(myChar.getCharClass(), myChar.getId());
        }
        
        
        
        System.out.println("Hit die sides is " + myChar.getHitDiceSides() + " in level up servlet before level up.");
        
        
        
        LevelUp.levelUp(myChar, charClass);
        
        System.out.println("Name: " + myChar.getName() + "; Level: " + myChar.getLevel());
        
        System.out.println("Hit dice sides is " + myChar.getHitDiceSides() + " in level up servlet after level up.");
        
        characterManager.updateChar(myChar);
        charClassManager.updateClass(charClass);
        
        Skill skillArray[] = skillManager.getSkill(myChar.getCharClass(), myChar.getLevel());
        LevelUp.getSkillsForLevel(skillArray, myChar, charSkillManager);
        
        int newLevel = myChar.getLevel();
        if (newLevel == 4 || newLevel == 8 || newLevel == 12 || newLevel == 16 || newLevel == 19) {
            request.getSession().setAttribute("levelChar", myChar);
            response.sendRedirect("improvestats");
        } else {
            response.sendRedirect("/characterlist/info?id=" + myChar.getId());
            //response.sendRedirect("home?charName=" + java.net.URLEncoder.encode(myChar.getName(), "UTF-8"));
        }
    }
}
