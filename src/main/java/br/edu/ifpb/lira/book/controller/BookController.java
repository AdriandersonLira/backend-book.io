package br.edu.ifpb.lira.book.controller;

import br.edu.ifpb.lira.book.model.Book;
import br.edu.ifpb.lira.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Long idBook) {
        return this.bookService.getBookById(idBook);
    }

    @PostMapping("/books")
    public Book insertBook(@RequestBody Book book){
        return this.bookService.insertOrUpdate(book);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book){
        return this.bookService.insertOrUpdate(book);
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable("id") Long idBook) {
        this.bookService.delete(idBook);
    }

}
