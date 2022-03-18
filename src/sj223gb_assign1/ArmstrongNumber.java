package sj223gb_assign1;

import java.util.Scanner;

/**
* Class Description: This class is about the second task of assignment 1.
* It determines which numbers between a minimum and maximum integer are an armstrong number.
*
* @version 1.0 2 September 2021
* @author Sebastian Jonsson
*/
public class ArmstrongNumber {
    private Scanner scanner = new Scanner(System.in);
    private int startNum = 0;
    private int endNum = 0;
    
    /**
     * Collects user input, a start and end value.
     */
    public void getUserInput() {
        System.out.print("Enter the starting number of the range :");
        startNum = scanner.nextInt();

        do {
            System.out.print("Enter the ending number of the range :");
            endNum = scanner.nextInt();  
        } while (endNum < startNum);

        inputChecker();
    }

    /**
     * Loops through all numbers between the start and end numbers which were input by the user.
     */
    private void inputChecker() {
        System.out.println("The Armstrong numbers between the given range are :");

        for (int i = startNum; i <= endNum; i++) {
            calculateArmstrongNum(i);
        }

        restartUserInput();
    }
    
    /**
     * Calculates the armstrong number.
     * 
     * @param numConvert - The current number being checked if it is an armstrong number.
     */
    private void calculateArmstrongNum(int numConvert) {
        int[] numCalcArray = inputNumConversion(numConvert);
        int validNum = 0;     

        for (int i = 0; i < numCalcArray.length; i++) {
            validNum += Math.pow(numCalcArray[i], numCalcArray.length);
        }
        
        if (validNum == numConvert) {
            System.out.println(validNum);
        }
    }
    
    /**
     * Converts the current int number into an int array.
     * 
     * @param splitNum - Current int being converted into an int array.
     * @return - int array to calculate the armstrong potential numbers.
     */
    private int[] inputNumConversion(int splitNum) {
        String convertNum = Integer.toString(splitNum);
        int[] numbers = new int[convertNum.length()];

        for (int i = 0; i < convertNum.length(); i++) {
            numbers[i] = Character.digit(convertNum.charAt(i), 10);
        }

        return numbers;
    }


    /**
     * Restarts or exits the program if proper user input is given.
     */
    private void restartUserInput() {
        System.out.print("Do you want to repeat? (Y/N): ");

        if (scanner.nextLine().equals("Y")) {
            getUserInput();
        }
        else if (scanner.nextLine().equals("N")) {
            System.exit(1);
        }
        else {
            System.out.println("Choose ");
            restartUserInput();
        }
    }

}
