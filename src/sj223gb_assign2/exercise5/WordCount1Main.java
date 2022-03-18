package sj223gb_assign2.exercise5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
* Creates objects of the Word class and adds it to both a TreeSet and HashSet.
* Also iterates through the TreeSet and prints each word on a new line.
* Further counts the number of words in HashSet and TreeSet and prints them.
*
* @version 1.0 30 September 2021
* @author Sebastian Jonsson
*/
public class WordCount1Main {
    private static String fileToRead = "words.txt";
    static HashSet<Word> wordHashSet = new HashSet<Word>();
    static TreeSet<Word> wordTreeSet = new TreeSet<Word>();

    public static void main(String[] args) throws IOException {
        initiateFileReader();

        System.out.println();
        iterateOverTreeSet();
        sizeOfSets();
    }

    private static void sizeOfSets() {
        System.out.println("HashSet Size: " + wordHashSet.size() + " words.");
        System.out.println("TreeSet Size: " + wordTreeSet.size() + " words.");
    }

    private static void iterateOverTreeSet() {
        Iterator<Word> treeIterator = wordTreeSet.iterator();

        // Iterates through the TreeSet and prints each word.
        while (treeIterator.hasNext()) {
            System.out.print(treeIterator.next() + ", \n");
        }
    }

    public static void initiateFileReader() throws IOException {
		try {
			FileInputStream fileInputStream = new FileInputStream(fileToRead);
			InputStreamReader inStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader buffReader = new BufferedReader(inStreamReader);

            // Sending the buffReader so we can get new lines.
            checkLines(buffReader);
			
			buffReader.close();
		} 
        catch (FileNotFoundException fileNotFound) {
			System.err.println("File Not Found");
		}
	}

    private static void checkLines(BufferedReader buffReader) throws IOException {
        String line = "";
		line = buffReader.readLine();

        while (line != null) {
            addWordsFromLine(line);
            
            line = buffReader.readLine();
        }

    }

    private static void addWordsFromLine(String line) {
        String[] words = line.split(" ");
        
        // Means if a line have something and is not just empty.
        if (line.length() != 0) {
            
            for (int i = 0; i < words.length; i++) {
                // I convert words to lowercase so that it will not take doubles in.
                words[i] = words[i].toLowerCase();

                Word newWord = new Word(words[i]);
                wordHashSet.add(newWord);
                wordTreeSet.add(newWord);
            }
        }
    }
}
