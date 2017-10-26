package ua.chumakov.service.database.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.chumakov.model.Category;
import ua.chumakov.service.CategoryRepository;
import ua.chumakov.util.xml.CategoryUtil;
import ua.chumakov.util.xml.DocumentUtil;
import ua.chumakov.util.xml.SettingsXml;

import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

@Service
public class AllCategoryUpdate {
    private List<Category> categories;

    private DocumentUtil documentUtil = new DocumentUtil(SettingsXml.url);
    private CategoryUtil categoryUtil = new CategoryUtil(documentUtil.getDocument());

    @Autowired
    private CategoryRepository categoryRepository;

    public AllCategoryUpdate() throws ParserConfigurationException {
        allCategory();
    }


    private void allCategory(){
        categories = categoryUtil.getCategories();
    }



    public void updateCategory(){
        categoryRepository.save(categories);
    }
}
