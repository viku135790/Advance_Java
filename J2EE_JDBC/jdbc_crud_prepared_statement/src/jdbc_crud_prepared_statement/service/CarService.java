package jdbc_crud_prepared_statement.service;

import java.util.List;

import jdbc_crud_prepared_statement.dao.CarDao;
import jdbc_crud_prepared_statement.dto.Car;

public class CarService {
	CarDao carDao=new CarDao();
	public void createTable(Car car) {
		carDao.createTable(car);
	}
	
	public void insertData(Car car) {
		carDao.insertData(car);
	}
	
	public void update(int carId, String carName, String carColor, double carPrice) {
		int id1=carDao.getById(carId);
		if(id1==carId) {
			carDao.update(carId, carName, carColor, carPrice);
		}
		else {
			System.out.println("id not matched.............");
		}
		
	}
	public void delete(int carId) {
		carDao.delete(carId);
	}
	
	public List<Car> display(){
		return carDao.display();
	}

}
