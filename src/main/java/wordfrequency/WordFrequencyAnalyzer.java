package wordfrequency;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordFrequencyAnalyzer {
        //properties
        private ArrayList<String> commonWords = new ArrayList<>();
        private ArrayList<String> textOne = new ArrayList<>();
        private int counter;

        //constructors
        public WordFrequencyAnalyzer(){

        }

        public void loadCommonWords(String commonWordsFilePath) throws FileNotFoundException{
            File file = new File(commonWordsFilePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()){
                commonWords.add(scanner.next());
            }
            scanner.close();
        }

        public void loadTextOne(String textOneFilePath) throws FileNotFoundException{
            File file = new File(textOneFilePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()){
                textOne.add(scanner.next());
            }
            scanner.close();
        }

        public ArrayList<String> textOneWithoutCommonWords() {
            ArrayList<String> textWithoutCommonWords = new ArrayList<>(textOne);
            textWithoutCommonWords.removeAll(commonWords);
            return textWithoutCommonWords;
        }

        public String highestFreqWord(){
            String highestFreqWord = "";
            int maxCount = 0;
            ArrayList<String> textWithoutCommonWords = textOneWithoutCommonWords();
            for (String word : textWithoutCommonWords){
                int counter = 0;
                for (String textWord : textWithoutCommonWords){
                    if (word.equalsIgnoreCase(textWord)){
                        counter++;
                    }
                }

                if (counter > maxCount){
                    maxCount = counter;
                    highestFreqWord = word;
                }
            }
            return "The word with the highest frequency not in common words is " + highestFreqWord + ", with a frequency of " + maxCount + " words.";
        }
}
