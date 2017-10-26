package ua.chumakov.xxx;

import ua.chumakov.util.xml.DocumentUtil;
import ua.chumakov.util.xml.ProductUtil;
import ua.chumakov.util.xml.SettingsXml;

import javax.xml.parsers.ParserConfigurationException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class XXX {

    public static void main(String[] args){

    }

}

class Phone{

    private String name;
    private int price;

    public Phone(String name, int price){
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}