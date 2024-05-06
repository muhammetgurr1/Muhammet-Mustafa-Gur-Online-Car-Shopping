import java.sql.*;
import java.util.ArrayList;

public class Products_DAL {
    // for MySQL Server
    // mysql.connector.j-8.3.0
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
        String cmd = "SELECT `ID`,`NAME`,`PRICE`,`COLOR` FROM `products` ";

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            int say=0;
            int ID,PRICE;
            String NAME,color;

            System.out.println("result set ready");
            while(res.next()) {
                ID = res.getInt(1);
                NAME = res.getString(2);
                PRICE = res.getInt(3);
                color = res.getString(4);
                System.out.printf("Id= %d, Name= %s Price=%d %n", ID, NAME, PRICE,color);
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

    public ArrayList<Product> GetProducts()
    {
        ArrayList<Product> plist = new ArrayList<>();

        String cmd = "SELECT `ID`,`NAME`,`PRICE`,`COLOR` FROM `products` ";
        Product p;

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            while(res.next()) {
                p = new Product();

                p.ID = res.getInt(1);
                p.NAME = res.getString(2);
                p.PRICE = res.getInt(3);
                p.color=res.getString(4);

                plist.add(p);
            }
            res.close();

            //System.out.println("Connected to MySql server.....");
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return plist;
    }
}
