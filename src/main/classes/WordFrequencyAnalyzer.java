package classes;

import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyAnalyzer implements main.interfaces.WordFrequencyAnalyzer {

    /**
     * This method takes the first element of the List and returns the frequency. In the case of an empty List, a
     * frequency of zero is returned.
     * @param text  Any String object that the user wants to analyze.
     * @return      An integer value that corresponds to the frequency of the most common word in the text.
     */
    public int calculateHighestFrequency(String text) {
        return analyzeText(text).stream()
                .findFirst()
                .map(WordFrequency::getFrequency)
                .orElse(0);
    }

    /**
     * This method checks how often a certain word appears in a given text. If the word is not used in the text, the
     * method will return a value of zero.
     * @param text  Any String object that the user wants to analyze.
     * @param word  A word that the user wants to know the usage of.
     * @return      The number of times the word is used in the text.
     */
    public int calculateFrequencyForWord(String text, String word) {
        return analyzeText(text).stream()
                .filter(wordFrequency -> wordFrequency.getWord().equals(word))
                .map(WordFrequency::getFrequency)
                .findAny()
                .orElse(0);
    }

    /**
     * This method returns an n number of WordFrequency objects, corresponding to the words that are most common in the
     * text, sorted alphabetically.
     * @param text  Any String object that the user wants to analyze.
     * @param n     The number of most common words the user wants returned.
     * @return      A List of size n, showing the most common words in the text in alphabetical order.
     */
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        List<WordFrequency> wordFrequencyList = analyzeText(text);

        if(wordFrequencyList.size() < n) {
            return wordFrequencyList;
        } else {
            return wordFrequencyList.subList(0, n);
        }
    }

    /**
     * This method first transforms a String into a List of lower case Strings, removing all non-alphabetic characters
     * in the process. Then, a new List WordFrequency objects is made and sorted on their 'frequency' and 'word' fields.
     * The final removeIf method is used in case of a parameter that results in no words. It makes it so that an empty
     * List is returned.
     * @param text  Any String object that the user wants to analyze.
     * @return      A sorted List of WordFrequency objects.
     */
    private List<WordFrequency> analyzeText(String text) {
        List<String> words = Arrays.asList(text.toLowerCase().split("\\P{Alpha}+"));

        List<WordFrequency> wordFrequencyList = words.stream()
                .distinct()
                .map(word -> new WordFrequency(word, Collections.frequency(words, word)))
                .sorted(Comparator.comparing(WordFrequency::getFrequency).reversed().thenComparing(WordFrequency::getWord))
                .collect(Collectors.toList());

        wordFrequencyList.removeIf(wordFrequency -> Objects.equals(wordFrequency.getWord(), ""));

        return wordFrequencyList;
    }
}
