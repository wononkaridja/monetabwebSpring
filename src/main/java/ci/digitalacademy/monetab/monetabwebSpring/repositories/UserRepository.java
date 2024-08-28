package ci.digitalacademy.monetab.monetabwebSpring.repositories;

import ci.digitalacademy.monetab.monetabwebSpring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository <User,Long>{
}
