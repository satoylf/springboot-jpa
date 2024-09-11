package proj.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.entities.User;
import proj.repositories.UserRepository;

@Service // This annotation tells Spring that this class is a service component
public class UserService {

  @Autowired
  private UserRepository Repository;

  public List<User> findAll() {
    return Repository.findAll();
  }

  public User findById(Long id) {
    Optional<User> obj = Repository.findById(id);
    return obj.get();
  }
}
