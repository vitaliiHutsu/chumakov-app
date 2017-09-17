package ua.chumakov.service;

import org.springframework.data.repository.CrudRepository;
import ua.chumakov.model.User;

import java.util.Set;

/**
 * Created by vesa-pk on 30.08.2017.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    Set<User> findAll();
    User findByLogin(String login);
}
