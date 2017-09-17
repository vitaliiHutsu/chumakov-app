package ua.chumakov.validation;

import org.springframework.beans.factory.annotation.Autowired;
import ua.chumakov.model.Category;
import ua.chumakov.service.CategoryRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by vesa-pk on 06.09.2017.
 */
public class ValidCategoryTitle implements ConstraintValidator<CategoryValidTitleAnnotation, String> {

    @Autowired
    private CategoryRepository repository;

    @Override
    public void initialize(CategoryValidTitleAnnotation categoryValidTitleAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (repository != null) {
            Category category = repository.findByTitle(s);
            if (category == null)
                return true;
            else
                return false;
        }else {
            return true;
        }
    }
}
