package servletexamples;
import java.serv1et.Serv1etResponse;

public class CalcyServlet extends GenericServlet{
	
	public void init() {
		System.out.println("init method is executing...");
	}
	public void service(Serv1etRequest req,Serv1etResponse res){
		System.out.println("in service method...");
		add(30,70);
		System.out.println("Multiplication result is:"+multy(5.0,7.0));
	}
 
	public void add(int num1,int num2) {
		System.out.println("Addition of two number is:"+(num1+num2));
	}
	public double multy(double nl,double n2) {
		return (n1*n2);
	}
	public void destroy() {
		System.out.println("destroy method is executing...");
	}
    
}
