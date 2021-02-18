package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteDemo {
	public static void main(String[] args) {
	Connection con;
	Statement stmt;
	int cnt=0;
	try {
		//register driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//open a connection
		System.out.println("connecting to database");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Kameswari@1721");
		  
		String sql = "Delete from candidates where rtrim(last_name) like\'Y%g\';";
        System.out.println("");
        stmt=con.createStatement();
        cnt=stmt.executeUpdate(sql);
        if(cnt>0)
        {
            System.out.println("Record for Young is deleted");
        }
        con.close();
        
   }
   catch(Exception ce)
   {
       System.out.println(ce);
   }
        
}
}