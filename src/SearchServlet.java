
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		try
		{
		String prn=request.getParameter("id");
		int pr=Integer.parseInt(prn);
		String sub1=request.getParameter("sub1");
		int pr1=Integer.parseInt(sub1);
		String sub2=request.getParameter("sub2");
		int pr2=Integer.parseInt(sub2);
		String sub3=request.getParameter("sub3");
		int pr3=Integer.parseInt(sub3);
		Connection con=Connections.getConnection();
		PreparedStatement psm = con.prepareStatement("insert into result values (?,?,?)");
		//psm.setInt(1,pr);
		psm.setInt(2,pr1);
		psm.setInt(3,pr2);
		psm.setInt(4,pr3);
		int ans=psm.executeUpdate();
		//pw.write("prn is"+pr);
		//String str=String.valueOf(pr);
		//request.getRequestDispatcher("link.html").include(request, response);
		/*pw.print("<form action='insertServlet' method='post'>");
		pw.print("Name:<input type='number' value='id'>");
		pw.print("sub1:<input type='text' name='sub1'><br><br>");
		pw.print("sub2:<input type='text' name='sub2'><br><br>");
		pw.print("sub3:<input type='text' name='sub3'><br><br>");
		pw.print("<input type='submit' name='submit' value='submit'><br><br>");
		*/
		
		
		
		
		
		
		}
		catch(Exception e)
		{
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
