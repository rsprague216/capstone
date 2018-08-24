package sprague.ryan.capstone;

/**
 * @author Ryan Sprague
 */
public class LevelUp {
    static public void levelUp(Character character) {
        System.out.println("Character level is " + character.getLevel() + " in level up class.");
        if (character.getLevel() < 20) {
            character.setLevel(character.getLevel() + 1);
            character.addHitDie();
        } else {
            // level doesn't increase, should return a message
        }
    }
    
    static public void levelUp(Character character, CharacterClass charClass) {
        if (charClass.getClassLevel() < 20) {
            charClass.setClassLevel(charClass.getClassLevel() + 1);
            character.addHitDie(charClass);
        } else {
            // level doesn't increase
        }
    }
    
    static public void getSkillsForLevel(Skill[] skillArray, Character myChar, CharSkillManager manager) {
        int skillIndex = 0;
        System.out.println("Hey, I'm trying to add some skills!");
        System.out.println("CharID is " + myChar.getId() + " in level up class.");
        while (skillIndex < skillArray.length && skillArray[skillIndex] != null) {
            manager.addSkill(skillArray[skillIndex], myChar.getId());
//            myChar.addSkills(skillArray[skillIndex]);
            System.out.println("Hey, I've added some skills!");
            skillIndex++;
        }
    }
    
    static public void getSkillsForLevel(Skill[] skillArray, Character myChar, CharSkillManager skillManager, CharClassManager classManager) {
        int skillIndex = 0;
        System.out.println("Hey, I'm trying to add some skills!");
        System.out.println("CharID is " + myChar.getId() + " in level up class.");
        while (skillIndex < skillArray.length && skillArray[skillIndex] != null) {
            skillManager.addSkill(skillArray[skillIndex], myChar.getId());
//            myChar.addSkills(skillArray[skillIndex]);
            System.out.println("Hey, I've added some skills!");
            skillIndex++;
        }
    }
    
    static public void getSkillsLevelOne(Skill[] skillArray, String name, CharacterManager charManager, CharSkillManager skillManager) {
        int skillIndex = 0;
        Character character = charManager.charByName(name);
        System.out.println("Hey, I'm trying to add some skills!");
        System.out.println("CharID is " + character.getId() + " in level up class.");
        while (skillIndex < skillArray.length && skillArray[skillIndex] != null) {
            skillManager.addSkill(skillArray[skillIndex], character.getId());
            System.out.println("Hey, I've added some skills!");
            skillIndex++;
        }
    }
}
