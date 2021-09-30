package br.edu.ifpb.lira.book.repositories;

import br.edu.ifpb.lira.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>{
    public List<Book> findByTitle(String title);

    @Query("SELECT b FROM Book b where b.pages>=150")
    public List<Book> getBooksBigs();
}
