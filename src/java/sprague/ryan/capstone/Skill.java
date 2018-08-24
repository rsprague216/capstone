package sprague.ryan.capstone;

/**
 * @author Ryan Sprague
 */
public class Skill {
    private int charId, id;
    private final String name, effect, charClass, path;
    private final int level;
    
    public Skill(String name, String path, String effect, String charClass, int level) {
        this.name = name;
        this.path = path;
        this.effect = effect;
        this.charClass = charClass;
        this.level = level;
    }
    
    public Skill(int id, String name, String path, String effect, String charClass, int level, int charId) {
        this.id = id;
        this.charId = charId;
        this.name = name;
        this.path = path;
        this.effect = effect;
        this.charClass = charClass;
        this.level = level;
    }
    
//    public void setSkillName(String name)       { this.name = name; }
//    public void setSkillEffect(String effect)   { this.effect = effect; }
//    public void setSkillClass(String charClass) { this.charClass = charClass; }
//    public void setSkillLevel(int level)        { this.level = level; }
    
    public int    getId()          { return this.id; }
    public int    getCharId()      { return this.charId; }
    public String getSkillName()   { return this.name; }
    public String getSkillPath()   { return this.path; }
    public String getSkillEffect() { return this.effect; }
    public String getSkillClass()  { return this.charClass; }
    public int    getSkillLevel()  { return this.level; }
}
