package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repository.StudentRepository;

import jakarta.transaction.Transactional;
@Service
public class StudentServiceImpl implements StudentService {

	
	private StudentRepository studentRepository;
	
	
	public StudentServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@Override
	public void saveAllStudents(Student student) {
		try {
			this.studentRepository.save(student);
		}catch(DataIntegrityViolationException ex){
			
		}
	
		
	}

	@Override
	public Student getStudentById(int id) {
		Optional<Student> optional = studentRepository.findById(id);
		Student student = null;
		if (optional.isPresent()) {
            student = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
		return student;
	}

	@Override
	public void deleteStudentById(int id) {
		this.studentRepository.deleteById(id);
		
	}

}
