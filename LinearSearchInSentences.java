import java.util.Scanner;

public class LinearSearchInSentences {
    public static void main(String[] args) {
        String[] sentences = {
                "The quick brown fox jumps over the lazy dog.",
                "Java is a popular programming language.",
                "Artificial Intelligence is transforming the world.",
                "Data structures and algorithms are fundamental concepts."
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word to search: ");
        String word = scanner.nextLine();

        String result = searchSentence(sentences, word);
        System.out.println("Result: " + result);
    }

    public static String searchSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }
}