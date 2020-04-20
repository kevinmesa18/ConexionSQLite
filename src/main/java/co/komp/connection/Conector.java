package co.komp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conector {

	private String url = "jdbc:sqlite:Chinook.db";
	private Connection connect;

	public void connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection(url);
			if (connect != null) {
				System.out.println("Connected");
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("Error: could not connect to the database\n" + e.getMessage());
		}
	}
	
	public void consult() {
		try {
			ResultSet rs = null;
			String sql = "SELECT * FROM Album a where ArtistId = '4'";
			PreparedStatement st = connect.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				System.out.println("");
				System.out.println("Title: " + rs.getString("Title"));
				System.out.println("Artist: " + rs.getInt("ArtistId"));
				System.out.println("");
			}
		} catch (SQLException e) {
			System.err.println("Error: \n" + e.getMessage());
		}
	}

	public void close() {
		try {
			connect.close();
		} catch (SQLException e) {
			System.err.println("Error: connection could not be closed\n" + e.getMessage());
		}
	}
}
