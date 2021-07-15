package com.drastyn.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.drastyn.respositories.ProductRepository;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void initialize(UniqueName constraintAnnotation) {
	}
	
	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
	  if(productRepository == null) { return true; }
	  return productRepository.findByName(name).isEmpty();
	}
}
	