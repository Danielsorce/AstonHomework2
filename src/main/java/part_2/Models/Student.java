package part_2.Models;

import java.util.List;

public class Student {
    //
    private final String firstName;

    private List<Book> books;

    public Student(String firstName, List<Book> books) {
        this.firstName = firstName;
        if (books != null) {
            this.books = books;
        }
    }

    public List<Book> getBooks(){
        return books;
    }

    public String toString() {
        return "Студент Имя {" + firstName + "} Книги " + books;
    }
}