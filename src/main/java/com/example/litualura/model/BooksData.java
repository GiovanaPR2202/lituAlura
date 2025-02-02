package com.example.litualura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BooksData(@JsonAlias("title") String title, @JsonAlias("authors") List<AuthorsData> author,
                        @JsonAlias("languages") List<String> languages,
                        @JsonAlias("download_count") Integer downloadsNumber) {

}