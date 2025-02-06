package com.example.live;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// Испольозвание пакета Lombok
@Data // предоставляет геттеры и сеттеры по умолчанию для всех не финальных полей
@NoArgsConstructor // используется для создания конструктора без аргументов
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private int publishedYear;
    private boolean isBorrowed;
}
