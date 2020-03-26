package com.troweprice.interview;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.*;

public class WordUtilsTest {

    private WordUtils wordUtils = new WordUtils();

    @Test(expected=NullPointerException.class)
    public void getTestFindLongestWordWithNullSentence() {
        wordUtils.findLongestWords(null);
    }

    @Test
    public void testFindLongestWordWithEmptySentence() {
        assertTrue(wordUtils.findLongestWords("").size() == 0);
    }

    @Test
    public void testFindLongestWordWithPunctuation() {
        assertTrue(wordUtils.findLongestWords("Careful, this is a '****sentence****' containing punctuation!")
                .toArray()[0].equals(new Word("punctuation")));

    }

    @Test
    public void testFindLongestWord() {
        Set<Word> longestWords = wordUtils.findLongestWords("The cow jumped over the moon.");

        assertTrue(longestWords.size() == 1);

        Word longestWord = (Word)longestWords.toArray()[0];
        assertTrue(longestWord.getValue().equals("jumped"));
        assertTrue(longestWord.getLength() == 6);
    }

    @Test
    public void testFindLongestWordWithMultipleAnswers() {
        Set<Word> longestWords = wordUtils.findLongestWords("One two three four five six seven eight nine ten");

        assertTrue(longestWords.size() == 3);
        assertTrue(longestWords.containsAll(Arrays.asList(new Word("three"),
                new Word("seven"), new Word("eight"))));

        assertTrue(((Word)(longestWords.toArray()[0])).getLength() == 5);
    }

    @Test(expected=NullPointerException.class)
    public void getTestFindShortestWordWithNullSentence() {
        wordUtils.findShortestWords(null);
    }

    @Test
    public void testFindShortestWordWithEmptySentence() {
        assertTrue(wordUtils.findLongestWords("").size() == 0);
    }

    @Test
    public void testFindShortestWordWithPunctuation() {
        assertTrue(wordUtils.findShortestWords("Careful, 'a' should returned despite punctuation!")
                .toArray()[0].equals(new Word("a")));
    }

    @Test
    public void testFindShortestWord() {
        Set<Word> shortestWords = wordUtils.findShortestWords("The cow jumped over the moon.");

        assertTrue(shortestWords.size() == 3);

        assertTrue(shortestWords.containsAll(Arrays.asList(new Word("The"),
                new Word("cow"), new Word("the"))));

        Word shortestWord = (Word)shortestWords.toArray()[0];
        assertTrue(shortestWord.getLength() == 3);
    }

    @Test
    public void testFindShortestWordWithMultipleAnswers() {
        Set<Word> shortestWords = wordUtils.findShortestWords("One two three four five six seven eight nine ten");

        assertTrue(shortestWords.size() == 4);
        assertTrue(shortestWords.containsAll(Arrays.asList(new Word("One"),
                new Word("two"), new Word("six"), new Word("ten"))));

        assertTrue(((Word)(shortestWords.toArray()[0])).getLength() == 3);
    }
}
