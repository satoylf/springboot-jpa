package proj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import proj.entities.Product;
import proj.repositories.ProductRepository;

@Service 
public class ProductService {

  @Autowired
  private ProductRepository Repository;

  public List<Product> findAll() {
    return Repository.findAll();
  }

  public Product findById(Long id) {
    Optional<Product> obj = Repository.findById(id);
    return obj.get();
  }
}
