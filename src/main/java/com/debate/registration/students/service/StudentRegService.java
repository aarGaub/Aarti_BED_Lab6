package com.debate.registration.students.service;

import java.util.List;

import com.debate.registration.students.entity.Student;

public interface StudentRegService {

	public List<Student> findAll();

	public Student findById(long theId);

	public void save(Student student);

	public void deleteById(long theId);

	Student updateStudentById(Student student, long id);

}
