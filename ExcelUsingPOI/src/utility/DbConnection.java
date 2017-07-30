package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection {
	
	public static void main(String [] args){
	
		//String URL=;
		String username="root";
		String password="123";
		
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("class.formname execute");
			Connection con=DriverManager.getConnection("jdbc.mysql:@localhost:3306/", username, password);
			
			Statement stt=con.createStatement();
			
			//select database
			stt.execute("CREATE DATABASE IF NOT EXISTS test");
			stt.execute("USE test");
			
			//create table
			stt.execute("DROP iF EXISTS emp");
			stt.execute("CREATE TABLE emp("+ 
			" empid BIGINT NOT NULL AUTO_INCREMENT,"
			+ "fname VARCHAR(20),"
			+ "lname VARCHAR(20),"
			+ "PRIMARY KEY(empid)"
			+ ")");
			
			//add some entries into it
			stt.execute("INSERT INTO emp(fname,lname) VALUES('shailu','swami'),('rushi','swami'),('tanu','math')");
			ResultSet res=stt.executeQuery("SELECT * FROM emp WHERE lname='swami'");
			while(res.next()){
				System.out.println(res.getString("fname") + "" + res.getString("lname"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	 
		
	}
	
}
