package com.valuemomentum.training.jdbcdemo;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CallableDemo {
	Connection con;
	CallableStatement cstmt;
	int cnt=0;
	ResultSet rs;

CallableDemo(){
	
}
void createConnection()
{
	try {
		//register driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//open a connection
		System.out.println("connecting to database");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Kameswari@1721");
	}catch(Exception ce)
		   {
		       System.out.println(ce);
		   }
	}
public void getSkills(int candidateId) {
	try {
		String query="{ call get_candidate_skill(?) }";
		cstmt=con.prepareCall(query);
		cstmt.setInt(1, candidateId);
		
		rs=cstmt.executeQuery();
		while(rs.next()) {
			System.out.println(String.format("%s - %s",rs.getString("first_name") + " " + rs.getString("last_name"),rs.getString("skill"))); 
		}
	}
	catch(Exception ce)
	   {
	      System.out.println(ce);
	   }
}
	public static void main(String[] args) {
CallableDemo cd1=new CallableDemo();
cd1.createConnection();
cd1.getSkills(133);
	}
	
}
