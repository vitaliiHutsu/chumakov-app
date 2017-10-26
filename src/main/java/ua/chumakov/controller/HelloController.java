package ua.chumakov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.chumakov.model.Category;
import ua.chumakov.service.CategoryRepository;
import ua.chumakov.service.ProductRepository;
import ua.chumakov.service.database.util.AllCategoryUpdate;
import ua.chumakov.service.database.util.AllProductUpdate;

import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

@Controller()
public class HelloController {
//
    @Autowired
    private AllCategoryUpdate allCategoryUpdate;
    @Autowired
    private AllProductUpdate allProductUpdate;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/")
    public ModelAndView welcome() throws ParserConfigurationException {
        ModelAndView modelAndView = new ModelAndView("home");
//        allCategoryUpdate.updateCategory();
//        allProductUpdate.updateProduct();
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }


    @RequestMapping("/403")
    public ModelAndView get403(){
        return new ModelAndView("403");
    }


}
