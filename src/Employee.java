

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Employee
 */
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Employee() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String p=request.getParameter("prn");
		int prnNo=Integer.parseInt(p);
		
		try 
	{
		Connection Con=Connections.getConnection();
		PreparedStatement psmt=Con.prepareStatement("select * from result where prnNo=?");
		psmt.setInt(1, prnNo);
		ResultSet rs=psmt.executeQuery();
		
		int total=0;
		if(rs.next())
		{
			pw.print("<h2>PRN Available</h2>");
			pw.print("<table width=50% border=1 solid grey>");
			pw.print("<caption><h2>Result</h2></caption>");
			ResultSetMetaData rsmt=(ResultSetMetaData)rs.getMetaData();
			int totalMark=rsmt.getColumnCount();
			pw.print("<tr>");
			for(int i=1;i<=totalMark;i++)
			{
				pw.print("<th>" +rsmt.getColumnName(i)+"</th>");
			}
			pw.write("<td>Total</td>");
			pw.print("</tr>");
			total+=rs.getInt(2)+rs.getInt(3)+rs.getInt(4);
			pw.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getInt(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+total+"</td></tr>");
			//System.out.println("total is"+total);
		}
			else
		{
			pw.print("<h2>PRN not Available</h2>");
			//pw.print("<h3>Add your New PRN here</h3>");
			//request.getRequestDispatcher("link.html").include(request, response);

			//pw.print("<h2>Your PRN Added Successfully.....</h2>");
			request.getRequestDispatcher("link.html").include(request, response);
			
			
			
		}
	
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

}
