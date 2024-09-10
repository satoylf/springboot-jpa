package proj.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import proj.entities.Product;
import proj.services.ProductService;

@RestController 
@RequestMapping(value = "/products") 
public class ProductResource {

  @Autowired
  private ProductService service;

  @GetMapping 
  public ResponseEntity<List<Product>> findAll() { 
    List<Product> list = service.findAll();

    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}") 
  public ResponseEntity<Product> findById(@PathVariable Long id) { 
    Product obj = service.findById(id);

    return ResponseEntity.ok().body(obj);
  }
}
