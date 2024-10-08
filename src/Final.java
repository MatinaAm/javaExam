package src;

import galaxy.Galaxy;
import utils.enums.GalaxyNameEnum;
import utils.enums.LifeStatus;
import utils.enums.NaturalResource;
import utils.enums.PlanetType;

import java.util.Scanner;

import static utils.enums.GalaxyNameEnum.displayGalaxies;

public class Final {
    public static void main(String[] args) {

                try {
//
//            RockPlanet earth2 = new RockPlanet("Earth", 1, PlanetType.ROCK,150, resources,LifeStatus.UNHABITABLE);
//            RockPlanet earth3 = new RockPlanet("Earth", 1, PlanetType.ROCK,150, resources,LifeStatus.UNHABITABLE);

                    Galaxy.displayGalaxies();

//      ===============

                    Scanner scanner = new Scanner(System.in);

                    // Input for planet details
                    System.out.print("نام سیاره را وارد کنید: ");
                    String name = scanner.nextLine(); // Name of the planet

                    // Input for galaxy
                    System.out.print("نام کهکشان را وارد کنید (MILKY_WAY, ANDROMEDA, TRIANGULUM, WHIRLPOOL, SOMBRERO, SPIRAL, ELLIPTICAL, IRREGULAR): ");
                    String galaxyName = scanner.nextLine(); // User input for galaxy

                    GalaxyNameEnum galaxy;

                    // Check if the input is empty or invalid, use MILKY_WAY if so
                    try {
                        if (galaxyName.isEmpty()) {
                            galaxy = GalaxyNameEnum.MILKY_WAY; // Use MILKY_WAY if no input is provided
                        } else {
                            galaxy = GalaxyNameEnum.valueOf(galaxyName.toUpperCase()); // Convert input to Galaxy enum
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

                        // Convert input to an array of resources
                        resources = new NaturalResource[]{NaturalResource.valueOf(resourceInput.toUpperCase())};
                    } else {
                        resources = new NaturalResource[]{NaturalResource.NONE}; // No resources
                    }

                    // Select life status
                    System.out.print("وضعیت حیات (1: HABITABLE, 2: UNHABITABLE): ");
                    int lifeChoice = scanner.nextInt();
                    LifeStatus lifeStatus = (lifeChoice == 1) ? LifeStatus.HABITABLE : LifeStatus.UNHABITABLE;

                    InstancePlanet planet = new InstancePlanet(name, galaxy,moons, type, distanceFromSun, resources, lifeStatus);

                    planet.displayPlanetInfo();


                    System.out.print("تعداد ماه: ");
                    int moon = scanner.nextInt();
                    planet.addMoons(moon);

                    planet.displayPlanetInfo();

                    scanner.close();


                } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // Output: Planet name must be unique. 'Earth' already exists.
        }


//        ======================


    }
}