import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class customerform extends JFrame{
    private JScrollBar scrollBar1;
    private JTable table1;
    private JPanel JPanel1;

    customer_dal cdal;
    private ArrayList<customer> clist;
    private DefaultTableModel tblModel;
    private final String TableColName[] =
            { "ID", "NAME", "SURNAME","TELEPHONE" };

    public customerform()
    {
        setContentPane(JPanel1);
        setTitle("My GUI Form"); // optional
        setMinimumSize(new Dimension(400,300) ); // optional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        cdal = new customer_dal();
        clist = cdal.GetCustomer();

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
        for (customer k: clist) {
            String data[] = {String.valueOf(k.id), k.name, k.surname, String.valueOf(k.telephone)};
            tblModel.addRow(data);
        }
    }

    public static void main(String[] args) {
        new customerform();
    }
}
