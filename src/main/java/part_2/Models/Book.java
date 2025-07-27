package part_2.Models;

import java.util.Objects;
//
public class Book {
    private final String title;
    private final int year;
    private final int pages;

    public Book(String title, int year, int pages) {
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book b)) return false;
        return Objects.equals(year, b.year) &&
                Objects.equals(pages, b.pages) &&
                Objects.equals(title, b.title);
    }
    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public int hashCode() {
        return Objects.hash(title, year, pages);
    }

    public String toString() {
        return String.format("%s, %d, %d", title, year, pages);
    }
}
