package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Car;

public class CarManager {

	private Connection connection;

	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	
	
	public CarManager() {
		try {
			connection = DriverManager.getConnection(url);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	 Connection getConnection() {
		return connection;
	}	
	
	
}
