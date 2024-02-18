import java.util.Scanner;

/**
 * The DiceGame class implements a game where the user plays against the
 * computer to reach a score of 100 points first.
 * The game is played using a pair of dice and there are several rules governing
 * how points are scored and when a turn ends.
 */
public class DiceGame {
    // Initialize a Scanner object to read user input
    static Scanner input = new Scanner(System.in);

    /**
     * The main method is responsible for starting the game and printing out the
     * rules.
     * 
     * @param args command-line arguments, not used in this implementation
     */
    public static void main(String[] args) {
        PairOfDice dice = new PairOfDice(); // Create a pairOfDice Object
        // Print the welcome Message and Rules.
        System.out.println("---------------------------------");
        System.out.println("    Welcome to the Dice Game!");
        System.out.println("---------------------------------");
        System.out.println("you will be playing against computer!\n");
        System.out.println("Rules: \n");
        System.out.println("The first player to get 100 points Wins.\n" +
                "However, if you roll one 1, you lose all point you have accumulated in your turn.\n" +
                "If you roll two 1's you lose all your points. You can turn the dice over at any time.\n " +
                "However, if you roll one or two 1's, you lose your turn.\n" +
                "I (the computer) play by the same rules, \n" +
                "except I'll always turn over the dice when I've rolled 20 or more points in a single turn");
        System.out.println("-----------------------------------------------------------\n");

        DiceTurn(dice); // Calling the 'DiceTurn' Method
    }

    /**
     * The DiceTurn method is responsible for running a single turn of the game,
     * alternating between the player and the computer.
     * 
     * @param dice a PairOfDice object representing the dice to be used in the game
     */
    public static void DiceTurn(PairOfDice dice) {
        int playerScore = 0; // initialize the player score to 0
        int playerTurnScore = 0; // initialize the player turn score to 0
        int computerTurnScore = 0; // initialize the computer turn score to 0
        int computerScore = 0; // initialize the computer score to 0
        boolean playerTurn = true; // set playerTurn to true, indicating it is the player's turn

        // The game continues as long as neither player has scored 100 points yet
        while (playerScore <= 100 && computerScore <= 100) {
            // If it is the player's turn
            if (playerTurn) {
                System.out.println("Ready to begin (Enter 'y' when you're ready:)");
                char answer = input.nextLine().charAt(0); // prompt user to input 'y' when ready.

                // While the player continues to roll
                while (answer == 'y') {
                    dice.roll(); // roll the dice
                    System.out.println("You're rolling....");
                    System.out.println("You rolled: " + dice);
                    int rollSum = dice.getDiceSum(); // get the sum of pairOfDice

                    // If the player rolls two ones
                    if (dice.getDie1() == 1 && dice.getDie2() == 1) {
                        System.out.println("You rolled two 1's...\nyour turn is over.");
                        System.out.println("You lost all your points so far");
                        playerTurnScore = 0;
                        playerScore = 0; // Player score is reset to 0
                        System.out.println("Continue? (type 'y' to turn the dice over to me:)");
                        char response = input.nextLine().charAt(0);
                        if (response == 'y') {
                            break;
                        }
                    }

                    // If the player rolls one
                    if (dice.getDie1() == 1 || dice.getDie2() == 1) {
                        System.out.println("You rolled one 1...\nYour turn is over.");
                        System.out.println("You lost all your points for this turn");
                        playerTurnScore = 0;
                        System.out.println("Continue? (type 'y' to turn the dice over to me:)");
                        char response = input.nextLine().charAt(0);
                        if (response == 'y') {
                            break;
                        }
                    } else {
                        playerTurnScore += rollSum; // summing up the points
                        System.out.println("this gives you a turn total of " + playerTurnScore);
                        System.out.println("and a grand total of " + (playerScore + playerTurnScore));
                        System.out.println("Do you want to continue rolling? 'y' or 'n'");
                        answer = input.nextLine().charAt(0); // ask user Whether continue or not?
                    }
                }

                playerScore += playerTurnScore; // Add the player's turn score to their total score
                System.out.println("-------------------------------");
                System.out.println("    Player score: " + playerScore); // printing player total score
                System.out.println("    Computer Score: " + computerScore); // printing player total score
                System.out.println("--------------------------------");
                playerTurnScore = 0; // reset the player's turn score
                playerTurn = false; // Set the turn to the computer

                // If it is the computer's turn
            } else {
                // The computer continues to roll until it has scored at least 20 points
                while (computerTurnScore < 20) {
                    dice.roll();
                    System.out.println("I'm rolling...");
                    System.out.println("I rolled: " + dice);
                    int rollSum = dice.getDiceSum();

                    // If the computer rolls two ones
                    if (dice.getDie1() == 1 && dice.getDie2() == 1) {
                        System.out.println("I rolled two 1's...\nyour turn is over.");
                        System.out.println("I lost all your points so far");
                        computerTurnScore = 0;
                        computerScore = 0;
                        break;
                    }

                    if (dice.getDie1() == 1 || dice.getDie2() == 1) {
                        System.out.println("I rolled one 1...\nI lost all my points for this turn");
                        computerTurnScore = 0;
                        break;
                    } else {
                        computerTurnScore += rollSum; // summing up the points
                        System.out.println("This gives me a turn total of: " + computerTurnScore);
                        System.out.println("and a grand total of " + (computerScore + computerTurnScore));
                    }
                }
                computerScore += computerTurnScore; // Add the player's turn score to their total score
                System.out.println("-------------------------------");
                System.out.println("      Player score: " + playerScore);
                System.out.println("      Computer Score: " + computerScore);
                System.out.println("-------------------------------");
                computerTurnScore = 0;
                playerTurn = true;
            }
        }

        // Check the Winner
        if (playerScore >= 100) {
            System.out.println("\n----------------------------");
            System.out.println("Congratulations! You won!!"); // User wins
            System.out.println("----------------------------");
        } else {
            System.out.println("Better Luck Next Time!"); // Computer wins
        }
    }
}

            
