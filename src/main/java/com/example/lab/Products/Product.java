package com.example.lab.Products;

import com.example.lab.Category.Category;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "wydawnictwo", nullable = false)
    private String wydawnictwo;

    @JoinColumn(name = "category_id", nullable = false)
    @ManyToOne(cascade = CascadeType.DETACH)
    private Category category;


    @Nullable
    public Product(String name, String author, String language, String wydawnictwo, Category category) {
        this.name = name;
        this.author = author;
        this.language = language;
        this.wydawnictwo = wydawnictwo;
        this.category = category;
    }
}
