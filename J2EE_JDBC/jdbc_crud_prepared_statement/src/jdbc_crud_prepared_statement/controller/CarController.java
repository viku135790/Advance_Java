package jdbc_crud_prepared_statement.controller;

import java.util.List;
import java.util.Scanner;

import jdbc_crud_prepared_statement.dao.CarDao;
import jdbc_crud_prepared_statement.dto.Car;
import jdbc_crud_prepared_statement.service.CarService;

public class CarController {

	public static void main(String[] args) {
		Car car=new Car();
		CarDao carDao=new CarDao();
		CarService carService=new CarService();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Table creation\n2.insert\n3.Update by id\n4.delete\n5.display");
		int ch = sc.nextInt();
		
		switch (ch) {
		//create table------------------------------------------------------------
		case 1: {
			carService.createTable(car);
		}break;
		
		//insert--------------------------------------------------------------
		case 2:{
			System.out.println("How much data do youn want to store");
			int n=sc.nextInt();
			while(n>0) {
				System.out.println("Enter car id");
				car.setCarId(sc.nextInt());
				System.out.println("Enter the car name");
				car.setCarName(sc.next());
				System.out.println("Enter the car color");
				car.setCarColor(sc.next());
				System.out.println("Enter the car price");
				car.setCarPrice(sc.nextDouble());
				
				carService.insertData(car);
				
				n--;
			}
			
		}break;
		
		//update-----------------------------------------------------------------
		case 3:{
			System.out.println("Enter the carId");
			int id=sc.nextInt();
			System.out.println("Enter the car Name");
			String name=sc.next();
			System.out.println("Enter the car Color");
			String color=sc.next();
			System.out.println("Enter the carprice");
			double price=sc.nextDouble();
			
			carService.update(id, name, color, price);
			
		}break;
		
		//delete--------------------------------------------------------------
		case 4:{
			System.out.println("Enter the car id");
			int id=sc.nextInt();
			
			carService.delete(id);
		}break;
		
		
		//display------------------------------------------------------------
		case 5:{
			List<Car> cars=carService.display();
			
			for (Car car2 : cars) {
				System.out.println("CarID = "+car2.getCarId());
				System.out.println("CarName = "+car2.getCarName());
				System.out.println("carColor = "+car2.getCarColor());
				System.out.println("carPrice = "+car2.getCarPrice());
				System.out.println("================================");
			}
			carService.display();
		}break;
		
		
		default:
			System.out.println("Invalid input");
		}
	}

}
