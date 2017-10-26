package ua.chumakov.util.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import ua.chumakov.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryUtil {

    private List<Category> categories = new ArrayList<>();
    private Document document;

    public CategoryUtil(Document document) {
        this.document = document;
        installCategories();
    }


    private void installCategories() {
        NodeList nodeList = document.getElementsByTagName("category");
        Category category = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);

            category = new Category();
            category.setTitle(element.getTextContent());
            if (element.getAttribute("parentId").equals(""))
                category.setXmlParentId(0);
            else
                category.setXmlParentId(Integer.valueOf(element.getAttribute("parentId")));
            category.setXmlId(Integer.valueOf(element.getAttribute("id")));
            categories.add(category);
        }
    }

    public List<Category> getCategories() {
        return categories;
    }
}
