package proj.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.entities.Category;
import proj.repositories.CategoryRepository;

@Service 
public class CategoryService {

  @Autowired
  private CategoryRepository Repository;

  public List<Category> findAll() {
    return Repository.findAll();
  }

  public Category findById(Long id) {
    Optional<Category> obj = Repository.findById(id);
    return obj.get();
  }
}
