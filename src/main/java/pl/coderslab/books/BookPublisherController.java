package pl.coderslab.books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/bookpub")
public class BookPublisherController {

    private final PublisherDao publisherDao;
    private final BookDao bookDao;

    public BookPublisherController(PublisherDao publisherDao, BookDao bookDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
    }

    @GetMapping("/all")
    @ResponseBody
    public String allBook() {
        bookDao.getAll().forEach(b -> System.out.println(b.getTitle()));
        return "ok";
    }

    @GetMapping("/all/{rating}")
    @ResponseBody
    public String allBook(@PathVariable int rating) {
        bookDao.getRatingList(rating).forEach(b -> System.out.println(b.getTitle()));
        return "ok";
    }

    @GetMapping("/add")
    @ResponseBody
    public String addBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.save(publisher);
        Book book = new Book();
        book.setTitle("Ania z zielonego");
        book.setPublisher(publisher);
        bookDao.save(book);

        return "ok";
    }
}
