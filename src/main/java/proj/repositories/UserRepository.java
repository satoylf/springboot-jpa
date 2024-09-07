package proj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
  
}
