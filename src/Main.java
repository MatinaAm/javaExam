package src;

import galaxy.Galaxy;
import utils.functions.FileUtilsReadWrite;
import utils.enums.GalaxyNameEnum;
import utils.enums.LifeStatus;
import utils.enums.NaturalResource;
import utils.enums.PlanetType;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

import static utils.functions.FileUtilsReadWrite.extractPlanetName;
import static utils.functions.FileUtilsReadWrite.readExistingData;
import static utils.functions.ParseResources.parseResources;

public class Main {
    public static void main(String[] args) {

        FileUtilsReadWrite fileUtils = new FileUtilsReadWrite();
        String fileName = "D:\\TEST-JAVA-1\\javaExam\\data.txt";

        try {

            Galaxy.displayGalaxies();
            Scanner scanner = new Scanner(System.in);

            // Input for planet details
            System.out.print("نام سیاره را وارد کنید: ");
            String name = scanner.nextLine(); // Name of the planet

            // Input for galaxy
            System.out.print("نام کهکشان را وارد کنید (MILKY_WAY, ANDROMEDA, TRIANGULUM, WHIRLPOOL, SOMBRERO, SPIRAL, ELLIPTICAL, IRREGULAR): ");
            String galaxyName = scanner.nextLine(); // User input for galaxy

            GalaxyNameEnum galaxy;

            try {
                if (galaxyName.isEmpty()) {
                    galaxy = GalaxyNameEnum.MILKY_WAY;
                } else {
                    galaxy = GalaxyNameEnum.valueOf(galaxyName.toUpperCase());
                }
            } catch (IllegalArgumentException e) {
                System.out.println("کهکشان نامعتبر است. از کهکشان پیش‌فرض MILKY_WAY استفاده می‌شود.");
                galaxy = GalaxyNameEnum.MILKY_WAY; // Fallback to MILKY_WAY if input is invalid
            }


            System.out.print("تعداد قمرها را وارد کنید: ");
            int moons = scanner.nextInt(); // Number of moons

            System.out.print("فاصله از خورشید (میلیون کیلومتر) را وارد کنید: ");
            double distanceFromSun = scanner.nextDouble(); // Distance from the sun

            // Select the type of planet
            System.out.print("نوع سیاره (1: ROCK, 2: GAS): ");
            int typeChoice = scanner.nextInt();
            PlanetType type = (typeChoice == 1) ? PlanetType.ROCK : PlanetType.GAS;

            // Input for resources
            System.out.print("آیا این سیاره منابع طبیعی دارد؟ (1: بله، 2: خیر): ");
            int hasResources = scanner.nextInt();

            NaturalResource[] resources;

            if (hasResources == 1) {

                System.out.print("منابع طبیعی را وارد کنید (WATER، GOLD، IRON، ...): ");
                scanner.nextLine(); // Consume newline
                String resourceInput = scanner.nextLine(); // Get user input for resources
                resources = parseResources(resourceInput); // Use helper method to parse and validate input
            } else {
                resources = new NaturalResource[]{NaturalResource.NONE}; // No resources
            }

            // Select life status
            System.out.print("وضعیت حیات (1: HABITABLE, 2: UNHABITABLE): ");
            int lifeChoice = scanner.nextInt();
            LifeStatus lifeStatus = (lifeChoice == 1) ? LifeStatus.HABITABLE : LifeStatus.UNHABITABLE;

            InstancePlanet planet = new InstancePlanet(name, galaxy, moons, type, distanceFromSun, resources, lifeStatus);

            planet.displayPlanetInfo();


            System.out.print("تغییر تعداد قمر: ");
            int moon = scanner.nextInt();
            planet.addMoons(moon);

            planet.displayPlanetInfo();
            Set<String> existingPlanets = readExistingData(fileName);

            System.out.println("Writing to file...");
            String inputData = scanner.nextLine();
            // Check for duplicates
            for (String data : existingPlanets) {
                String planetNames = extractPlanetName(data);
                if (existingPlanets.contains(inputData) || planetNames.equals(name)) {
                    System.out.println("Duplicate entry: This planet data already exists in the file.");
                    return;
                }

            }

            fileUtils.writeFile(fileName, String.valueOf(planet));
            // Reading content from the file
            System.out.println("Reading from file...");
            String fileContent = fileUtils.readFromFile(fileName);
            System.out.println("File Content:");
            scanner.close();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // Output: Planet name must be unique. 'Earth' already exists.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}