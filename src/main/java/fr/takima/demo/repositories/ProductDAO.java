package fr.takima.demo.repositories;

import fr.takima.demo.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public interface ProductDAO extends CrudRepository<Product, Long> {
    Product findByName(String name);
    List<Product> findByCategory(String category);
}
