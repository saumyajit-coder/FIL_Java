package myjdbc;
import java.sql.*;
public class DbConn {
		public Connection conn;
		public Statement stat;
		public PreparedStatement pstat;
		public ResultSet rs;
		public ResultSetMetaData md;
		public DbConn()
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/d1","root","Saumyajit@123");
				stat=conn.createStatement();
			}
			catch(Exception e)
			{
				System.err.println(e);
			}
		}
	}

