package galaxy;

import utils.abstracts.Planet;
import utils.enums.GalaxyNameEnum;

import java.util.ArrayList;
import java.util.List;

public class Galaxy {
    private GalaxyNameEnum galaxyName;
    private String customName;
    private List<Planet> planets;

    // Constructor for predefined galaxy names
    public Galaxy(GalaxyNameEnum galaxyName) {
        this.galaxyName = galaxyName;
        this.planets = new ArrayList<>();
    }

    // Constructor for a custom galaxy name
    public Galaxy(String customName) {
        this.customName = customName;
        this.planets = new ArrayList<>();
    }

    public String getName() {
        return (galaxyName != null) ? galaxyName.name() : customName;
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }


    public List<Planet> getPlanets() {
        return planets;
    }

    public void displayPlanets() {
        System.out.println("Planets in " + getName() + ":");
        for (Planet planet : planets) {
            System.out.println("- " + planet.getName());
        }
    }



//    public boolean displayPlanets(String targetPlanetName) {
//        boolean found = false;
//
//        for (Planet planet : planets) {
//            System.out.println("Planets in " + planet + ":");
//
//            System.out.println("- " + planet.getName());
//            if (planet.getName().equals(targetPlanetName)) {
//                found = true;
//            }
//        }
//
//        if (found) {
//            System.out.println("Planet '" + targetPlanetName + "' is available.");
//        } else {
//            System.out.println("Planet '" + targetPlanetName + "' is not available.");
//        }
//        return found;
//    }

}