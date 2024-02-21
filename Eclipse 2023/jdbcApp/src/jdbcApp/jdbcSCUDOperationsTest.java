package jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class jdbcSCUDOperationsTest {
     
	private static String q = "INSERT INTO employees _ info VALUES(?,?,?,?)";
	private static String q2 = "UPDATE employees_info SET designation=? WHERE id=?";
	private static Scanner sc;
	private static Connection can;
	private static PreparedStatement ps;
	
	public static void main(String[] args){
		
		sc = new Scanner(System.in);
		System.out.println("Enter Your Choice!");
		System.out.println("1-Insertion  2-Update  3-Delete  4-Display");
		int choice = sc.nextInt();
		
	  try {
		  Class.forName("com.mysql.jdbc.Driver");
		  
		  con = DriverManager.getConnection("jdbc:mysql:///db1","root","root/tiger");
		  
		  switch(choice) {
		  
		  case 1:
			  System.out.println("Enter employee name");
			  String ename = sc.name();
			  System.out.println("Enter employee salary");
			  int esalary = sc.nextInt();
			  System.out.println("Enter employee designation");
			  String edesignation = sc.next();
			  
			  ps = con.prepareStatement(q);
			  
			  ps.setString(1,null);
			  ps.setString(2,ename);
			  ps.setInt(3,esalary);
			  ps.setString(4,designation);
			  
			  int result = ps.executeUpdate();
			  
			  if(result==1) {
				  System.out.println("Insertion Success!!!");
			  }
			  else {
				  System.out.println("Insertion Fail....");
			  }
			  break;
			  
		  case 2:
			  
			  ps = con.prepareStatement(q2);
			  
			  System.out.println("Enter employee Id whose designation to be updated");
			  int oldId = sc.nextInt();
			  System.out.println("Enter employee's Updated designation");
			  String NewDesg = sc.next();
			  
			  ps.setString(1,NewDesg);
			  ps.setInt(2,oldId);
			  
			  int result2 = ps.executeUpdate();
			  
			  if(result2==1) {
				  System.out.println("Update success!!!");
			  }
			  else {
				  System.out.println("Update fail...");
			  }
			  break;
		  }
		  
	  }	
      catch(ClassNotFoundException cnf) {
    	  cnf.printStackTrace();
      }
	  catch(SQLException se) {
		  se.printStackTrace();
	  }
	  
	  finally {
		  
		  try {
			  ps.close();
			  con.close();
			  sc.close();
		  }
	  }
		
	}

}
