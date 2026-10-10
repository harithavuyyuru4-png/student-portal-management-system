package com.vcube.studentportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vcube.studentportal.model.Student;
import com.vcube.studentportal.repo.StudentRepo;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    @Autowired
    StudentRepo studentRepo;


    // =========================
    // POST - ADD
    // =========================
    @PostMapping("/ss")
    public Student addStudent(@RequestBody Student student) {

        return studentRepo.save(student);
    }


    // =========================
    // GET ALL
    // =========================
    @GetMapping
    public List<Student> getAllStudents() {

        return studentRepo.findAll();
    }


    // =========================
    // GET BY ID
    // =========================
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {

        return studentRepo.findById(id).orElse(null);
    }


    // =========================
    // PUT - UPDATE
    // =========================
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Integer id,
            @RequestBody Student student) {

        Student existingStudent =
                studentRepo.findById(id).orElse(null);

        if (existingStudent != null) {

            existingStudent.setFname(student.getFname());
            existingStudent.setLname(student.getLname());
            existingStudent.setAge(student.getAge());
            existingStudent.setTotal_marks(student.getTotal_marks());

            return studentRepo.save(existingStudent);
        }

        return null;
    }


    // =========================
    // PATCH - PARTIAL UPDATE
    // =========================
    @PatchMapping("/{id}")
    public Student patchStudent(
            @PathVariable Integer id,
            @RequestBody Student student) {

        Student existingStudent =
                studentRepo.findById(id).orElse(null);

        if (existingStudent != null) {

            if (student.getFname() != null) {
                existingStudent.setFname(student.getFname());
            }

            if (student.getLname() != null) {
                existingStudent.setLname(student.getLname());
            }

            if (student.getAge() != null) {
                existingStudent.setAge(student.getAge());
            }

            if (student.getTotal_marks() != 0) {
                existingStudent.setTotal_marks(student.getTotal_marks());
            }

            return studentRepo.save(existingStudent);
        }

        return null;
    }


    // =========================
    // DELETE
    // =========================
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {

        if (studentRepo.existsById(id)) {

            studentRepo.deleteById(id);

            return "Student deleted successfully";
        }

        return "Student not found";
    }
}