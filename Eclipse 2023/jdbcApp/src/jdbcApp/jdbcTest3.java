package jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class jdbcTest3 {
	private static final String q ="SELECT * FROM students_info";
	
	public static void main (String[] args){
		
		try {
     		Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql:///db1","root","root/tiger") ;
		
			Statement St = (Statement) con.createStatement();
			
			ResultSet rs = St.executeQuery(q);
			
			while(rs.next()) {
			   
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}	
		
	}

}
