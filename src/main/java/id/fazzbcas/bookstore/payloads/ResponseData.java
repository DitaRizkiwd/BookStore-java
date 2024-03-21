package id.fazzbcas.bookstore.payloads;

// import lombok.AllArgsConstructor;
// import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResponseData<T> extends Response {
    private T data;

    public ResponseData(String message, Boolean success, T data) {
        super(message, success);
        this.data = data;
    }
    
}
