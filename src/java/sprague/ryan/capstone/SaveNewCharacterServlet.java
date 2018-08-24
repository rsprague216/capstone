
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
@WebServlet(name = "SaveNewCharacterServlet", urlPatterns = {"/savenewchar"})
public class SaveNewCharacterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SkillManager skillManager = (SkillManager)getServletContext().getAttribute("skillManager");
        System.out.println("skillManager is " + skillManager + " in the save character servlet.");
        
        CharacterManager characterManager = (CharacterManager)getServletContext().getAttribute("characterManager");
        System.out.println("characterManager is " + characterManager + " in the save character servlet.");
        
        CharSkillManager charSkillManager = (CharSkillManager)getServletContext().getAttribute("charSkillManager");
        System.out.println("charSkillManager is " + charSkillManager + " in the save character servlet.");
        
        User user = (User)request.getSession().getAttribute("user");
        System.out.println("User loaded as " + user + " in the save character servlet.");
        
        CharClassManager charClassManager = (CharClassManager)getServletContext().getAttribute("charClassManager");
        System.out.println("CharClass manager is " + charClassManager + " in save new character servlet.");
        
        Character newChar = (Character)request.getSession().getAttribute("character");
        System.out.println("newChar is " + newChar + " in the save character servlet.");
        
        String charClass = newChar.getCharClass(),
               race = newChar.getRace();
        int hitDieSides;
        
        int strength = newChar.getStrength();
        int dexterity = newChar.getDexterity();
        int constitution = newChar.getConstitution();
        int intelligence = newChar.getIntelligence();
        int wisdom = newChar.getWisdom();
        int charisma = newChar.getCharisma();
        
        switch (charClass) {
            case "barbarian": hitDieSides = 12; break;
            case "bard": hitDieSides = 8; break;
            case "cleric": hitDieSides = 8; break;
            case "druid": hitDieSides = 8; break;
            case "fighter": hitDieSides = 10; break;
            case "monk": hitDieSides = 8; break;
            case "paladin": hitDieSides = 10; break;
            case "ranger": hitDieSides = 10; break;
            case "rogue": hitDieSides = 8; break;
            case "sorcerer": hitDieSides = 6; break;
            case "warlock": hitDieSides = 8; break;
            case "wizard": hitDieSides = 6; break;
            default: hitDieSides = 6; break;
        }
        
        switch (race) {
            case "dwarf": constitution += 2; break;
            case "elf": dexterity += 2; break;
            case "halfling": dexterity += 2; break;
            case "human": strength++;
                            dexterity++;
                            constitution++;
                            intelligence++;
                            wisdom++;
                            charisma++;
                            break;
            case "dragonborn": strength += 2; charisma++; break;
            case "gnome": intelligence += 2; break;
            case "half-elf": charisma += 2; /*choose two scores to increase*/ break;
            case "half-orc": strength += 2; constitution++; break;
            case "tiefling": intelligence++; charisma += 2; break;
            default: break;
        }
        
        newChar.setStrength(strength);
        newChar.setDexterity(dexterity);
        newChar.setConstitution(constitution);
        newChar.setIntelligence(intelligence);
        newChar.setWisdom(wisdom);
        newChar.setCharisma(charisma);
        newChar.setHitDieSides(hitDieSides);
        newChar.setHitPoints(hitDieSides);
        
        System.out.println("Hit die sides is " + newChar.getHitDiceSides() + " in save new character servlet.");
        
        characterManager.addCharacter(newChar, user.getID());
        
        Skill skillArray[] = skillManager.getSkill(newChar.getCharClass(), newChar.getLevel());
        LevelUp.getSkillsLevelOne(skillArray, newChar.getName(), characterManager, charSkillManager);
        
        newChar = characterManager.charByName(newChar.getName());
        charClassManager.addCharClass(new CharacterClass(newChar.getCharClass()), newChar.getId());
        
        response.sendRedirect("/newchar");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
