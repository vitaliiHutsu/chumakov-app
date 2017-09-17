package ua.chumakov.service;

import org.springframework.data.repository.CrudRepository;
import ua.chumakov.model.Brand;
import ua.chumakov.model.BrandModel;

import java.util.Set;

/**
 * Created by vesa-pk on 30.08.2017.
 */
public interface BrandRepository extends CrudRepository<Brand, Integer> {
    Brand findByTitle(String title);
    Set<Brand> findAll();
    Set<Brand> findByBrandModels(BrandModel brandModel);
}
