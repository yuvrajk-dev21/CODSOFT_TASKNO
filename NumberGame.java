import java.util.Random;
import java.util.Scanner;

public class Numbergame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int roundsWon = 0;
        char playAgain;

        do {
            int number = random.nextInt(100) + 1;
            int maxAttempts = 5;
            boolean guessed = false;

            System.out.println("\n=== Number Guessing Game ===");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            for (int i = 1; i <= maxAttempts; i++) {

                System.out.print("Attempt " + i + ": ");
                int guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    roundsWon++;
                    guessed = true;
                    break;
                } else if (guess < number) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessed) {
                System.out.println("You lost! The number was: " + number);
            }

            System.out.print("Play again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("Rounds Won: " + roundsWon);
        sc.close();
    }
}


Output
=== Number Guessing Game ===
Guess a number between 1 and 100
You have 5 attempts.
Attempt 1: 40
Too low!
Attempt 2: 62
Too low!
Attempt 3: 78
Too high!
Attempt 4: 89
Too high!
Attempt 5: 98
Too low!
You lost! The number was: 100
Play again? (Y/N): 
