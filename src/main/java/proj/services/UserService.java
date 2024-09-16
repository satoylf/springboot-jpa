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
    Optional<User> obj = Repository.findById(id); // findById returns an Optional object
    return obj.get();
  }

  public User insert(User obj) {
    return Repository.save(obj);
  }

  public void delete(Long id) {
    Repository.deleteById(id);
  }

  public User update(Long id, User obj) { 
    User entity = Repository.getReferenceById(id); // getReferenceById returns an entity without making a database request
    updateData(entity, obj);
    return Repository.save(entity);
  }

  private void updateData(User entity, User obj) {
    entity.setName(obj.getName());
    entity.setEmail(obj.getEmail());
    entity.setPhone(obj.getPhone());
  }
}
