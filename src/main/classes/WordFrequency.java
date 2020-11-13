package classes;

import java.util.Objects;

public class WordFrequency implements main.interfaces.WordFrequency {

    private final String word;
    private final int frequency;

    public WordFrequency(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

    // Overrides performed for testing purposes. This way we can compare two objects of type WordFrequency based on
    // their fields.
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        WordFrequency wordFrequency = (WordFrequency) o;
        return Objects.equals(word, wordFrequency.word) &&
                frequency == wordFrequency.frequency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, frequency);
    }
}
