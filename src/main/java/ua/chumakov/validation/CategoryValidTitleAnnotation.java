package ua.chumakov.validation;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by vesa-pk on 06.09.2017.
 */
@Documented
@Constraint(validatedBy = ValidCategoryTitle.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoryValidTitleAnnotation {
    String message() default "Есть такая категория";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
