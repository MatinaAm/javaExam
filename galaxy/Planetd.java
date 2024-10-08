package galaxy;

import utils.enums.PlanetType;

public class Planetd {
    private String name;  // نام یکتا و غیرتکراری
    private PlanetType type;  // استفاده از enum برای نوع سیاره

    private int moons;    // تعداد قمرها
    private double distanceFromSun;  // فاصله از خورشید (واحد: میلیون کیلومتر)



    // سازنده (Constructor)
    public Planetd(String name, PlanetType type, int moons, double distanceFromSun) {
        this.name = name;
        this.type = type;
        this.moons = moons;
        this.distanceFromSun = distanceFromSun;
    }

    // Getters و Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlanetType  getType() {
        return type;
    }

    public void setType(PlanetType  type) {
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

    @Override
    public String toString() {
        return "Planet: " + name + ", Type: " + type + ", Moons: " + moons + ", Distance: " + distanceFromSun + " million km";
    }
}
