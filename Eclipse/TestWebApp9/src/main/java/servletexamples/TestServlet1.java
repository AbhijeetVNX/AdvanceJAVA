package servletexamples;

import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet1 {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String fname = req.getParameter("name");
		String lname = req.getParameter("name");
		String mstatus = req.getParameter("mstatus");
		
	  pw.println(<br><br><br><a href='test2?fname1='+fname+"&1name1="+lname+"&mststus1="+mstatus+"'>Next</a>");
	   pw.close();
	   
	} 
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
       doGet(req,res);
    }
}