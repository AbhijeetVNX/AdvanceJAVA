package servletexamples;

import java.io.IOException;

public class TestServlet2 extends HttpServlet{
	
}
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
         res.setContentType("text/html");
         PrintWriter pw = res.getWriter();
         
         string fname = req.getParameter("name");
 		 string lname = req.getParameter("name");
 		 string mstatus = req.getParameter("mstatus");
 		
 		 pw.println("<br><br><b>data:"+fname+"\t"+lname+"\t"+mstatus+"</b>");
  }
}