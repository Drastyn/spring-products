package com.drastyn.respositories;

import java.util.Optional;

import com.drastyn.models.ProductsDTO;
import com.drastyn.models.ProductModel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
  @Query("SELECT p.id as id, p.name as name, p.barcode as barcode FROM ProductModel p") 
  Page<ProductsDTO> findProductsDTO(Pageable pageable);
  Optional<ProductModel> findByBarcode(String barcode);
  Optional<ProductModel> findByName(String name);
}
