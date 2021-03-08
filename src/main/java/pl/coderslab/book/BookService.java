package pl.coderslab.book;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save(Book book) {
        // create PZ
        bookDao.save(book);
        //send email to newspetter
        // send info to marketing compamnny
    }

    public Book finfById(long id) {
        return bookDao.findById(id);
    }
}
