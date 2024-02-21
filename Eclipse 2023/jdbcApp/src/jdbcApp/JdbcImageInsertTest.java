package jdbcApp;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcImageInsertTest {
	
	private static String q = "insert into employees2 values(?,?,?,?)";

	public static void main(String[] args) {
	    
		Scanner sc=null;
		int no = 0;
		String name=null,imagePath=null;
		float salary=0.0f;
		
		File file=null;
		InputStream is=null;
		
		Connection con=null;  
		PreparedStatement ps=null;
		int result=0;
		
	  try {
		  
		  sc=new Scanner(System.in);
		  if(sc!=null) {
			  
			  System.out.println("Enter no:");
			  no=sc.nextInt();
			  
			  System.out.println("Enter Name:");
			  name=sc.next();
			  
			  System.out.println("Enter Salary:");
			  salary=sc.nextFloat();
			  
			  System.out.println("Enter Image Path:");
			  imagePath=sc.next();
		  }
		  
		  file = new File(imagePath);
		  
		  is= new FileInputStream(file);
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","tiger");
		  
		  if(con!=null)
			  ps=con.prepareStatement(q);
		  
		  if(ps!=null) {
			  ps.setInt(1, no);
			  ps.setString(2,name);
			  ps.setFloat(3,salary);
			  ps.setBinaryStream(4,is,file.length());
			
		  }
		  if(ps!=null)
			  result=ps.executeUpdate();
		  
		  if(result==1) {
			  System.out.println("Record Insertion success!!");
		  }
		  else {
			  System.out.println("Record Insertion fails..");
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
			  
			  if(ps!=null) {
				  ps.close();
			  }
	   }
	 catch(SQLException se) {
			  se.printStackTrace();
		  }
		  
		  try {
			  
			  if(con!=null) {
				  con.close();
			  }
			  
		  }
		  catch(SQLException se) {
			  se.printStackTrace();
		  }
		  
		  try {
			  
			  if(sc!=null) {
				  sc.close();
			  }
			  
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
	  }
	  
  }
	
}