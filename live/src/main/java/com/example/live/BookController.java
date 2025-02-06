package com.example.live;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //для преобразования ответов в JSON или XML (RESTful веб сервис)
@RequestMapping("/books")
public class BookController {
    @Autowired  // для автоматического связывания компонентов бина между собой
    private BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(
        @RequestParam(required=false) String title,
        @RequestParam(required=false) String author) {
            List<Book> books;
            if (title != null || author != null) {
                books = bookRepository.findByTitleAndAuthor(title, author);
            } else {
                books = bookRepository.findAll();
            }
            return new ResponseEntity<>(books, HttpStatus.OK);
        }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createBook = bookRepository.save(book);
        return new ResponseEntity<>(createBook, HttpStatus.CREATED);
    }
}
