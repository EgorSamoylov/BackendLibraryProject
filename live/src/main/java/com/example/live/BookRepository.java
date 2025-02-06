package com.example.live;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// интерфейса фреймворка Spring Data для работы с бд
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE " + 
    "(:title IS NULL OR lower(b.title) LIKE lower(concat('%', :title, '%'))) AND " +
    "(:author IS NULL OR lower(b.author) LIKE lower(concat('%', :author, '%')))")
    List<Book> findByTitleAndAuthor(@Param("title") String title, @Param("author") String author);
}
