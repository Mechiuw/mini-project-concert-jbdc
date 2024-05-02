import java.sql.Connection;
import java.util.Scanner;

public class User implements User_Functions{


    static String choiceUpdateAttendant,valueNUpdateAttendant,valueOUpdateAttendant,nameToDelete;
    public void showAllAccount(){
        Main.db.showAA(Main.connect,"m_customer");
    }
    public void updDataAttendant(){
        Scanner scan = new Scanner(System.in);
        System.out.println("which one you want to update? (name/address/phone_number/email)(1) ");
        choiceUpdateAttendant = scan.nextLine();
        System.out.println("insert OLD value : ");
        valueOUpdateAttendant = scan.nextLine();
        System.out.println("insert NEW value ");
        valueNUpdateAttendant = scan.nextLine();
        Main.db.update_Customer(Main.connect,"m_customer");
    }
    public void deleteDataAttendant(){
        Scanner scan = new Scanner(System.in);
        System.out.print("insert name to specify personal data, where to delete : ");
        nameToDelete = scan.nextLine();
        Main.db.delete_data_customer(Main.connect,"m_customer");

    }

}
