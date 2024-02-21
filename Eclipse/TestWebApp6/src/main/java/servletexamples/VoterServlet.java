package servletexamples;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/VoterServlet")
public class VoterServlet extends HttpServlet{
	private static final long serialVersionUID =1L;
    
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException {
		System.out.println("lnside doGet Method");
		res.setContentType("text/html");
		PrintWriter pw=res. getWriter();
		String fname=req.getParameter ("pname");
		String fage=req. getParameter("page"); 
		int age=0;
		
		String vstatus=req.getParameter("vflag");
	 
	pw.println("<br><font color='red'><a href='index.html'><b>back</b></a></font><br><br><br>");
		 
	if(vstatus.equals("no")){
		
		if(fname.equals("")|| fname==null || fname.length()==0){
		
			pw.println("<br><font color='blue'><i>Person Name is Mandatory!!!</i><font>");
		}
		if(fage.equals("")|| fage==null || fage.length()==0){
			
			pw.println("<br><font color='green'><i>Person Age is Mandatory!!!</i><font>");
		}
		else {
			try {
				 age=Integer.parseInt(fage);
				}
			catch(NumberFormatException nfe) {
				
				pw.println("<br><font color='green'><i>Age must be numeric!!!</i><font>");
				return;
			}
		
		}
	}
	 if(vstatus.equals("yes")) {
		 age=Integer.parseInt(fage);
		}
	 if(!fname.equals("")&& age!=0) {
		 if(age>=18) {
			 
		pw.println("<br><font color='red'><i>Congratulation You are eligible to vote!!!</i></font>");
		 }
		 else {
			 pw.println("<br><font color='red'><i>You are Not eligible to vote!!!</i></font>");
		 }
	 }
	}
		 public void dopost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException {

			 System.out.println("Inside doPost Method");
			 doGet(req,res);
		 }
	
	} 

