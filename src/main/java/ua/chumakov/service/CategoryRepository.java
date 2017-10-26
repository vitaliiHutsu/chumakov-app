package ua.chumakov.service;

import org.springframework.data.repository.CrudRepository;
import ua.chumakov.model.Category;

import java.util.List;
import java.util.Set;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category findByTitle(String title);

    List<Category> findAll();
    Category findByXmlId(int xmlId);
    List<Category> findByXmlParentId(int xmlParentId);
    Category findById(int id);

}
