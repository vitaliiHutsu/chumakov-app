package ua.chumakov.service;

import org.springframework.data.repository.CrudRepository;
import ua.chumakov.model.Sale;

/**
 * Created by vesa-pk on 30.08.2017.
 */
public interface SaleRepository extends CrudRepository<Sale, Integer> {
}
