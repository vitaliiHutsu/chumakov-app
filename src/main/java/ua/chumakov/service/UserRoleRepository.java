package ua.chumakov.service;

import org.springframework.data.repository.CrudRepository;
import ua.chumakov.model.UserRole;

/**
 * Created by vesa-pk on 30.08.2017.
 */
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
}
