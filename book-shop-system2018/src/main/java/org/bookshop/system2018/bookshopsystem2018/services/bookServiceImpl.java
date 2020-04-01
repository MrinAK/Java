package org.bookshop.system2018.bookshopsystem2018.services;

import org.bookshop.system2018.bookshopsystem2018.model.entity.Book;
import org.bookshop.system2018.bookshopsystem2018.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class bookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public bookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveIntoDb(List<Book> books) {
        this.bookRepository.saveAll(books);
    }

    @Override
    public List<String> allTitleAfterYear(Date year) {

        return this.bookRepository.findAllByReleaseDateAfter(year)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }
}
