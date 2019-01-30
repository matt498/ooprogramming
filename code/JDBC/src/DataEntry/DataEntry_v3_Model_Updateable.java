package DataEntry;

import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.DBManager;

public class DataEntry_v3_Model_Updateable {
	DBManager db;
	ResultSet rs;

	public DataEntry_v3_Model_Updateable(DBManager db) {
		this.db = db;

		try {
			rs = db.executeQuery("SELECT * FROM mortadella");
			rs.first();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public Mortadella getSelectedItem() {
		try {
			return new Mortadella(
					java.util.UUID.fromString(rs.getString("id")),
					rs.getDouble("lenght"),
					rs.getDouble("diameter"),
					rs.getDouble("weight"),
					rs.getString("quality"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getSelectedIndex() {
		try {
			return rs.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void first() {
		try {
			rs.first();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void last() {
		try {
			rs.last();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void next() {
		try {
			if (!rs.isLast()) rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void previous() {
		try {
			if (!rs.isFirst()) rs.previous();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(double lenght, double diameter, double weight, String quality) {
		try {
			rs.moveToInsertRow();
			rs.updateString("id", java.util.UUID.randomUUID().toString());
			rs.updateDouble("lenght", lenght);
			rs.updateDouble("diameter", diameter);
			rs.updateDouble("weight", weight);
			rs.updateString("quality", quality);
			rs.insertRow();
			rs.last();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void remove() {
		try {
			rs.deleteRow();
		} catch (SQLException e1) { 
			e1.printStackTrace();
		}
	}

	public void setLenght(double lenght) {
		try {
			rs.updateDouble("lenght", lenght);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
	}

	public void setDiameter(double diameter) {
		try {
			rs.updateDouble("diameter", diameter);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
	}

	public void setWeight(double weight) {
		try {
			rs.updateDouble("weight", weight);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
	}

	public void setQuality(String quality) {
		try {
			rs.updateString("quality", quality);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
	}
}
