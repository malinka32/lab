package com.example.lab.Products;

import com.example.lab.Category.Category;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAllProducts();
    Optional<Product> findById(Long id);
    List<Product> findByCategory(Category category);
    Product saveProduct(Product product);
    Product updateProduct(Long id, ProductUpdateRequest updateRequest);
    void deleteProduct(Long id);
}
