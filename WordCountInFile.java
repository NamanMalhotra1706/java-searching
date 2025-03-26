import java.io.*;

public class WordCountInFile {
    public static int countWordOccurrences(String fileName, String wordToFind) {
        int count = 0;
        wordToFind = wordToFind.toLowerCase(); // Convert to lowercase for case-insensitive search

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] words = line.toLowerCase().split("\\W+"); // Split on non-word characters
                for (String word : words) {
                    if (word.equals(wordToFind)) {
                        count++;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {
        String fileName = "SampleFile";
        String wordToFind = "Java";

        int occurrences = countWordOccurrences(fileName, wordToFind);
        System.out.println("The word '" + wordToFind + "' appears " + occurrences + " times in the file.");
    }
}
