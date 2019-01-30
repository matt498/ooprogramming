package Examples;

import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.DBManager;

/**
 * A class for testing basic operations with JDBC
 * It supports both MySQL and SQLite
 * 
 * @author Nicola Bicocchi
 */
public class JDBCBasics {
	protected DBManager db;

	public JDBCBasics() throws SQLException {
		try {
			db = new DBManager(DBManager.JDBCDriverSQLite, DBManager.JDBCURLSQLite);
			/*
			db = new DBManager(DBManager.JDBCDriverMySQL, DBManager.JDBCURLMySQL,
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			*/
			db.executeQuery("SELECT * FROM book LIMIT 1");
		} catch (SQLException e) {
			db.executeUpdate("DROP TABLE IF EXISTS book");
			db.executeUpdate("CREATE TABLE book (" +
					"id INTEGER PRIMARY KEY, " +
					"title VARCHAR(30), " +
					"author VARCHAR(30), " +
					"pages INTEGER)");

			db.executeUpdate("INSERT INTO book (id, title, author, pages) VALUES(0, 'The Lord of the Rings', 'Tolkien', 241)");
			db.executeUpdate("INSERT INTO book (id, title, author, pages) VALUES(1, 'Fight Club', 'Palahniuk', 212)");
			db.executeUpdate("INSERT INTO book (id, title, author, pages) VALUES(2, 'Computer Networks', 'Tanenbaum', 313)");
			db.executeUpdate("INSERT INTO book (id, title, author, pages) VALUES(3, 'Affective Computing', 'Picard', 127)");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints the current ResultSet row
	 * 
	 * @param rs
	 * @throws SQLException
	 */
	public void printRow(ResultSet rs) throws SQLException {
		System.out.println(
				"id=" + rs.getInt("id") + 
				", title=" + rs.getString("title") + 
				", author=" + rs.getString("author") +
				", pages=" + rs.getInt("pages"));

	}

	/**
	 * Reads the content of the person table
	 * Results are limited using "LIMIT 100"
	 * This is useful for very large tables
	 * 
	 * @throws SQLException
	 */
	public void testSelect() throws SQLException {
		ResultSet rs = db.executeQuery("SELECT * FROM book LIMIT 100");
		while(rs.next()) {
			printRow(rs);
		}
	}

	/**
	 * Update the content of the book table
	 * @throws SQLException
	 */
	public void testUpdate() throws SQLException {
		db.executeUpdate(
				"UPDATE book SET title='Il Principe', " + 
						"author='Macchiavelli', " +
						"pages=176 " +
				"WHERE id=1");
	}


	/**
	 * Test Scrollable ResultSet
	 * 
	 * @throws SQLException
	 */
	public void testScrollable() throws SQLException {
		ResultSet rs = db.executeQuery("SELECT * FROM book LIMIT 100 OFFSET 0");
		// Third record
		rs.absolute(3);
		printRow(rs);

		// Previous record
		rs.previous();
		printRow(rs);

		// +2 records from current position
		rs.relative(2);
		printRow(rs);
	}


	/**
	 * Test Updateable ResultSet
	 * Increment pages of one element
	 * 
	 * @throws SQLException
	 */
	public void testUpdateable() throws SQLException {
		ResultSet rs = db.executeQuery("SELECT * FROM book LIMIT 100 OFFSET 0");
		while (rs.next()) {
			int pages = rs.getInt("pages");
			rs.updateInt("pages", pages + 1);
			rs.updateRow();
		}		
	}


	/**
	 * Test Sensitive ResultSet
	 * @throws SQLException
	 */
	public void testSensitive() throws SQLException {
		ResultSet rs = db.executeQuery("SELECT * FROM book LIMIT 100 OFFSET 0");
		for (int retry = 0; retry < 10; retry++) {
			while (rs.next()) {
				rs.refreshRow();
				printRow(rs);
			}
			System.out.println(String.format("\n[%d] awaiting for external changes 6s...", retry));
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// do nothing
			}
			rs.beforeFirst();
		}
	}

	public void run() {
		try {
			System.out.println("\n- reading database...");
			testSelect();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		} 

		try {
			System.out.println("\n- updating database...");
			testUpdate();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		} 

		try {
			System.out.println("\n- reading database...");
			testSelect();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		} 

		try {
			System.out.println("\n- test scrollable...");
			testScrollable();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		} 

		try {
			System.out.println("\n- test updateable...");
			testUpdateable();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		} 

		try {
			System.out.println("\n- reading database...");
			testSelect();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		} 

		try {
			System.out.println("\n- test sensitive...");
			testSensitive();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		} 

		try {
			System.out.println("\n- closing database...");
			db.close();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		} 
	}

	public static void main(String[] args) {
		try {
			new JDBCBasics().run();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
