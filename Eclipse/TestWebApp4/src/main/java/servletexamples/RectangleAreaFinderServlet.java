package servletexamples;

import java.io.IOException;
import java.io.PrintWriter;

public class RectangleAreaFinderServlet extends GenericServlet {
	 
	public void service (ServletRequest req,ServletResponse res) {
		
	   try {
		   res.setContentType("text/html");
		   
		   double length = 30.0;
		   double width = 20.0;
		   
		   double rectArea = length*width;
		   
		   PrintWriter pw = res.getWriter();
		   
		   pw.println("<html><body>");
		   pw.println("<h2 style='color:green;text-align:center'>");
		   pw.println("Rectangle Area is:+rectArea");
		   pw.println("</h2>");
		   pw.println("<br><br>");
		   pw.println("<a href='./'>home</a>");
		   pw.println("<body><html>");
		   
		   pw.close();
		 }
	    catch(IOException e) {
	    	e.printStackTrace();
	    	
	    }
	}
	

}
