package com.debate.registration.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.debate.registration.students.entity.Student;
import com.debate.registration.students.service.StudentRegService;

@Controller
@RequestMapping("/registerStudents")
public class StudentRegController {

	@Autowired
	StudentRegService studentService;

	@RequestMapping("/listStudents")
	public String listStudents(Model model) {
		List<Student> list = studentService.findAll();
		model.addAttribute("students", list);
		return "listStudents";

	}

	@RequestMapping("/getStudentForm")
	public String getAddStudentForm(Model model) {

		Student student = new Student();
		model.addAttribute("student", student);
		return "getStudentForm";
	}

	@PostMapping("/saveStudentDetails")
	public String saveStudentDetails(@ModelAttribute("student") Student student) {

		studentService.save(student);
		return "redirect:/registerStudents/listStudents";

	}

	@GetMapping("/edit/{id}")
	public String updateEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.findById(id));
		return "editStudentForm";
	}

	@PostMapping("/update/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student e) {
		studentService.save(e);
		return "redirect:/registerStudents/listStudents";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudentById(@PathVariable Long id) {
		studentService.deleteById(id);
		return "redirect:/registerStudents/listStudents";
	}

	@RequestMapping("/403")
	public String accesssDenied(Model model) {

		return "/403";

	}

}
