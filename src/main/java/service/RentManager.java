package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RentManager {

	private Connection connection;

    private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	
}
