package InterstellarTravel;

public class Ticket {
    String destination;
    String date;
    String rocket;
    String id;

    public Ticket(String destination, String date, String rocket, String id) {
        this.destination = destination;
        this.date = date;
        this.rocket = rocket;
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getRocket() {
        return rocket;
    }

    public String getId() {
        return id;
    }
}
