package org.bookshop.system2018.bookshopsystem2018;

import org.bookshop.system2018.bookshopsystem2018.enums.AgeRestriction;
import org.bookshop.system2018.bookshopsystem2018.enums.EditionType;
import org.bookshop.system2018.bookshopsystem2018.model.entity.Author;
import org.bookshop.system2018.bookshopsystem2018.model.entity.Book;
import org.bookshop.system2018.bookshopsystem2018.model.entity.Category;
import org.bookshop.system2018.bookshopsystem2018.services.AuthorService;
import org.bookshop.system2018.bookshopsystem2018.services.BookService;
import org.bookshop.system2018.bookshopsystem2018.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

//      private static final String AUTHORS_RESOURCE_FILE = "authors.txt";
//      Hardcore Path
//      private static final String AUTHORS_RESOURCE_FILE = System.getProperty("user.dir") + "/src/main/resources" + "author.txt";
    private static final String AUTHORS_RESOURCE_FILE = "D:/IdeaProjects/SoftwareUniversity/book-shop-system2018/src/main/resources/authors.txt";

    private static final String CATEGORIES_RESOURCE_FILE = "D:\\IdeaProjects\\SoftwareUniversity\\book-shop-system2018\\src\\main\\resources\\categories.txt";

    private static final String BOOKS_RESOURCE_FILE = "D:\\IdeaProjects\\SoftwareUniversity\\book-shop-system2018\\src\\main\\resources\\books.txt";


    @Autowired
    public Runner(AuthorService authorService,
                  CategoryService categoryService,
                  BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        initAuthors();
        initCategories();
        initBooks();
        allBooksTitleAfter2000();
    }

    private void initAuthors() throws IOException {
//        InputStream inputStream = this.getClass().getResourceAsStream(AUTHORS_RESOURCE_FILE);
//        new BufferedReader(new InputStreamReader(inputStream));
        List<String> allAuthors = Files.readAllLines(Paths.get(AUTHORS_RESOURCE_FILE));
        List<Author> authors = allAuthors
                .stream()
                .map(s -> {
                    String[] authorsNames = s.split("\\s+");
                    return new Author(authorsNames[0], authorsNames[1]);
                }).collect(Collectors.toList());

        this.authorService.saveAuthorIntoDb(authors);
    }

    private void initCategories() throws IOException {
        List<String> allCategories = Files.readAllLines(Paths.get(CATEGORIES_RESOURCE_FILE));
        List<Category> categories = allCategories
                .stream()
                .filter(s -> !s.isEmpty())
                .map(Category::new)
                .collect(Collectors.toList());

        this.categoryService.saveCategoryIntoDb(categories);
    }

    private void initBooks() throws IOException, ParseException {
        List<String> allBooks = Files.readAllLines(Paths.get(BOOKS_RESOURCE_FILE));
        List<Author> allAuthors = this.authorService.getAll();
        Random random = new Random();
        List<Book> allLibrary = new ArrayList<>();

        for (String line : allBooks) {
            String[] data = line.split("\\s+");

            int authorIndex = random.nextInt(allAuthors.size());
            Author author = allAuthors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType.toString());
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction.toString());
            book.setTitle(title);
            allLibrary.add(book);
        }

        this.bookService.saveIntoDb(allLibrary);
    }

    private void allBooksTitleAfter2000() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2000-01-01");
        List<String> allBooks = this.bookService.allTitleAfterYear(date);
        System.out.println(allBooks);
    }

}
