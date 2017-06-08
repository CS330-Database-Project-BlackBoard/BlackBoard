package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	private String dbUser = "root";
	private String dbPassword = "root";
	//private String database = "blackboard?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	//private String server = "104.131.84.114:3306/";
	private String database = "blackboard?allowMultiQueries=true";
	private String server = "127.0.0.1:3306/";

	private String driver = "jdbc:mysql://";
	private String url = driver + server  + database;


	public Connection getConnection() {

		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, dbUser, dbPassword);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return connection;
	}

}