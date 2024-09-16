package proj.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import proj.entities.User;
import proj.repositories.UserRepository;
import proj.services.exceptions.DatabaseException;
import proj.services.exceptions.ResourceNotFoundException;

@Service // This annotation tells Spring that this class is a service component
public class UserService {

  @Autowired
  private UserRepository Repository;

  public List<User> findAll() {
    return Repository.findAll();
  }

  public User findById(Long id) {
    Optional<User> obj = Repository.findById(id); // findById returns an Optional object
    return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // return the object or throw an exception
  }

  public User insert(User obj) {
    return Repository.save(obj);
  }

  public void delete(Long id) {
    try {
      Repository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      throw new ResourceNotFoundException(id);
    } catch (DataIntegrityViolationException e) {
      throw new DatabaseException(e.getMessage());
    }
  }

  public User update(Long id, User obj) {
    try {
      User entity = Repository.getReferenceById(id); // getReferenceById returns an entity without making a database request
      updateData(entity, obj);
      return Repository.save(entity);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException(id);
    }
  }

  private void updateData(User entity, User obj) {
    entity.setName(obj.getName());
    entity.setEmail(obj.getEmail());
    entity.setPhone(obj.getPhone());
  }
}
