package ua.chumakov.service;

import org.springframework.data.repository.CrudRepository;
import ua.chumakov.model.Category;

import java.util.Set;

/**
 * Created by vesa-pk on 06.09.2017.
 */
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category findByTitle(String title);

    Set<Category> findAll();

}
