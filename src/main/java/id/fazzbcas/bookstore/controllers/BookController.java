package id.fazzbcas.bookstore.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.aspectj.lang.reflect.NoSuchAdviceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import id.fazzbcas.bookstore.models.Book;
import id.fazzbcas.bookstore.payloads.BookRequest;
import id.fazzbcas.bookstore.payloads.Response;
import id.fazzbcas.bookstore.payloads.ResponseData;
import id.fazzbcas.bookstore.services.book.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;






@RestController //untuk routing controller backend, controller aja untuk frontend
@RequestMapping("/books")

public class BookController {
    @Autowired
    BookService bookService;
    
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    @GetMapping
    public ResponseEntity<?> showBooks(@RequestParam(defaultValue="",value="title")String title){
        try{
            ResponseData<List<Book>> response;
            if(title=="" ||title==null||Objects.isNull(title)||title.equals("")){
                response = bookService.getBooks();
            }
            else{
                response = bookService.getBooksbyTitle(title);
            }
            if(response.getData().size()==0){
                throw new NoSuchElementException("Title not Found");
            }
            else{
            return ResponseEntity.status(200).body(response);
            }
        }
        catch(Exception e){
            throw e;
        }
        
    }


    @PostMapping
    public ResponseEntity<?> postBooks(@RequestBody BookRequest request){
        try{
            Response respon = bookService.postBook(request);
            return ResponseEntity.status(HttpStatus.CREATED.value()).body(respon);
        }
        catch(Exception e){
            throw e;
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable String id, @RequestBody BookRequest request){
        try{
            ResponseData<Book> responseData = this.bookService.updateBook(id, request);
            return ResponseEntity.ok().body(responseData);
        }
        catch(Exception e){
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id){
        try{
            Response respon = bookService.deletedBook(id);
            return ResponseEntity.ok().body(respon);

        }
        catch(Exception e){
            throw e;
        }
    }

}
