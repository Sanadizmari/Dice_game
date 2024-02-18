/**
 * The PairOfDice class represents a pair of six-sided dice that can be rolled
 * and have their face values set or retrieved.
 */
public class PairOfDice {
    private Die die1;
    private Die die2;

    /**
     * Creates a new PairOfDice object with two dice that are rolled.
     */
    public PairOfDice() {
        die1 = new Die();
        die2 = new Die();
    }

    /**
     * Rolls both dice.
     */
    public void roll() {
        die1.roll();
        die2.roll();
    }

    /**
     * Returns the sum of the face values of both dice.
     * 
     * @return the sum of the face values of both dice
     */
    public int getDiceSum() {
        return die1.getFaceValue() + die2.getFaceValue();
    }

    /**
     * 
     * Returns the face value of the first die.
     * 
     * @return the face value of the first die
     */
    public Die getDie1() {
        return new Die(die1);
    }

    /**
     * 
     * Sets the face value of the first die to the specified value.
     * 
     * @param value the value to set the face value of the first die to
     */
    public void setDie1(Die die1) {
        this.die1 = new Die(die1);
    }

    /**
     * 
     * Returns the face value of the second die.
     * 
     * @return the face value of the second die
     */
    public Die getDie2() {
        return new Die(die2);
    }

    /**
     * 
     * Sets the face value of the second die to the specified value.
     * 
     * @param value the value to set the face value of the second die to
     */
    public void setDie2(Die die2) {
        this.die2 = new Die(die2);
    }

    /**
     * 
     * Returns a string representation of the face values of both dice.
     * 
     * @return a string representation of the face values of both dice
     */
    public String toString() {
        return die1.getFaceValue() + " " + die2.getFaceValue();
    }

    /**
     * 
     * Compares this pair of dice to another pair of dice to see if they have the
     * same face values.
     * 
     * @param other the other pair of dice to compare to
     * @return true if the two pairs of dice have the same face values, false
     *         otherwise
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PairOfDice other = (PairOfDice) obj;
        if (!(die1.equals(other.die1))) {
            return false;
        }
        return die2.equals(other.die2);
    }
}
