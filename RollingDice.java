/**
 * The RollingDice class is a simple program that rolls a single six-sided die
 * and prints the result.
 */
public class RollingDice {
    /**
     * main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        Die die = new Die(); // My object
        System.out.println("Initial face value of die: " + die.getFaceValue()); // testing my dice
        System.out.println("----------------------------------------------------------------");
        die.roll();
        System.out.println("After rolling dice: " + die.getFaceValue()); // result after rolling the dice
        System.out.println("----------------------------------------------------------------");
    }
}
