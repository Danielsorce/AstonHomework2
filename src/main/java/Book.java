import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Book {
    String name;
    String author;
    Integer pages;
    Integer year;
}
