package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransactionsDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		Statement stmt;
		int cnt=0;
		ResultSet rs;
		try {
			//register driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//open a connection
			System.out.println("connecting to database");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Kameswari@1721");
            stmt=con.createStatement();
            con.setAutoCommit(false);
		
            try {
            	int i1=stmt.executeUpdate("insert into candidate_skills values(100,3)");
            	int i2=stmt.executeUpdate("update skills set name='ruby' where id=1");
            	int i3=stmt.executeUpdate("delete from candidate where id=0");
            	con.commit();
            	System.out.println("transaction is success");
            }
		
		catch(Exception e) {
            	try {
            		con.rollback();
            		System.out.println("transaction is failed");
            	}
	catch(Exception ex)
            	 {
         	       System.out.println(ex);
         	        }
             }
            
            con.close();
    		stmt.close();
    		System.out.println("connection closed");
		    
		} catch(Exception e1) {}
	}
}