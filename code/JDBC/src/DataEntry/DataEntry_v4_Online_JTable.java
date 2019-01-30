package DataEntry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import Utils.DBManager;

public class DataEntry_v4_Online_JTable extends JFrame implements ActionListener, TableModelListener {
	private static final long serialVersionUID = 1L;
	DBManager db;

	JTable tResults;
	JButton btInsert;
	JButton btDelete;

	public DataEntry_v4_Online_JTable() throws SQLException {
		super("Mortadelle Manager");

		try {
			db = new DBManager(DBManager.JDBCDriverMySQL, DBManager.JDBCURLMySQL,
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			db.executeQuery("SELECT * FROM mortadella LIMIT 1");
		} catch (SQLException e) {
			db.executeUpdate("DROP TABLE IF EXISTS mortadella");
			db.executeUpdate("CREATE TABLE mortadella (" +
					"id VARCHAR(50) PRIMARY KEY, " +
					"lenght REAL, " +
					"diameter REAL, " +
					"weight REAL, " +
					"quality VARCHAR(50))");

			/* Examples for easier debug */
			db.executeUpdate("INSERT INTO mortadella (id, lenght, diameter, weight, quality) VALUES ('214bb0db-aa52-48be-b052-cd30f730ae79', 30.2, 30.0, 2.6, 'High')");
			db.executeUpdate("INSERT INTO mortadella (id, lenght, diameter, weight, quality) VALUES ('03e9e721-f241-4539-9cc7-baecd8b3a931', 40.3, 35.5, 2.2, 'Low')");
			db.executeUpdate("INSERT INTO mortadella (id, lenght, diameter, weight, quality) VALUES ('e1f0dcb0-181b-4463-97d7-edcfed736ae1', 35.1, 28.2, 4.3, 'High')");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		tResults = new JTable();
		tResults.setModel(new DataEntry_v4_Model_Updateable(db));
		tResults.getModel().addTableModelListener(this);
		
		tResults.setGridColor(Color.BLACK);
		btInsert = new JButton("Insert...");
		btInsert.addActionListener(this);
		btDelete = new JButton("Remove");
		btDelete.addActionListener(this);
		
		JPanel p01 = new JPanel(new GridLayout(1, 2));
		p01.add(btInsert);
		p01.add(btDelete);

		setLayout(new BorderLayout());
		add(p01, BorderLayout.SOUTH);
		add(new JScrollPane(tResults), BorderLayout.CENTER);

		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btInsert) {
			String[] v = JOptionPane.showInputDialog(this, "Insert Mortadella (lenght;diameter;weight;quality)").split(";");
			((DataEntry_v4_Model_Updateable)tResults.getModel()).insertRow(v);
		} 
		
		if (e.getSource() == btDelete) {
			((DataEntry_v4_Model_Updateable)tResults.getModel()).removeRow(tResults.getSelectedRow(), tResults.getSelectedRow());
		}
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("The table has been modifed!");
	}
	
	public static void main(String[] args) throws SQLException {
		new DataEntry_v4_Online_JTable();
	}
}
