package com.debate.registration.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debate.registration.students.dao.StudentRepository;
import com.debate.registration.students.entity.Student;

@Service
public class StudentRegServiceImpl implements StudentRegService {

	@Autowired
	StudentRepository studentRepo;

	@Override
	public List<Student> findAll() {

		return studentRepo.findAll();
	}

	@Override
	public Student findById(long theId) {

		return studentRepo.findById(theId).get();
	}

	@Override
	public void save(Student student) {
		studentRepo.save(student);

	}

	@Override
	public void deleteById(long theId) {
		studentRepo.deleteById(theId);

	}

	@Override
	public Student updateStudentById(Student student, long id) {

		Student e = this.findById(id);
		e.setFirstName(student.getFirstName());
		e.setLastName(student.getLastName());
		e.setCourse(student.getCourse());
		e.setCountry(student.getCountry());
		this.studentRepo.save(e);
		return e;
	}

}
