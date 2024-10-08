//package utils;
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//public class FileRead {
//
//        public void writeFile(String fileName, String content) throws IOException {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
//            writer.write(content);
//            writer.write("\n");
//            writer.close();
//        }
//
//
//        public String readFromFile(String fileName) throws IOException {
//            String read;
//            try {
//                FileInputStream stream = new FileInputStream(fileName);
//                Path path = Paths.get(fileName);
//                read = Files.readAllLines(path).get(0);
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//            return read;
//        }
//
//}
//



package utils.functions;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileUtilsReadWrite {

    // Method to write content to a file (appends to the file)
    public void writeFile(String fileName, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true)); // Append mode
        writer.write(content);
        writer.newLine(); // Adds a new line after writing
        writer.close(); // Always close resources
    }

//    ================================

    // Method to read the entire content of a file
    public String readFromFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder(); // To store the entire file content
        try {
            Path path = Paths.get(fileName);
            List<String> lines = Files.readAllLines(path); // Read all lines into a list
            for (String line : lines) {
                content.append(line).append("\n"); // Append each line and a new line character
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return content.toString(); // Convert the StringBuilder to String
    }

//    =====================================
    public static Set<String> readExistingData(String filePath) throws IOException {
        Set<String> planets = new HashSet<>();
        File file = new File(filePath);

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    planets.add(line.trim()); // Add each line to the set
                }
            }
        }
        return planets;
    }


    public static String extractPlanetName(String planetData) {
        if (planetData == null || !planetData.contains("name='")) {
            return "Unknown"; // or throw an exception, depending on your use case
        }

        // Extracting the name using substring
        int startIndex = planetData.indexOf("name='") + 6; // Position after "name='"
        int endIndex = planetData.indexOf("'", startIndex); // Position of the next "'"

        // Check if the endIndex is valid
        if (endIndex == -1 || endIndex <= startIndex) {
            return "Unknown"; // or throw an exception
        }

        return planetData.substring(startIndex, endIndex);
    }

}
