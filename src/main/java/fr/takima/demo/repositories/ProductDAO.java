package fr.takima.demo.repositories;

import fr.takima.demo.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface ProductDAO extends CrudRepository<Product, Long> {

    int findByAvailable(Integer available);
}
