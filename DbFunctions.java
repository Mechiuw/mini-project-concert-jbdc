import javax.xml.transform.Result;
import java.sql.*;

public class DbFunctions {
    public Connection connect_to_db() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/db_EdSheeran_Tour";
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");
        return DriverManager.getConnection(url, username, password);
    }
    public void sign_up(Connection connect, String table_name){
        PreparedStatement preparedStatement = null;
        try{
            String querry = "INSERT INTO " + table_name + " (name,address,phone_number,email) values (?,?,?,?); ";
            preparedStatement = connect.prepareStatement(querry);
            preparedStatement.setString(1,Main.name);
            preparedStatement.setString(2,Main.address);
            preparedStatement.setString(3,Main.phone_number);
            preparedStatement.setString(4,Main.email);
            preparedStatement.executeUpdate();
            System.out.println("data input success");
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void buy_ticket_ET(Connection connect, String table_name){
        PreparedStatement preparedStatement = null;

        try{
            String query = "INSERT INTO " + table_name + " (concert_name,venue,organizer,date,price,discount) " +
                    "values(?,?,?,?,?,?)";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1,Ticket.concertName);
            preparedStatement.setString(2,"Arena");
            preparedStatement.setString(3,"Live Nation Entertainment");
            preparedStatement.setString(4,Ticket.askDateET);
            preparedStatement.setString(5, "350000");
            preparedStatement.setString(6,"100000");
            preparedStatement.executeUpdate();
            System.out.println("ticket bought");
            System.out.println(query);
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void buy_ticket_HITC(Connection connect, String table_name){
        PreparedStatement preparedStatement = null;

        try{
            String query = "INSERT INTO " + table_name + " (concert_name,venue,organizer,date,price,discount) " +
                    "values(?,?,?,?,?,?)";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1,Ticket.concertName);
            preparedStatement.setString(2,"Stadium");
            preparedStatement.setString(3,"AEG Presents");
            preparedStatement.setString(4,Ticket.askDateHITC);
            preparedStatement.setString(5, "500000");
            preparedStatement.setString(6,"100000");
            preparedStatement.executeUpdate();
            System.out.println("ticket bought");
            System.out.println(query);
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void buy_ticket_GDA(Connection connect, String table_name){
        PreparedStatement preparedStatement = null;

        try{
            String query = "INSERT INTO " + table_name + " (concert_name,venue,organizer,date,price,discount) " +
                    "values(?,?,?,?,?,?)";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1,Ticket.concertName);
            preparedStatement.setString(2,"Stadium");
            preparedStatement.setString(3,"C3 Presents");
            preparedStatement.setString(4,Ticket.askDateGDA);
            preparedStatement.setString(5, "700000");
            preparedStatement.setString(6,"100000");
            preparedStatement.executeUpdate();
            System.out.println("ticket bought");
            System.out.println(query);
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void buy_ticket_NA(Connection connect, String table_name){
        PreparedStatement preparedStatement = null;

        try{
            String query = "INSERT INTO " + table_name + " (concert_name,venue,organizer,date,price,discount) " +
                    "values(?,?,?,?,?,?)";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1,Ticket.concertName);
            preparedStatement.setString(2,"Stadium");
            preparedStatement.setString(3,"The Bowery Presents");
            preparedStatement.setString(4,Ticket.askDateNA);
            preparedStatement.setString(5, "400000");
            preparedStatement.setString(6,"100000");
            preparedStatement.executeUpdate();
            System.out.println("ticket bought");
            System.out.println(query);
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void update_ET(Connection connect, String table_name){
        PreparedStatement preparedStatement = null;
        try{
            String querry = "UPDATE " + table_name + " SET date = ? WHERE date = ? ";
            preparedStatement = connect.prepareStatement(querry);
            preparedStatement.setString(1,Ticket.updDateET);
            preparedStatement.setString(2,Ticket.opdDateET);
            preparedStatement.executeUpdate();
            System.out.println("date updated");
            System.out.println(Ticket.opdDateET + " -> " + Ticket.updDateET);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void update_HITC(Connection connect, String table_name){
        PreparedStatement preparedStatement = null;
        try{
            String querry = "UPDATE " + table_name + " SET date = ? WHERE date = ? ";
            preparedStatement = connect.prepareStatement(querry);
            preparedStatement.setString(1,Ticket.updDateHITC);
            preparedStatement.setString(2,Ticket.opdDateHITC);
            preparedStatement.executeUpdate();
            System.out.println("date updated");
            System.out.println(Ticket.opdDateHITC + " -> " + Ticket.updDateHITC);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void update_GDA(Connection connect, String table_name){
        PreparedStatement preparedStatement = null;
        try{
            String querry = "UPDATE " + table_name + " SET date = ? WHERE date = ? ";
            preparedStatement = connect.prepareStatement(querry);
            preparedStatement.setString(1,Ticket.updDateGDA);
            preparedStatement.setString(2,Ticket.opdDateGDA);
            preparedStatement.executeUpdate();
            System.out.println("date updated");
            System.out.println(Ticket.opdDateGDA + " -> " + Ticket.updDateGDA);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void update_NA(Connection connect, String table_name){
        PreparedStatement preparedStatement = null;
        try{
            String querry = "UPDATE " + table_name + " SET date = ? WHERE date = ? ";
            preparedStatement = connect.prepareStatement(querry);
            preparedStatement.setString(1,Ticket.updDateNA);
            preparedStatement.setString(2,Ticket.opdDateNA);
            preparedStatement.executeUpdate();
            System.out.println("date updated");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void delete_HITC(Connection connect,String table_name){
        PreparedStatement preparedStatement = null;
        try{
            String query ="DELETE FROM " + table_name + " WHERE ticket_code = ? ";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1,Ticket.askCodeHITC);
            preparedStatement.executeUpdate();
            System.out.println("Ticket refunded -" + "350000");
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void delete_GDA(Connection connect,String table_name){
        PreparedStatement preparedStatement = null;
        try{
            String query ="DELETE FROM " + table_name + " WHERE ticket_code = ? ";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1,Ticket.askCodeGDA);
            preparedStatement.executeUpdate();
            System.out.println("Ticket refunded -" + "350000");
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void delete_NA(Connection connect,String table_name){
        PreparedStatement preparedStatement = null;
        try{
            String query ="DELETE FROM " + table_name + " WHERE ticket_code = ? ";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1,Ticket.askCodeNA);
            preparedStatement.executeUpdate();
            System.out.println("Ticket refunded -" + "350000");
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void delete_ET(Connection connect,String table_name){
        PreparedStatement preparedStatement = null;
        try{
            String query ="DELETE FROM " + table_name + " WHERE ticket_code = ? ";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1, Ticket.askCodeET);
            preparedStatement.executeUpdate();
            System.out.println("Ticket refunded -" + "350000");
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void showAT(Connection connect, String table_name){
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try{
            String query ="SELECT * FROM " + table_name;
            preparedStatement = connect.prepareStatement(query);
            set = preparedStatement.executeQuery();
            while (set.next()){
                System.out.println("concert name = [" + set.getString(2) + "] ");
                System.out.println("venue name = [" + set.getString(3) + "] ");
                System.out.println("date name = [" + set.getString(5) + "] ");
                System.out.println("price name = [" + set.getString(6) + "] ");
                System.out.println();
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void showAA(Connection connect, String table_name){
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try{
            String query ="SELECT * FROM " + table_name;
            preparedStatement = connect.prepareStatement(query);
            set = preparedStatement.executeQuery();
            while (set.next()){
                System.out.println("attendant's name = [" + set.getString(2) + "] ");

                System.out.println();
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void update_Customer(Connection connect, String table_name){
        PreparedStatement preparedStatement = null;
        try{
            String querry = "UPDATE " + table_name + " SET ? = ? WHERE ? = ? ";
            preparedStatement = connect.prepareStatement(querry);
            preparedStatement.setString(1,User.choiceUpdateAttendant);
            preparedStatement.setString(2,User.valueNUpdateAttendant);
            preparedStatement.setString(3,User.choiceUpdateAttendant);
            preparedStatement.setString(4,User.valueOUpdateAttendant);
            preparedStatement.executeUpdate();
            System.out.println("date updated");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void delete_data_customer(Connection connect, String table_name){
        PreparedStatement preparedStatement = null;
        try{
            String querry = "DELETE FROM " + table_name + " WHERE name = ? ";
            preparedStatement = connect.prepareStatement(querry);
            preparedStatement.setString(1,User.nameToDelete);
            preparedStatement.executeUpdate();
            System.out.println("data deleted");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void show_available_ticket(Connection connect, String table_name){
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try{
            String query = "SELECT distinct * FROM " + table_name + " WHERE name = ? ";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1,Main.searchAT);
            result = preparedStatement.executeQuery();

            boolean found = false;
            while(result.next()){
                System.out.print("name = [" + result.getString(2) + "] ");
                System.out.println("date = [" + result.getString(3) + "] ");
                System.out.print("price = [" + result.getString(4) + "] ");
                System.out.println("artist = [" + result.getString(5) + "] ");
                System.out.println();
                found = true;
            }
            if(result.next() == found){
                System.out.println("not found");
            }

        } catch (SQLException e ){
            System.out.println(e.getMessage());
        }
    }
    public void best_selling_tickets(Connection connect,String table_name){
        PreparedStatement preparedStatement = null;
        ResultSet show = null;
        try{
            String query = "select date, count(CAST(price AS INTEGER)) as best_seller from " +
                    table_name + " group by " + table_name + ".date;";
            preparedStatement = connect.prepareStatement(query);
            show = preparedStatement.executeQuery();
            while(show.next()){
                System.out.print("at date = [" + show.getString(1) + "]  ");
                System.out.println("tickets = [" + show.getString(2) + "]");

            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
