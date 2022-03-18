package sj223gb_assign1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
* Class Description: This class is about the fifth task of assignment 1.
* Creates anagrams based on the input of the user and matches if they are in the wordlist.
* 
* @version 1.1 14 September 2021
* @author Sebastian Jonsson
*/
public class Anagram {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<String> anagramsList = new ArrayList<String>();

    /**
     *  Collects the user input.
     * 
     * @throws IOException
     */
    public void getUserInput() throws IOException {
        System.out.print("Type a word: ");
        String inputText = scanner.next();
        
        processText(inputText);
    }

    /**
     * Sends the user input for anagram checking and then prints the outcome from a list as shown in the example of the task.
     * 
     * @param inputText - The user input text.
     * @throws IOException
     */
    private void processText(String inputText) throws IOException {
        readFileLines(inputText);
        
        String printList = anagramsList.toString();
        System.out.print(printList.substring(1, printList.length() -1));
    }

    /**
     * Reads word by word from the wordlist text file.
     * 
     * @param word - The word the user wrote to check for anagrams.
     * @throws IOException
     */
    private void readFileLines(String word) throws IOException {
		try {
			FileInputStream fileInputStream = new FileInputStream("wordlist");
			InputStreamReader inStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader buffReader = new BufferedReader(inStreamReader);

			String line = "";
			line = buffReader.readLine();

			while (line != null) {
                checkAnagramValidity(word, line);
				line = buffReader.readLine();
			}
			
			buffReader.close();
		} 
        catch (FileNotFoundException fileNotFound) {
			System.err.println("File Not Found");
		}
	}
    
    /**
     * Checks if the user input and the current word of the list are valid anagrams.
     * 
     * @param userWord - The user input.
     * @param lineWord - The current line of the wordlist text document.
     */
    private void checkAnagramValidity(String userWord, String lineWord) {

        if (sameWordLength(userWord, lineWord)) {
            isAnagram(userWord, lineWord);
        }
    }
    
    /**
     * Compares the length of the user input and the word on the current line of the wordlist text document.
     * 
     * @param userWord - The user input.
     * @param lineWord - The current line of the wordlist text document.
     * @return - boolean, if the length of two words are the same or not.
     */
    private boolean sameWordLength(String userWord, String lineWord) {
        return userWord.length() == lineWord.length();
    }
    
    /**
     * Checks if the words of the same length are the same letters.
     * 
     * @param userWord - The user input.
     * @param lineWord - The current line of the wordlist text document.
     */
    private void isAnagram(String userWord, String lineWord) {
        String[] userWordCheck = userWord.split("");
        String[] lineWordCheck = lineWord.split("");

        Arrays.sort(userWordCheck);
        Arrays.sort(lineWordCheck);

        if (Arrays.equals(userWordCheck, lineWordCheck)) {
            anagramsList.add(lineWord);
        };
    }
    
}
