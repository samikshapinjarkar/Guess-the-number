import javax.swing.*;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Random random = new Random();

        int min = 1;
        int max = 100;
        int attempts = 0;
        boolean guessedCorrectly = false;

        int randomNumber = random.nextInt(max - min + 1) - min ;

        JOptionPane.showMessageDialog(null, "Welcome to the Number Guessing Game!\n" +
                "You have picked a number between " + min + " and " + max + ".\nTry to guess it!");

        while (!guessedCorrectly) {
            String input = JOptionPane.showInputDialog(null, "Enter your guess:");
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Game canceled. Goodbye!");
                break;
            }

            try {
                int userGuess = Integer.parseInt(input);
                attempts++;

                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempts + " attempts.");
                } else if (userGuess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.");
            }
        }
    }
}