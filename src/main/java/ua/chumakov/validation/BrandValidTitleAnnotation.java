package ua.chumakov.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidBrandTitle.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface BrandValidTitleAnnotation {
    String message() default "Есть такой бренд";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
