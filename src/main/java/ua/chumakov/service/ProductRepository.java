package ua.chumakov.service;

import org.springframework.data.repository.CrudRepository;
import ua.chumakov.model.Product;

import java.util.List;

/**
 * Created by vesa-pk on 26.09.2017.
 */
public interface ProductRepository extends CrudRepository<Product, Integer>{
    List<Product> findAll();
}
