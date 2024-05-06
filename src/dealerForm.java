import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class dealerForm extends  JFrame {
    private JScrollBar scrollBar1;
    private JTable table1;
    private JPanel JPanel1;

    dealer_dal dDal;
    private ArrayList<dealer> dlist;
    private DefaultTableModel tblModel;
    private final String TableColName[] =
            { "Id", "CarDealerName", "Location","Telephone" };

    public dealerForm()
    {
        setContentPane(JPanel1);
        setTitle("My GUI Form"); // optional
        setMinimumSize(new Dimension(400,300) ); // optional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        dDal = new dealer_dal();
        dlist = dDal.Getdealer();

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
        for (dealer k: dlist) {
            String data[] = {String.valueOf(k.id), k.carDealerName, k.location, String.valueOf(k.telephone)};
            tblModel.addRow(data);
        }
    }
    public static void main(String[] args) {
        new dealerForm();
    }
}
