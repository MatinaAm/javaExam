package src;

import utils.abstracts.Planet;
import utils.enums.GalaxyNameEnum;
import utils.enums.LifeStatus;
import utils.enums.NaturalResource;
import utils.enums.PlanetType;

import java.util.List;

public class InstancePlanet extends Planet {
    public InstancePlanet(String name, String galaxy , int moons, PlanetType type, double distanceFromSun, NaturalResource[] resource, LifeStatus habitable ) {
        super(name,galaxy, type, moons, distanceFromSun, List.of(resource),habitable);
    }

    @Override
    public void displayPlanetInfo() {
        System.out.println(this );
    }

    @Override
    public double calculateOrbitalPeriod() {
        // Example calculation (this is just a placeholder)
        return 2 * Math.PI * ( this.getDistanceFromSun()); // Circular orbit approximation
    }

    @Override
    public void addMoons(int moons) {
        if (moons > 0) {
            int currentMoons = this.getMoons(); // Get the current number of moons
            setMoons(currentMoons + moons); // Update the number of moons
            System.out.println("you have "+ currentMoons + moons + "moons now");

        } else {
            System.out.println("Cannot add a negative number of moons.");
        }
    }
}