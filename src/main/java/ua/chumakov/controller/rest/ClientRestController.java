package ua.chumakov.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ua.chumakov.model.Client;
import ua.chumakov.service.ClientRepository;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vesa-pk on 03.09.2017.
 */
@RestController()
@RequestMapping("/client")
@EnableGlobalMethodSecurity
public class ClientRestController {

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value = "/getDetalisClient/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getByIdClient(@PathVariable int id){

        Client client = clientRepository.findOne(id);
        System.out.println(client);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll/",method = RequestMethod.GET)
    public ResponseEntity<?> getAllClient(){

        List<Client> clients = clientRepository.findAll();
        if (clients == null && clients.size() == 0)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(clients, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/newClient/", method = RequestMethod.POST)
    public ResponseEntity<?> addNewClient(@RequestBody @Valid Client client, Errors errors){

        if (errors.hasErrors()){
            Map<String, String> stringMap = new HashMap<>();
            String errorMessageJson = "error";

            List<FieldError> fieldErrors = errors.getFieldErrors();

            for (FieldError fieldError : fieldErrors){
                stringMap.put(fieldError.getField(), errorMessageJson);
            }
            return new ResponseEntity<Object>(stringMap, HttpStatus.EXPECTATION_FAILED);
        }else {
            System.out.println(client);
            clientRepository.save(client);
            HttpHeaders headers = new HttpHeaders();
            headers.set("date", new Date().toString());
            return new ResponseEntity<String>(headers, HttpStatus.CREATED);
        }

    }
}
