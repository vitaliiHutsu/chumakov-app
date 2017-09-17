package ua.chumakov.service;

import org.springframework.data.repository.CrudRepository;
import ua.chumakov.model.BrandModel;

import java.util.Set;

public interface BrandModelRepository extends CrudRepository<BrandModel, Integer> {
    BrandModel findById(int index);
    Set<BrandModel> findAll();
    BrandModel findByTitle(String title);
}
