import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("******ONLINE CAR SHOPPING******");
        while (true)
        {
            System.out.println("1-List Customer");
            System.out.println("2-List CarDealer");
            System.out.println("3-List Cars");
            System.out.println("4-Exit");
            System.out.print("Choose:");
            int choose = input.nextInt();
            if (choose==1)
            {
                System.out.println(" ");
                customer_dal c = new customer_dal();
                c.ListToConsole();
            }
           else if (choose==2)
            {
                System.out.println(" ");
                dealer_dal d = new dealer_dal();
                d.ListToConsole();
            }
           else if (choose==3)
            {
                System.out.println(" ");
                Products_DAL p = new Products_DAL();
                p.ListToConsole();
            }
           else if (choose==4)
            {
                break;
            }


        }

    }


}