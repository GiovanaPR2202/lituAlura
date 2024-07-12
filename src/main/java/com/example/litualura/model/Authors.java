package com.example.litualura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "authors")
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private  Integer birthYear;
    private Integer deathYears;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Books> books = new ArrayList<>();

    public Authors() {}

    public Authors(AuthorsData authorsData){
       this.name = authorsData.name();
       this.birthYear = authorsData.birthYear();
       this.deathYears = authorsData.deathYear();
    }

    public Authors(String name,  Integer birthYear, Integer deathYears){
        this.name = name;
        this.birthYear = birthYear;
        this.deathYears = deathYears;
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

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYears() {
        return deathYears;
    }

    public void setDeathYears(Integer deathYears) {
        this.deathYears = deathYears;
    }

    public List<com.example.litualura.model.Books> getBooks() {
        return books;
    }

    public void setBooks(List<com.example.litualura.model.Books> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "------------------- Author -----------------" +
                "\nAuthor: " + name +
                "\nBirth Year: " + birthYear +
                "\nDeath Year: " + deathYears +
                "\nLivros: " + books.stream().map(l -> l.getTitle()).collect(Collectors.toList())+
                "\n-------------------------------------------\n";
    }

}


