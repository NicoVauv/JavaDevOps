package fr.takima.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface ProductDAO extends CrudRepository<Product, Long> {

    public int findBySelected(Integer selected);
}
