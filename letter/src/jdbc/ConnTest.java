package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;

public class ConnTest {
	public static void main(String[] args) {
		try {
			Connection conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
