package servletexamples;


import java.io.PrintWriter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SecondServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		try{
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			
			Cookie ck[]=request.getCookies();
			
			pw.print("Hello*****"+ck[0].getValue());
			pw.close();
		}
		catch(Exception e) {
		    System.out.println(e);	
		}
	}

}
