package utils.abstracts;

import utils.enums.GalaxyNameEnum;
import utils.enums.LifeStatus;
import utils.enums.NaturalResource;
import utils.enums.PlanetType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Planet  {


    private String name;  //  نام یکتا و غیرتکراری
    private GalaxyNameEnum galaxyName;  //  نام یکتا و غیرتکراری
    private PlanetType type;  // استفاده از enum برای نوع سیاره
    private int moons;    // تعداد قمرها
    private double distanceFromSun;  // فاصله از خورشید (واحد: میلیون کیلومتر)

    private List<NaturalResource> resources;  // List to hold resources available on the planet

    public Planet(String name, GalaxyNameEnum galaxyNameEnum, PlanetType type, int moons, double distanceFromSun, List<NaturalResource> resources, LifeStatus lifeStatus) {
        setName(name);  // Use setter to validate name
        this.galaxyName = galaxyNameEnum;
        this.type = type;
        this.moons = moons;
        this.distanceFromSun = distanceFromSun;
        this.resources = resources;
        this.lifeStatus = lifeStatus;
    }

    private LifeStatus lifeStatus; // Life status of the planet


    private static Set<String> existingNames = new HashSet<>();


    public Planet(String name, PlanetType type, int moons, double distanceFromSun) {
        setName(name);  // Use setter to validate name
        this.type = type;
        this.moons = moons;
        this.distanceFromSun = distanceFromSun;
        this.resources = new ArrayList<>(); // Initialize the resources list

    }

    public Planet(String name, PlanetType planetType, int moons, double distanceFromSun, LifeStatus lifeStatus) {
    }

    // Getters و Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {


        if (existingNames.contains(name)) {
            throw new IllegalArgumentException("Planet name must be unique. '" + name + "' already exists.");
        }
        // If changing the name, remove the old name from the set
        if (this.name != null) {
            existingNames.remove(this.name);
        }
        this.name = name;  // Set the new name
        existingNames.add(name);  // Add the new name to the set

    }

    public PlanetType getType() {
        return type;
    }

    public void setType(PlanetType type) {
        this.type = type;
    }

    public int getMoons() {
        return moons;
    }

    public void setMoons(int moons) {
        this.moons = moons;
    }

    public double getDistanceFromSun() {
        return distanceFromSun;
    }

    public void setDistanceFromSun(double distanceFromSun) {
        this.distanceFromSun = distanceFromSun;
    }

    public boolean isHabitable() {
        return lifeStatus == LifeStatus.HABITABLE;
    }
    public void addResources(NaturalResource resource) {
        if (resource != NaturalResource.NONE) {
            resources.add(resource);
        }
    }

    public abstract void displayPlanetInfo();

    public abstract double calculateOrbitalPeriod();
    public abstract void addMoons(int moons);
    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", type=" + galaxyName +
                ", type=" + type +
                ", moons=" + moons +
                ", distanceFromSun=" + distanceFromSun +
                ", resources=" + resources +
                ", lifeStatus=" + lifeStatus +
                '}';
    }
}
