package ua.chumakov.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ua.chumakov.model.Brand;
import ua.chumakov.model.BrandModel;
import ua.chumakov.model.Category;
import ua.chumakov.model.TitleBrendAndCategory;
import ua.chumakov.service.BrandModelRepository;
import ua.chumakov.service.BrandRepository;
import ua.chumakov.service.CategoryRepository;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by vesa-pk on 05.09.2017.
 */
@RestController()
@RequestMapping("/productRest/")
@EnableGlobalMethodSecurity
public class ProductRestController {

    @Autowired
    private CategoryRepository repositoryCategory;
    @Autowired
    private BrandRepository repositoryBrand;
    @Autowired
    private BrandModelRepository brandModelRepository;

    @RequestMapping(value = "newCategory/", method = RequestMethod.POST)
    public ResponseEntity<?> addCategory(@RequestBody @Valid Category category, Errors errors) {

        if (errors.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } else {
            repositoryCategory.save(category);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "getAllTitleBrand/", method = RequestMethod.GET)
    public ResponseEntity<?> getTitleBrand() {
        List<String> allTitleBrand = repositoryBrand.findAll()
                .stream()
                .map(Brand::getTitle)
                .collect(Collectors.toList());

        List<String> allTitleCategory = repositoryCategory.findAll()
                .stream()
                .map(Category::getTitle)
                .collect(Collectors.toList());

        System.out.println(allTitleBrand);
        return new ResponseEntity<>(new TitleBrendAndCategory(allTitleBrand, allTitleCategory), HttpStatus.OK);
    }

    @RequestMapping(value = "newBrand/", method = RequestMethod.POST)
    public ResponseEntity<?> addBrand(@RequestBody @Valid Brand brand, Errors errors) {

        if (errors.hasErrors()) {
            System.out.println("UUUPS!!!!");
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

        } else {
            System.out.println(brand);
            repositoryBrand.save(brand);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }


    @RequestMapping(value = "getAllCategory/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCategory() {
        Set<Category> categories = repositoryCategory.findAll();

        System.out.println(categories);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "getAllBrands/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllBrands() {
        Set<Brand> brands = repositoryBrand.findAll();

        System.out.println(brands);
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @RequestMapping(value = "addNewProduct/", method = RequestMethod.GET)
    public ResponseEntity<?> addProduct(@RequestParam String titleProduct,
                                        @RequestParam String brendProduct,
                                        @RequestParam String categoryProduct,
                                        @RequestParam String purchasePriceProduct,
                                        @RequestParam String percentageMarkupProduct,
                                        @RequestParam String notationProduct) {
        BrandModel brandModel = new BrandModel();
        brandModel.setCategory(repositoryCategory.findByTitle(categoryProduct));
        brandModel.setTitle(titleProduct);
        brandModel.setPurchasePrice(Double.valueOf(purchasePriceProduct));
        brandModel.setDate(new java.sql.Date(new Date().getTime()));
        brandModel.setNotation(notationProduct);
        double wrappingPrice = (Double.valueOf(purchasePriceProduct) * Double.valueOf(percentageMarkupProduct)) / 100;
        brandModel.setSellingPrice(Double.valueOf(purchasePriceProduct) + wrappingPrice);
        Set<Brand> brands = new HashSet<>();
        brands.add(repositoryBrand.findByTitle(brendProduct));
        brandModel.setBrands(brands);
        brandModelRepository.save(brandModel);
        System.out.println(wrappingPrice);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "getAllProduct/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllProduct(){
        Set<BrandModel> brandModels = brandModelRepository.findAll();
        System.out.println("------------------------hello ----------------------");
        System.out.println(brandModels);
        return new ResponseEntity<>(brandModels,HttpStatus.OK);
    }
    @RequestMapping(value = "getProductById/", method = RequestMethod.GET)
    public ResponseEntity<?> getProductById(@RequestParam int index){
        BrandModel brandModel = brandModelRepository.findById(index);
        Set<Brand> brands = repositoryBrand.findByBrandModels(brandModel);
        System.out.println(brands.size());
        return new ResponseEntity<>(brandModel, HttpStatus.OK);
    }

}
