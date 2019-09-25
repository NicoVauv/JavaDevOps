package fr.takima.demo.repositories;

import fr.takima.demo.models.Product;
import fr.takima.demo.models.ProductFridge;
import fr.takima.demo.models.ProductList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public interface ProductFridgeDAO extends CrudRepository<ProductFridge, Long> {
    List<ProductFridge> findProductFridgesByMyFridges(Product myFridges);
}
