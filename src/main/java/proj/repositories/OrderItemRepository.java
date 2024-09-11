package proj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import proj.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> { 
 
}
