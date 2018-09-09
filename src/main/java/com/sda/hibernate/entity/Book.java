package com.sda.hibernate.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)          // wybieranie sposobu w jaki ma byc ustawiany klucz
    private int id;
    @Column                                                      // @Column(name =" ") sluzy do zmieniania nazwy kolumny
    private String title;
    @Column
    private String isbn;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Author> author;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    private Publisher publisher;

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public Book() {
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAuthor(Set<Author> author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
