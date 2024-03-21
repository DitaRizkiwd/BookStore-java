package id.fazzbcas.bookstore.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import id.fazzbcas.bookstore.payloads.ResponseError;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value=Exception.class)
    public ResponseEntity <?> globalEx(Exception e){
        log.info("Global Exception", e.getMessage());
        ResponseError responseError = new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
        HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
        return ResponseEntity.status(responseError.getStatus()).body(responseError);
    }
    @ExceptionHandler(value=NoSuchElementException.class)
    public ResponseEntity<?> nullEx (NoSuchElementException e){
        log.info("Null Exception invoked", e.getMessage());
        ResponseError responseError = new ResponseError(HttpStatus.NOT_FOUND.value(),
        HttpStatus.NOT_FOUND.toString(),e.getMessage());
        return ResponseEntity.status(responseError.getStatus()).body(responseError);
    }

}
