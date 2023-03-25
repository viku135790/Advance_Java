package jdbc_crud_with_statement.service;

import java.util.List;

import jdbc_crud_with_statement.dao.StudentDao;
import jdbc_crud_with_statement.dto.Student;

public class StudentService {
	StudentDao studentDao=new StudentDao();
	
	public void createTable(Student student) {
		studentDao.createTable(student);
	}
	
	public void insertStudent(Student student) {
		studentDao.insertStudent(student);
	}
	
	public void updateStudent(String studentName, String studentEmail, int studentId) {
		int id1=studentDao.getById(studentId);
		if(studentId==id1) {
			studentDao.updateStudent(studentName, studentEmail, studentId);
		}
	}
	
	public void deleteStudent(Student student) {
		studentDao.deleteStudent(student);
	}
	
	public List<Student> displayStudent() {
		return studentDao.displayStudent();
	}

}
