package sj223gb_assign1;

import java.util.Scanner;

/**
* Class Description: This class is about the third task of assignment 1.
* Babylonian algorithm which compute the square root of a positive number which the user provides.
*
* @version 1.1 14 September 2021
* @author Sebastian Jonsson
*/
public class SquareRoot {
    private Scanner scanner = new Scanner(System.in);
    private double previousGuess;

    /**
     * Collects user input.
     */
    public void getUserInput() {
        System.out.println("This program estimate square roots.");

        System.out.print("Enter an integer to estimate the square root of: ");
        int inputNum = scanner.nextInt();
        double initialGuess = (double) inputNum;
        
        calculateGuess(initialGuess);
    }
    
    /**
     * The calculation for the Babylonian algorithm which loops until it is correct.
     * @param startNumber - The input that the user enters to the program.
     */
    private void calculateGuess(double startNumber) {
        double initialGuess = startNumber / 2;
        
        do {
            previousGuess = initialGuess;
            double ratio = startNumber / initialGuess;
            initialGuess = (initialGuess + ratio) / 2;
            
        } while (checkMatch(initialGuess));


        estimatedSquareRoot(initialGuess, startNumber);
        
    }
    
    /**
     * Formats the estimated square root of the given input number.
     * 
     * @param initialGuess - The initial guess.
     * @param startNumber - The input that the user entered.
     */
    private void estimatedSquareRoot(double initialGuess, double startNumber) {
        String formatAnswer = String.format("%.02f", initialGuess);
        System.out.print("\nThe estimated square root of " + 
        startNumber + " is " + formatAnswer);
    }

    /**
     * Method that compares the current guess against the previous guess to determine if a match is made and thus completing the result.
     * @param currentGuess - The current guess.
     * @return - boolean.
     */
    private boolean checkMatch(double currentGuess) {
        double calc = currentGuess / this.previousGuess;

        System.out.println("Current guess: " + currentGuess);

        return calc < 0.99 || calc > 1.01;
    }
    
}
