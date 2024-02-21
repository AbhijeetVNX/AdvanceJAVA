package jdbcApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest6{
	
	  private static Connection con;
	  private static PreparedStatement ps;
	  private static final String q = "SELECT * FROM employees";
	  private static ResultSet rs;
	  
	  
	  public static void main(String[] args) {
	     try {
	    	 Class.forName("oracle.jdbc.driver.OracleDriver");
	    	 
	    	 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","tiger");
	    	 
	    	 ps = con.prepareStatement(q);
	    	 
	    	 rs = ps.executeQuery();
	    	 
	    	 while(rs.next()) {
	    		 
	    		 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
	    	 }
	   }
	     catch (ClassNotFoundException cnfe) {
	    	 cnfe.printStackTrace();
	     }
	     catch (SQLException se) {
	    	se.printStackTrace();
	     }
	     
	     finally {
	    	 
	       try {
	    	   rs.close();
	    	   ps.close();
	    	   con.close();
	    	}
	       catch(SQLException se) {
	    	   se.printStackTrace();
	    	 }
	     }
	}
	
}