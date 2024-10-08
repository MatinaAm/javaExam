package src;

import galaxy.Galaxy;
import utils.enums.GalaxyNameEnum;
import utils.enums.LifeStatus;
import utils.enums.NaturalResource;
import utils.enums.PlanetType;

public class Main {
    public static void main(String[] args) {



        NaturalResource[] resources = {NaturalResource.COPPER , NaturalResource.IRON};
//
//        RockPlanet earth = new RockPlanet("Earth" , GalaxyNameEnum.MILKY_WAY,2, PlanetType.ROCK,150, resources,LifeStatus.UNHABITABLE);
//        Galaxy galaxy = new Galaxy(GalaxyNameEnum.ANDROMEDA);
//
//        galaxy.addPlanet(earth);
//        galaxy.displayGalaxyInfo();
//
////        System.out.println(galaxy + "galaxy=========");
//        earth.displayPlanetInfo(); // Displays information about Earth


//
//        // Checking if the planet is habitable
//        if (earth.isHabitable()) {
//            System.out.println(earth.getName() + " is a habitable planet.");
//        } else {
//            System.out.println(earth.getName() + " is not a habitable planet.");
//        }
//
//
//
//        try {
//
//            RockPlanet earth2 = new RockPlanet("Earth", 1, PlanetType.ROCK,150, resources,LifeStatus.UNHABITABLE);
//            RockPlanet earth3 = new RockPlanet("Earth", 1, PlanetType.ROCK,150, resources,LifeStatus.UNHABITABLE);
//
//            System.out.println(earth);
//
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());  // Output: Planet name must be unique. 'Earth' already exists.
//        }
    }
}