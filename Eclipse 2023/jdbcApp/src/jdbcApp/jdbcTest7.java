package jdbcApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class jdbcTest7 {
	
	private static String q = "insert into employee_table values";
	
public static void main(String[] args) {
	
	Scanner sc=null;
	Connection con=null;
	PreparedStatement ps=null;
	
	int id=0;
	String name=null,dob=null,doj=null;
	
	SimpleDateFormat sdf=null;
	
	java.util.Date udob=null;
	
	java.sql.Date sqdob=null,sqdoj=null;
	
	long ms=0;
	
	int result=0;
	
	try {
		
		 sc=new Scanner(System.in);
		  if(sc!=null) {
			  
			  System.out.println("Enter Employee ID");
			  id=sc.nextInt();
			  
			  System.out.println("Enter Employee Name");
			  name=sc.next();
			  
			  System.out.println("Enter DOB(dd-MM-yyyy)");
			  dob=sc.next();
			  
			  System.out.println(
			  imagePath=sc.next();
		
		
		
	}
	
}
	
}
