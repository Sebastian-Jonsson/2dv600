package sj223gb_assign2.exercise5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
* Class that tests the Word class from exercise 5.2.
* Instantiates new Word classes to test the functionality.
* Junit5 is used.
*
* @version 1.1 30 September 2021
* @author Sebastian Jonsson
*/
public class WordTest {
    private String lowerCaseWord = "baloon";
    private String upperCaseWord = "BALOON";
    private String capitalStartWord = "Baloon";
    private String snakeCaseWord = "bAlOoN";
    private String tooLongWord = "ThisIsNotEvenAWordItIsInFactAReallyLongSentenceWhichIsBasedUponNoParticularReasonSoIDoBegYourPardon";

    @Test
    public void setWord_ShouldThrowException_IfTooLong() {
        assertThrows("Should throw when trying to insert a too long String: ", IllegalArgumentException.class, () -> new Word(tooLongWord));
    }

    @Test
    public void setWord_ShouldReturnCorrectWord() {
        Word word = new Word(lowerCaseWord);

        assertEquals("Should be the same as a new word containing the same word: ", new Word(lowerCaseWord), word);
    }

    @Test
    public void toString_ShouldReturnCorrectString() {
        Word word = new Word(lowerCaseWord);

        assertEquals("Should be the same string as the word returns with toString: ", lowerCaseWord, word.toString());
    }

    @Test
    public void hashCode_ShouldReturnCorrectInteger() {
        int lowerWord = new Word(lowerCaseWord).hashCode();
        Word upperWord = new Word(upperCaseWord);
        Word capitalWord = new Word(capitalStartWord);
        Word snakeWord = new Word(snakeCaseWord);

        assertTrue("Should receive the same hashcode value toward a new instance with the same string input: ", lowerWord == new Word(lowerCaseWord).hashCode());
        assertTrue("Should receive the same hashcode value toward upperWord: ", lowerWord == upperWord.hashCode());
        assertTrue("Should receive the same hashcode value toward capitalWord: ", lowerWord == capitalWord.hashCode());
        assertTrue("Should receive the same hashcode value toward snakeWord: ", lowerWord == snakeWord.hashCode());
    }

    @Test
    public void equals_ShouldBeSameTypeAndHashCode() {
        Word lowerWord = new Word(lowerCaseWord);
        Word upperWord = new Word(upperCaseWord);
        Word capitalWord = new Word(capitalStartWord);
        Word snakeWord = new Word(snakeCaseWord);

        assertTrue("Should be the same type and hashValue: ", lowerWord.equals(upperWord));
        assertTrue("Should be the same type and hashValue: ", lowerWord.equals(capitalWord));
        assertTrue("Should be the same type and hashValue: ", lowerWord.equals(snakeWord));
    }

    @Test
    public void equals_ShouldReturnFalse() {
        Word lowerWord = new Word(lowerCaseWord);
        Word upperWrongWord = new Word("WRONG");

        assertFalse("Should be the same type and hashValue: ", lowerWord.equals(upperWrongWord));
    }

    @Test
    public void compareTo_ShouldBeTheSame() {
        Word lowerWord = new Word(lowerCaseWord);

        assertEquals("Should be the same value: ", 0, lowerWord.compareTo(new Word(lowerCaseWord)));
    }

    @Test
    public void compareTo_ShouldNotBeTheSame() {
        Word lowerWord = new Word(lowerCaseWord);
        Word upperWrongWord = new Word("WRONG");

        assertFalse("Should not be the same value: ", 0 == lowerWord.compareTo(upperWrongWord));
    }

    
    
}
