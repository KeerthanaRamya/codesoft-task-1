
    import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int totalRounds = 0;
        int roundsWon = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        String playAgain;
        do {
            int numberToGuess = rand.nextInt(100) + 1; 
            int maxAttempts = 7;
            int attempts = 0;
            boolean isCorrect = false;

            System.out.println("\nI have picked a number between 1 and 100. You have " + maxAttempts + " attempts!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    isCorrect = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low . Try again.");
                } else {
                    System.out.println("Too high . Try again.");
                }
            }

            if (!isCorrect) {
                System.out.println(" You've used all your attempts! The correct number was: " + numberToGuess);
            }

            totalRounds++;
            totalAttempts += attempts;
            if (isCorrect) {
                roundsWon++;
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            sc.nextLine(); 
            playAgain = sc.nextLine().trim().toLowerCase();

        } while (playAgain.equals("yes") || playAgain.equals("y"));

        
        System.out.println("\n=== Game Summary ===");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Total Attempts: " + totalAttempts);
        if (totalRounds > 0) {
            System.out.printf("Average Attempts per Round: %.2f\n", (double) totalAttempts / totalRounds);
        }
        System.out.println("Thanks for playing!");

        sc.close();
    }
}


