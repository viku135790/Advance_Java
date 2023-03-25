package jdbc_crud_with_statement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc_crud_with_statement.dto.Student;

public class StudentDao {

	static Connection connection = null;

	// create
	// table--------------------------------------------------------------------
	public void createTable(Student student) {
		// load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create the connection
			String url = "jdbc:mysql://localhost:3306/jdbc_crud_with_statement";
			String user = "root";
			String pass = "TIGER";
			connection = DriverManager.getConnection(url, user, pass);

			// create statement
			Statement statement = connection.createStatement();
			// for creation of table
			String createcolumn = "create table Student(sid int(10) not null primary key, sname varchar(20) not null, semail varchar(20) not null)";

			// executequary
			statement.executeUpdate(createcolumn);
			System.out.println("Table is create sucessfully..........");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// insert-------------------------------------------------------------------------------
	public void insertStudent(Student student) {
		// load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create the connection
			String url = "jdbc:mysql://localhost:3306/jdbc_crud_with_statement";
			String user = "root";
			String pass = "TIGER";
			connection = DriverManager.getConnection(url, user, pass);

			// create statement
			Statement statement = connection.createStatement();
			String insert = "insert into student values(" + student.getStudentId() + ",'" + student.getStudentName()+"','" + student.getStudentEmail() + "')";

			// executequary
			statement.execute(insert);
			System.out.println("data inserted sucessfully................");
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// getbyId----------------------------------------------------------------------------
	public int getById(int id) {
		
		// load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create the connection
			String url = "jdbc:mysql://localhost:3306/jdbc_crud_with_statement";
			String user = "root";
			String pass = "TIGER";
			connection = DriverManager.getConnection(url, user, pass);
			Statement statement=connection.createStatement();
			
			String getId="select * from student where sid="+id+"";
			ResultSet resultSet=statement.executeQuery(getId);
			
			resultSet.next();
			
			try {
				int id1=resultSet.getInt("sid");
				System.out.println("Id is found = "+id1);
				return id1;
			}
			catch (Exception e) {
				System.out.println("ID is not present");
			}
			
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	//update-----------------------------------------------------------------------
	public void updateStudent(String studentName, String studentEmail, int studentId) {
		// load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create the connection
			String url = "jdbc:mysql://localhost:3306/jdbc_crud_with_statement";
			String user = "root";
			String pass = "TIGER";
			connection = DriverManager.getConnection(url, user, pass);

			// create statement
			Statement statement = connection.createStatement();
			String update="update student set sname='"+studentName+"', semail ='"+studentEmail+"' where sid="+studentId+" ";
			// executequary
			statement.executeUpdate(update);
			System.out.println("data updated sucessfully................");
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//delete-----------------------------------------------------------------------
	public void deleteStudent(Student student) {
		// load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create the connection
			String url = "jdbc:mysql://localhost:3306/jdbc_crud_with_statement";
			String user = "root";
			String pass = "TIGER";
			connection = DriverManager.getConnection(url, user, pass);

			// create statement
			Statement statement = connection.createStatement();
			String delete="delete from student where sid="+student.getStudentId()+"";
			// executequary
			statement.executeUpdate(delete);
			System.out.println("data deleted sucessfully................");
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//display-----------------------------------------------------------------------
		public List<Student> displayStudent() {
			// load the driver
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				// create the connection
				String url = "jdbc:mysql://localhost:3306/jdbc_crud_with_statement";
				String user = "root";
				String pass = "TIGER";
				connection = DriverManager.getConnection(url, user, pass);

				// create statement
				Statement statement = connection.createStatement();
				String display="select * from student";
				// executequary
				ResultSet resultSet=statement.executeQuery(display);
				List<Student> students=new ArrayList<Student>();
				
				while(resultSet.next()) {
					Student student=new Student();
					student.setStudentId(resultSet.getInt("sid"));
					student.setStudentName(resultSet.getString("sname"));
					student.setStudentEmail(resultSet.getString("semail"));
					
					students.add(student);
				}
				
				return students;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	
}
