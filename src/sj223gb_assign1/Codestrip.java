package sj223gb_assign1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;

/**
* Class Description: This class is about the sixth task of assignment 1.
* Program that prints code and statistics as specified in the assignment.
* 
* @version 1.0 7 September 2021
* @author Sebastian Jonsson
*/
public class Codestrip {
    private int codeLines;
    private int blankLines;
    private int commentLines;
    private boolean commentStarted;
    private String finalOutput = "";

    /**
     * Reads line by line from the HelloWorld.java file.
     * 
     * @throws IOException
     */
    public void readFileLines() throws IOException {
		try {
			FileInputStream fileInputStream = new FileInputStream("HelloWorld.java");
			InputStreamReader inStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader buffReader = new BufferedReader(inStreamReader);

			String line = "";
			line = buffReader.readLine();

			while (line != null) {
                lineChecker(line);

				line = buffReader.readLine();
			}
            printResults();
			
			buffReader.close();
		} 
        catch (FileNotFoundException fileNotFound) {
			System.err.println("File Not Found");
		}
	}

    /**
     * Checks the lines and then counts what type of text is on the lines. 
     * Then further adds which lines are to remain.
     * 
     * @param line - The current line that is checked against the boolean expression.
     */
    private void lineChecker(String line) {
        String trimmedLine = line.trim();

        if (singleLineComment(trimmedLine)) {
            commentLines++;
        }
        else if (multiLineStart(trimmedLine)) {
            commentStarted = true;  
        }
        else if (commentStarted) {
            
            if (multiLineEnd(trimmedLine) ) {
                commentStarted = false;
                commentLines++;                
            }
        }
        else if (blankLineChecker(trimmedLine)) {
            blankLines++;
        }
        else {
            codeLines++;
            finalOutput += "\n" + line;
        }
    }

    /**
     * Prints the final output of the program.
     */
    private void printResults() {
        System.out.println(finalOutput + "\n\nNumber of actual lines of code: " + codeLines + 
        "\nNumber of blank lines removed: " + blankLines + 
        "\nNumber of comments removed: " + commentLines);
    }   
    
    /**
     * Checks if there is a blank line, then returns a boolean value.
     * 
     * @param line - The current line that is checked against the boolean expression.
     * @return - A boolean value.
     */
    private boolean blankLineChecker(String line) {
        return line.length() == 0;
    }

    /**
     * Checks if there is a singleline comment, then returns a boolean value.
     * 
     * @param line - The current line that is checked against the boolean expression.
     * @return - A boolean value.
     */
    private boolean singleLineComment(String line) {
        return line.startsWith("//");
    }

    /**
     * Checks if there is a javadoc or multiline comment start, then returns a boolean value.
     * 
     * @param line - The current line that is checked against the boolean expression.
     * @return - A boolean value.
     */
    private boolean multiLineStart(String line) {
        return line.startsWith("/*");
    }

    /**
     * Checks if there is a javadoc or multiline comment ending, then returns a boolean value.
     * 
     * @param line - The current line that is checked against the boolean expression.
     * @return - A boolean value.
     */
    private boolean multiLineEnd(String line) {
        return line.endsWith("*/") && commentStarted;
    }
    
}
