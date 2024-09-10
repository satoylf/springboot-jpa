package proj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
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
