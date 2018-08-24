package sprague.ryan.capstone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ryan Sprague
 */
@WebServlet(name = "CharDetailsServlet", urlPatterns = {"/characterlist/info"})
public class CharDetailsServlet extends HttpServlet {

    protected int idParameter(HttpServletRequest request) {
        return Integer.parseInt(request.getParameter("id"));
    }
    
    protected Character findCharacter(HttpServletRequest request, CharacterManager characterManager) {
        try {
            return characterManager.charByID(idParameter(request));
        } catch(Exception e) {
            return null;
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/home");
        } else {
            CharacterManager characterManager = (CharacterManager)getServletContext().getAttribute("characterManager");
            System.out.println("characterManager is " + characterManager + " in the details servlet.");

            String[] numbers = {
                "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty",
                "Twentyone", "Twentytwo", "Twentythree", "Twentyfour", "Twentyfive", "Twentysix", "Twentyseven", "Twentyeight", "Twentynine", "Thirty",
                "Thirtyone", "Thirtytwo", "Thirtythree", "Thirtyfour", "Thirtyfive", "Thirtysix", "Thirtyseven", "Thirtyeight", "Thirtynine", "Forty"
            };

            CharSkillManager charSkillManager = (CharSkillManager)getServletContext().getAttribute("charSkillManager");
            System.out.println("charSkillManager is " + charSkillManager + " in the char details servlet.");

            CharClassManager charClassManager = (CharClassManager)getServletContext().getAttribute("charClassManager");
            System.out.println("CharClass Manager is " + charClassManager + " in char details servlet.");
            
            Character character = findCharacter(request, characterManager);
            System.out.println("Character is loaded as " + character + " in the details servlet.");
            
            System.out.println("Hit dice sides is " + character.getHitDiceSides() + "in char details servlet.");

            List<CharacterClass> charClassesList = charClassManager.allClassesForChar(character.getId());
            
            
            
            request.setAttribute("charClasses", charClassesList);
            
            request.setAttribute("classNum", "" + charClassesList.size());
            
            CharacterClass[] charClasses = new CharacterClass[charClassesList.size()];
            int classIndex = 0;
            int totalLevel = 0;
            
            for (CharacterClass charClass : charClassesList) {
                charClasses[classIndex] = charClass;
                classIndex++;
                totalLevel += charClass.getClassLevel();
            }
            
            request.setAttribute("totalLevel", totalLevel + "");

            
            if (character.getLevel() == 3 || character.getLevel() == 7 || character.getLevel() == 11 || character.getLevel() == 15 || character.getLevel() == 18) {
                request.setAttribute("level20", null);
                request.setAttribute("improveStats", "non null");
            } else if (character.getCharClass().equals("fighter") && (character.getLevel() == 5 || character.getLevel() == 13)) {
                request.setAttribute("level20", null);
                request.setAttribute("improveStats", "non null");
            } else if (character.getLevel() == 20) {
                request.setAttribute("level20", "not null");
            }else {
                request.setAttribute("level20", null);
                request.setAttribute("improveStats", null);
            }
            List<Skill> charSkills = charSkillManager.allSkillFromCharacter(character.getId());
            
            ArrayList<String> count = new ArrayList<>();
            
            int index = 0;
            for (Skill skill : charSkills) {
                count.add("" + index);
                index++;
            }
            request.setAttribute("countNums", count);
            
            request.getSession().setAttribute("character", character);

            request.setAttribute("charSkills", charSkills);

            System.out.println("id is " + request.getParameter("id") + " in the details servlet.");

            if (character == null) {
                response.sendError(404, "Character Not Found");
            } else {
                request.setAttribute("character", character);
                request.setAttribute("numbers", numbers);

                if(character.getModifier(character.getStrength()) > 0) {
                    request.setAttribute("strMod", "+" + character.getModifier(character.getStrength()));
                } else {
                    request.setAttribute("strMod", character.getModifier(character.getStrength()));
                }

                if(character.getModifier(character.getDexterity()) > 0) {
                    request.setAttribute("dexMod", "+" + character.getModifier(character.getDexterity()));
                } else {
                    request.setAttribute("dexMod", character.getModifier(character.getDexterity()));
                }

                if(character.getModifier(character.getConstitution()) > 0) {
                    request.setAttribute("conMod", "+" + character.getModifier(character.getConstitution()));
                } else {
                    request.setAttribute("conMod", character.getModifier(character.getConstitution()));
                }

                if(character.getModifier(character.getIntelligence()) > 0) {
                    request.setAttribute("intMod", "+" + character.getModifier(character.getIntelligence()));
                } else {
                    request.setAttribute("intMod", character.getModifier(character.getIntelligence()));
                }

                if(character.getModifier(character.getWisdom()) > 0) {
                    request.setAttribute("wisMod", "+" + character.getModifier(character.getWisdom()));
                } else {
                    request.setAttribute("wisMod", character.getModifier(character.getWisdom()));
                }

                if(character.getModifier(character.getCharisma()) > 0) {
                    request.setAttribute("chrMod", "+" + character.getModifier(character.getCharisma()));
                } else {
                    request.setAttribute("chrMod", character.getModifier(character.getCharisma()));
                }


                request.getRequestDispatcher("/WEB-INF/chardetails.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Character character = findCharacter(request, characterManager);
        //System.out.println("Character is loaded as " + character + " in the details servlet.");
        
        String stat1 = request.getParameter("stat1");
        String stat2 = request.getParameter("stat2");
        
        request.getSession().setAttribute("stat1", stat1);
        request.getSession().setAttribute("stat2", stat2);
        //request.getSession().setAttribute("character", character);
        
        response.sendRedirect("/improvestats");
    }
}
