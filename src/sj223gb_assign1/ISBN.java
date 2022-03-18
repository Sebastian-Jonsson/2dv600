package sj223gb_assign1;

import java.util.Scanner;

/**
* Class Description: This class is about the first task of assignment 1.
* It determines if the input number is a valid ISBN number or not.
*
* @version 1.1 14 September 2021
* @author Sebastian Jonsson
*/
public class ISBN {
    private int calcNum = 0;
    private String fillNum = "";
    private String finalResult = "";

    /**
     * Gathers the user input and fills the leading numbers of ISBN-10 with zeros if they are missing.
     */
    public void inputGatherer() {
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.print("Enter the first 9 digits of an ISBN as integer: ");
            int tempNum = scanner.nextInt();

            fillNum = String.format("%09d", tempNum);
            
        } while (fillNum.length() > 9);
        
        scanner.close();

        stringToIntArray();
    }

    /**
     * Converts to a string array for easier handling.
     */
    private void stringToIntArray() {
        int[] numbers = new int[fillNum.length()];

        for (int i = 0; i < fillNum.length(); i++) {
            numbers[i] = Character.digit(fillNum.charAt(i), 10);
        }
        
        calculateISBN10(numbers);
        printResult();
    }

    /**
     * Calculates the ISBN-10 number and adds the final digit to a string that will be presented in the final results.
     * 
     * @param numbers
     */
    private void calculateISBN10(int[] numbers) {
        
        for (int i = 0; i < numbers.length; i++) {
            finalResult += numbers[i];
            calcNum += (numbers[i] * (i + 1));
        }
        int tenthDigit = calcNum % 11;

        dividableByTen(tenthDigit);
    }

    /**
     * Divides the tenthDigit by ten and sets the final digit of the ISBN-10 number.
     * @param tenthDigit - The tenth digit to divide.
     */
    private void dividableByTen(int tenthDigit) {

        if (tenthDigit % 10 == 0) {
            finalResult += "X";
        }
        else { 
            finalResult += String.valueOf(tenthDigit);
        }
    }

    /**
     * Prints the final result.
     */
    private void printResult() {
        System.out.println("The ISBN-10 number is " + finalResult);
    }

}
