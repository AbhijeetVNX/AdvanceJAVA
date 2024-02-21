package servletexamples;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TestServlet1 extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponcse res)throws ServletException,IOEXception{
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String sname = req.getParameter("Name");
		String sfname = req.getParameter("Fname");
		String smstatus = req.getParameter("mstatus");
		
		if(smstatus.equals("UnMaeeied")) {
			pw.println("<fieldset style='margin-left:30%;margin-top:5%;width:500px'>");
			pw.println("<h2 style='text-align:center'>Candidate Info Form-2</h2>");
			pw.println("form action='test2'method='get'>");
			pw.println("why do you want to marry<input type='text' name='f2t1'><br><br>");
			pw.println("when do you want to marry<input type='text' name='f2t2'<br><br>");
			
			pw.println("<input type='hidden' name='hname' value="+sname+">");
			pw.println("<input type='hidden' name='hfname' value="+sfname+">");
			pw.println("<input type='hidden' name='hms' value="+smstatus+">");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form></fieldset>");
		}
		else {
			pw.println("<fieldset style='margin-left:30%;margin-top:5%;width:500px'>");
			pw.println("<h2 style='text-align:center'>Candidate Info Form-2</h2>");
			pw.println("form action='test2'method='get'>");
			pw.println("spouse Name<input type='text' name='f2t1'><br><br>");
			pw.println("No. of children<input type='text' name='f2t2'<br><br>");
			
			pw.println("<input type='hidden' name='hname' value="+sname+">");
			pw.println("<input type='hidden' name='hfname' value="+sfname+">");
			pw.println("<input type='hidden' name='hms' value="+smstatus+">");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form></fieldset>");
		}
		pw.close();
	}
	
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	  
	  doGet(req,res);
  }

}
