package pl.coderslab.books;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Publisher byId = new PublisherDao().findById(1l);
        BookDao bookDao = new BookDao();
        List<Book> listByActiveAndPublisher = bookDao.getListByActiveAndPublisher(byId);
        listByActiveAndPublisher.forEach(b -> System.out.println(b.getTitle()));
    }
}
