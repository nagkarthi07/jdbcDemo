package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		Statement stmt;
		ResultSet rs;
		int cnt=0;
		try {
			//register driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//open a connection
			System.out.println("connecting to database");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Kameswari@1721");
			String str="insert into skills(name)"+"values('html5')";
			stmt=con.createStatement();
			int rowcount=stmt.executeUpdate(str);
			if(rowcount>0)
			{
				System.out.println("record inserted");
			}
			String str1="select count(id) from skills";
			rs=stmt.executeQuery(str1);
			while(rs.next())
			{
				cnt=rs.getInt(1);
			}
			System.out.println("total no. of records is:"+cnt );
			rs.close();
			stmt.close();
			con.close();
			}
			catch(Exception e) {
				System.out.println(e);
	}
			}
			}

