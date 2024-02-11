import javax.swing.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            List<String> shortWords = collectAll(selectedFile, new ShortWordFilter());
            System.out.println("Short words in the file:");
            for (String word : shortWords) {
                System.out.println(word);
            }
        } else {
            System.out.println("No file chosen.");
        }
    }

    public static List<String> collectAll(File file, Filter filter) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (filter.accept(word)) {
                        result.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}