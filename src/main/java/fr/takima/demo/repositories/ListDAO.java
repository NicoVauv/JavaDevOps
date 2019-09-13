package fr.takima.demo.repositories;

import fr.takima.demo.models.List;
import org.springframework.data.repository.CrudRepository;

public interface ListDAO extends CrudRepository<List, Long> {
    List findById(long id);
}
