package utils.enums;

public enum LifeStatus {
    HABITABLE("has life"),
    UNHABITABLE("no life");


    private final String description;

    LifeStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
