package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping("/add")
    @ResponseBody
    public String addBook() {
        ServiceBook serviceBook = new ServiceBook();
        serviceBook.setTitle("Thinking in Java");
        serviceBook.setAuthor("Bruce Eckel");

        bookService.save(serviceBook);

        return "ok" + serviceBook.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        ServiceBook serviceBook = bookService.finfById(id);

        System.out.println(serviceBook.getTitle() + " " + serviceBook.getAuthor());
        return "ok";
    }


}
