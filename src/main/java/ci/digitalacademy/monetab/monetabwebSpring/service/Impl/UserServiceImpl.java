package ci.digitalacademy.monetab.monetabwebSpring.service.Impl;

import ci.digitalacademy.monetab.monetabwebSpring.models.User;
import ci.digitalacademy.monetab.monetabwebSpring.repositories.UserRepository;
import ci.digitalacademy.monetab.monetabwebSpring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        Optional<User> optionalUser = findOne(user.getId());
        if (optionalUser.isPresent()) {
            User userToUpdate = optionalUser.get();
            userToUpdate.setIdentifiant(user.getIdentifiant());
            userToUpdate.setMotDePasse(user.getMotDePasse());
            userToUpdate.setDateCreation(user.getDateCreation());

            return save(userToUpdate);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        //if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        //} else {
           // throw new IllegalArgumentException("L'utilisateur avec l'ID " + id + " n'existe pas.");

        }

}
