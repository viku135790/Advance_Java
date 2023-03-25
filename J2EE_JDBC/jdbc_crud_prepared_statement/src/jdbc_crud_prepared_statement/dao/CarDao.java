package jdbc_crud_prepared_statement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_crud_prepared_statement.connection.CarConnection;
import jdbc_crud_prepared_statement.dto.Car;

public class CarDao {
	static Connection connection=null;
	// table--------------------------------------------------------------------
	public void createTable(Car car) {
		connection=CarConnection.getConnection();
		String createcolumn = "create table Car(cid int(10) not null primary key, cname varchar(20) not null, ccolor varchar(20) not null, cprice double not null )";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(createcolumn);
			preparedStatement.execute();
			System.out.println("Table created sucessfully .................................");
		} catch (Exception e) {
			System.out.println("Please check code again........");
		}
		
	}
	
	
	//insert--------------------------------------------------------------------
	public void insertData(Car car) {
		connection=CarConnection.getConnection();
		String insert ="insert into car values(?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setInt(1, car.getCarId());
			preparedStatement.setString(2, car.getCarName());
			preparedStatement.setString(3, car.getCarColor());
			preparedStatement.setDouble(4, car.getCarPrice());
			
			preparedStatement.executeUpdate();
			System.out.println("Data Stored Sucessfully.............");
			
		} catch (SQLException e) {
			System.out.println("Please check code again........");
			e.printStackTrace();
		}
	}
	
	
	//getById--------------------------------------------------------------------------------
	public int getById(int id) {
		connection=CarConnection.getConnection();
		String findId="Select * from car where cid=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(findId);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				if(resultSet!=null) {
					int id1=resultSet.getInt("cid");
					return id1;
				}
			}
		} catch (SQLException e) {
			System.out.println("Id is not found");
			e.printStackTrace();
		}
		return 0;
	} 
	
	
	//update--------------------------------------------------------------------------------
	public void update(int carId, String carName, String carColor, double carPrice) {
		connection=CarConnection.getConnection();
		String update="update Car set cname=?, ccolor=?, cprice =? where cId =?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(update);
			preparedStatement.setString(1, carName);
			preparedStatement.setString(2, carColor);
			preparedStatement.setDouble(3, carPrice);
			preparedStatement.setInt(4, carId);
			preparedStatement.executeUpdate();
			System.out.println("Data updated.................");
			
		} catch (SQLException e) {
			System.out.println("Please check code again........");
			e.printStackTrace();
		}
		
	}
	
	//delete------------------------------------------------------------
	public void delete(int carId) {
		connection=CarConnection.getConnection();
		String delete="delete from car where cid=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(delete);
			preparedStatement.setInt(1, carId);
			preparedStatement.executeUpdate();
			System.out.println("Data deleted sucessfully........................");
		} catch (SQLException e) {
			System.out.println("Please check your code again..........");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	//display-----------------------------------------------------------
	public List<Car> display(){
		connection=CarConnection.getConnection();
		String display="select * from car";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(display);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<Car> cars=new ArrayList<Car>();
			
			while(resultSet.next()) {
				Car car=new Car();
				car.setCarId(resultSet.getInt("cid"));
				car.setCarName(resultSet.getString("cname"));
				car.setCarColor(resultSet.getString("ccolor"));
				car.setCarPrice(resultSet.getDouble("cprice"));
				
				cars.add(car);
			}
			return cars;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	

}
