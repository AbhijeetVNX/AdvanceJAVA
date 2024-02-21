package jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class jdbcTest4{
	
	private static String q;
	
	public static void main(String[] args){
		
	  try {
		    
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter roll no.");
			int roll = sc.nextInt();
			System.out.println("Please enter student name");
			String sname = sc.next();
			System.out.println("Please enter city");
			String city = sc.next();
			
			q="INSERT INTO students_info VALUES("+roll+",'"+sname+","+city+"')";
			System.out.println(q);
			
			
		
     	Class.forName("com.mysql.jdbc.Driver");
			
		Connection con = DriverManager.getConnection("jdbc:mysql:///db1","root","root/tiger") ;
		
		Statement St = (Statement) con.createStatement();
		
		int r = St.executeUpdate(q);
		
		if(r==1) {
			System.out.println("Record Inserted!!!");
		}
		else {
			System.out.println("Insertion fail....");
		}
		
		St.close();
		con.close();
	 }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
   }

}
