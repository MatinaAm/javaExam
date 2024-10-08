package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DuplicateFinder {
    public static void main(String[] args) {
        String filePath = "D:\\TEST-JAVA-2\\test.txt";
//        String filePath = "path/to/your/file.txt"; // Replace with your file path
        findDuplicates(filePath);
    }

    public static void findDuplicates(String filePath) {
        Set<String> lines = new HashSet<>(); // Set to store unique lines
        Set<String> duplicates = new HashSet<>(); // Set to store duplicates

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // If the line is already in the set, it's a duplicate
                if (!lines.add(line)) {
                    duplicates.add(line); // Add to duplicates set
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the results
        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            System.out.println("Duplicate lines found:");
            for (String duplicate : duplicates) {
                System.out.println(duplicate);
            }
        }
    }
}