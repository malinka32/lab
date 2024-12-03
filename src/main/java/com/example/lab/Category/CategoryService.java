package com.example.lab.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();
    Category saveCategory(Category category);
}
