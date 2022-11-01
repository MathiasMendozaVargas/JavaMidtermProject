package InterstellarTravel;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<Ticket> tickets;

    public User(String username, String password, ArrayList<Ticket> tickets) {
        this.username = username;
        this.password = password;
        this.tickets = tickets;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    static User checkUser(String user, String pass, ArrayList<User> list_of_users) {
        User userName = null;
        for (User username : list_of_users) {
            if (username.getUsername().equals(user)) {
                if (pass.equals(username.getPassword())) {
                    userName = username;
                }
            }
        }
        return userName;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
}
