package sprague.ryan.capstone;

/**
 * @author Ryan Sprague
 */
public class LevelManager {
    private final int[] levels = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    private String[] abilities = new String[20];
    
    public LevelManager() {
        System.out.println("length is " + abilities.length);
        for (int index = 0; index < levels.length; index++) {
            if (index == 3 || index == 7 || index == 11 || index == 15 || index == 18) {
                abilities[index] = "ability score improvement";
            } else {
                abilities[index] = "new skill";
            }
        }
    }
    
    public String levelUp(int level) { return abilities[level - 1]; }
}
