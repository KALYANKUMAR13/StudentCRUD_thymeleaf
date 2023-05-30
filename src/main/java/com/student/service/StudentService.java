package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {
	List<Student>getAllStudents();
	void saveAllStudents(Student student);
	Student getStudentById(int id);
	void deleteStudentById(int id);

}
