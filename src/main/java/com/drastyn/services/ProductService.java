package com.drastyn.services;

import java.util.Optional;

import com.drastyn.models.ProductsDTO;
import com.drastyn.models.ProductModel;
import com.drastyn.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public Page<ProductsDTO> getProducts(Pageable pageable) {
	  return productRepository.findProductsDTO(pageable);
	}
	
	public ProductModel createProduct(ProductModel product) {
	  return productRepository.save(product);
	}
	
	public ProductModel updateProduct(ProductModel product) {
	  return productRepository.save(product);
	}

	public Optional<ProductModel> getProduct(String barcode) {
	  return productRepository.findByBarcode(barcode);
	}

}
