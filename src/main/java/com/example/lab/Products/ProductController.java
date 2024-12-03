package com.example.lab.Products;

import com.example.lab.Category.Category;
import com.example.lab.Category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductMapper productMapper;
    private final ProductService productService;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.findAllProducts()
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductsByCategory(@PathVariable Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        List<ProductDto> products = productService.findByCategory(category)
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @GetMapping(params = {"category"})
    public List<ProductDto> getProductsByCategoryName(@RequestParam String category) {
        Category foundCategory = categoryRepository.findByName(category)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return productService.findByCategory(foundCategory)
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createNewProduct(@RequestBody @Validated ProductCreationRequest productCreationRequest) {
        Category category = categoryRepository.findById(productCreationRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product newProduct = new Product(
                productCreationRequest.getName(),
                productCreationRequest.getAuthor(),
                productCreationRequest.getLanguage(),
                productCreationRequest.getWydawnictwo(),
                category
        );

        Product savedProduct = productService.saveProduct(newProduct);
        return productMapper.toDto(savedProduct);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) {
        Product product = productService.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ResponseEntity.ok(productMapper.toDto(product));
    }

    @PatchMapping(path = "{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable("id") Long id,
            @RequestBody ProductUpdateRequest updateRequest) {
        Product updatedProduct = productService.updateProduct(id, updateRequest);
        return ResponseEntity.ok(productMapper.toDto(updatedProduct));
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
}
