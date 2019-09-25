package fr.takima.demo.repositories;

import fr.takima.demo.models.ProductFridge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface ProductFridgeDAO extends CrudRepository<ProductFridge, Long> {
}
