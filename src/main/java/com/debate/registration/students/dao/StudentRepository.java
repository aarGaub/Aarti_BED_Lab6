package com.debate.registration.students.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.debate.registration.students.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
