package fr.takima.demo.repositories;

import fr.takima.demo.models.ProductList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface ProductListDAO extends CrudRepository<ProductList, Long> {
}
