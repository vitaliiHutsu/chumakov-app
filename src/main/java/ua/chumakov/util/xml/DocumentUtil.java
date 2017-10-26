package ua.chumakov.util.xml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;


public class DocumentUtil {

    private Document document;

    public DocumentUtil(String url) throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        dbf.setNamespaceAware(true);
        dbf.setFeature("http://xml.org/sax/features/namespaces", false);
        dbf.setFeature("http://xml.org/sax/features/validation", false);
        dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
        dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        try {
            document = db.parse(new URL(url).openStream());
        } catch (SAXException e) {
            e.printStackTrace(); // добавить логирования
        } catch (IOException e) {
            e.printStackTrace(); // добавить логирования если не получилось подключиться к серверу
        }
        document.getDocumentElement().normalize();

    }

    public  Document getDocument() throws ParserConfigurationException {
        return document;
    }

}
