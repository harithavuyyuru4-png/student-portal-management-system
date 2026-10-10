package com.vcube.studentportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.studentportal.model.Student;
import com.vcube.studentportal.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student saveStudent(Student student) {

        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {

        return studentRepo.findAll();
    }

    @Override
    public List<Student> getStudentBylname(String name) {

        return studentRepo.findBylname(name);
    }

    // UPDATE
    @Override
    public Student updateStudent(int sid, Student student) {

        Student existingStudent = studentRepo.findById(sid).orElse(null);

        if (existingStudent != null) {

            existingStudent.setFname(student.getFname());
            existingStudent.setLname(student.getLname());
            existingStudent.setAge(student.getAge());
            existingStudent.setTotal_marks(student.getTotal_marks());

            return studentRepo.save(existingStudent);
        }

        return null;
    }

    // DELETE
    @Override
    public String deleteStudent(int sid) {

        if (studentRepo.existsById(sid)) {

            studentRepo.deleteById(sid);

            return "Student deleted successfully";
        }

        return "Student not found";
    }
}