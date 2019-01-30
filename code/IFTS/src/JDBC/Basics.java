package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Basics {
	public static final String JDBCDriverSQLite = "org.sqlite.JDBC";
	public static final String JDBCURLSQLite = "jdbc:sqlite:phones.db";

	public static final String JDBCDriverMySQL = "com.mysql.jdbc.Driver";
	public static final String JDBCURLMySQL = "jdbc:mysql://localhost:3306/jdbc_test?user=nicola&password=episteme";


	public static void main(String[] args) throws SQLException {
		Statement statement;
		Connection connection;
		ResultSet rs;

		try {
			Class.forName(JDBCDriverSQLite);
		} catch (ClassNotFoundException e) {
			System.out.println("Lib not found!");
		}

		connection = DriverManager.getConnection(JDBCURLSQLite);
		// jdbc:mysql://localhost:3306/jdbc_test?user=nicola&password=episteme

		statement = connection.createStatement();
		statement.setQueryTimeout(30); 	

		try {
			statement.executeQuery("SELECT * FROM phones LIMIT 1");
		} catch (SQLException e) {
			statement.executeUpdate("DROP TABLE IF EXISTS phones");
			statement.executeUpdate("CREATE TABLE phones (" +
					"ID INTEGER PRIMARY KEY, " +
					"name VARCHAR(30), " +
					"lastName VARCHAR(30), " +
					"phone VARCHAR(30))");
			statement.executeUpdate("INSERT INTO phones (id, name, lastName, phone) VALUES(0, 'Nicola', 'Bicocchi', '241')");
			statement.executeUpdate("INSERT INTO phones (id, name, lastName, phone) VALUES(1, 'Luca', 'Fra', '212')");
			statement.executeUpdate("INSERT INTO phones (id, name, lastName, phone) VALUES(2, 'Laura', 'Tanenbaum', '313')");
			statement.executeUpdate("INSERT INTO phones (id, name, lastName, phone) VALUES(3, 'Pippo', 'Picard', '127')");
		}
		
		
		
		rs = statement.executeQuery("SELECT * FROM phones");
		while (rs.next()) {
			System.out.printf("%s; %s; %s\n",
					rs.getString("name"),
					rs.getString("lastName"),
					rs.getString("phone"));
		}
		statement.executeUpdate("UPDATE phones SET phone='17' WHERE name='Nicola'");
		
		rs = statement.executeQuery("SELECT * FROM phones");
		while (rs.next()) {
			System.out.printf("%s; %s; %s\n",
					rs.getString("name"),
					rs.getString("lastName"),
					rs.getString("phone"));
		}
		
	}
}
