package service.impl;

import model.Book;
import service.BookService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class BookServicrImpl implements BookService {
    List<Book> books1 = new ArrayList<>();
    @Override
    public List<Book> createBooks(List<Book> books) {
        books1.addAll(books);
        return books1;
    }

    @Override
    public List<Book> getAllBooks() {
        return books1;
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return  books1.stream().filter(book -> book.getGenre().equals(genre.toUpperCase())).toList();
    }

    @Override
    public Book removeBookById(Long id) {
        books1.removeIf(book -> Objects.equals(book.getId(), id));
        return null;
    }

    @Override
    public List<Book> sortBooksByPriceInDescendingOrder() {
        return books1.stream().sorted(Comparator.comparing(Book::getPrice).reversed()).toList();
    }

    @Override
    public List<Book> filterBooksByPublishedYear() {
        return null;
    }

    @Override
    public List<Book> getBookByInitialLetter() {
         books1.stream().map(Book::getName).filter(s -> s.startsWith("T")).toList().forEach(System.out::println);
        return null;
    }

    @Override
    public Book maxPriceBook() {
        books1.stream().max(Comparator.comparing(Book::getPrice)).ifPresent(System.out::println);
        return null;
    }
}
