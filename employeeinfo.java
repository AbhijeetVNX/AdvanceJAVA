import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
class employeeinfo{

	private static String q;
	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter id");
		int ID=sc.nextInt();
			System.out.println("Enter employee name");
			String sname=sc.next();
			System.out.println("Enter salary");
		    float Salary=sc.nextFloat();
			System.out.println("enter degsitination");
			String Degsitination=sc.next();
			
			q="INSERT INTO employees VALUES(?,?,?,?)";
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			Connection con= DriverManager.getConnection("jdbc:odbc:oracledsn","system","tiger");
			PreparedStatement ps= con.prepareStatement(q);
			
			ps.setInt(1, ID);
			ps.setString(2,sname);
			ps.setFloat(3,Salary);
			ps.setString(4,Degsitination);
			
			int r=ps.executeUpdate();
			
			if(r==1) {
             System.out.println("Record insertion successfully!!");
             
			}else {
				System.out.println("Record insertion failed");
			}
			ps.close();
			con.close();
			sc.close();
			
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	static {
		System.out.println("User Abhiii");
	}
}