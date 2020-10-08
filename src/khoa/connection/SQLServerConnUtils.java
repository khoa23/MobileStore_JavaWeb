package khoa.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnUtils {
	// Connect to SQL Server.
		// (Using JDBC Driver: SQLJDBC)
		public static Connection getSQLServerConnection() //
				throws ClassNotFoundException, SQLException {

			// Note: Change the connection parameters accordingly.
			String hostName = "localhost";
			String database = "mobilestore";
			String userName = "sa";
			String password = "123456";

			return getSQLServerConnection(hostName, database, userName, password);
		}

		// Connect to SQLServer, using SQLJDBC Library.
		private static Connection getSQLServerConnection(String hostName, //
				String database, String userName, String password)//
				throws ClassNotFoundException, SQLException {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Example:
			// jdbc:sqlserver://localhost:1433/SQLEXPRESS;databaseName=webdb
			String connectionURL = "jdbc:sqlserver://" + hostName + ":1433" //
					+ ";databaseName=" + database;

			Connection conn = DriverManager.getConnection(connectionURL, userName, password);
			return conn;
		}
}
