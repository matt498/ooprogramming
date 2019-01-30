package DataEntry;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Utils.DBManager;

public class DataEntry_v1_Offline extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	public static String[] qualities = { "High", "Average", "Low", "Shitty"};

	DBManager db;
	List<Mortadella> lm;
	int selectedItem;

	JTextField tfLenght;
	JTextField tfDiameter;
	JTextField tfWeight;
	JComboBox<String> cbQuality;

	JButton btnLoad;
	JButton btnSave;
	JButton btnPrev;
	JButton btnNext;
	JButton btnInsert;
	JButton btnRemove;

	public DataEntry_v1_Offline() throws SQLException {
		super("Mortadelle Manager");
		lm = new ArrayList<Mortadella>();

		try {
			db = new DBManager(DBManager.JDBCDriverSQLite, DBManager.JDBCURLSQLite);
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

		tfLenght = new JTextField();
		tfDiameter = new JTextField();
		tfWeight = new JTextField();
		cbQuality = new JComboBox<String>(qualities);

		btnLoad = new JButton("Load");
		btnSave = new JButton("Save");
		btnPrev = new JButton("Prev");
		btnNext = new JButton("Next");
		btnInsert = new JButton("Insert");
		btnRemove = new JButton("Remove");

		tfLenght.addActionListener(this);
		tfDiameter.addActionListener(this);
		tfWeight.addActionListener(this);
		cbQuality.addActionListener(this);

		btnLoad.addActionListener(this);
		btnSave.addActionListener(this);
		btnPrev.addActionListener(this);
		btnNext.addActionListener(this);
		btnInsert.addActionListener(this);
		btnRemove.addActionListener(this);

		JPanel p1 = new JPanel(new GridLayout(4, 2));
		p1.add(new JLabel("Lenght"));
		p1.add(tfLenght);

		p1.add(new JLabel("Diameter"));
		p1.add(tfDiameter);

		p1.add(new JLabel("Weight"));
		p1.add(tfWeight);

		p1.add(new JLabel("Quality"));
		p1.add(cbQuality);

		JPanel p2 = new JPanel(new GridLayout(3, 2));
		p2.add(btnLoad);
		p2.add(btnSave);
		p2.add(btnPrev);
		p2.add(btnNext);
		p2.add(btnInsert);
		p2.add(btnRemove);

		setLayout(new BorderLayout());
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);

		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setVisible(true);
	}

	public void showItem() {
		try {
			tfLenght.setText(new Double(lm.get(selectedItem).getLenght()).toString());
			tfDiameter.setText(new Double(lm.get(selectedItem).getDiameter()).toString());
			tfWeight.setText(new Double(lm.get(selectedItem).getWeigth()).toString());
			cbQuality.setSelectedItem(lm.get(selectedItem).getQuality());
		} catch (IndexOutOfBoundsException e) {
			tfLenght.setText("");
			tfDiameter.setText("");
			tfWeight.setText("");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLoad) {
			try {
				lm.clear();
				ResultSet rs = db.executeQuery("SELECT * FROM mortadella");
				while (rs.next()) {
					lm.add(new Mortadella(
							java.util.UUID.fromString(rs.getString("id")),
							rs.getDouble("lenght"),
							rs.getDouble("diameter"),
							rs.getDouble("weight"),
							rs.getString("quality")));
				}
				selectedItem = 0;
				showItem();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == btnSave) {	
			try {
				db.executeUpdate("DELETE FROM mortadella");
				for (Mortadella m : lm) {
					String query = String.format("INSERT INTO mortadella (id, lenght, diameter, weight, quality) VALUES ('%s', %f, %f, %f, '%s')",
							m.getId().toString(),
							m.getLenght(),
							m.getDiameter(),
							m.getWeigth(),
							m.getQuality());
					db.executeUpdate(query);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

		if (e.getSource() == btnNext) {
			selectedItem = Math.min(selectedItem + 1, lm.size() - 1);
			showItem();
		}

		if (e.getSource() == btnPrev) {
			selectedItem = Math.max(selectedItem - 1, 0);
			showItem();
		}

		if (e.getSource() == btnInsert) {
			String[] v = JOptionPane.showInputDialog(this, "Insert Mortadella (lenght;diameter;weight;quality)").split(";");
			lm.add(new Mortadella(java.util.UUID.randomUUID(), 
					Double.parseDouble(v[0]), 
					Double.parseDouble(v[1]), 
					Double.parseDouble(v[2]), 
					v[3]));                 
			selectedItem = lm.size() - 1;
			showItem();
		}

		if (e.getSource() == btnRemove) {
			try {
				lm.remove(selectedItem);
				selectedItem = Math.max(selectedItem - 1, 0);
			} catch (IndexOutOfBoundsException e1) {
				// pass
			} finally {
				showItem();
			}
		}

		if (e.getSource() == tfLenght) {
			lm.get(selectedItem).setLenght(Double.parseDouble(tfLenght.getText()));
		}

		if (e.getSource() == tfDiameter) {
			lm.get(selectedItem).setDiameter(Double.parseDouble(tfDiameter.getText()));
		}

		if (e.getSource() == tfWeight) {
			lm.get(selectedItem).setWeigth(Double.parseDouble(tfWeight.getText()));
		}

		if (e.getSource() == cbQuality) {
			lm.get(selectedItem).setQuality((String)cbQuality.getSelectedItem());
		}
	}
	
	public static void main(String[] args) throws SQLException {
		new DataEntry_v1_Offline();
	}
}
