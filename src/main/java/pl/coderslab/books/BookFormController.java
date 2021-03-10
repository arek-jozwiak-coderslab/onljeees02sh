package pl.coderslab.books;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/bookform")
public class BookFormController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.getAll());
        return "book/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(Model model) {
        model.addAttribute("publishers", publisherDao.getAll());
        model.addAttribute("book", new Book());
        return "book/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String performForm(Model model,@Valid Book book, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("publishers", publisherDao.getAll());
            return "book/form";
        }

        bookDao.save(book);
        return "redirect:/bookform/list";
    }

}


