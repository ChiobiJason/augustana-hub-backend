package student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long>{
    void deleteByStudentEmailIgnoreCase(String studentEmail);

    Optional<Student> findByStudentEmailIgnoreCase(String studentEmail);

}
