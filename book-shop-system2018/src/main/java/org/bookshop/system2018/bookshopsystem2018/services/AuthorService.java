package org.bookshop.system2018.bookshopsystem2018.services;

import org.bookshop.system2018.bookshopsystem2018.model.entity.Author;

import java.util.List;

public interface AuthorService {

    void saveAuthorIntoDb(Author author);

    void saveAuthorIntoDb(List<Author> author);

    List<Author> getAll();

}
