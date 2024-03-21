package id.fazzbcas.bookstore.models;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //buat menandakan entitas
@Table(name="books")
@NoArgsConstructor
@Setter
@Getter
public class Book {
    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private String title;

    private String description;

    private Boolean isDeleted = false;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updateAt;


    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }
    
}
