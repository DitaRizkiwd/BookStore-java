package id.fazzbcas.bookstore.services.book;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.fazzbcas.bookstore.dao.BookRepo;
import id.fazzbcas.bookstore.models.Book;
import id.fazzbcas.bookstore.payloads.BookRequest;
import id.fazzbcas.bookstore.payloads.Response;
import id.fazzbcas.bookstore.payloads.ResponseData;

@Service
public class BookServiceImpl implements BookService{
    @Autowired //agar inisialisasi bookRepo agar tidak null
    BookRepo bookRepo;

    @Override
    public ResponseData<List<Book>> getBooks() {
        //ambil data dari db all
        List<Book> books = this.bookRepo.findAll();
        //return respons
        ResponseData<List<Book>> result = new ResponseData<List<Book>>("succes", true,books);
        return result;

    }

    @Override
    public Response postBook(BookRequest request) {
        //buat entitas buku dari payload
        Book book = new Book(request.getTitle(),request.getDescription());
        //save to repo
        this.bookRepo.save(book);
        //return response
        Response respon = new Response("success", true);
        return respon;
    }

    @Override
    public ResponseData<Book> updateBook(String id, BookRequest request) {
        //find book by id
         //id gadapet ->throw ex
        Book book = this.bookRepo.findById(id).orElseThrow(()->{
            throw new NoSuchElementException("ID Book "+id+" not found");
        }); //handling exception
    
        // id dapet -> value diganti request
        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());
        //save book
        this.bookRepo.save(book);
        //response
        ResponseData<Book> result = new ResponseData<Book>("success", true,book);
        return result;

    }

    @Override
    public Response deletedBook(String id) {
        //find book by id
        Book book = this.bookRepo.findById(id).orElseThrow(()->{
            throw new NoSuchElementException("ID Book "+id+" not found");
        });

        //update status deleted
        book.setIsDeleted(true);

        //save
        this.bookRepo.save(book);

        Response response = new Response(id+" is deleted! ", true);
        return response;
        
    }

    @Override
    public ResponseData<List<Book>> getBooksbyTitle(String title) {
        List<Book> books = this.bookRepo.searchByTitle(title);
        ResponseData<List<Book>> responseData = new ResponseData<List<Book>>("success",true, books);
        return responseData;
    }
    
    
}
