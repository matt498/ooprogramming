package Examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	public static final String JDBCDriverSQLite = "org.sqlite.JDBC";
	public static final String JDBCURLSQLite = "jdbc:sqlite:test.db";

	public static final String JDBCDriverMySQL = "com.mysql.jdbc.Driver";
	public static final String JDBCURLMySQL = "jdbc:mysql://localhost:3306/jdbc_test?user=nicola&password=episteme";

	public static final String JDBCDriverDefault = JDBCDriverSQLite;
	public static final String JDBCURLDefault = JDBCURLSQLite;

	protected Statement statement;
	protected Connection connection;

	public DBManager() throws ClassNotFoundException, SQLException {
		Class.forName(JDBCDriverDefault);
		connection = DriverManager.getConnection(JDBCURLDefault);
		statement = connection.createStatement();
		statement.setQueryTimeout(30); 
	}

	public DBManager(String JDBCDriver, String JDBCURL, int resultSetType, int resultSetConcurrency) throws ClassNotFoundException, SQLException {
		Class.forName(JDBCDriver);
		connection = DriverManager.getConnection(JDBCURL);
		statement = connection.createStatement(resultSetType, resultSetConcurrency);
		statement.setQueryTimeout(30); 
	}
	
	public Statement getStatement() {
		return statement;
	}

	public Connection getConnection() {
		return connection;
	}

	public void verify() throws SQLException {
		try {
			statement.executeQuery("SELECT * FROM mortadella LIMIT 1");
		} catch (SQLException e) {
			statement.executeUpdate("DROP TABLE IF EXISTS mortadella");
			statement.executeUpdate("CREATE TABLE mortadella (" +
					"id VARCHAR(50) PRIMARY KEY, " +
					"lenght REAL, " +
					"diameter REAL, " +
					"weight REAL, " +
					"quality VARCHAR(50))");
			statement.executeUpdate("CREATE TABLE log (" +
					"id INTEGER PRIMARY KEY AUTOINCREMENT, " +
					"query VARCHAR(1024))");
			
			/* Examples for easier debug */
			statement.executeUpdate("INSERT INTO mortadella (id, lenght, diameter, weight, quality) VALUES ('214bb0db-aa52-48be-b052-cd30f730ae79', 30.2, 30.0, 2.6, 'High')");
			statement.executeUpdate("INSERT INTO mortadella (id, lenght, diameter, weight, quality) VALUES ('03e9e721-f241-4539-9cc7-baecd8b3a931', 40.3, 35.5, 2.2, 'Low')");
			statement.executeUpdate("INSERT INTO mortadella (id, lenght, diameter, weight, quality) VALUES ('e1f0dcb0-181b-4463-97d7-edcfed736ae1', 35.1, 28.2, 4.3, 'High')");
		}
	}

	public ResultSet executeQuery(String query) throws SQLException {
		return statement.executeQuery(query);
	}

	public int executeUpdate(String query) throws SQLException {
		return statement.executeUpdate(query);
	}

	public void close() throws SQLException {
		if (connection != null) {
			statement.close();
			connection.close();
		}
	}
}

