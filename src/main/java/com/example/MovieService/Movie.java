package com.example.MovieService;

import jakarta.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;

    public Movie(Long id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
    public Movie(){

    }
//    public Movie(String name, String category) {
//        this.id = 5L;
//        this.name = name;
//        this.category = category;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
