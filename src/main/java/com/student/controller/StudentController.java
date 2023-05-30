package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "index";
	}

	@GetMapping("/showNewStudentForm")
	public String showNewStudentForm(Model model) {
		// create model attribute to bind form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "new_student";
	}


    @PostMapping(value="/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        // save employee to database
        studentService.saveAllStudents(student);
        return "redirect:/";
    }
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
   
        // get employee from the service
        Student student = studentService.getStudentById(id);
//System.out.print(student.getStudentId()+"kkkkkkkkkkk"+id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("student", student);
        return "update_student";
    }
    
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") int id) {
//System.out.print(id+"kalyan");
        // call delete employee method 
        this.studentService.deleteStudentById(id);
        return "redirect:/";
    }
}
