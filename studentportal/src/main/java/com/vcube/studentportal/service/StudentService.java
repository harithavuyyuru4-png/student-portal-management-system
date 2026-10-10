package com.vcube.studentportal.service;

import java.util.List;

import com.vcube.studentportal.model.Student;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    List<Student> getStudentBylname(String name);

    Student updateStudent(int sid, Student student);

    String deleteStudent(int sid);
}