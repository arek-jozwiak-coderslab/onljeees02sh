package pl.coderslab.person;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {


    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("people", personDao.getAll());
        return "person/list";
    }

    @GetMapping("/edit/{id}")
    public String editEditForm(@PathVariable long id, Model model) {
        model.addAttribute("person", personDao.findById(id));
        return "person/edit";
    }

    @PostMapping("/update")
    public String performEditForm(Person person) {
        personDao.update(person);
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "person/add";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String performForm(Person person) {
        personDao.save(person);
        return "redirect:/person/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        personDao.delete(id);
        return "redirect:/person/list";
    }

}
