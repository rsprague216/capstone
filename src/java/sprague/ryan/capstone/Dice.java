package sprague.ryan.capstone;

/**
 * @author Ryan Sprague
 */
public class Dice {
    private final int sides;
    private int result;
    
    public Dice(int sides) {
        this.sides = sides;
    }
    
    public int getResult() {
        return this.result;
    }
    
    public  void roll() {
        this.result = rollDie();
    }
    
    private int rollDie(){
        return (int)(1 + Math.random() * sides);
    }
}
