package jdbcexamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import java.sql.PreparedStatement;

public class JdbcTest5 {

	private static String q;

	public static void main(String[] args) {

		try {

			// logic to read the data from user
			Scanner sc = new Scanner(System.in);
			System.out.println("please enter roll no.");
			int roll = sc.nextInt();
			System.out.println("please enter city");
			String city = sc.next();

			// process the query
			q = "UPDATE students_info SET city=? WHERE roll=?";

			// Step1: Activate the Driver
			Class.forName("com.mysql.jdbc.Driver");

			// step2: crate the connection
			Connection con = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");

			// step3: create PreparedStatement object
			PreparedStatement ps = con.prepareStatement(q);

			// step4: set data to query params
			ps.setString(1, city);
			ps.setInt(2, roll);

			// step5: send and execute the query
			int r = ps.executeUpdate();

			// step6: process the result
			if (r == 1) {
				System.out.println("Record Insterted!!!");

			} else {
				System.out.println("Insertion Fail...");

			}
			// step7: close the connection
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}