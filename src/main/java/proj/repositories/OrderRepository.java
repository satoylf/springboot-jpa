package proj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
  
}
