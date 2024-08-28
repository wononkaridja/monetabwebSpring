package ci.digitalacademy.monetab.monetabwebSpring.service;

import ci.digitalacademy.monetab.monetabwebSpring.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person save(Person person);
    Person update (Person person);
    Optional<Person> findOne(Long id);
    List<Person> findAll();
    void delete (Long id);
}
