package fr.takima.demo.repositories;

import fr.takima.demo.models.Product;
import fr.takima.demo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface UserDAO extends CrudRepository<User, Long> {
    User findByMail(String mail);
}