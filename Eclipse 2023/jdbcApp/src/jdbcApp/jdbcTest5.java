package jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import java.sql.PreparedStatement;

public class jdbcTest5 {

	private static String q;

	public static void main(String[] args) {

		try {

			Scanner sc = new Scanner(System.in);
			System.out.println("please enter roll no.");
			int roll = sc.nextInt();
			System.out.println("please enter city");
			String city = sc.next();
			
			q = "UPDATE students_info SET city=? WHERE roll=?";
			
		   Class.forName("com.mysql.jdbc.Driver");
			
		   Connection con = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
			
		   PreparedStatement ps = con.prepareStatement(q);
		  
		   ps.setInt(1,roll);
		   ps.setString(2,sname);
		   ps.setString(3,city);
		  
			
			int r = ps.executeUpdate(); 

			if (r == 1) {
				System.out.println("Record Insterted!!!");

			} else {
				System.out.println("Insertion Fail...");

			}
			ps.close();
			con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}