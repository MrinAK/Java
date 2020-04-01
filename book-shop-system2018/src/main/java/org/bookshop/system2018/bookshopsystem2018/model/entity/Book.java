package org.bookshop.system2018.bookshopsystem2018.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    private Long id;
    private String title;
    private String description;
    private String editionType;
    private BigDecimal price;
    private Integer copies;
    private Date releaseDate;
    private Author author;
    private String ageRestriction;
    private Set<Category> categories;

    public Book() {
        this.categories = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    @Column(length = 50, nullable = false)
    public String getTitle() {
        return this.title;
    }

    @Column(length = 1000)
    public String getDescription() {
        return this.description;
    }

    @Column(nullable = false)
    public String getEditionType() {
        return this.editionType;
    }

    @Column(scale = 2, precision = 19, nullable = false)
    public BigDecimal getPrice() {
        return this.price;
    }

    @Column(nullable = false)
    public Integer getCopies() {
        return this.copies;
    }


    public Date getReleaseDate() {
        return this.releaseDate;
    }

    @ManyToOne(optional = false)
    public Author getAuthor() {
        return this.author;
    }

    @Column(nullable = false)
    public String getAgeRestriction() {
        return this.ageRestriction;
    }

    @ManyToMany
    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEditionType(String editionType) {
        this.editionType = editionType;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
