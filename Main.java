package InterstellarTravel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Creating the Default User
        User current_user = null;

        // Creating the Users manually
        User user1 = new User("mathiasmendoza", "password", null);
        User user2 = new User("The Rock", "rocky", null);

        ArrayList<User> list_of_users = new ArrayList<User>();
        list_of_users.add(user1);
        list_of_users.add(user2);

        // Creating the flights
        Flight flight1 = new Flight("Moon", "Saturn V", "November 24th 2022", 50);
        Flight flight2 = new Flight("Mars", "Starship", "January 24th 2023", 120);
        Flight flight3 = new Flight("Mars", "New Glenn", "January 28th 2023", 220);
        Flight flight4 = new Flight("Moon", "SLS", "Febraury 19th 2023", 60);
        Flight flight5 = new Flight("Jupiter", "SADB V (Shields are down, Baby!)", "March 14th 2023", 440);
        Flight flight6 = new Flight("Proxima Centauri B", "Morpheudizer", "September 12th 2023", 850);

        ArrayList<Flight> list_of_flights = new ArrayList<Flight>();
        list_of_flights.add(flight1);
        list_of_flights.add(flight2);
        list_of_flights.add(flight3);
        list_of_flights.add(flight4);
        list_of_flights.add(flight5);
        list_of_flights.add(flight6);

        // Create the Planets Info
        Destination destination1 = new Destination("Earth's Moon", "16.6% that on Earth's surface",
                "Between (-208, 250) degrees F", "27.3 Earth days to complete a single rotation on its axis.", "22K",
                "The Moon is Earth's only natural satellite and the fifth largest moon in the solar system.");
        Destination destination2 = new Destination("Mars", "0.375 that of Earth", "Average -81 degrees F",
                "24 hours 37 minutes", "2M+",
                "Mars is the fourth planet from the Sun and the next planet beyond Earth. It is, on average, more than 142 million miles from the Sun.");
        Destination destination3 = new Destination("Jupiter", "2.5 times than Earth's Gravity",
                "Average -234 degrees F", "9 hours and 53 minutes", "150K+",
                "Jupiter is the fifth planet from the Sun and the largest in the Solar System. It is a gas giant with a mass more than two and a half times that of all the other planets in the Solar System combined, but slightly less than one-thousandth the mass of the Sun.");
        Destination destination4 = new Destination("Proxima Centauri B", "1.3 times more than Earth's gravity",
                "Average of -38F", "11.2 Earth days (orbital period)", "1.5M+",
                "Proxima Centauri b, sometimes referred to as Alpha Centauri Cb, is an exoplanet orbiting in the habitable zone of the red dwarf star Proxima Centauri, which is the closest star to the Sun and part of the triple star system Alpha Centauri");

        ArrayList<Destination> list_of_destinations = new ArrayList<Destination>();
        list_of_destinations.add(destination1);
        list_of_destinations.add(destination2);
        list_of_destinations.add(destination3);
        list_of_destinations.add(destination4);

        // Start the Program
        startMenu(list_of_flights, list_of_destinations, current_user, list_of_users);
    }

    public static void startMenu(ArrayList<Flight> list_of_flights, ArrayList<Destination> list_of_destinations,
            User current_user, ArrayList<User> list_of_users) {
        System.out.println("************************************************");
        System.out.println("*     Welcome to the Interstellar Travesls!    *");
        System.out.println("************************************************");

        System.out.println("We take you to any destination inside our solar system, Proxima Centauri and more!\n");
        System.out.println("///////////////////////");
        System.out.println("/   Menu of Options   /");
        System.out.println("///////////////////////");

        List<String> menu_options = new ArrayList<>();
        menu_options.add("Book a flight");
        menu_options.add("Learn about our destinations");
        menu_options.add("See my tickets");

        for (int i = 0; i < menu_options.size(); i++) {
            System.out.println(i + 1 + ".-" + " " + menu_options.get(i));
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nMake your selection");
            int menu_selection = scanner.nextInt();

            switch (menu_selection) {
                case 1:
                    System.out.println(
                            "\n/////////////" +
                                    "/  Upcoming Flights  " +
                                    "///////////////");
                    for (int i = 0; i < list_of_flights.size(); i++) {
                        System.out.println(i + 1 + ".- " + list_of_flights.get(i).getDestination() + " - "
                                + list_of_flights.get(i).getTime());
                    }
                    System.out.println("Make a selection");
                    int user_destination = scanner.nextInt();
                    user_destination = user_destination - 1;

                    if (current_user == null) {
                        System.out.println("\nPlease, you need to sign in or sign up first!");
                        System.out.println("1.- Sign in");
                        System.out.println("2.- Sign up");
                        System.out.println("\nMake your selection, 1 for sign in, 2 for sign up.");
                        int sign_decision = scanner.nextInt();

                        if (sign_decision == 1) {
                            User currentUser = SignIn(list_of_users);
                            System.out.println("\n#################################################");
                            System.out.println("Welcome back! Glad you wanna move to "
                                    + list_of_flights.get(user_destination).getDestination() + "!");
                            System.out.println("#################################################\n");
                            System.out.println(
                                    "Destination: " + list_of_flights.get(user_destination).getDestination());
                            System.out.println("Rocket: " + list_of_flights.get(user_destination).getRocket());
                            System.out.println("Date: " + list_of_flights.get(user_destination).getTime());
                            System.out.println(
                                    "Ticket price: $" + list_of_flights.get(user_destination).getPrice() + "k");

                            scanner.nextLine();
                            System.out.println("\nWould you like to buy a ticket? (yes/no)");

                            String buy_decision = scanner.nextLine();

                            if (buy_decision.equals("yes")) {
                                System.out.println("Are you confirming to buy a ticker for "
                                        + list_of_flights.get(user_destination).getDestination() + " on "
                                        + list_of_flights.get(user_destination).getTime() + "? (yes/no)");
                                String buy_decision2 = scanner.nextLine();
                                if (buy_decision2.equals("yes")) {
                                    Ticket newTicket = new Ticket(
                                            list_of_flights.get(user_destination).getDestination(),
                                            list_of_flights.get(user_destination).getTime(),
                                            list_of_flights.get(user_destination).getRocket(),
                                            currentUser.getUsername());
                                    if (currentUser.getTickets() == null) {
                                        ArrayList<Ticket> list_Tickets = new ArrayList<Ticket>();
                                        list_Tickets.add(newTicket);
                                        currentUser.setTickets(list_Tickets);
                                    } else {
                                        currentUser.getTickets().add(newTicket);
                                    }

                                    System.out.println("\n################################################");
                                    System.out.println("Congrats! You just bought the ticket for "
                                            + list_of_flights.get(user_destination).getDestination() + "!");
                                    System.out.println("################################################");

                                    System.out.println("\n/////////////////");
                                    System.out.println("// Page Handler");
                                    System.out.println("////////////////");
                                    System.out.println("1.- Go to Main Menu section\n2.- Quit the program");

                                    Integer page_handler = scanner.nextInt();

                                    switch (page_handler) {
                                        case 1:
                                            startMenu(list_of_flights, list_of_destinations, currentUser,
                                                    list_of_users);
                                        case 2:
                                            break;
                                    }

                                } else if (buy_decision2 == "no") {
                                    startMenu(list_of_flights, list_of_destinations, currentUser,
                                            list_of_users);
                                }
                            } else if (buy_decision.equals("no")) {
                                startMenu(list_of_flights, list_of_destinations, currentUser, list_of_users);
                            }
                        } else if (sign_decision == 2) {
                            User currentUser = SignUp();

                            list_of_users.add(currentUser);

                            System.out.println("\n#################################################");
                            System.out.println("Welcome back! Glad you wanna move to "
                                    + list_of_flights.get(user_destination).getDestination() + "!");
                            System.out.println("#################################################\n");
                            System.out.println(
                                    "Destination: " + list_of_flights.get(user_destination).getDestination());
                            System.out.println("Rocket: " + list_of_flights.get(user_destination).getRocket());
                            System.out.println("Date: " + list_of_flights.get(user_destination).getTime());
                            System.out.println(
                                    "Ticket price: $" + list_of_flights.get(user_destination).getPrice() + "k");

                            scanner.nextLine();
                            System.out.println("\nWould you like to buy a ticket? (yes/no)");

                            String buy_decision = scanner.nextLine();

                            if (buy_decision.equals("yes")) {
                                System.out.println("Are you confirming to buy a ticker for "
                                        + list_of_flights.get(user_destination).getDestination() + " on "
                                        + list_of_flights.get(user_destination).getTime() + "? (yes/no)");
                                String buy_decision2 = scanner.nextLine();
                                if (buy_decision2.equals("yes")) {
                                    Ticket newTicket = new Ticket(
                                            list_of_flights.get(user_destination).getDestination(),
                                            list_of_flights.get(user_destination).getTime(),
                                            list_of_flights.get(user_destination).getRocket(),
                                            currentUser.getUsername());
                                    if (currentUser.getTickets() == null) {
                                        ArrayList<Ticket> list_Tickets = new ArrayList<Ticket>();
                                        list_Tickets.add(newTicket);
                                        currentUser.setTickets(list_Tickets);
                                    } else {
                                        currentUser.getTickets().add(newTicket);
                                    }
                                    System.out.println("\n################################################");
                                    System.out.println("Congrats! You just bought the ticket for "
                                            + list_of_flights.get(user_destination).getDestination() + "!");
                                    System.out.println("################################################");

                                    System.out.println("\n/////////////////");
                                    System.out.println("// Page Handler");
                                    System.out.println("////////////////");
                                    System.out.println("1.- Go to Main Menu section\n2.- Quit the program");

                                    Integer page_handler = scanner.nextInt();

                                    switch (page_handler) {
                                        case 1:
                                            startMenu(list_of_flights, list_of_destinations, currentUser,
                                                    list_of_users);
                                        case 2:
                                            break;
                                    }

                                } else if (buy_decision2 == "no") {
                                    startMenu(list_of_flights, list_of_destinations, currentUser,
                                            list_of_users);
                                }
                            } else if (buy_decision.equals("no")) {
                                startMenu(list_of_flights, list_of_destinations, currentUser, list_of_users);
                            }
                        }
                    } else {
                        System.out.println("\n#################################################");
                        System.out.println("Welcome back! Glad you wanna move to "
                                + list_of_flights.get(user_destination).getDestination() + "!");
                        System.out.println("#################################################\n");
                        System.out.println(
                                "Destination: " + list_of_flights.get(user_destination).getDestination());
                        System.out.println("Rocket: " + list_of_flights.get(user_destination).getRocket());
                        System.out.println("Date: " + list_of_flights.get(user_destination).getTime());
                        System.out.println(
                                "Ticket price: $" + list_of_flights.get(user_destination).getPrice() + "k");

                        scanner.nextLine();
                        System.out.println("\nWould you like to buy a ticket? (yes/no)");

                        String buy_decision = scanner.nextLine();

                        if (buy_decision.equals("yes")) {
                            System.out.println("Are you confirming to buy a ticker for "
                                    + list_of_flights.get(user_destination).getDestination() + " on "
                                    + list_of_flights.get(user_destination).getTime() + "? (yes/no)");
                            String buy_decision2 = scanner.nextLine();
                            if (buy_decision2.equals("yes")) {
                                Ticket newTicket = new Ticket(
                                        list_of_flights.get(user_destination).getDestination(),
                                        list_of_flights.get(user_destination).getTime(),
                                        list_of_flights.get(user_destination).getRocket(),
                                        current_user.getUsername());
                                if (current_user.getTickets() == null) {
                                    ArrayList<Ticket> list_Tickets = new ArrayList<Ticket>();
                                    list_Tickets.add(newTicket);
                                    current_user.setTickets(list_Tickets);
                                } else {
                                    current_user.getTickets().add(newTicket);
                                }

                                System.out.println("\n################################################");
                                System.out.println("Congrats! You just bought the ticket for "
                                        + list_of_flights.get(user_destination).getDestination() + "!");
                                System.out.println("################################################");

                                System.out.println("\n/////////////////");
                                System.out.println("// Page Handler");
                                System.out.println("////////////////");
                                System.out.println("1.- Go to Main Menu section\n2.- Quit the program");

                                Integer page_handler = scanner.nextInt();

                                switch (page_handler) {
                                    case 1:
                                        startMenu(list_of_flights, list_of_destinations, current_user,
                                                list_of_users);
                                    case 2:
                                        break;
                                }

                            } else if (buy_decision2 == "no") {
                                startMenu(list_of_flights, list_of_destinations, current_user,
                                        list_of_users);
                            }
                        } else if (buy_decision.equals("no")) {
                            startMenu(list_of_flights, list_of_destinations, current_user, list_of_users);
                        }
                    }

                case 2:
                    System.out.println(
                            "\n/////////////" +
                                    "/  Destinations  " +
                                    "///////////////");
                    for (int i = 0; i < list_of_destinations.size(); i++) {
                        System.out.println(i + 1 + ".- " + list_of_destinations.get(i).getPlanetName());
                    }
                    System.out.println("\nMake your selection");
                    int dest_selection = scanner.nextInt();
                    showPlanetInfo(list_of_destinations.get(dest_selection - 1), list_of_flights, list_of_destinations,
                            current_user, list_of_users);

                    break;
                case 3:
                    if (current_user == null) {
                        System.out.println("\nPlease, you need to sign in or sign up first!");
                        System.out.println("1.- Sign in");
                        System.out.println("2.- Sign up");
                        System.out.println("\nMake your selection, 1 for sign in, 2 for sign up.");
                        int sign_decision = scanner.nextInt();

                        if (sign_decision == 1) {
                            User curUser = SignIn(list_of_users);
                            System.out.println("########################");
                            System.out.println("#  Your Tickets  ");
                            System.out.println("########################");
                            if (curUser.getTickets() == null) {
                                System.out.println("\nSorry, you don't have any tickets...");

                                System.out.println("\n/////////////////");
                                System.out.println("// Page Handler");
                                System.out.println("////////////////");
                                System.out.println("1.- Go to Main Menu section\n2.- Quit the program");

                                Integer page_handler = scanner.nextInt();

                                switch (page_handler) {
                                    case 1:
                                        startMenu(list_of_flights, list_of_destinations, curUser,
                                                list_of_users);
                                    case 2:
                                        break;
                                }

                            } else {
                                for (int i = 0; i < curUser.getTickets().size(); i++) {
                                    System.out.println(i + 1 + ".- " + curUser.getTickets().get(i).getDestination()
                                            + " / " + curUser.getTickets().get(i).getDate() + " / "
                                            + curUser.getTickets().get(i).getRocket());
                                }

                                System.out.println("\n/////////////////");
                                System.out.println("// Page Handler");
                                System.out.println("////////////////");
                                System.out.println("1.- Go to Main Menu section\n2.- Quit the program");

                                Integer page_handler = scanner.nextInt();

                                switch (page_handler) {
                                    case 1:
                                        startMenu(list_of_flights, list_of_destinations, curUser,
                                                list_of_users);
                                    case 2:
                                        break;
                                }
                            }
                        } else if (sign_decision == 2) {
                            User curUser = SignUp();

                            System.out.println("########################");
                            System.out.println("#  Your Tickets  ");
                            System.out.println("########################");
                            if (curUser.getTickets() == null) {
                                System.out.println("\nSorry, you don't have any tickets...");

                                System.out.println("\n/////////////////");
                                System.out.println("// Page Handler");
                                System.out.println("////////////////");
                                System.out.println("1.- Go to Main Menu section\n2.- Quit the program");

                                Integer page_handler = scanner.nextInt();

                                switch (page_handler) {
                                    case 1:
                                        startMenu(list_of_flights, list_of_destinations, curUser,
                                                list_of_users);
                                    case 2:
                                        break;
                                }

                            }
                        }
                    } else {
                        System.out.println("########################");
                        System.out.println("#  Your Tickets  ");
                        System.out.println("########################");
                        if (current_user.getTickets() == null) {
                            System.out.println("\nSorry, you don't have any tickets...");

                            System.out.println("\n/////////////////");
                            System.out.println("// Page Handler");
                            System.out.println("////////////////");
                            System.out.println("1.- Go to Main Menu section\n2.- Quit the program");

                            Integer page_handler = scanner.nextInt();

                            switch (page_handler) {
                                case 1:
                                    startMenu(list_of_flights, list_of_destinations, current_user,
                                            list_of_users);
                                case 2:
                                    break;
                            }

                        } else {
                            for (int i = 0; i < current_user.getTickets().size(); i++) {
                                System.out.println(i + 1 + ".- " + current_user.getTickets().get(i).getDestination()
                                        + " / " + current_user.getTickets().get(i).getDate() + " / "
                                        + current_user.getTickets().get(i).getRocket());
                            }

                            System.out.println("\n/////////////////");
                            System.out.println("// Page Handler");
                            System.out.println("////////////////");
                            System.out.println("1.- Go to Main Menu section\n2.- Quit the program");
                            scanner.nextLine();
                            Integer page_handler = scanner.nextInt();

                            switch (page_handler) {
                                case 1:
                                    startMenu(list_of_flights, list_of_destinations, current_user,
                                            list_of_users);
                                case 2:
                                    break;
                            }
                        }
                    }
            }
        }
    }

    public static User SignIn(ArrayList<User> list_of_users) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n################################");
                System.out.println("# Please enter your login info");
                System.out.println("################################");

                scanner.nextLine();
                System.out.println("Enter your username");
                String username = scanner.nextLine();
                System.out.println("\nEnter your password");
                String password = scanner.nextLine();

                User currenUser = User.checkUser(username, password, list_of_users);
                if (currenUser == null) {
                    System.out.println("Wrong Username or Password!");
                    System.out.println("Do you wanna try again?");
                    System.out.println("Answer with 'yes' or 'no'");
                    String answer = scanner.next().toLowerCase();
                    if (answer.equals("no")) {
                        System.out.println("See you in the stars, bye!");
                        System.exit(0);
                    } else if (answer.equals("yes")) {
                        continue;
                    }
                } else {
                    return currenUser;
                }
            }
        }
    }

    public static User SignUp() {
        System.out.println("#############################");
        System.out.println("#       Create Username     #");
        System.out.println("#############################");
        System.out.println("\nEnter your new Username");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.println("\nEnter your new password");
        String pass1 = scanner.nextLine();

        System.out.println("\nConfirm the new password please");
        String pass2 = scanner.nextLine();

        // Check if the password is the same
        if (pass1.equals(pass2)) {
            User newUser = new User(username, pass2, null);
            return newUser;
        } else {
            System.out.println("Something went wrong!");
            return null;
        }
    }

    public static void showPlanetInfo(Destination destination, ArrayList<Flight> list_of_flights,
            ArrayList<Destination> list_of_destinations, User current_user, ArrayList<User> list_ofUsers) {
        System.out.println("\n***************************");
        System.out.println("      " + destination.getPlanetName() + "      ");
        System.out.println("***************************");
        System.out.println("Description: " + destination.getDescription());
        System.out.println("\nGravity: " + destination.getGravity());
        System.out.println("Temperature: " + destination.getTemperature());
        System.out.println("Length of Day: " + destination.getLength_of_day());
        System.out.println("Population: " + destination.getPopulation());

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n/////////////////");
            System.out.println("// Page Handler");
            System.out.println("////////////////");
            System.out.println("1.- Go to Main Menu section\n2.- Quit the program");

            Integer page_handler = scanner.nextInt();

            switch (page_handler) {
                case 1:
                    startMenu(list_of_flights, list_of_destinations, current_user, list_ofUsers);
                case 2:
                    break;
            }
        }
    }
}