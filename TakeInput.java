package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TakeInput {
    String filePath;
    String tempStr;
    int sentences;
    int words;
    int chars;
    int letters;
    int syllables;
    int polysyllables;

    public TakeInput(String filePath) {
        this.filePath = filePath;
        tempStr = "";
        sentences = 0;
        words = 0;
        chars = 0;
        letters = 0;
        syllables = 0;
        polysyllables = 0;
    }

    void readFile() {
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                tempStr = scanner.nextLine();

                String[] sentencesArr = tempStr.split("[.!?]");
                sentences = sentencesArr.length;

                String[] wordsArr = tempStr.split("\\s+");
                words += wordsArr.length;

                String[] charsArr = tempStr.replace(" ", "").split("");
                chars += charsArr.length;

                for (int j = 0; j < wordsArr.length; j++) {
                    if (wordsArr[j].matches(".+[.?!,]")) {
                        wordsArr[j] = wordsArr[j].substring(0, wordsArr[j].length() - 1);
                    }
                    letters += wordsArr[j].length();
                    if(wordsArr[j].matches(".+e")) {
                        wordsArr[j] = wordsArr[j].substring(0, wordsArr[j].length() - 1);
                    }
                    determineSyllables(wordsArr[j]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }

    void determineSyllables(String w) {
        String[] a = w.split("");
        int count = 0;
        int i = 0;
        while (i < a.length) {
            if (a[i].matches("[aeiouyAEIOUY]")) {
                count++;
                while (i < a.length && a[i].matches("[aeiouyAEIOUY]")) {
                    i++;
                }
            } else {
                i++;
            }
        }
        if (count == 0) {
            count = 1;
        }
        syllables += count;
        if (count > 2) {
            polysyllables++;
        }
    }

    void printData() {
        System.out.println("The text is:");
        System.out.println(tempStr);
        System.out.println();
        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + chars);
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + polysyllables);
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
    }
}