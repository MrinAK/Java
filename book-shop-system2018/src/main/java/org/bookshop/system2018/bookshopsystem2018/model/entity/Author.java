package org.bookshop.system2018.bookshopsystem2018.model.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "authors")
public class Author {

    private Long authorId;
    private String firstName;
    private String lastName;
    private Set<Book> books;

    public Author() {
        this.books = new HashSet<>();
    }

    public Author(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getAuthorId() {
        return this.authorId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    @Column(nullable = false)
    public String getLastName() {
        return this.lastName;
    }

    @OneToMany(mappedBy = "author")
    public Set<Book> getBooks() {
        return this.books;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}

