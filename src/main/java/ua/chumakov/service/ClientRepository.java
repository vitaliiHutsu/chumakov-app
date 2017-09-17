package ua.chumakov.service;

import org.springframework.data.repository.CrudRepository;
import ua.chumakov.model.Client;

import java.util.List;

/**
 * Created by vesa-pk on 30.08.2017.
 */
public interface ClientRepository extends CrudRepository<Client, Integer> {

     List<Client> findAll();
}
