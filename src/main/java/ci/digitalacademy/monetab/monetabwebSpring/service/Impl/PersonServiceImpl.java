package ci.digitalacademy.monetab.monetabwebSpring.service.Impl;

import ci.digitalacademy.monetab.monetabwebSpring.models.Person;
import ci.digitalacademy.monetab.monetabwebSpring.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class PersonServiceImpl implements PersonService {
    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public Optional<Person> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
