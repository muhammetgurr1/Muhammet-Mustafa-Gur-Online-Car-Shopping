import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ProductsForm extends JFrame {
    private JScrollBar scrollBar1;
    private JTable table1;
    private JPanel JPanel1;

    Products_DAL pdal;
    private ArrayList<Product> plist;
    private DefaultTableModel tblModel;
    private final String TableColName[] =
            { "ID", "NAME", "PRICE","COLOR" };// column names

    public ProductsForm()
    {
        setContentPane(JPanel1);
        setTitle("My GUI Form"); // optional
        setMinimumSize(new Dimension(400,300) ); // optional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        pdal = new Products_DAL();
        plist = pdal.GetProducts();

        tblModel = (DefaultTableModel) table1.getModel();
        tblModel.setColumnIdentifiers(TableColName);

        UpdateTable();
    }

    private void UpdateTable()
    {
        // clear table rows
        while (tblModel.getRowCount()>0)
            tblModel.removeRow(0);
        // fill the table
        for (Product k: plist) {
            String data[] = {String.valueOf(k.ID), k.NAME, String.valueOf(k.PRICE),k.color};
            tblModel.addRow(data);
        }
    }

    public static void main(String[] args) {
        new ProductsForm();
    }
}
