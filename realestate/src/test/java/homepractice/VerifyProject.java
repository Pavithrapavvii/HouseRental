package homepractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class VerifyProject {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		String project_name="TY_proj_1398";
		try {
			Driver driverref=new Driver();
	        DriverManager.registerDriver(driverref);
	         conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
	        Statement statement = conn.createStatement();
	        String Query="select * from project";
	        ResultSet result = statement.executeQuery(Query);
	        boolean flag=false;
	        while(result.next())
	        {
	        	String value=result.getString(1);
	        	if(value.equalsIgnoreCase(project_name))
	        	{
	        		System.out.println("project is created");
	        		flag=true;
	        		break;
	        	}
	        }
	        if(!flag)
	        {
	        	System.out.println("project is not created");
	        }
		}
		finally {
			conn.close();
			
		}
		

	}

}
