import classes.WordFrequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {

    public String text = "Hallo, mijn naam is Amar en ik ben 27 jaar oud.\n"+
                         "Ik maak deze case voor JTech.\n" +
                         "jtech amar27 hallo14 amar@1993.";
    public String shortText = "Amar Jtech234 %#amar jtech bravo test test Test TEST    123TEsT";
    public String emptyText = "";
    public String wordInText = "jtech";
    public String wordNotInText = "goodbye";

    public int highestFrequency = 3;
    public int frequencyWordInText = 2;
    public int n = 5;

    public List<WordFrequency> wordFrequencyList = Arrays.asList(new WordFrequency("amar", 3),
            new WordFrequency("hallo", 2),
            new WordFrequency("ik", 2),
            new WordFrequency("jtech", 2),
            new WordFrequency("ben", 1));

    public List<WordFrequency> shortWordFrequencyList = Arrays.asList(new WordFrequency("test", 5),
            new WordFrequency("amar", 2),
            new WordFrequency("jtech", 2),
            new WordFrequency("bravo", 1));

    public List<WordFrequency> emptyWordFrequencyList = new ArrayList<>();
}
