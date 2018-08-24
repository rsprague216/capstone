package sprague.ryan.capstone;

import java.util.ArrayList;
import javax.servlet.http.HttpServlet;

/**
 * @author Ryan Sprague
 */
public class Character {
    
    private int id, strength, dexterity, constitution,
            intelligence, wisdom, charisma, hitDiceSides,
            hitDiceNum, hitPoints, level, initiative, speed, userId;
    private String name, gender, race, charClass, alignment;
    private Dice hitDice;
    private ArrayList<Skill> charSkills = new ArrayList<>();
    
    public Character() {
        this.name = "John Doe";
        this.gender = "male";
        this.race = "human";
        this.charClass = "villager";
        this.alignment = "Chaotic Good";
        this.level = 1;
        this.strength = 10;
        this.dexterity = 10;
        this.constitution = 10;
        this.intelligence = 10;
        this.wisdom = 10;
        this.charisma = 10;
        this.hitDiceNum = 1;
        this.hitPoints = 0;
        this.hitDice = new Dice(4);
        for (int count = 0; count < this.hitDiceNum; count++) {
            hitDice.roll();
            this.hitPoints = hitDice.getResult();
        }
    }
     
    public Character(String name, String gender, String race, String charClass,
            String alignment, int strength, int dexterity, int constitution,
            int intelligence, int wisdom, int charisma, int hitDieSides) {
        this.name = name;
        this.gender = gender;
        this.race = race;
        this.charClass = charClass;
        this.alignment = alignment;
        this.level = 1;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.hitDiceNum = 1;
        this.hitPoints = 0;
    }
    
    public Character(int id, String name, String gender, String race, String charClass,
            String alignment, int level, int strength, int dexterity, int constitution,
            int intelligence, int wisdom, int charisma, int hitDiceNum, int hitDieSides,
            int hitPoints, int userId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.race = race;
        this.charClass = charClass;
        this.alignment = alignment;
        this.level = level;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.hitDiceNum = hitDiceNum;
        this.hitDiceSides = hitDieSides;
        this.hitPoints = hitPoints;
        this.userId = userId;
    }
    
    /**** Setters
     * @param strength ****/
    public void setStrength(int strength)         { this.strength = strength; }
    public void setDexterity(int dexterity)       { this.dexterity = dexterity; }
    public void setConstitution(int constitution) { this.constitution = constitution; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }
    public void setWisdom(int wisdom)             { this.wisdom = wisdom; }
    public void setCharisma(int charisma)         { this.charisma = charisma; }
    public void setLevel(int level)               { this.level = level; }
    public void setHitDieSides(int hitDieSides)   { this.hitDiceSides = hitDieSides; }
    public void setHitPoints(int hitDieSides)     { this.hitDiceSides = hitDieSides;
                                                    this.hitDice = new Dice(hitDieSides);
                                                    this.hitPoints = hitDieSides + getModifier(constitution);
    }
    
    /**** Getters
     * @return  ****/
    public String getName()             { return this.name; }
    public String getGender()           { return this.gender; }
    public String getRace()             { return this.race; }
    public String getCharClass()        { return this.charClass; }
    public String getAlignment()        { return this.alignment; }
    public int    getLevel()            { return this.level; }
    public int    getStrength()         { return this.strength; }
    public int    getDexterity()        { return this.dexterity; }
    public int    getConstitution()     { return this.constitution; }
    public int    getIntelligence()     { return this.intelligence; }
    public int    getWisdom()           { return this.wisdom; }
    public int    getCharisma()         { return this.charisma; }
    public int    getHitPoints()        { return this.hitPoints; }
    public int    getHitDiceSides()     { return this.hitDiceSides; }
    public int    getHitDiceNum()       { return this.hitDiceNum; }
    public int    getModifier(int stat) { return (stat - 10) / 2; }
    public int    getId()               { return this.id; }
    public int    getUserId()           { return this.userId; }
    
    public void incrementStrength()     { this.strength++; }
    public void incrementDexterity()    { this.dexterity++; }
    public void incrementConstitution() { this.constitution++; }
    public void incrementIntelligence() { this.intelligence++; }
    public void incrementWisdom()       { this.wisdom++; }
    public void incrementCharisma()     { this.charisma++; }
    
    public void addHitDie() {
        this.hitDiceNum++;
        this.hitDice = new Dice(this.hitDiceSides);
        this.hitDice.roll();
        this.hitPoints += (this.hitDice.getResult() + getModifier(constitution));
    }
    
    public void addHitDie(CharacterClass charClass) {
        this.hitDiceNum++;
        this.hitDice = new Dice(charClass.getHitDieSides());
        this.hitDice.roll();
        this.hitPoints += (this.hitDice.getResult() + getModifier(constitution));
    }
    
    public ArrayList<Skill> getCharSkills() {
        return charSkills;
    }
    
    public void addSkills(Skill newSkill) {
        this.charSkills.add(newSkill);
    }
    
    public void addSkills(Skill skill1, Skill skill2) {
        this.charSkills.add(skill1);
        this.charSkills.add(skill2);
    }
    
    public static int statRoll() {
        int finalStat = 0, low = 7;
        Dice statDie = new Dice(6);
        int[] statRolls = new int[4];
        for (int roll : statRolls) {
            statDie.roll();
            roll = statDie.getResult();
            if (roll < low) { 
                low = roll;
            }
            finalStat += roll;
        }
        return finalStat - low;
    }
    
//    public static int[] rollForStats() {
//        int[] stats = new int[6];
//        for (int stat : stats) {
//            stat = statRoll();
//        }
//        
//        return stats;
//    }
}
