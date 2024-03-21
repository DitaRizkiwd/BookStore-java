package id.fazzbcas.bookstore.services.book;

import java.util.List;

import id.fazzbcas.bookstore.models.Book;
import id.fazzbcas.bookstore.payloads.BookRequest;
import id.fazzbcas.bookstore.payloads.Response;
import id.fazzbcas.bookstore.payloads.ResponseData;

public interface BookService {
    //kerangka CRUD
    //retrieve
    ResponseData<List<Book>> getBooks();
    Response postBook(BookRequest request);
    ResponseData<Book> updateBook(String id,BookRequest request);
    Response deletedBook(String id);
    ResponseData<List<Book>> getBooksbyTitle(String title);
}
