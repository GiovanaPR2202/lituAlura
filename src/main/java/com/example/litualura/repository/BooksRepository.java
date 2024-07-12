package com.example.litualura.repository;

import com.example.litualura.model.Authors;
import com.example.litualura.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BooksRepository  extends JpaRepository<Books, Long> {

    List<Books> findByLanguage(String language);

    Integer countByLanguage(String language);

    @Query("SELECT b.downloadsNumbers FROM Books b")
    List<Integer> searchDownloadNumbers();

    @Query("SELECT a FROM Books b JOIN b.author a")
    List<Authors> searchAuthors();

    @Query("SELECT a FROM Books b JOIN b.author a WHERE a.birthYear <= :year and a.deathYears >= :year")
    List<Authors> searchLivingAuthors(@Param("year") Integer year);

    @Query("SELECT a FROM Books b JOIN b.author a WHERE a.name = :name")
    Authors findAuthorByName(@Param("name") String name);

    @Query("SELECT b FROM Books b WHERE b.language LIKE %:language%")
    List<Books> findBooksByLanguages(@Param("language") String language);

}
