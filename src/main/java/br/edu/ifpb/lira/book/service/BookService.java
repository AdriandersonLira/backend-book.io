package br.edu.ifpb.lira.book.service;

import br.edu.ifpb.lira.book.repositories.BookRepository;
import br.edu.ifpb.lira.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return this.bookRepository.findAll();
    }

    public Book getBookById(Long idBook) {
        return this.bookRepository.findById(idBook).orElse(null);
    }

    @Transactional
    public Book insertOrUpdate(Book book) {
        Book bookInserted = this.bookRepository.save(book);
        return bookInserted;
    }

    public void delete(Long idBook) {
        this.bookRepository.deleteById(idBook);
    }
}
