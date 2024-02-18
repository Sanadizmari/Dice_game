import java.util.Random;

/** 
 * The Die class represents a standard six-sided die
 * that can be rolled and have
 * its face value set or retrieved.
 */
public class Die {
    private int faceValue; // instance variable of dice
    private final int MAX = 6; // maximum variable of dice

    /**
     * Creates a new Die object and rolls it.
     */
    public Die() {
        roll(); // to roll the dice
    }

    /**
     * Rolls the die and sets its face value to a random number between 1 and 6.
     */
    public void roll() {
        Random rand = new Random();
        faceValue = rand.nextInt(MAX) + 1;
    }

    /**
     * Sets the face value of the die to the specified value.
     * 
     * @param value the value to set the face value of the die to
     */
    public void setFaceValue(int value) {
        faceValue = value;
    }

    /**
     * Returns the face value of the die.
     * 
     * @return the face value of the die
     */
    public int getFaceValue() {
        return faceValue;
    }

    /**
     * Returns a string representation of the die's face value.
     * 
     * @return a string representation of the die's face value
     */
    public String toString() {
        return " " + faceValue;
    }

    /**
     * Compares this die to another die to see if they have the same face value.
     * 
     * @param other the other die to compare to
     * @return true if the two dice have the same face value, false otherwise
     */
    public boolean equals(Die other) {
        return faceValue == other.getFaceValue();
    }
}
