import java.sql.*;
import java.util.ArrayList;

public class dealer_dal {
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

    public void ListToConsole() {
        String cmd = "SELECT `id`,`carDealerName`,`location`,`telephone` FROM `cardealer` ";

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);) {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            int say = 0;
            int id, telephone;
            String carDealerName, location;

            System.out.println("result set ready");
            while (res.next()) {
                id = res.getInt(1);
                carDealerName = res.getString(2);
                location = res.getString(3);
                telephone = res.getInt(4);
                System.out.printf("Id= %d, CarDealerName= %s, Location=%s, Telephone=%d %n", id, carDealerName, location, telephone);
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
        public ArrayList<dealer> Getdealer ()
        {
            ArrayList<dealer> dlist = new ArrayList<>();

            String cmd = "SELECT `id`,`carDealerName`,`location`,`telephone` FROM `cardealer` ";
            dealer d;

            try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
            {
                Statement statement = conn.createStatement();
                ResultSet res = statement.executeQuery(cmd);

                while(res.next()) {
                    d = new dealer();

                    d.id = res.getInt(1);
                    d.carDealerName = res.getString(2);
                    d.location = res.getString(3);
                    d.telephone=res.getInt(4);

                    dlist.add(d);
                }
                res.close();

            } catch (
                    SQLException e) {
                System.out.println(e.getMessage());
            }
            return dlist;
        }

}
