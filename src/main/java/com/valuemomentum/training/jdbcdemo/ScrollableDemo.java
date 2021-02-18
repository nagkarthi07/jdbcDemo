package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		Statement stmt;
		ResultSet rs;
		try {
			//register driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//open a connection
			System.out.println("connecting to database");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Kameswari@1721");
			
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	rs=stmt.executeQuery("select * from skills");
	
	rs.afterLast();
	while(rs.previous()) {
		System.out.println(rs.getInt(1)+" "+rs.getString(2));
	}
	System.out.println("**********");
	rs.absolute(3);
	System.out.println(rs.getInt(1)+" "+rs.getString(2));
	System.out.println("**********");
	rs.relative(-1);
	System.out.println(rs.getInt(1)+" "+rs.getString(2));
	System.out.println("**********");
	int i=rs.getRow();
	System.out.println("cursor postiton"+i);
	rs.close();
	stmt.close();
	con.close();
}
		catch(Exception e) {
			System.out.println(e);
}

	}
}
