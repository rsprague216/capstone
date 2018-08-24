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
@WebServlet(name = "StatRollServlet", urlPatterns = {"/newcharroll2"})
public class StatRollServlet2 extends HttpServlet {

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
        
        Character newChar = (Character)request.getSession().getAttribute("character");
        System.out.println("newChar is " + newChar + " in the stat roll servlet.");
        String charClass = newChar.getCharClass(),
               race = newChar.getRace();
        int strength, dexterity, constitution, intelligence, wisdom, charisma, hitDieSides;
        
        strength = Character.statRoll();
        dexterity = Character.statRoll();
        constitution = Character.statRoll();
        intelligence = Character.statRoll();
        wisdom = Character.statRoll();
        charisma = Character.statRoll();
        
        
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
        
        newChar.setCharisma(charisma);
        newChar.setConstitution(constitution);
        newChar.setDexterity(dexterity);
        newChar.setIntelligence(intelligence);
        newChar.setStrength(strength);
        newChar.setWisdom(wisdom);
        newChar.setHitPoints(hitDieSides);
        
        System.out.println("user id is " + user.getID() + " in the stat roll servlet.");
        characterManager.addCharacter(newChar, user.getID());
        
        Skill skillArray[] = skillManager.getSkill(newChar.getCharClass(), newChar.getLevel());
        LevelUp.getSkillsLevelOne(skillArray, newChar.getName(), characterManager, charSkillManager);
        
        
        
        response.sendRedirect("newchar"/*?charName=" + java.net.URLEncoder.encode(newChar.getName(), "UTF-8")*/);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
