package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/book")
public class BookController {


    private final Validator validator;

    private final BookService bookService;

    public BookController(Validator validator, BookService bookService) {
        this.validator = validator;
        this.bookService = bookService;
    }


    @RequestMapping("/add")
    @ResponseBody
    public String addBook() {
        ServiceBook serviceBook = new ServiceBook();
        serviceBook.setAuthor("Bruce Eckel");

        Set<ConstraintViolation<ServiceBook>> constraintViolations = validator.validate(serviceBook);

        if (constraintViolations.isEmpty()) {
            bookService.save(serviceBook);
        } else {
            constraintViolations.forEach(
                    cv -> System.out.println(
                            "cv.getPropertyPath() " + cv.getPropertyPath() +
                                    " cv.getMessage() " + cv.getMessage()
                    )
            );
        }


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
