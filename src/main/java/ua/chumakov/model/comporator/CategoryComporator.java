package ua.chumakov.model.comporator;

import ua.chumakov.model.Category;

import java.util.Comparator;

/**
 * Created by vesa-pk on 06.10.2017.
 */
public class CategoryComporator implements Comparator<Category> {
    @Override
    public int compare(Category o1, Category o2) {
        return o1.getTitle().toLowerCase().compareTo(o2.getTitle().toUpperCase());
    }

    @Override
    public Comparator<Category> reversed() {
        return null;
    }
}
