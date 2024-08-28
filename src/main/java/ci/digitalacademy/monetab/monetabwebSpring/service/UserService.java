package ci.digitalacademy.monetab.monetabwebSpring.service;



import ci.digitalacademy.monetab.monetabwebSpring.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);
    User update (User user);
    Optional<User>findOne(Long id);
    List<User> findAll();
    void delete (Long id);
}
