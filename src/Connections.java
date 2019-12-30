import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Connections
{
	public static Connection getConnection () throws SQLException, ClassNotFoundException 
	{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver found");
		con=DriverManager.getConnection("jdbc:mysql://192.168.100.26:3306/group016","group016","welcome");
		System.out.println("Connection Established");
		return con;
	}
	
}
