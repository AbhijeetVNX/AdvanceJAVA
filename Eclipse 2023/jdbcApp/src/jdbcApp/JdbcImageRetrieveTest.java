package jdbcApp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcImageRetrieveTest {
	
	private static String q = "select * from employees where id=?";
	
	public static void main(String[] args){
		
		Scanner sc=null;
		int no=0;
		
		InputStream is=null;
		OutputStream os=null;
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		byte[] buffer=null;
		int bytesRead=0;
		
		try {
			
			sc=new Scanner(System.in);
			if(sc!=null) {
				
				System.out.println("Enter Employee Id:");
				no=sc.nextInt();
			}
			
	        Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","tiger");
			
			if(con!=null) 
				ps = con.prepareStatement(q);
			
			if(ps!=null) {
				
				ps.setInt(1,no);
				
			}
			
			if(ps!=null) 
				
				rs=ps.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3));
				
				is=rs.getBinaryStream(4);
			}
			
			os=new FileOutputStream("C:\\Newfolder\\i1.jpg");
			
			buffer=new byte[4096];
			
			if((bytesRead=is.read(buffer))!=1) {
				
				System.out.println("read method has read:" +bytesRead);
				os.write(buffer,0,bytesRead);
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
				if(sc!=null);{
					sc.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(is!=null);{
					is.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(os!=null);{
					os.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	    }
		
	}
	
}