package proj.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.entities.Order;
import proj.repositories.OrderRepository;

@Service 
public class OrderService {

  @Autowired
  private OrderRepository Repository;

  public List<Order> findAll() {
    return Repository.findAll();
  }

  public Order findById(Long id) {
    Optional<Order> obj = Repository.findById(id);
    return obj.get();
  }
}
