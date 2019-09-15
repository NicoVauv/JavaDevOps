package fr.takima.demo.repositories;

import fr.takima.demo.models.MyFridge;
import org.springframework.data.repository.CrudRepository;

public interface FridgeDAO extends CrudRepository<MyFridge, Long> {
}
