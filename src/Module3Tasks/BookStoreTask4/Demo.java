package Module3Tasks.BookStoreTask4;

public class Demo {

    /**
     * Написать программу «Книжный магазин»,
     * расположенную в специальном пакете.
     *
     * В программе создать класс «книга»,
     * состояние которого описывается параметрами:
     * «название книги» (строковый), «цена» (целочисленный),
     * «дата издания» (целочисленный).
     *
     * В основном классе создать «картотеку книг»,
     * представленную массивом «книг».
     *
     * В основном или отдельном классе создать
     * статический метод/методы, который будет осуществлять
     * проверку по параметрам «название книги» и «год выпуска».
     * Есть ли такая книга в картотеке: если есть —
     * выдавать соответствующее сообщение), если нет —
     * добавлять книгу в картотеку (выдавать сообщения о добавлении книги).
     *
     * Если массив (картотека) заполнен — выдавать сообщение об этом.
     *
     * Проверку строчных параметров («название книги») можно организовать
     * встроенным методом String equals.
     *
     * ⭐ Добавить метод, который выводит в консоль (на печать) всю информацию
     * о всех книгах (название, год издания, цену) без конкатенации, при помощи форматирования.
     *
     * Пример вывода:
     * книга №1: название: "The Hobbit", год издания: 1937г., цена - 999usd
     * книга №2: название: "......", год издания: …...г., цена - ….usd
     * @param args
     */

    private static final Book[] books = new Book[10];

    public static void main(String[] args) {
        Book theWitcher = new Book("The Last Wish", 199, 1993);
        Book metro2033 = new Book("Metro2033", 299, 2005);

        addBook(theWitcher);
        addBook(metro2033);

        System.out.println(showBooks());
    }

    public static String showBooks() {
        StringBuilder result = new StringBuilder();

        for (Book book: books) {
            if (book != null) {
                result.append("Book name: ").append(book.getBookName())
                        .append("\nPrice: ").append(book.getPrice()).append("usd")
                        .append("\nPublication date: ").append(book.getPublicationDate())
                        .append("\n\n");
            }
        }
        return result.toString();
    }

    public static boolean checkBook(Book inputBook) {
        for (Book book: books) {
            if (book.equals(inputBook)) return true;
        }

        if (addBook(inputBook)) System.out.println("The book is not in the list but already added");
        return false;
    }

    public static boolean addBook(Book inputBook) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = inputBook;
                System.out.printf("The '%s' book is successfully added\n", inputBook.getBookName());
                return true;
            }
        }
        System.out.println("There is no more space, sorry :(");
        return false;
    }
}
