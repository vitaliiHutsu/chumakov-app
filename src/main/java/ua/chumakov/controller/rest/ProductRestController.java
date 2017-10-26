package ua.chumakov.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;
import ua.chumakov.model.Category;
import ua.chumakov.model.Product;
import ua.chumakov.model.comporator.CategoryComporator;
import ua.chumakov.model.proxy.model.ProxyCategory;
import ua.chumakov.model.proxy.model.ProxyProduct;
import ua.chumakov.service.BrandRepository;
import ua.chumakov.service.CategoryRepository;
import ua.chumakov.service.ProductRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/productRest/")
@EnableGlobalMethodSecurity
public class ProductRestController {

    @Autowired
    private CategoryRepository repositoryCategory;
    @Autowired
    private BrandRepository repositoryBrand;
    @Autowired
    private ProductRepository productRepository;

//    @RequestMapping(value = "newCategory/", method = RequestMethod.POST)
//    public ResponseEntity<?> addCategory(@RequestBody @Valid Category category, Errors errors) {
//
//        if (errors.hasErrors()) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//        } else {
//            repositoryCategory.save(category);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        }
//    }
//
//    @RequestMapping(value = "getAllTitleBrand/", method = RequestMethod.GET)
//    public ResponseEntity<?> getTitleBrand() {
//        List<String> allTitleBrand = repositoryBrand.findAll()
//                .stream()
//                .map(Brand::getTitle)
//                .collect(Collectors.toList());
//
//        List<String> allTitleCategory = repositoryCategory.findAll()
//                .stream()
//                .map(Category::getTitle)
//                .collect(Collectors.toList());
//
//        System.out.println(allTitleBrand);
//        return new ResponseEntity<>(new TitleBrendAndCategory(allTitleBrand, allTitleCategory), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "newBrand/", method = RequestMethod.POST)
//    public ResponseEntity<?> addBrand(@RequestBody @Valid Brand brand, Errors errors) {
//
//        if (errors.hasErrors()) {
//            System.out.println("UUUPS!!!!");
//            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//
//        } else {
//            System.out.println(brand);
//            repositoryBrand.save(brand);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        }
//    }
//
//
    @RequestMapping(value = "getAllCategory/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCategory() {
        List<Category> categories = repositoryCategory.findAll();
        Collections.sort(categories);
        categories.forEach(x->x.getProducts().clear());
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "getProductsById/", method = RequestMethod.GET)
    public ResponseEntity<?> getProductsById(@RequestParam int id){
        Category category = repositoryCategory.findById(id);
        List<Product> products = category.getProducts();
        products.forEach(x -> x.getCategories().clear());
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


//
//    @RequestMapping(value = "getAllBrands/", method = RequestMethod.GET)
//    public ResponseEntity<?> getAllBrands() {
//        Set<Brand> brands = repositoryBrand.findAll();
//
//        System.out.println(brands);
//        return new ResponseEntity<>(brands, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "addNewProduct/", method = RequestMethod.GET)
//    public ResponseEntity<?> addProduct(@RequestParam String titleProduct,
//                                        @RequestParam String brendProducts,
//                                        @RequestParam String categoryProduct,
//                                        @RequestParam String purchasePriceProduct,
//                                        @RequestParam String percentageMarkupProduct,
//                                        @RequestParam String notationProduct) {
//        BrandModel brandModel = new BrandModel();
//        brandModel.setCategory(repositoryCategory.findByTitle(categoryProduct));
//        brandModel.setTitle(titleProduct);
//        brandModel.setPurchasePrice(Double.valueOf(purchasePriceProduct));
//        brandModel.setDate(new java.sql.Date(new Date().getTime()));
//        brandModel.setNotation(notationProduct);
//        double wrappingPrice = (Double.valueOf(purchasePriceProduct) * Double.valueOf(percentageMarkupProduct)) / 100;
//        brandModel.setSellingPrice(Double.valueOf(purchasePriceProduct) + wrappingPrice);
//        try {
//            brandModelRepository.save(brandModel);
//        } catch (DataIntegrityViolationException ex) {
//            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
//        }
//
//        BrandModel updateBrandModel = brandModelRepository.findByTitle(titleProduct);
//
//        String[] titleBrands = brendProducts.split(",");
//        for (String titleBrand : titleBrands) {
//            Brand brand = repositoryBrand.findByTitle(titleBrand);
//            brand.getBrandModels().add(updateBrandModel);
//            repositoryBrand.save(brand);
//        }
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//        @RequestMapping(value = "getAllProduct/", method = RequestMethod.GET)
//    public ResponseEntity<?> getAllProduct(){
//        Set<BrandModel> brandModels = brandModelRepository.findAll();
//        return new ResponseEntity<>(brandModels,HttpStatus.OK);
//    }
//    @RequestMapping(value = "getProductById/", method = RequestMethod.GET)
//    public ResponseEntity<?> getProductById(@RequestParam int index) {
//        BrandModelel brandModel = brandModelRepository.findById(index);
//        ProxyBrandModel model = new ProxyBrandModel(brandModel.getId(), brandModel.getTitle(),
//                brandModel.getPurchasePrice(), brandModel.getSellingPrice(), brandModel.getNotation());
//        model.setTitleBrend(brandModel.getBrands());
//        return new ResponseEntity<>(model, HttpStatus.OK);
//    }

}
