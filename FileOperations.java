import java.io.*;

/**
 * Demonstrates file operations in Java, including reading, writing, and modifying text files.
 */
public class FileOperations {

    /**
     * Writes text to a file.
     *
     * @param fileName the name of the file to write to
     * @param text     the text to write to the file
     */
    public static void writeToFile(String fileName, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(text);
            System.out.println("Text written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Reads text from a file.
     *
     * @param fileName the name of the file to read from
     * @return the text read from the file
     */
    public static String readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
            System.out.println("Text read from " + fileName);
            return text.toString();
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            return "";
        }
    }

    /**
     * Modifies text in a file by replacing a given string with a new string.
     *
     * @param fileName the name of the file to modify
     * @param oldString the string to replace
     * @param newString the string to replace with
     */
    public static void modifyFile(String fileName, String oldString, String newString) {
        String text = readFromFile(fileName);
        text = text.replace(oldString, newString);
        writeToFile(fileName, text);
        System.out.println("File " + fileName + " modified");
    }

    public static void main(String[] args) {
        // Create a new file and write text to it
        writeToFile("example.txt", "Hello, World!");

        // Read text from the file
        String text = readFromFile("example.txt");
        System.out.println("Text: " + text);

        // Modify the text in the file
        modifyFile("example.txt", "World", "Universe");

        // Read the modified text from the file
        text = readFromFile("example.txt");
        System.out.println("Modified Text: " + text);
    }
}


