package DataEntry;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

import Utils.DBManager;

public class DataEntry_v4_Model_Updateable extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private ResultSet rs;

	private final String[] columnNames = new String[] {
			"id", "lenght", "diameter", "weight", "quality"
	};

	private final Class<?>[] columnClass = new Class<?>[] {
			String.class, Double.class, Double.class, Double.class, String.class
	};

	public DataEntry_v4_Model_Updateable(DBManager db)  {
		try {
			rs = db.executeQuery("SELECT * from mortadella");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertRow(Object[] data) {
		try {
			rs.moveToInsertRow();
			rs.updateString("id", java.util.UUID.randomUUID().toString());
			rs.updateDouble("lenght", Double.parseDouble((String)data[0]));
			rs.updateDouble("diameter", Double.parseDouble((String)data[1]));
			rs.updateDouble("weight", Double.parseDouble((String)data[2]));
			rs.updateString("quality", (String)data[3]);
			rs.insertRow();
			fireTableRowsInserted(rs.getRow(), rs.getRow());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeRow(int firstRow, int lastRow) {
		try {
			rs.absolute(firstRow);
			for (int i=firstRow; i <= lastRow; i++) {
				rs.deleteRow();
			}
			fireTableRowsDeleted(firstRow, lastRow);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	@Override
	public int getRowCount() {
		int rowCount = 0;
		try {
			rs.last();
			rowCount = rs.getRow();
		} catch (SQLException e) {
			// do nothing
		}
		return rowCount;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			rs.absolute(rowIndex + 1);
			switch (columnIndex) {
			case 0: return rs.getString("id");
			case 1: return rs.getDouble("lenght");
			case 2: return rs.getDouble("diameter");
			case 3: return rs.getDouble("weight");
			case 4: return rs.getString("quality");
			}
			throw new IllegalStateException("Unhandled column index: " + columnIndex);
		} catch (SQLException e) {
			// do nothing
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		try {
			rs.absolute(rowIndex);
			switch (columnIndex) {
			case 0:
				rs.updateString("id", (String)aValue);
				break;
			case 1:
				rs.updateDouble("lenght", (Double)aValue);
				break;
			case 2:
				rs.updateDouble("diameter", (Double)aValue);
				break;
			case 3:
				rs.updateDouble("weight", (Double)aValue);
				break;
			case 4:
				rs.updateString("quality", (String)aValue);
				break;
			}
			rs.updateRow();
			fireTableCellUpdated(rowIndex, columnIndex);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}