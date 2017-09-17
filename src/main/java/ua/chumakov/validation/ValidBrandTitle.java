package ua.chumakov.validation;

import org.springframework.beans.factory.annotation.Autowired;
import ua.chumakov.model.Brand;
import ua.chumakov.service.BrandRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by vesa-pk on 08.09.2017.
 */
public class ValidBrandTitle implements ConstraintValidator<BrandValidTitleAnnotation, String> {

    @Autowired
    private BrandRepository repository;

    @Override
    public void initialize(BrandValidTitleAnnotation brandValidTitleAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (repository != null) {
            Brand brand = repository.findByTitle(s);
            if (brand == null)
                return true;
            else
                return false;
        }else {
            return true;
        }
    }
}
