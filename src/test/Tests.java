import classes.WordFrequency;
import classes.WordFrequencyAnalyzer;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {

    private WordFrequencyAnalyzer wordFrequencyAnalyzer;
    private TestData testData;

    @Before
    public void init() {
        wordFrequencyAnalyzer = new WordFrequencyAnalyzer();
        testData = new TestData();
    }

    @Test
    public void testCorrectHighestFrequencyReturned() {
        int frequency = wordFrequencyAnalyzer.calculateHighestFrequency(testData.text);
        assertEquals(testData.highestFrequency, frequency);
    }

    @Test
    public void testFrequencyOfZeroReturnedForEmptyText() {
        int frequency = wordFrequencyAnalyzer.calculateHighestFrequency(testData.emptyText);
        assertEquals(0, frequency);
    }

    @Test
    public void testCorrectFrequencyReturnedForWordInText() {
        int frequency = wordFrequencyAnalyzer.calculateFrequencyForWord(testData.text, testData.wordInText);
        assertEquals(testData.frequencyWordInText, frequency);
    }

    @Test
    public void testFrequencyOfZeroReturnedForWordNotInText() {
        int frequency = wordFrequencyAnalyzer.calculateFrequencyForWord(testData.text, testData.wordNotInText);
        assertEquals(0, frequency);
    }

    @Test
    public void testFrequencyOfZeroReturnedForWordAndEmptyText() {
        int frequency = wordFrequencyAnalyzer.calculateFrequencyForWord(testData.emptyText, testData.wordInText);
        assertEquals(0, frequency);
    }

    @Test
    public void testCorrectNWordsFoundInText() {
        List<WordFrequency> list = wordFrequencyAnalyzer.calculateMostFrequentNWords(testData.text, testData.n);
        assertEquals(testData.wordFrequencyList, list);
    }

    @Test
    public void testLessThanNWordsFoundInText() {
        List<WordFrequency> list = wordFrequencyAnalyzer.calculateMostFrequentNWords(testData.shortText, testData.n);
        assertEquals(testData.shortWordFrequencyList, list);
    }

    @Test
    public void testZeroWordsFoundInEmptyText() {
        List<WordFrequency> list = wordFrequencyAnalyzer.calculateMostFrequentNWords(testData.emptyText, testData.n);
        assertEquals(testData.emptyWordFrequencyList, list);
    }
}
