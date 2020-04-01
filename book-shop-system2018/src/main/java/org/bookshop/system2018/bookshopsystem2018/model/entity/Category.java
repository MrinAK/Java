package org.bookshop.system2018.bookshopsystem2018.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    private Long id;
    private String name;
    private Set<Book> books;

    public Category() {
        this.books = new HashSet<>();
    }

    public Category(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @ManyToMany(mappedBy = "categories", targetEntity = Book.class)
    public Set<Book> getBooks() {
        return this.books;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
