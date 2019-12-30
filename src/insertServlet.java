

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
 * Servlet implementation class insertServlet
 */
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	try 
	{
		//int prn=Integer.parseInt(request.getParameter("id"));
		//int pr=Integer.parseInt(prn);
		String sub1=request.getParameter("sub1");
		int pr1=Integer.parseInt(sub1);
		String sub2=request.getParameter("sub2");
		int pr2=Integer.parseInt(sub2);
		String sub3=request.getParameter("sub3");
		int pr3=Integer.parseInt(sub3);
		Connection con=Connections.getConnection();
		PreparedStatement psm = con.prepareStatement("insert into result values (?,?,?,?)");
		//psm.setInt(1,prn);
		psm.setInt(2,pr1);
		psm.setInt(3,pr2);
		psm.setInt(4,pr3);
		int ans=psm.executeUpdate();
		
		pw.print("<h2>Your PRN Added Successfully.....</h2>");
		request.getRequestDispatcher("index.html").include(request, response);
	} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
