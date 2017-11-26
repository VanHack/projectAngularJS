package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {

	Connection con;
	PreparedStatement stmt;
	ResultSet rs;

	private final static String URL = "jdbc:mysql://****.****.us-east-1.rds.amazonaws.com:3306/****";
	final private static String USUARIO = "****";
	static private final String SENHA = "****";

	protected void open() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(URL, USUARIO, SENHA);
	}

	protected void close() throws Exception {
		con.close();
	}

}
