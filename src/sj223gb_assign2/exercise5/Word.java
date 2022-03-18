package sj223gb_assign2.exercise5;

/**
* Class that sets rules and methods for Word. In order to compare and measure equality.
*
* @version 1.1 30 September 2021
* @author Sebastian Jonsson
*/
public class Word implements Comparable<Word> {
    
    // See word "pneumonoultramicroscopicsilicovolcanoconiosis" which is 45 long. 'Longest' English word.
    private final String longestEnglishWord = "pneumonoultramicroscopicsilicovolcanoconiosis";
    private String word;


    public Word(String str) {
        setWord(str);
    }

    private void setWord(String str) {

        if (str.length() <= longestEnglishWord.length() && str.length() >= 1) {
            word = str;
        }
        else {
            throw new IllegalArgumentException("Longer word than the longest English word detected.");
        }
        
    }

    public String toString() {
        return word;
    }

    /**
     * Makes certain lower, upper and mixed case characters are hashed the same.
     */
    @Override
    public int hashCode() {
        word = word.toUpperCase();
        return word.hashCode();
    }
    
    /**
     * Compares this hashcoded Word with the other Word.
     */
    @Override
    public boolean equals(Object other) {

        if (other.getClass() == Word.class) {
            return hashCode() == other.hashCode();
        }

        return false;
    }

    /**
     * Compares two Word instances word.
     */
    public int compareTo(Word w) {
        int truth = word.compareTo(w.toString());
        return truth;
    }
    
}
