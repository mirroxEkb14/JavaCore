package Module3Tasks.BookStoreTask4;

import java.util.Objects;

public class Book {

    /**
     * В программе создать класс «книга», состояние которого
     * описывается параметрами: «название книги» (строковый),
     * «цена» (целочисленный), «дата издания» (целочисленный).
     */

    private String bookName;
    private int price;
    private int publicationDate;

    public Book(String bookName, int price, int publicationDate) {
        this.bookName = bookName;
        this.price = price;
        this.publicationDate = publicationDate; // editionYear
    }

    public String getBookName() {
        return bookName;
    }

    public int getPrice() {
        return price;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return publicationDate == book.publicationDate &&
                Objects.equals(bookName, book.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, publicationDate);
    }
}
