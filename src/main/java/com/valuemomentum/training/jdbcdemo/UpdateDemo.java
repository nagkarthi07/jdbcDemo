package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;
public class UpdateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		PreparedStatement pstmt;
		int cnt=0;
		ResultSet rs;
		try {
			//register driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//open a connection
			System.out.println("connecting to database");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Kameswari@1721");
			  String sqlUpdate=" UPDATE candidates " + " set last_name= ? "+" where id= ? ";
			  
			  pstmt=con.prepareStatement(sqlUpdate);
			  Scanner sc=new Scanner(System.in);
					  System.out.println("enter employee id");
			  int eid=sc.nextInt();
			  System.out.println("enter emploee's new last name:");
			  String lastname=sc.next();
			  pstmt.setInt(1,eid);
			  pstmt.setString(2,lastname);
			  
			  
			  int rowAffected=pstmt.executeUpdate();
	System.out.println(String.format("row affected %d", rowAffected));
	
	lastname="grohe";
	eid=101;
	pstmt.setString(2,lastname);
	pstmt.setInt(1,eid);
	   rowAffected=pstmt.executeUpdate();
		System.out.println(String.format("row affected %d", rowAffected));
		con.close();
		}
		catch(Exception ce)
		   {
		       System.out.println(ce);
		   }
		
	}
}
