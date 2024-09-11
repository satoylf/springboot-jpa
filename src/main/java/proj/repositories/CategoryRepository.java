package proj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import proj.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> { 
 
}
