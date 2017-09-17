package ua.chumakov.service;

import org.springframework.data.repository.CrudRepository;
import ua.chumakov.model.Provider;

/**
 * Created by vesa-pk on 30.08.2017.
 */
public interface ProviderRepository extends CrudRepository<Provider, Integer> {
}
