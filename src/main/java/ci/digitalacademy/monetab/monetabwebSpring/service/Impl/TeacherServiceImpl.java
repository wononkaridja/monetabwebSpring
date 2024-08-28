package ci.digitalacademy.monetab.monetabwebSpring.service.Impl;

import ci.digitalacademy.monetab.monetabwebSpring.models.Teacher;
import ci.digitalacademy.monetab.monetabwebSpring.repositories.TeacherRepository;
import ci.digitalacademy.monetab.monetabwebSpring.service.TeacherService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;


    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);

    }

    @Override
    public Optional<Teacher> findOne(Long id) {

        return teacherRepository.findById(id);
    }

     @Override
  public Teacher update(Teacher teacher) {
        Optional<Teacher> optionalTeacher = findOne(teacher.getId());
        if (optionalTeacher.isPresent()){
            Teacher teacherToUpdate = optionalTeacher.get();
            teacherToUpdate.setMatiereEnseigne(teacher.getMatiereEnseigne());
            teacherToUpdate.setVacant(teacher.getVacant());
            return save(teacherToUpdate);
        }else {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();

    }

    @Override
    public void delete(Long id) {
        //if (!teacherRepository.existsById(id)) {
           // throw new EntityNotFoundException("Enseignant avec l'ID " + id + " non trouvé.");
        //}
        // Supprime l'enseignant par ID
        teacherRepository.deleteById(id);
    }

}
