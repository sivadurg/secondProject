package com.siva.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DataBaseEx4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		// step 1...driver loading ...
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("loading driver completed successfully.....");
//step 2...creating connection....

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "siva", "welcome");
		System.out.println("conection successfully completed  ..." + connection);
//step 3....processing the queries
		PreparedStatement statement = connection.prepareStatement("update emp set empsal=empsal+? where (empsal>?)");
		String flag = "yes";
		while (flag.equalsIgnoreCase("yes")) {
			System.out.println("enter adding amount ");
			double amoun = sc.nextDouble();
			statement.setDouble(1, amoun);
			System.out.println("enter adding amount ");
			double amoun2 = sc.nextDouble();
			statement.setDouble(2, amoun2);
			int data = statement.executeUpdate();

			System.out.println("enetr yes or no.."+data);
			flag = sc.next();
		}
//step:4 closing the connections ..
		sc.close();
		statement.close();
		connection.close();
		System.out.println("connetion closed successfully....");
	}

}
