package com.vcube.studentportal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.studentportal.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<Student> findBylname(String lname);
}