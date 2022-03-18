package sj223gb_assign2.exercise5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileWriter;

/**
* Class that identifies words by their alphabetical characters and removes other non alphabetic characters.
* Also writes edited text to a new file.
*
* @version 1.0 29 September 2021
* @author Sebastian Jonsson
*/
public class IdentifyWordsMain {

    public static void main(String[] args) {
        String fileToCopyTo = "words.txt";
        String fileToCopyFrom = "HistoryOfProgramming.txt";

        try {
            // createFile method would do just as well at the top of editLinesAndCopy method. For ease of argument access.
            createFile(fileToCopyTo);
            initiateFileReader(fileToCopyFrom);
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Info from labs and w3schools. Creates the file to copy into.
     * 
     * @param fileToCreate - The file that is to be copied to.
     * @throws IOException
     */
    private static void createFile(String fileToCreate) throws IOException {
        File myWords = new File(fileToCreate);
        
        if (myWords.createNewFile()) {
        System.out.println("File created: " + myWords.getName());
        }
    }

    /**
     * Initiates required tools to read the selected file sent as parameter.
     * Also initiates the editLinesAndCopy function with the fileToRead.
     * 
     * @param fileToRead - The file to be read line by line in editLinesAndCopy.
     * @throws IOException
     */
    public static void initiateFileReader(String fileToRead) throws IOException {
		try {
			FileInputStream fileInputStream = new FileInputStream(fileToRead);
			InputStreamReader inStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader buffReader = new BufferedReader(inStreamReader);

            // Sending the buffReader so we can get new lines.
            editLinesAndCopy(buffReader);
			
			buffReader.close();
		} 
        catch (FileNotFoundException fileNotFound) {
			System.err.println("File Not Found");
		}
	}
    
    /**
     * Instantiates a writer and removes every non alphabetic character from each line.
     * When the lines are edited they are copied over to the new file.
     * 
     * @param buffReader - Helps with reading line by line.
     * @throws IOException
     */
    private static void editLinesAndCopy(BufferedReader buffReader) throws IOException {
        String line = "";
		line = buffReader.readLine();
        FileWriter myWriter = createWriter("words.txt");

        while (line != null) {
            String editedLine = removeNonAlphabetic(line);
            myWriter.write(editedLine + "\n");
            
            line = buffReader.readLine();
        }

        myWriter.close();
    }

    /**
     * Creates a new FileWriter with the proper place to write to.
     * 
     * @param fileToWrite - The file to write to.
     * @return - A new FileWriter.
     * @throws IOException
     */
    private static FileWriter createWriter(String fileToWrite) throws IOException {
        return new FileWriter(fileToWrite);
    }

    /**
     * Removes the non alphabetic characters from the line.
     *  
     * @param line - The line to be edited.
     * @return - The edited line.
     */
    private static String removeNonAlphabetic(String line) {
        line = line.replaceAll("'", "");
        line = line.replaceAll("[^a-zA-ZaAiIoO\\s]", " ");
        line = line.replaceAll("[ ]{2,}", " ");
        line = line.replaceAll(" s ", " ");

        return line;
    }
}
