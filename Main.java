import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static DbFunctions db;
    static Connection connect;
    static String name, address, phone_number, email,searchAT;

    static User user;
    static Ticket ticket;

    public static void main(String[] args) {
        try {
            run();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void run() throws SQLException {
        db = new DbFunctions();
        connect = db.connect_to_db();
        askDataCustomer();
        showMenu();
        process();
        askEnd();
    }

    public static void showMenu() {
        System.out.println("+-----------------------------+");
        System.out.println("|        CONCERT MAPS         |");
        System.out.println("|                             |");  //cA = sign_up
        System.out.println("|1. to buy a ticket           |");  //cT
        System.out.println("|2. to update attendance      |");  //uT
        System.out.println("|3. to update account         |");  //uA
        System.out.println("|4. to cancel your ticket     |");  //dT
        System.out.println("|5. to delete your account    |");
        System.out.println("|6. best selling ticket       |");
        System.out.println("|7. to show all ticket        |");  //sT
        System.out.println("|8. to show all account       |");  //sA
        System.out.println("|9. search available ticket   |");
        System.out.println("|                             |");
        System.out.println("|       TYPE \"EXIT\" QUIT      |");
        System.out.println("+-----------------------------+");
    }

    public static void process() {
        ticket = new Ticket();
        Scanner scan = new Scanner(System.in);
        System.out.println("type something : ");
        String choice = scan.nextLine();
        switch (choice) {
            case "1":
                showConcertList();
                ticket.askDataBuyTicket();
                break;
            case "2":
                Ticket.updDataAttendance();
                break;
            case "3":
                user.updDataAttendant();
                break;
            case "4" :
                ticket.deleteTicket();
                break;
            case "5":
                user.deleteDataAttendant();
                break;
            case "6":
                ticket.bestSeller();
                break;
            case "7":
                ticket.showAllTicket();
                break;
            case "8":
                user.showAllAccount();
                break;
            case "9":
                ticket.anyAvailableTicket();
                break;
        }

    }

    public static void askDataCustomer() {
        user = new User();
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("enter your name: ");
            name = scan.nextLine();
            System.out.println("enter your address: ");
            address = scan.nextLine();
            System.out.println("enter your phone_number: ");
            phone_number = scan.nextLine();
            System.out.println("enter your email: ");
            email = scan.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        db.sign_up(connect, "m_customer");
    }

    public static void showConcertList() {
        System.out.println("            [ AVAILABLE TICKET DATES ]            ");
        System.out.println();
        System.out.println("Eras Tour Taylor Swift = [27-04-2024],[28-04-2024]");
        System.out.println();
        System.out.println("Head In The Clouds 88rising = [05-05-2024],[06-05-2024]");
        System.out.println();
        System.out.println("Golden Disc Award = [21-12-2024],[22-12-2024]");
        System.out.println();
        System.out.println("North America World Tour Reality Club = [17-10-2024],[18-10-2024]");
    }

    public static void askEnd() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("do you want to continue? (yes/no)");
        String continueOrNo = scan.nextLine();
        if (continueOrNo.equalsIgnoreCase("no")) {
            System.exit(0);
        }
        while (continueOrNo.equalsIgnoreCase("yes")) {
            showMenu();
            process();
            askEnd();
        }
    }

}
