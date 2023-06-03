package com.drastyn.controllers;

import com.drastyn.models.ProductsDTO;
import com.drastyn.models.ProductModel;
import com.drastyn.services.ProductService;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/products")
public class ProductController {
  @Autowired
  ProductService productService;
  
  @GetMapping()
  Page<ProductsDTO> getProducts(Pageable pageable) {
    return productService.getProducts(pageable);
  } 
  
  @PostMapping("/new")
  public ProductModel saveProduct(@Valid @RequestBody ProductModel product) {
    return this.productService.createProduct(product);
  }
  
  @PostMapping("/update")
  public ProductModel updateProduct(@RequestBody ProductModel product) {
    return this.productService.updateProduct(product);
  }
  
  @GetMapping(path = "/{barcode}")
  public Optional<ProductModel> getProduct(@PathVariable("barcode") String barcode) {
    return this.productService.getProduct(barcode);
  }
  
}
