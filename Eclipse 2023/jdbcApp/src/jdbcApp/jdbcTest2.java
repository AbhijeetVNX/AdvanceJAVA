package jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Statement;

public class jdbcTest2{
	
	private static final String q ="INSERT INTO students_info VALUES(101,'Abhi','pune')";
	
	public static void main(String[] args) {
		
		try {
     		Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql:///db1","root","root/tiger") ;
		
			Statement St = (Statement) con.createStatement();
			
			int result = St.executeUpdate(q);
			
		   if(result==1) {
				System.out.println("Record inserted sucessfullyl!!!");
			}
		   else {
			    System.out.println("Record inserted Fail...");
		   }
		   
		   St.close();
		   con.close();
		}
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
}