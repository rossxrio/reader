package studio.rossxrio;

import java.io.FileReader;
import java.io.IOException;

public class Book {
    String path;
    String bookName;
    String book = "";

    public Book(String path, String bookName) {
        this.path = path;
        this.bookName = bookName;

        setBook();
    }

    private void setBook() {
        try (FileReader bookReader = new FileReader(path) ) {
            int character;

            while ((character = bookReader.read()) != -1) {
                book += (char)character;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void changeBook(String path) {
        this.path = path;
        setBook();
    }

    public String getBook() {
        return book;
    }

    public String getBookName() {
        return bookName;
    }

    public static void main(String[] args) {
        Book book1 = new Book("src/main/resources/books/sample.html", "Lorem Ipsum");

        System.out.println(book1.getBook());
        System.out.println(book1.getBookName());
    }
}
