package com.drastyn.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { UniqueNameValidator.class })
public @interface UniqueName {
  String message() default "There is already a product with that name";
  
  Class<?>[] groups() default {};
  
  Class<? extends Payload>[] payload() default {};
}
