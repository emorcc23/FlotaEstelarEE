package conexion;

/**
 * 
 * @author Álvaro Santos
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConexion {
	private static final String JDBC_URL = "jdbc:mysql://halifaxtraining.es:3306/ciberkaos014";
	
	private static Connection instance = null;

	private DBConexion() {
    }

	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			Properties props = new Properties();
			props.put("user", "uss014");
			props.put("password", "pass014");
			instance = DriverManager.getConnection(JDBC_URL, props);
		}

		return instance;
	}
} 
