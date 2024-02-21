package servletexamples;

import java.io.PrintWriter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			
			String uname=request.getParameter("userName");
			pw.print("Welcome"+uname);
			
			Cookie ck=new Cookie("uname",uname);
			response.addCookie(ck);
			
			response.sendRedirect("second.html");
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
 