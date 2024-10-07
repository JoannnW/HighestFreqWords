package wordfrequency;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        wordfrequency.WordFrequencyAnalyzer analyzer = new wordfrequency.WordFrequencyAnalyzer();

        analyzer.loadCommonWords("src/commonWords.txt");
        analyzer.loadTextOne("src/main/textOne.txt");

        String mostFrequentWord = analyzer.highestFreqWord();
        System.out.println("The word with the highest frequency not in common words is: " + mostFrequentWord);
    }
}
