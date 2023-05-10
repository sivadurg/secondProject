package com.siva.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DataBaseExx2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		// step 1...driver loading ...
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("loading driver completed successfully.....");
		
//step 2...creating connection....

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "siva", "welcome");
		System.out.println("conection successfully completed  ..." + connection);
//step 3....processing the queries
		
		PreparedStatement statement1 = connection.prepareStatement("insert into student values(?,?,?)");

		String flag ="yes";
		while (flag.equalsIgnoreCase("yes")) {
			System.out.println("enter student roll number");
			int rollno = sc.nextInt();
			statement1.setInt(1, rollno);

			
			System.out.println("enter student name ");
			String name = sc.next();
			statement1.setString(2, name);

			
			System.out.println("enter student fee amout");
			double fee = sc.nextDouble();
			statement1.setDouble(3, fee);

			int rows = statement1.executeUpdate();
			System.out.println(rows + "..rows inserted");
			System.out.println("Do want to enter another student details -->yes or -->no ..");
			flag = sc.next();
		}
		
// step 4....closing the connection ...
		
		sc.close();
		statement1.close();
		connection.close();
		System.out.println("connection closed... ");
		
	}
}