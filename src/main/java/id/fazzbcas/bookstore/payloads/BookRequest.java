package id.fazzbcas.bookstore.payloads;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String description;
}
