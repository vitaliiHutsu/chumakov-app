package ua.chumakov.util.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import ua.chumakov.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductUtil {
    private List<Product> products = new ArrayList<>();
    private Document document;

    public ProductUtil(Document document) {
        this.document = document;
        installProducts();
    }

    private void installProducts() {
        NodeList nodeList = document.getElementsByTagName("offer");
        Product product;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);

            product = new Product();
            product.setXmlId(Integer.valueOf(getItemElementValue(element, "categoryId")));
            product.setUrl(getItemElementValue(element, "url"));
            product.setPrice(Double.valueOf(getItemElementValue(element, "price")));
            product.setPicture(getItemElementValue(element, "picture"));
            product.setName(getItemElementValue(element, "name"));
            String vendor = getItemElementValue(element, "vendor");
            if (vendor != null)
                product.setVendor(vendor);
            else
                product.setVendor("");
            product.setVendorCode(getItemElementValue(element, "vendorCode"));
            product.setDescription(getItemElementValue(element, "description"));

            products.add(product);
        }
    }

    private String getItemElementValue(Element element, String item) {
        Element element1 = (Element) element.getElementsByTagName(item)
                .item(0);
        if (element1 == null)
            return "";
        else {
            return element.getElementsByTagName(item)
                    .item(0)
                    .getChildNodes()
                    .item(0).getNodeValue();
        }

    }

    public List<Product> getProducts() {
        return products;
    }
}
