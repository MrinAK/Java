package org.bookshop.system2018.bookshopsystem2018.services;

import org.bookshop.system2018.bookshopsystem2018.model.entity.Author;
import org.bookshop.system2018.bookshopsystem2018.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void saveAuthorIntoDb(Author author) {
        this.authorRepository.saveAndFlush(author);
    }

    @Override()
    public void saveAuthorIntoDb(List<Author> authors) {
        this.authorRepository.saveAll(authors);
    }

    @Override
    public List<Author> getAll() {
        return this.authorRepository.findAll();
    }

}

