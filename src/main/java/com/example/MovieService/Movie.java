package com.example.MovieService;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
public class Movie {
    @Schema(name = "ID filmu", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(name = "nazwa filmu", example = "star gate", required = false)
    private String name;
    @Schema(name = "kategoria filmu z enum", example = "SCI_FI", required = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Schema(name = "dostepnosc", example = "false", required = false)
    private boolean isAvailable = false;

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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

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
