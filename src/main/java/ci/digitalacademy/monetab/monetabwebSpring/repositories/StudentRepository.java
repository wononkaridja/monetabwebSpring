package ci.digitalacademy.monetab.monetabwebSpring.repositories;


import ci.digitalacademy.monetab.monetabwebSpring.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
