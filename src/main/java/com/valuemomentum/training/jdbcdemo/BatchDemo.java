package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class BatchDemo {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con;
		Statement stmt;
		int cnt=0;
		ResultSet rs;
		//register driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//open a connection
		System.out.println("connecting to database");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Kameswari@1721");
		stmt=con.createStatement();
stmt.addBatch("insert into candidate_skills values(100,5)");
stmt.addBatch("update skills set name='ajax' where id=3");
stmt.addBatch("delete from candidates where id=80");

con.setAutoCommit(false);

try {
stmt.executeBatch();
con.commit();
System.out.println("batch is executed");
}
catch(Exception ce)
{
try {
con.rollback();
System.out.println("batch is failed");
System.out.println(ce);
}
   catch(Exception e1)
   {
      System.out.println(e1);
   }
}
con.close();
stmt.close();
		}		
	}
