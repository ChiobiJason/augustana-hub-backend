package com.aughub.augustana_hub;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student newStudent) {
        studentRepository.save(newStudent);
        return newStudent;
    }

    public List<Student> addBatchOfStudents(List<Student> students) {
        studentRepository.saveAll(students);
        return students;
    }

    @Transactional
    public void deleteStudentByStudentEmail(String givenStudentEmail) {
        studentRepository.deleteByStudentEmailIgnoreCase(givenStudentEmail);
    }

    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public Student updateStudentByStudentEmail(String givenStudentEmail, Student updatedStudent) {
        Student studentToUpdate = studentRepository.findByStudentEmailIgnoreCase(
                        givenStudentEmail.toLowerCase())
                .orElseThrow(() -> new RuntimeException(
                        "Student not found with email: " + updatedStudent.getStudentEmail()));

        studentToUpdate.setFirstName(updatedStudent.getFirstName());
        studentToUpdate.setLastName(updatedStudent.getLastName());
        studentToUpdate.setStartYear((updatedStudent.getStartYear()));
        studentToUpdate.setCourse((updatedStudent.getCourse()));
        studentToUpdate.setCountry(updatedStudent.getCountry());
        studentToUpdate.setEthnicity(updatedStudent.getEthnicity());
        studentToUpdate.setGender(updatedStudent.getGender());

        studentRepository.save(studentToUpdate);

        return studentToUpdate;
    }

    public Student updateStudentById(Long id, Student updatedStudent) {
        Student studentToUpdate = studentRepository.findById(id).orElse(null);
//                .orElseThrow(() -> new RuntimeException(
//                        "Student not found with id: " + id));

        if (studentToUpdate == null) {
            return null;
        }

        studentToUpdate.setFirstName(updatedStudent.getFirstName());
        studentToUpdate.setLastName(updatedStudent.getLastName());
        studentToUpdate.setStartYear((updatedStudent.getStartYear()));
        studentToUpdate.setCourse((updatedStudent.getCourse()));
        studentToUpdate.setCountry(updatedStudent.getCountry());
        studentToUpdate.setEthnicity(updatedStudent.getEthnicity());
        studentToUpdate.setGender(updatedStudent.getGender());

        studentRepository.save(studentToUpdate);

        return studentToUpdate;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentById(Long givenId) {
        return studentRepository.findAll().stream()
                .filter(student -> givenId.equals(student.getId()))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByFirstName(String givenFirstName) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getFirstName() != null &&
                        student.getFirstName().toLowerCase().contains(givenFirstName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByLastName(String givenLastName) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getLastName() != null &&
                        student.getLastName().toLowerCase().contains(givenLastName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentByFullName(String givenFullName) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getFullName() != null &&
                        student.getFullName().toLowerCase().contains(
                                givenFullName.toLowerCase()
                        ))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByStartYear(Integer givenStartYear) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getStartYear() != null &&
                        student.getStartYear().equals(givenStartYear))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByCourse(String givenCourse) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getCourse() != null &&
                        student.getCourse().toLowerCase().contains(
                                givenCourse.toLowerCase()
                        ))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByCountry(String givenCountry) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getCountry() != null &&
                        student.getCountry().toLowerCase().contains(
                                givenCountry.toLowerCase()
                        ))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByEthnicity(String givenEthnicity) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getEthnicity() != null &&
                        student.getEthnicity().toLowerCase().contains(
                                givenEthnicity.toLowerCase()
                        ))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByGender(String givenGender) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getGender() != null &&
                        student.getGender().toLowerCase().contains(
                                givenGender.toLowerCase()
                        ))
                .collect(Collectors.toList());
    }
}
