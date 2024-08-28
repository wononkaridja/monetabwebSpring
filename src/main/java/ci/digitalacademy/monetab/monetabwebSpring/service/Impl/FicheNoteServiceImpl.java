package ci.digitalacademy.monetab.monetabwebSpring.service.Impl;

import ci.digitalacademy.monetab.monetabwebSpring.models.FicheNote;
import ci.digitalacademy.monetab.monetabwebSpring.models.Teacher;
import ci.digitalacademy.monetab.monetabwebSpring.repositories.FicheNoteRepository;
import ci.digitalacademy.monetab.monetabwebSpring.service.FicheNoteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class FicheNoteServiceImpl implements FicheNoteService {

    private final FicheNoteRepository ficheNoteRepository;


    @Override
    public FicheNote save(FicheNote ficheNote) {
        return ficheNoteRepository.save(ficheNote);
    }

    @Override
    public FicheNote update(FicheNote ficheNote) {
        Optional<FicheNote> optionalTeacher = findOne(ficheNote.getId());
        if (optionalTeacher.isPresent()){
            FicheNote ficheNoteToUpdate = optionalTeacher.get();
            ficheNoteToUpdate.setNote(ficheNote.getNote());
            ficheNoteToUpdate.setAnnee(ficheNote.getAnnee());
            ficheNoteToUpdate.setDateCreation(ficheNote.getDateCreation());
            return save(ficheNoteToUpdate);
        }else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<FicheNote> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<FicheNote> findAll() {
        return ficheNoteRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        if (!ficheNoteRepository.existsById(id)) {
            throw new EntityNotFoundException("Enseignant avec l'ID " + id + " non trouvé.");
        }
        // Supprime l'enseignant par ID
        ficheNoteRepository.deleteById(id);
    }
}
