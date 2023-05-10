package com.siva.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBaseEx3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// step 1...driver loading ...

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("loading driver completed successfully.....");

		// step 2...creating connection....

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "siva", "welcome");
		System.out.println("conection successfully completed  ..." + connection);

		// step 3....processing the queries\

		Scanner sc = new Scanner(System.in);
		System.out.println("enter the value of flag yes or no");
		String flag = sc.next();
		while (flag.equalsIgnoreCase("yes")) {
			Statement statement = connection.createStatement();
			System.out.println("enter student roll number");
			int rollno = sc.nextInt();

			System.out.println("enter student name ");
			String name = sc.next();

			System.out.println("enter student fee amout");
			double fee = sc.nextDouble();

			int inserts = statement
					.executeUpdate("insert into student values(" + rollno + ",'" + name + "'," + fee + " )");

			System.out.println(inserts + "..rows inserted");
			System.out.println("Do want to enter another student details -->yes or -->no ..");
			flag = sc.next();

		}
		// step 4....closing the connection ...
		sc.close();
		connection.close();
		System.out.println("connection closed... ");

	}

}
