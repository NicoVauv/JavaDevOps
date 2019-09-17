package fr.takima.demo.repositories;

import fr.takima.demo.models.ProductFridge;
import org.springframework.data.repository.CrudRepository;

public interface ProductFridgeDAO extends CrudRepository<ProductFridge, Long> {
}