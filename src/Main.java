package src;

import galaxy.Galaxy;
import utils.functions.FileUtilsReadWrite;
import utils.enums.GalaxyNameEnum;
import utils.enums.LifeStatus;
import utils.enums.NaturalResource;
import utils.enums.PlanetType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static utils.functions.FileUtilsReadWrite.extractPlanetName;
import static utils.functions.FileUtilsReadWrite.readExistingData;
import static utils.functions.ParseResources.parseResources;

public class Main {
    private static final String FILE_NAME = "D:\\TEST-JAVA-1\\javaExam\\data.txt";
    private static final Scanner scanner = new Scanner(System.in);
    private static final FileUtilsReadWrite fileUtils = new FileUtilsReadWrite();

    public static void main(String[] args) {
//           String fileName = "D:\\TEST-JAVA-1\\javaExam\\data.txt";
        try {

            displayMenu();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void displayMenu() throws IOException {
        boolean running = true;
        while (running) {
            System.out.println("\nGalaxy Management System:");
            System.out.println("1. Display Galaxies");
            System.out.println("2. Add New Planet");
            System.out.println("3. Change Moon Count of a Planet");
            System.out.println("4. Display Planet Information");
            System.out.println("5. Save and Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            running = executeChoice(choice);
        }
    }

    private static boolean executeChoice(int choice) throws IOException {
        switch (choice) {
            case 1 -> displayGalaxies();
            case 2 -> addPlanet();
            case 3 -> changeMoonCount();
            case 4 -> displayPlanetInfo();
            case 5 -> {
                System.out.println("Saving data and exiting...");
                saveAndExit();
                return false;
            }
            default -> System.out.println("Invalid choice! Please select a valid option.");
        }
        return true;
    }

    private static void displayGalaxies() throws IOException {
        FileUtilsReadWrite fileUtils = new FileUtilsReadWrite();
        String fileName = "D:\\TEST-JAVA-1\\javaExam\\data.txt";
        String fileContent = fileUtils.readFromFile(fileName);
        System.out.println(fileContent + "Displaying all galaxies...");
    }

    private static void addPlanet() throws IOException {
        System.out.print("Enter planet name: ");
        String name = scanner.nextLine();

        Galaxy galaxy = getGalaxyFromUser();

        System.out.print("Enter the number of moons: ");
        int moons = scanner.nextInt();

        System.out.print("Enter the distance from the sun (in million km): ");
        double distanceFromSun = scanner.nextDouble();

        PlanetType type = getPlanetTypeFromUser();

        NaturalResource[] resources = getResourcesFromUser();

        LifeStatus lifeStatus = getLifeStatusFromUser();

        InstancePlanet planet = new InstancePlanet(name, galaxy.getName(), moons, type, distanceFromSun, resources, lifeStatus);
        planet.displayPlanetInfo();
        Set<String> existingPlanets = readExistingData(FILE_NAME);
        addPlanetToFile(planet, name, existingPlanets);
    }

    private static Galaxy getGalaxyFromUser() {
        System.out.println("Enter galaxy name or choose from the following:");
        for (GalaxyNameEnum g : GalaxyNameEnum.values()) {
            System.out.println("- " + g);
        }
        String input = scanner.nextLine().toUpperCase();

        try {
            GalaxyNameEnum galaxyEnum = GalaxyNameEnum.valueOf(input);
            return new Galaxy(galaxyEnum);
        } catch (IllegalArgumentException e) {
            return new Galaxy(input);
        }
    }

    private static PlanetType getPlanetTypeFromUser() {
        System.out.print("Enter planet type (1: ROCK, 2: GAS): ");
        int typeChoice = scanner.nextInt();
        return (typeChoice == 1) ? PlanetType.ROCK : PlanetType.GAS;
    }

    private static NaturalResource[] getResourcesFromUser() {
        System.out.print("Does this planet have natural resources? (1: Yes, 2: No): ");
        int hasResources = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (hasResources == 1) {
            System.out.print("Enter natural resources (e.g., WATER, GOLD, IRON): ");
            String resourceInput = scanner.nextLine();
            return parseResources(resourceInput);
        }
        return new NaturalResource[]{NaturalResource.NONE};
    }

    private static LifeStatus getLifeStatusFromUser() {
        System.out.print("Enter life status (1: HABITABLE, 2: UNHABITABLE): ");
        int lifeChoice = scanner.nextInt();
        return (lifeChoice == 1) ? LifeStatus.HABITABLE : LifeStatus.UNHABITABLE;
    }

    private static void addPlanetToFile(InstancePlanet planet, String name, Set<String> existingPlanets) throws IOException {
        boolean isDuplicate = existingPlanets.stream()
                .anyMatch(data -> extractPlanetName(data).equals(name));

        if (isDuplicate) {
            System.out.println("Duplicate entry: This planet data already exists in the file.");
            existingPlanets.removeIf(data -> extractPlanetName(data).equals(name));
        }
        existingPlanets.add(planet.toString());
        fileUtils.writeFile2(FILE_NAME, planet.toString(), isDuplicate, existingPlanets);
        System.out.println("Planet data saved successfully.");
    }


    private static void changeMoonCount() throws IOException {
        System.out.print("Enter the name of the planet to update moon count: ");
        String targetPlanetName = scanner.nextLine();

        System.out.print("Enter the new moon count: ");
        int newMoonCount = scanner.nextInt();

        // Read all lines from the file
        List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
        boolean found = false;

        // Create a StringBuilder to hold updated lines
        StringBuilder updatedContent = new StringBuilder();

        for (String line : lines) {
            // Check if the line contains the planet name
            if (line.contains("name='" + targetPlanetName + "'")) {
                found = true;
                // Update the moons count in the line
                line = line.replaceAll("moons=\\d+", "moons=" + newMoonCount);
                System.out.println("Updated Planet data: " + line);
            }
            updatedContent.append(line).append(System.lineSeparator());
        }

        if (found) {
            // Write the updated content back to the file
            Files.write(Paths.get(FILE_NAME), updatedContent.toString().getBytes());
            System.out.println("Moon count updated successfully.");
        } else {
            System.out.println("Planet with name '" + targetPlanetName + "' not found.");
        }
    }


    private static void displayPlanetInfo() throws IOException {

        System.out.print("Enter the name of the planet to be displayed: ");
        String targetPlanetName = scanner.nextLine();

        // Read all lines from the file
        List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));

        for (String line : lines) {
            // Check if the line contains the planet name
            if (line.contains("name='" + targetPlanetName + "'")) {
                System.out.println("Fetched Planet data: " + line);
            }
        }
    }

    private static void saveAndExit() throws IOException {
        String fileContent = fileUtils.readFromFile(FILE_NAME);
        System.out.println("File content:\n" + fileContent);
    }
}
