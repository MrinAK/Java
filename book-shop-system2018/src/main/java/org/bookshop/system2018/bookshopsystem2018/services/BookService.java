package org.bookshop.system2018.bookshopsystem2018.services;

import org.bookshop.system2018.bookshopsystem2018.model.entity.Book;

import java.util.Date;
import java.util.List;

public interface BookService {

    void saveIntoDb(List<Book> books);

    List<String> allTitleAfterYear(Date year);
}
