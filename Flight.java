package InterstellarTravel;

public class Flight {
    private String destination;
    private String rocket;
    private String time;
    private Integer price;

    public Flight(String destination, String rocket, String time, Integer price) {
        this.destination = destination;
        this.rocket = rocket;
        this.time = time;
        this.price = price;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getRocket() {
        return this.rocket;
    }

    public String getTime() {
        return this.time;
    }

    public Integer getPrice() {
        return this.price;
    }
}
