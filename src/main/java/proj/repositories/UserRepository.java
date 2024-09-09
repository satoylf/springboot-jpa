package proj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entities.User;

public interface UserRepository extends JpaRepository<User, Long> { // JpaRepository<T, ID> means
  // that this interface is a repository that accesses user object and its ID type is Long
}
