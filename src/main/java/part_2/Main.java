package part_2;

import part_2.Models.Book;
import part_2.Models.Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Алиса", Arrays.asList(
                        new Book("А", 1999, 320),
                        new Book("Б", 2010, 200),
                        new Book("В", 2005, 250),
                        new Book("Г", 2012, 120),
                        new Book("Д", 2022, 180)
                )),
                new Student("Виталий", Arrays.asList(
                        new Book("Е", 1998, 145),
                        new Book("Ё", 2002, 210),
                        new Book("Ж", 2008, 220),
                        new Book("З", 2015, 333),
                        new Book("И", 2017, 500)
                )),
                new Student("Юрий", Arrays.asList(
                        new Book("Й", 2001, 104),
                        new Book("К", 2012, 222),
                        new Book("П", 2009, 334),
                        new Book("М", 2021, 405),
                        new Book("Н", 2022, 222)
                ))
        );

        students.stream()
                .peek(student ->  System.out.println(student.toString()))
                .flatMap(s -> s.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(b -> b.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска: " + year),
                        () -> System.out.println("Такой книги нет ")
                );
    }
}
