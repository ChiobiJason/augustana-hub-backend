package com.aughub.augustana_hub;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public List<Student> getStudentById(
            @PathVariable Long id
    ) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<Student> getStudents(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) Integer startYear,
            @RequestParam(required = false) String course,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String ethnicity,
            @RequestParam(required = false) String gender

    ) {
        if (id != null) {
            return studentService.getStudentById(id);
        } else if (firstName != null && lastName != null) {
            return studentService.getStudentByFullName(
                    firstName + " " + lastName);
        } else if (firstName != null) {
            return studentService.getStudentsByFirstName(firstName);
        } else if (lastName != null) {
            return studentService.getStudentsByLastName(lastName);
        } else if (startYear != null) {
            return studentService.getStudentsByStartYear(startYear);
        } else if (course != null) {
            return studentService.getStudentsByCourse(course);
        } else if (country != null) {
            return studentService.getStudentsByCountry(country);
        } else if (ethnicity != null) {
            return studentService.getStudentsByEthnicity(ethnicity);
        } else if (gender != null) {
            return studentService.getStudentsByGender(gender);
        } else {
            return studentService.getAllStudents();
        }
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(
            @RequestBody Student student
    ) {
        Student createdStudent = studentService.addStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Student>> addStudent(
            @RequestBody List<Student> students
    ) {
        List<Student> createdStudents = studentService.addBatchOfStudents(students);
        return new ResponseEntity<>(createdStudents, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudentById(
            @PathVariable Long id,
            @RequestBody Student updatedStudent
    ) {
        Student resultStudent = studentService.updateStudentById(id, updatedStudent);

        if (resultStudent != null) {
            return new ResponseEntity<>(resultStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/by-email/{studentEmail}")
    public ResponseEntity<Student> updateStudentByStudentEmail(
            @PathVariable String studentEmail,
            @RequestBody Student updatedStudent
    ) {
        Student resultStudent = studentService.updateStudentByStudentEmail(studentEmail, updatedStudent);

        if (resultStudent != null) {
            return new ResponseEntity<>(resultStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudentById(
            @PathVariable Long id
    ) {
        studentService.deleteStudentById(id);
        return new ResponseEntity<>("Student successfully deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/by-email/{studentEmail}")
    public ResponseEntity<String> deleteStudentByStudentEmail(
            @PathVariable String studentEmail
    ) {
        studentService.deleteStudentByStudentEmail(studentEmail);
        return new ResponseEntity<>("Student successfully deleted!", HttpStatus.OK);
    }
}
