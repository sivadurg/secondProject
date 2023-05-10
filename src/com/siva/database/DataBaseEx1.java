package com.siva.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseEx1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// step 1...driver loading ...
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("loading driver completed successfully.....");
//step 2...creating connection....

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "siva", "welcome");
		System.out.println("conection successfully completed  ..." + connection);
//processing the queries
		Statement statement=connection.createStatement();
int creat=	statement.executeUpdate("create table emp(empid number,empname varchar2(30),empsal number)");
		System.out.println("table create table successfully ...");
		
		int insert1=statement.executeUpdate("insert into emp values(111,'siva',1000.10)");
		int insert2=statement.executeUpdate("insert into emp values(222,'hema',2000.10)");
		int insert3=statement.executeUpdate("insert into emp values(444,'pawan',3000.10)");
		int insert4=statement.executeUpdate("insert into emp values(555,'santhu',4000.10)");
		System.out.println("data inserted successfully ..."+insert1+insert2+insert3);
//
//		//updating the data
//	int  update=statement.executeUpdate("update emp set empsal=empsal+500 where(empsal>1200)");
//	System.out.println("data updated successfully ..."+update);
//
//		//deleting the data 
//		int delete =statement.executeUpdate("delete from emp where (empsal<2000) ");
//		System.out.println("data deleted successfully ..."+delete);
//
//		
//		//drop command 
//		int drop =statement.executeUpdate("drop table emp");	
//		System.out.println("table droped  successfully ..."+drop);
//
//		
		
		

		
		
//step 4....closing the connection .....
		connection.close();
	System.out.println("connection closed successfully ...");

	}

}
