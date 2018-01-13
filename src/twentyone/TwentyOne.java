/*
 * TwentyOne.java
 * A game to see who is the closest to 21 without going over.
 * Jess Lorantfy
 * January 12th, 2018
 */
package twentyone;
import java.util.Scanner;

/**
 *
 * @author jessica.lorantfy
 */
public class TwentyOne {
    /**
     * Generates a random number between min (inclusive) and max (inclusive)
     */
    private static int generateRandomNumber(int min, int max) {
        return (int)Math.floor(Math.random() * (max - min + 1)) + min;
    }
    
    
    /**
     * This function starts and plays the game with the user.
     */
    private static void playGame() {
        CardDeck deck = new CardDeck();
        int dealer, player, hitOrStand = 1, score = 0;
        System.out.println("Goal: Beat the dealer without going over 21");
        Scanner input = new Scanner(System.in);

        // Generate the dealer's card
        dealer = generateRandomNumber(16, 21); 
        System.out.println("The Dealer scored: " + dealer);
        System.out.println("");
       

        // Keep playing while the player hasn't won or lost yet
        while (hitOrStand == 1 && score < 21 && score < dealer) {
            // Generate player's card
            player = generateRandomNumber(1, 10); 
            System.out.println("Your card is worth " + player);

            // Displays the picture of player's card
            String card = deck.drawCard(player);
            System.out.println(card);

            // Add player's card value to their score
            score = score + player;

            // Displays score and asks wether user wants to hit or stand
            if (score <= 21 && score < dealer) {
               System.out.println("Your score is " + score);
               System.out.print("Another card? Hit=1 stand=0: ");
               hitOrStand = input.nextInt();
               System.out.println("");
            }
        }
        
        // Display player won
        if (score > dealer && score <= 21 ) {
            System.out.println("You win!");
            System.out.println("Your score is " + score);
            System.out.println("The dealer score was " + dealer);
            System.out.println("You were closer to 21 by " + (score - dealer));

        // Display when player ties with dealer
        } else if (score == dealer) {
            System.out.println("Your score is " + score);
            System.out.println("");
            System.out.println("You tied!");

        // Display if player lost
        } else if (score > 21) {
            System.out.println("Your score is " + score);
            System.out.println("");
            System.out.println("You lose!");
            int over = score - 21;
            System.out.println("You were over 21 by " + over);

        // Display if player lost
        } else {
            int difference;
            difference = dealer - score;
            System.out.println("Your score is " + score);
            System.out.println("You lose!");
            System.out.println("The dealer was closer to 21 than you by " + difference);
        } 
    }
    
    public static void main(String[] args) {
       String userInput;
       boolean keepPlaying = true;
       Scanner input = new Scanner(System.in);

       // Read the title ASCII art text from a file and display it
       FileIO fileIO = new FileIO();
       String title;
       title = fileIO.readFile("title.txt");
       System.out.println(title);
       
       // Keep playing games until the user wants to quit
       while (keepPlaying) {
           playGame();
           System.out.println("Do you want to keep playing? (y/n) ");
           userInput = input.nextLine();
           
           /**
            * Allow the user to tell the program they want to keep playing
            * Can do this by entering any of the following:
            * - y
            * - Y
            * - yes
            * - YES
            * 
            * The player can quit by entering anything other than yes including "no" or "n"
            */
           keepPlaying = (userInput.toLowerCase().equals("y") || userInput.toLowerCase().equals("yes"));
           System.out.println("");
       }
       
       // Display a parting message to the user
       System.out.println("Ok, thanks for playing");
    }
}
