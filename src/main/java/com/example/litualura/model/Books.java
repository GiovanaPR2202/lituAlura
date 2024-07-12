package com.example.litualura.model;


import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private String language;
    private Integer downloadsNumbers;
    @ManyToOne(cascade = CascadeType.ALL)
    private  Authors author;


    public Books(){}

    public Books(BooksData booksData){
        this.title = booksData.title();
        Authors authors = new Authors(booksData.author().get(0));
        this.author = authors;
        this.language = booksData.languages().get(0);
        this.downloadsNumbers = booksData.downloadsNumber();
    }

    public Books(Long id, String title, Authors author, String language, Integer downloadsNumbers){
        this.title = title;
        this.author = author;
        this.language = language;
        this.downloadsNumbers = downloadsNumbers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getDownloadsNumbers() {
        return downloadsNumbers;
    }

    public void setDownloadsNumbers(Integer downloadsNumbers) {
        this.downloadsNumbers = downloadsNumbers;
    }

    @Override
    public String toString() {
        return "------------------ BOOK ------------------" +
                "\nTitle: " + title +
                "\nAuthor: " + author.getName() +
                "\nLanguage: " + language +
                "\nDownload Numbers: " + downloadsNumbers +
                "\n-------------------------------------------\n";
    }


}
