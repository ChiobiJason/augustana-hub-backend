package student;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false)
    private Integer startYear;

    @Column(nullable = false, length = 225)
    private String course;

    @Column(nullable = false)
    private String studentEmail;

    private String country;
    private String ethnicity;
    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, Integer startYear, String course, String studentEmail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.startYear = startYear;
        this.course = course;
        this.studentEmail = studentEmail;
    }

    public Student(Long id, String firstName, String lastName, Integer startYear, String course, String studentEmail, String country, String ethnicity, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.startYear = startYear;
        this.course = course;
        this.studentEmail = studentEmail;
        this.country = country;
        this.ethnicity = ethnicity;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        String fullName = firstName + " " + lastName;
        return fullName;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String countryOfBirth) {
        this.country = countryOfBirth;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
