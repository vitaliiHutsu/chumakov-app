package ua.chumakov.model;

import java.util.List;

/**
 * Created by vesa-pk on 10.09.2017.
 */
public class TitleBrendAndCategory {
    private List<String> allTitleBrand;
    private List<String> allTitleCategory;

    public TitleBrendAndCategory(List<String> allTitleBrand, List<String> allTitleCategory) {
        this.allTitleBrand = allTitleBrand;
        this.allTitleCategory = allTitleCategory;
    }

    public List<String> getAllTitleBrand() {
        return allTitleBrand;
    }

    public List<String> getAllTitleCategory() {
        return allTitleCategory;
    }
}
