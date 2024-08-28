package ci.digitalacademy.monetab.monetabwebSpring.service.Impl;

import ci.digitalacademy.monetab.monetabwebSpring.models.Student;
import ci.digitalacademy.monetab.monetabwebSpring.models.Teacher;
import ci.digitalacademy.monetab.monetabwebSpring.repositories.StudentRepository;
import ci.digitalacademy.monetab.monetabwebSpring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

private final StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        Optional<Student> optionalTeacher = findOne(student.getId());
        if (optionalTeacher.isPresent()){
            Student teacherToUpdate = optionalTeacher.get();
            teacherToUpdate.setMatricule(student.getMatricule());
            return save(teacherToUpdate);
        }else {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public Optional<Student> findOne(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
