package jdbcApp;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcClobRetrieveTest1{
	
	private static String q = "select * from employees3 where id=?";
	
	public static void main (String[] args) {
		
		Scanner sc = null;
		int id = 0;
		
		reader=null;
		writer=null;
		
	    con=null;
		ps=null;
		rs=null;
		file=null;
		
		char[]buffer=null;
		int charsRead=0;
		
	 try {
	   
		sc=new Scanner(System.in);
		if(sc!=null) {
		    
			System.out.println("Enter Employee Id");
			no=sc.nextInt();
			
			}
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","tiger");
		
	  if(con!=null)
		  
		  ps=con.prepareStatement(q);
	  if(ps!=null) {
		  
		  ps.setInt(1,no);
	  }
	  
	  if(ps!=null) {
		  rs=ps.executeQuery();
		  }
	 while(rs.next()) {
		 
		 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3));
		 
		 clob=rs.getClob(4);
		 
		 reader = clob.getCharacterStream();
		 
		 string filePath = "C:\Users\acer\Desktop\AdvanceJAVA\abstract1.txt";
		 
		 write.close();
		 System.out.println("File Writing Success!!!"+filePath);
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
	
	}
 }