package student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
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
}
