package ua.chumakov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by vesa-pk on 05.09.2017.
 */
@Controller
public class ProductController {

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("product");
    }
}
