package jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcTest1{
	
    public static void main(String[] args){
    	
    	try {
    		
    		Class.forName("com.mysql.jdbc.Driver");
    		
    		Connection con = DriverManager.getConnection("jdbc:mysql:///db1","root","root/tiger");
    		
    		if(con!=null){
    			System.out.println("Connection success!!!!!");
    		}
    		else {
    			System.out.println("Connection Fail.....");
    		}
    	}
         catch(Exception e) {
        	 e.printStackTrace();
        	 
         }
    }
    
}