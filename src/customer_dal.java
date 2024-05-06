import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;

public class customer_dal {
    String user="user1", pass="mg123";
    String conUrl = "jdbc:mysql://localhost/20210305052";

    public void Test()
    {
        try {
            Connection conn = DriverManager.getConnection(conUrl, user, pass);
            System.out.println("Connected to MySql server.....");
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ListToConsole()
    {
        String cmd = "SELECT `id`,`name`,`surname`,`telephone` FROM `customer` ";

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            int say=0;
            int id;
            int telephone;
            String name,surname;

            System.out.println("result set ready");
            while(res.next()) {
                id = res.getInt(1);
                name = res.getString(2);
                surname = res.getString(3);
                telephone = res.getInt(4);
                System.out.printf("Id= %d, Name= %s, Surname=%s Telephone=%d %n", id, name, surname,telephone);
                say++;
            }
            System.out.println("End of List.");
            res.close();

            //System.out.println("Connected to MySql server.....");
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<customer> GetCustomer()
    {
        ArrayList<customer> clist = new ArrayList<>();

        String cmd = "SELECT `id`,`name`,`surname`,`telephone` FROM `customer` ";
        customer c;

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            while(res.next()) {
                c = new customer();

                c.id = res.getInt(1);
                c.name = res.getString(2);
                c.surname = res.getString(3);
                c.telephone=res.getInt(4);

                clist.add(c);
            }
            res.close();

            //System.out.println("Connected to MySql server.....");
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return clist;
    }
}
