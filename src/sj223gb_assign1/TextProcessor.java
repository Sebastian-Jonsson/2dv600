package sj223gb_assign1;

import java.util.Scanner;

/**
* Class Description: This class is about the fourth task of assignment 1.
* It is a Text processor which changes and rearranges the contents of the user input.
* 
* @version 1.0 6 September 2021
* @author Sebastian Jonsson
*/
public class TextProcessor {
    private Scanner scanner = new Scanner(System.in);
    private int asciiOutput;
    private String finalOutput = "";

    /**
     * Collects user input.
     */
    public void getUserInput() {
        System.out.print("Type a line of text: ");
        String inputText = scanner.nextLine();
        
        processText(inputText);
    }

    /**
     * Processes and confirms what part of the text is alphabetic or not.
     * If alphabetic, sends it along for further editing, else adds it to the final output.
     * 
     * @param inputText - User text input.
     */
    private void processText(String inputText) {
        
        for (int i = 0; i < inputText.length(); i++) {

            if (Character.isAlphabetic(inputText.charAt(i))) {
                alphabeticStepAhead(inputText.charAt(i));
            }
            else {
                finalOutput += inputText.charAt(i);
            }
        }

        System.out.println(finalOutput);
    }

    /**
     * Rearranges the alphabetic characters by one step ahead.
     * 
     * @param processText - Character that is to be moved ahead by one step in the alphabet.
     */
    private void alphabeticStepAhead(char processText) {
        asciiOutput = processText;

        // Upper and lowercase "Z,z".
        if (asciiOutput == 122 || asciiOutput == 90) {
            asciiOutput -= 25;
        }
        else {
            asciiOutput += 1;
        }

        capitalizeVowels((char)asciiOutput);
    }

    /**
     * Checks the letters if they are a vowel or not and then adding to the final output.
     * 
     * @param processText - Character that is to be checked if it is a vowel or not.
     */
    private void capitalizeVowels(char processText) {
        String vowels = "aeiou";

        if (vowels.indexOf(processText) != -1) {
            processText = Character.toUpperCase((char) processText);
        }

        finalOutput += Character.toString(processText);
    }
}
