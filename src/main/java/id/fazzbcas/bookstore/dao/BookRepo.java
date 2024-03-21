package id.fazzbcas.bookstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.fazzbcas.bookstore.models.Book;
//ini untuk penulisan query, tidak perlu diisi apabila dia basic, penulisan query di web

public interface BookRepo extends JpaRepository<Book,String>{
//Stringnya adalah tipe data primary key
    @Query(value="select * from books where upper(title) like upper(concat('%',?,'%'))", nativeQuery=true)
    List<Book> searchByTitle(String title);

    List<Book> findByTitleIgnoreCaseLike(String title);
    
} 
