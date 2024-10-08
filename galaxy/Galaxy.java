package galaxy;

import utils.abstracts.Planet;
import utils.enums.GalaxyNameEnum;

import java.util.ArrayList;
import java.util.List;

public class Galaxy {
    private GalaxyNameEnum name;  //  نام یکتا و غیرتکراری
    private List<Planet> planets; // List to hold planets in the galaxy

    public Galaxy(GalaxyNameEnum name) {
        this.name = name;
        this.planets = new ArrayList<>(); // Initialize the list of planets
    }

    public Galaxy(String name) {
        this.name = GalaxyNameEnum.valueOf(name);
        this.planets = new ArrayList<>(); // Initialize the list of planets
    }

    // Method to add a planet to the galaxy
    public void addPlanet(Planet planet) {
        planets.add(planet);
    }

    public GalaxyNameEnum getName() {
        return name;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public static void displayGalaxies() {
        System.out.println("کهکشان‌های موجود:");
        for (GalaxyNameEnum galaxy : GalaxyNameEnum.values()) {
            System.out.println(galaxy);
        }
    }

    public void displayGalaxyInfo() {
        System.out.println("Galaxy: " + name);
        for (Planet planet : planets) {
            planet.displayPlanetInfo(); // Display info for each planet
        }
    }
}
