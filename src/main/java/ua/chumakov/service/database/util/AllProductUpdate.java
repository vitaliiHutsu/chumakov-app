package ua.chumakov.service.database.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.chumakov.model.Category;
import ua.chumakov.model.Product;
import ua.chumakov.service.CategoryRepository;
import ua.chumakov.service.ProductRepository;
import ua.chumakov.util.xml.DocumentUtil;
import ua.chumakov.util.xml.ProductUtil;
import ua.chumakov.util.xml.SettingsXml;

import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

/**
 * Created by vesa-pk on 26.09.2017.
 */
@Service
public class AllProductUpdate {
    private List<Product> products;

    private DocumentUtil documentUtil = new DocumentUtil(SettingsXml.url);
    private ProductUtil  productUtil = new ProductUtil(documentUtil.getDocument());

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public AllProductUpdate() throws ParserConfigurationException {
        initAllProduct();
    }

    public void initAllProduct(){
        products = productUtil.getProducts();
    }

    public void updateProduct(){
        productRepository.save(products);
        List<Product> productsTmp = productRepository.findAll();
        for (Product product : productsTmp){
           Category category = categoryRepository.findByXmlId(product.getXmlId());
            if (category != null) {
                category = categoryRepository.findByXmlId(product.getXmlId());
                product.getCategories().add(category);
                productRepository.save(product);
            }else {
                List<Category> categories = categoryRepository.findByXmlParentId(product.getXmlId());
                for (Category category1:categories){
                    product.getCategories().add(category1);
                }
                productRepository.save(product);
            }
        }
//        productRepository.save(productsTmp);
    }
}
