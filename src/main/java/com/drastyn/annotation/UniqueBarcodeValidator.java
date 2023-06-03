package com.drastyn.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.drastyn.respositories.ProductRepository;

public class UniqueBarcodeValidator implements ConstraintValidator<UniqueBarcode, String>{
  @Autowired
  private ProductRepository productRepository;
  
  @Override
  public void initialize(UniqueBarcode constraintAnnotation) {}
  
  @Override
  public boolean isValid(String barcode, ConstraintValidatorContext context) {
    if(productRepository == null) { return true; }
    return productRepository.findByBarcode(barcode).isEmpty();
  }
 
}
