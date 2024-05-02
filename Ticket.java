import java.sql.Connection;
import java.util.Scanner;

public class Ticket implements Ticket_Functions{


    static String  concertName, askDateET, askDateHITC, askDateGDA, askDateNA,
            updDateHITC, updDateET, updDateGDA, updDateNA, opdDateET, opdDateHITC, opdDateGDA, opdDateNA,askToDeleteTicket
            ,searchAT;
    static Integer askCodeET,askCodeHITC,askCodeGDA,askCodeNA;
    public void askDataBuyTicket() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("enter your concert name: ");
            concertName = scan.nextLine();
            switch (concertName) {
                case "Eras Tour":
                    System.out.println("insert date : ");
                    askDateET = scan.nextLine();
                    Main.db.buy_ticket_ET(Main.connect, "m_ticket");
                    break;
                case "Head In The Clouds":
                    System.out.println("insert date : ");
                    askDateHITC = scan.nextLine();
                    Main.db.buy_ticket_HITC(Main.connect, "m_ticket");
                    break;
                case "Golden Disc Award":
                    System.out.println("insert date : ");
                    askDateGDA = scan.nextLine();
                    Main.db.buy_ticket_GDA(Main.connect, "m_ticket");
                    break;
                case "North America":
                    System.out.println("insert date : ");
                    askDateNA = scan.nextLine();
                    Main.db.buy_ticket_NA(Main.connect, "m_ticket");
                    break;
                default:
                    System.out.println("invalid");
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void updDataAttendance() {
        Scanner scan = new Scanner(System.in);
        Main.showConcertList();
        System.out.println("what ticket attendance you want to ?");
        String askAttend = scan.nextLine();
        switch (askAttend) {
            case "Era’s Tour":
                System.out.println("insert old date : ");
                opdDateET = scan.nextLine();
                System.out.println("insert new date : ");
                updDateET = scan.nextLine();
                Main.db.update_ET(Main.connect, "m_ticket");
                break;
            case "Head In The Clouds":
                System.out.println("insert old date : ");
                opdDateHITC = scan.nextLine();
                System.out.println("insert new date : ");
                updDateHITC = scan.nextLine();
                Main.db.update_HITC(Main.connect, "m_ticket");
                break;
            case "Golden Disc Award":
                System.out.println("insert old date : ");
                opdDateGDA = scan.nextLine();
                System.out.println("insert new date : ");
                updDateGDA = scan.nextLine();
                Main.db.update_GDA(Main.connect, "m_ticket");
                break;
            case "North America":
                System.out.println("insert old date : ");
                opdDateNA = scan.nextLine();
                System.out.println("insert new date : ");
                updDateNA = scan.nextLine();
                Main.db.update_NA(Main.connect, "m_ticket");
                break;
            default:
                System.out.println("invalid");
                break;
        }
    }
    public void deleteTicket(){
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("what ticket you want to delete? : ");
            askToDeleteTicket = scan.nextLine();
            switch (askToDeleteTicket) {
                case "Eras Tour":
                    System.out.println("insert ticket code : ");
                    askCodeET = scan.nextInt();
                    Main.db.delete_ET(Main.connect, "m_ticket");
                    break;
                case "Head In The Clouds":
                    System.out.println("insert ticket code : ");
                    askCodeHITC = scan.nextInt();
                    Main.db.delete_HITC(Main.connect, "m_ticket");
                    break;
                case "Golden Disc Award":
                    System.out.println("insert ticket code : ");
                    askCodeGDA = scan.nextInt();
                    Main.db.delete_GDA(Main.connect, "m_ticket");
                    break;
                case "North America":
                    System.out.println("insert ticket code : ");
                    askCodeNA = scan.nextInt();
                    Main.db.delete_NA(Main.connect, "m_ticket");
                    break;
                default:
                    System.out.println("invalid");
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    public void showAllTicket(){
        Main.db.showAT(Main.connect,"m_ticket");
    }
    public void anyAvailableTicket(){
        Scanner scan = new Scanner(System.in);
        System.out.println("what concert you are into ?");
        searchAT = scan.nextLine();
        Main.db.show_available_ticket(Main.connect,"m_concerts");
    }
    public void bestSeller(){
        Main.db.best_selling_tickets(Main.connect,"m_ticket");
    }




}
