package com.example.lab.Category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.findAllCategory()
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDto createNewCategory(@RequestBody CategoryCreationRequest categoryCreationRequest) {
        Category category = new Category(categoryCreationRequest.getName(), categoryCreationRequest.getDescription());
        Category savedCategory = categoryService.saveCategory(category);
        return categoryMapper.toDto(savedCategory);
    }
}
