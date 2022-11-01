package InterstellarTravel;

public class Destination {
    private String planetName;
    private String gravity;
    private String temperature;
    private String length_of_day;
    private String population;
    private String description;

    public Destination(String planetName, String gravity, String temperature, String length_of_day, String population,
            String description) {
        this.planetName = planetName;
        this.gravity = gravity;
        this.temperature = temperature;
        this.length_of_day = length_of_day;
        this.population = population;
        this.description = description;
    }

    public String getPlanetName() {
        return planetName;
    }

    public String getGravity() {
        return gravity;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getLength_of_day() {
        return length_of_day;
    }

    public String getPopulation() {
        return population;
    }

    public String getDescription() {
        return description;
    }
}
