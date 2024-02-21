package jdbcApp;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcClobInsertionTest1 {
	
	private static String q= "insert into employees3 values(?,?,?,?)";

	public static void main(String[] args) {
		
		Scanner sc = null;
		int id = 0,result=0;
		float salary = 0.0f;
		String name = null,docpath=null;
		File f = null;
		Reader fr = null;
		Connection con = null;
		PreparedStatement ps = null;
		
		sc = new Scanner(System.in);
		
		try {
			
			if(sc!=null) {
				
				System.out.println("Enter employee id");
				id = sc.nextInt();
				System.out.println("Enter employee name");
				name = sc.next();
				System.out.println("Enter employee salary");
				salary = sc.nextFloat();
				System.out.println("Enter document path");
				docpath = sc.next();
			
			}
			
			f = new File(docpath);
			
			fr = new FileReader(f);
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","tiger");
			
			if(con!=null) {
				ps = con.prepareStatement(q);
			}
			
			if(ps!=null) {
				
				ps.setInt(1,id);
				ps.setString(2,name);
				ps.setFloat(3,salary);
				ps.setCharacterStream(4,fr, f.length());
				
				result = ps.executeUpdate();
			
			}
			
			if(result==1) {
				System.out.println("insertion success!!");
			}
			else {
				System.out.println("insertion falis..");
			}
			
	    }
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			try {
				if(ps!=null);{
					ps.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(con!=null);{
					con.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(fr!=null);{
					fr.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(sc!=null);{
					sc.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}	
		
	}
	
}