import java.util.*;
import java.util.stream.Collectors;


class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;


    public Book(int bookId, String title, String author, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

   public class LibraryManagement {
    private List<Book> books = new ArrayList<>();


    public void addBook(Book book) {
        books.add(book);
    }


    public List<Book> searchBooks(String query) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query))
                .collect(Collectors.toList());
    }


    public List<Book> listAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        library.addBook(new Book(1, "Java Programming", "James Gosling", true));
        library.addBook(new Book(2, "Effective Java", "Joshua Bloch", false));
        library.addBook(new Book(3, "Clean Code", "Robert C. Martin", true));

        System.out.println("Search results for 'Java Programming': " + library.searchBooks("Java Programming"));
        System.out.println("Available books: " + library.listAvailableBooks());
    }
}
