package DataEntry;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utils.DBManager;

public class DataEntry_v3_Model_Forward {
	DBManager db;
	List<Mortadella> lm;
	int selectedIndex;

	public DataEntry_v3_Model_Forward(DBManager db) {
		this.db = db;
		lm = new ArrayList<Mortadella>();

		try {
			ResultSet rs = db.executeQuery("SELECT * FROM mortadella");
			while (rs.next()) {
				lm.add(new Mortadella(
						java.util.UUID.fromString(rs.getString("id")),
						rs.getDouble("lenght"),
						rs.getDouble("diameter"),
						rs.getDouble("weight"),
						rs.getString("quality")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		first();
	}

	public Mortadella getSelectedItem() {
		return lm.get(selectedIndex);
	}

	public int getSelectedIndex() {
		return selectedIndex;
	}
	
	public void first() {
		selectedIndex = 0;
	}
	
	public void last() {
		selectedIndex = lm.size() - 1;
	}

	public void next() {
		selectedIndex = Math.min(selectedIndex + 1, lm.size() - 1);
	}

	public void previous() {
		selectedIndex = Math.max(selectedIndex - 1, 0);
	}

	public void insert(double lenght, double diameter, double weight, String quality) {
		Mortadella m = new Mortadella(java.util.UUID.randomUUID(), 
				lenght, diameter, weight, quality); 
		try {
			String query = String.format("INSERT INTO mortadella (id, lenght, diameter, weight, quality) VALUES ('%s', %f, %f, %f, '%s')",
					m.getId().toString(),
					m.getLenght(),
					m.getDiameter(),
					m.getWeigth(),
					m.getQuality());
			db.executeUpdate(query);
			lm.add(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		last();
	}

	public void remove() {
		try {
			String query = String.format("DELETE FROM mortadella WHERE id='%s'", 
					getSelectedItem().getId());
			db.executeUpdate(query);
			lm.remove(selectedIndex);
			previous();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public void setLenght(double lenght) {
		String query = String.format("UPDATE mortadella SET lenght=%f WHERE id='%s'",
				lenght,
				getSelectedItem().getId());
		try {
			db.executeUpdate(query);
			getSelectedItem().setLenght(lenght);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setDiameter(double diameter) {
		String query = String.format("UPDATE mortadella SET diameter=%f WHERE id='%s'",
				diameter,
				getSelectedItem().getId());
		try {
			db.executeUpdate(query);
			getSelectedItem().setDiameter(diameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setWeight(double weight) {
		String query = String.format("UPDATE mortadella SET weight=%f WHERE id='%s'",
				weight,
				getSelectedItem().getId());
		try {
			db.executeUpdate(query);
			getSelectedItem().setWeigth(weight);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setQuality(String quality) {
		String query = String.format("UPDATE mortadella SET quality='%s' WHERE id='%s'",
				quality,
				getSelectedItem().getId());
		try {
			db.executeUpdate(query);
			getSelectedItem().setQuality(quality);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
