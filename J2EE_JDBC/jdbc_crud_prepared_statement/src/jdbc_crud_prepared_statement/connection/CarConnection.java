package jdbc_crud_prepared_statement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CarConnection {
	static Connection connection=null;
	
	public static Connection getConnection() {
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create the connection
			String url="jdbc:mysql://localhost:3306/jdbc_crud_prepared_statement";
			String user="root";
			String pass="TIGER";
			
			connection=DriverManager.getConnection(url, user, pass);
			
			if(connection!=null) {
				return connection;
			}
			else {
				System.out.println("Something wrong inside connection please check again............");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
