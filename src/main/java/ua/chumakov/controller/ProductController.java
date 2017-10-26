package ua.chumakov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.chumakov.model.Category;
import ua.chumakov.model.Client;
import ua.chumakov.model.Product;
import ua.chumakov.model.Provider;
import ua.chumakov.service.ClientRepository;
import ua.chumakov.service.ProductRepository;
import ua.chumakov.service.ProviderRepository;

import java.util.List;

/**
 * Created by vesa-pk on 05.09.2017.
 */
@Controller()
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProviderRepository providerRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("product");
    }

    @RequestMapping(value = "/checkout/{id}",method = RequestMethod.GET)
    public ModelAndView checkout(@PathVariable int id) {
        Product product = productRepository.findOne(id);
        ModelAndView modelAndView = new ModelAndView("checkout");
        modelAndView.addObject("product", product);
        return modelAndView;
    }
}
