package org.bookshop.system2018.bookshopsystem2018.repositories;

import org.bookshop.system2018.bookshopsystem2018.model.entity.Author;
import org.bookshop.system2018.bookshopsystem2018.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(Date releaseDate);
}
