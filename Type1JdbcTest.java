import java.sql.*;

class Type1JdbcTest{
        
      public static void main(String[] args){
		  
		  try{
		  
		      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		      Connection con=DriverManager.getConnection("jdbc:odbc:oracledsn","system","tiger");
			  
		      if(con!=null){
			  System.out.println("connection success");
		  }
		      else{
			  
			  System.out.println("fails.....");
		  }
		  }
		  catch(Exception e){
			  e.printStackTrace();
			  
		  }
		  
	}
}