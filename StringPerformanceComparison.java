import java.io.*;
import java.util.StringTokenizer;

public class StringPerformanceComparison {
    public static void main(String[] args) {
        compareStringBuilders();
        compareFileReaders("SampleFile");
    }

    private static void compareStringBuilders() {
        String text = "hello";
        int iterations = 1_000_000;


        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) / 1_000_000 + " ms");


        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start) / 1_000_000 + " ms");
    }

    private static void compareFileReaders(String filePath) {
        long start, end;
        int wordCount = 0;


        try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr)) {
            start = System.nanoTime();
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += new StringTokenizer(line).countTokens();
            }
            end = System.nanoTime();
            System.out.println("FileReader word count: " + wordCount);
            System.out.println("FileReader time: " + (end - start) / 1_000_000 + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }

        wordCount = 0;


        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath)); BufferedReader br = new BufferedReader(isr)) {
            start = System.nanoTime();
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += new StringTokenizer(line).countTokens();
            }
            end = System.nanoTime();
            System.out.println("InputStreamReader word count: " + wordCount);
            System.out.println("InputStreamReader time: " + (end - start) / 1_000_000 + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
