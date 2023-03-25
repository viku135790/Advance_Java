package jdbc_crud_with_statement.controller;

import java.util.List;
import java.util.Scanner;

import jdbc_crud_with_statement.dao.StudentDao;
import jdbc_crud_with_statement.dto.Student;
import jdbc_crud_with_statement.service.StudentService;

public class StudentContrioller {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		StudentService studentService = new StudentService();
		Student student = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Table creation\n2.insert\n3.Update by id\n4.delete\n5.display");
		int ch = sc.nextInt();

		switch (ch) {

		// table creation------------------------------------------------
		case 1: {
			studentService.createTable(student);
		}
			break;

		// insert----------------------------------------------------------
		case 2: {
			System.out.println("Enter the id");
			student.setStudentId(sc.nextInt());
			System.out.println("Enter the Name");
			student.setStudentName(sc.next());
			System.out.println("Enter the Email");
			student.setStudentEmail(sc.next());

			studentService.insertStudent(student);
		}
			break;

		// update----------------------------------------------------------
		case 3: {
			System.out.println("Enter the id");
			int id=sc.nextInt();
			System.out.println("Enter the Name");
			String name=sc.next();
			System.out.println("Enter the Email");
			String email=sc.next();

			studentService.updateStudent(name, email, id);
		}
			break;

			
			
		// delete----------------------------------------------------------
		case 4: {
			System.out.println("Enter the id");
			student.setStudentId(sc.nextInt());

			studentService.deleteStudent(student);
		}
			break;
			
			
			
		case 5:{
			List<Student>students=studentService.displayStudent();
			for (Student student2 : students) {
				System.out.println(student2.getStudentId());
				System.out.println(student2.getStudentName());
				System.out.println(student2.getStudentEmail());
				
				System.out.println("====================================");
			}
		}break;

		default:
			System.out.println("Invalid input");
		}
	}

}
