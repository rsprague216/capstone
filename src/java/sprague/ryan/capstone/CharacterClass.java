package sprague.ryan.capstone;

/**
 * @author rspra
 */
public class CharacterClass {
    private int id, charId, classLevel, hitDieSides;
    private String className, classPath;
    
    // constructor for new Class Object
    public CharacterClass(String className) {
        this.className = className;
        this.classPath = null;
        this.classLevel = 1;
        this.hitDieSides = generateHitDieSides(className);
    }
    
    // constructor for getting Object from Database
    public CharacterClass(int id, int charId, String className, String classPath, int classLevel, int hitDieSides) {
        this.id = id;
        this.charId = charId;
        this.className = className;
        this.classPath = classPath;
        this.classLevel = classLevel;
        this.hitDieSides = hitDieSides;
    }
    
    public int    getId()          { return this.id; }
    public int    getCharId()      { return this.charId; }
    public int    getClassLevel()  { return this.classLevel; }
    public int    getHitDieSides() { return this.hitDieSides; }
    public String getClassName()   { return this.className; }
    public String getClassPath()   { return this.classPath; }
    
    public void setId(int id)                   { this.id = id; }
    public void setCharId(int charId)           { this.charId = charId; }
    public void setClassLevel(int classLevel)   { this.classLevel = classLevel; }
    public void setClassName(String className)  { this.className = className; }
    public void setClassPath(String classPath)  { this.classPath = classPath; }
    public void setHitDieSides(int hitDieSides) { this.hitDieSides = hitDieSides; }
    
    
    private int generateHitDieSides(String className) {
        int num;
        switch (className) {
            case "barbarian": num = 12; break;
            case "bard": num = 8; break;
            case "cleric": num = 8; break;
            case "druid": num = 8; break;
            case "fighter": num = 10; break;
            case "monk": num = 8; break;
            case "paladin": num = 10; break;
            case "ranger": num = 10; break;
            case "rogue": num = 8; break;
            case "sorcerer": num = 6; break;
            case "warlock": num = 8; break;
            case "wizard": num = 6; break;
            default: num = 6; break;
        }
        return num;
    }
}
