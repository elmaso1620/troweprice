package com.troweprice.interview;

import java.util.*;

public class WordUtils {

    public Set<Word> findLongestWords(String sentence) {
        Objects.requireNonNull(sentence);

        sentence = removePunctuation(sentence);

        String[] sentenceWords = sentence.split("\\s+");

        // iterate words array and check if word length exceeds answer list string lengths
        Set<Word> longestWords = new HashSet<>();
        for(String sentenceWord : sentenceWords) {
            if (!sentenceWord.isEmpty()) {
                Word firstLongestWord = longestWords.stream().findFirst().orElse(null);
                if (firstLongestWord == null || sentenceWord.length() == firstLongestWord.getLength()) {
                    longestWords.add(new Word(sentenceWord));
                } else if (sentenceWord.length() > firstLongestWord.getLength()) {
                    // remove all words as current word exceeds length
                    longestWords.clear();
                    longestWords.add(new Word(sentenceWord));
                }
            }
        }

        return longestWords;
    }

    public Set<Word> findShortestWords(String sentence) {
        Objects.requireNonNull(sentence);

        sentence = removePunctuation(sentence);

        String[] sentenceWords = sentence.split("\\s+");

        // iterate words array and check if word length is lower than answer list string lengths
        Set<Word> shortestWords = new HashSet<>();
        for(String sentenceWord : sentenceWords) {
            if (!sentenceWord.isEmpty()) {
                Word firstShortestWord = shortestWords.stream().findFirst().orElse(null);
                if (firstShortestWord == null || sentenceWord.length() == firstShortestWord.getLength()) {
                    shortestWords.add(new Word(sentenceWord));
                } else if (sentenceWord.length() < firstShortestWord.getLength()) {
                    // remove all words as current word is shorter
                    shortestWords.clear();
                    shortestWords.add(new Word(sentenceWord));
                }
            }
        }

        return shortestWords;
    }

    /**
     * Removes all characters except letters and spaces.
     *
     * @param sentence String to have punctuation removed
     * @return a String without punctuation
     */
    private String removePunctuation(String sentence) {
        return (sentence == null ? null : sentence.replaceAll("[^a-zA-Z ]", ""));
    }
}
