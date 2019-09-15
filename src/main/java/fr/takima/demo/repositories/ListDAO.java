package fr.takima.demo.repositories;

import fr.takima.demo.models.MyList;
import org.springframework.data.repository.CrudRepository;

public interface ListDAO extends CrudRepository<MyList, Long> {
}
